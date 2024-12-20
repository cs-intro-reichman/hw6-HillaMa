import java.awt.Color;

/**
 * Demonstrates the scaling (resizing) operation featured by Runigram.java. 
 * The program recieves three command-line arguments: a string representing the name
 * of the PPM file of a source image, and two integers that specify the width and the
 * height of the scaled, output image. For example, to scale/resize ironman.ppm to a width
 * of 100 pixels and a height of 900 pixels, use: java Editor2 ironman.ppm 100 900
 */
public class Editor2 {

	public static void main (String[] args){
        if (args.length != 3) {
            System.out.println("Usage: java Editor2 <filename> <width> <height>");
            return;
        }
        String fileName = args[0];
        int newWidth = Integer.parseInt(args[1]);
        int newHeight = Integer.parseInt(args[2]);
        Color[][] imageIn = Runigram.read(fileName);
        if (imageIn == null) {
            System.out.println("Error: Unable to read the image file.");
            return;
        }
        Color[][] imageOut = Runigram.scaled(imageIn, newWidth, newHeight);
        Runigram.setCanvas(imageIn);
        Runigram.display(imageIn);
        StdDraw.pause(3000);
        Runigram.setCanvas(imageOut);
        Runigram.display(imageOut);
    }
}