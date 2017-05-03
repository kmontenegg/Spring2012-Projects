/*
 * File: Checkerboard2.java
 * ------------------------
 *
 * This is the ACM Java Task Force Checkerboard.java acm.graphics
 * example, extended to include a few more graphics operations and
 * restructured a bit to match my preferences.
 * Here's the original description:
 *
 * -----
 * This program draws a checkerboard.  The dimensions of the
 * checkerboard is specified by the constants NROWS and
 * NCOLUMNS, and the size of the squares is chosen so
 * that the checkerboard fills the available vertical space.
 * -----
 *
 * To Compile and Run on a CS Lab Machine:
 *   $ javac -cp .:/usr/share/java/acm.jar Checkerboard2.java
 *   $ java  -cp .:/usr/share/java/acm.jar Checkerboard2
 *
 * Modifications by L. McCann 2007/02/11 and 2012/01/26
 */

import acm.program.*;   // Common classes used by all parts of the acm package
import acm.graphics.*;  // Defines graphical object classes
import acm.util.*;      // Used b/c we want to slow the program with pause()
import java.awt.*;      // Allows access to Java's Color class

public class Checkerboard2 extends GraphicsProgram {

    private static final int NROWS = 8;     // Number of rows of the board
    private static final int NCOLUMNS = 8;  // Number of columns " " "

            // Notice that the first method executed is run(), not main().
            // This is because the acm package provides a hidden main()
            // for us, which reduces the clutter in the code.

    public void run() {

        final int NUM_COLORS = 4;  // quantity of colors used for squares
        final int DELAY = 100;     // pause between generations (in millisecs)

        double squareSize;      // width and height of a sqaure on the board
        Color[] color;          // array of the available square colors
        RandomGenerator rand;   // Use to generate random colors

        squareSize = (double) getHeight() / NROWS;
        color = new Color[NUM_COLORS];
        rand = new RandomGenerator();

                // Initialize the color array with specific color values.

        color[0] = Color.BLACK;
        color[1] = Color.RED;
        color[2] = Color.BLUE;
        color[3] = Color.GREEN;

        double x, y;            // upper-left corner of a square
        GRect square;           // references each square created

        for (int i = 0; i < NROWS; i++) {
            for (int j = 0; j < NCOLUMNS; j++) {

                x = j * squareSize;
                y = i * squareSize;
                square = new GRect(x, y, squareSize, squareSize);

                if ((i + j) % 2 != 0) {
                    square.setColor(color[rand.nextInt(NUM_COLORS)]);
                    square.setFilled(true);
                    add(square);  // places the GRect obj on the canvas
                }

                JTFTools.pause(DELAY);   // pause briefly so user can see!
            }
        }
    }  // run

}

