import java.awt.*;
import java.util.*;

/**
 * Program thats generates steps based on input from user.
 *
 * @author Sarah Worley
 */
public class Steps {
    /** Constants */
    public static final int TOTAL_WIDTH = 740;
    /** TOTAL WIDTH CONSTANT */
    public static final int TOTAL_HEIGHT = 420;
    /** TOTAL HEIGHT CONSTANT */
    public static final int STEP_HIGH = 8;
    /** NUMBER OF STEPS MAX */
    public static final int STEP_LOW = 1;
    /** NUMBER OF STEPS MIN */
    public static final int COLOR_HIGH = 255;
    /** MAX COLOR VALUE */
    public static final int COLOR_LOW = 0;
    /** MIN COLOR VALUE */
    public static final int X = 5;
    /** X AXIS POINT AND Y AXIS POINT. ALSO SERVES AS A MODIFIER */
    public static final int WIDTH = 80;
    /** WIDTH CONSTANT */
    public static final int HEIGHT = 40;
    /** HEIGHT CONSTANT */
    /**
     * Declares variables using constants.
     * @param args command line arguments
     */

    public static void main(String[] args) {


        //Inports panel.
        DrawingPanel panel = new DrawingPanel(TOTAL_WIDTH, TOTAL_HEIGHT);

        //Imports graphics.
        Graphics g = panel.getGraphics();

        //Inports scanner. Promps user for input.
        Scanner s = new Scanner(System.in);
        System.out.print("How many steps 1-8 ");
        int numberOfSteps = s.nextInt();
        numberOfSteps = Math.max (numberOfSteps, STEP_LOW);
        numberOfSteps = Math.min (numberOfSteps, STEP_HIGH);

        //Gets red Value from user allows only numbers 0-255.
        System.out.print("Red value (0-255): ");
        int red = s.nextInt();
        red = Math.max(red, COLOR_LOW);
        red = Math.min(red, COLOR_HIGH);

        //Gets green value from user allows only number 0-255.
        System.out.print("Green value (0-255): ");
        int green = s.nextInt();
        green = Math.max(green, COLOR_LOW);
        green = Math.min(green, COLOR_HIGH);

        //Gets blue Value from user allows only numbers 0-255.
        System.out.print("Blue value (0-255): ");
        int blue = s.nextInt();
        blue = Math.max(blue, COLOR_LOW);
        blue = Math.min(blue, COLOR_HIGH);

        System.out.println("*CLOSE the Drawing Panel to exit the program*");

        // Creates new color based on user input.
        Color color = new Color(red, green, blue);

        //Creates inverseColor from color for background.
        Color inverseColor = new Color(Math.abs(red - COLOR_HIGH), Math.abs(green - COLOR_HIGH),
                                        Math.abs(blue - COLOR_HIGH));
        panel.setBackground(inverseColor);


        int y = X;
        //Creates starting x and y locations for the bottom corner.
        int bottomX = (TOTAL_WIDTH - X);
        int bottomY = (TOTAL_HEIGHT - X);


        drawTopSteps(g, color, numberOfSteps, X, y, WIDTH, HEIGHT);
        drawBottomSteps(g, color, numberOfSteps, bottomX, bottomY, WIDTH, HEIGHT);



    }
    /** Draws the given number of (upside down) steps with the given color such that the
    *upper-lefthand corner of the steps is at point (x,y)
    *All steps have the given width; the first step has the given height, the second
    *step has twice the given height, etc.
    * information provided by CSC116 Fall 2018 - Project 2 PDF
    * @param g Graphics panel
    * @param color draws from user varibles for custom color
    * @param numberOfSteps draws from user varibles for number of stairs to generate
    * @param x is point on x axis to start the rectangle.
    * @param y is point on y axis to start the rectangle.
    * @param width is width of the rectangle.
    * @param height is basis height of the rectangle.
    */
    public static void drawTopSteps(Graphics g, Color color, int numberOfSteps,
                                     int x, int y, int width, int height) {
        for (int i = 0; i <= numberOfSteps; i++) {
            g.setColor(color);
            g.fillRect(x + width * i,  y, width, (numberOfSteps * height) - height * i);
            
        }


    }
     /**Draws the given number of steps with the given color such that the
     *lower-righthand corner of the steps is at point (x,y)
     *All steps have the given width; the first step has the given height, the second
     *step has twice the given height, etc.
     * information provided by CSC116 Fall 2018 - Project 2 PDF
     * @param g Graphics panel insert.
     * @param color draws from user varibles for custom color.
     * @param numberOfSteps draws from user varibles for number of stairs to generate.
     * @param x is point on x axis to start the rectangle.
     * @param y is point on y axis to start the rectangle.
     * @param width is width of the rectangle.
     * @param height is basis height of the rectangle.
     */
    public static void drawBottomSteps(Graphics g, Color color, int numberOfSteps,
                                        int x, int y, int width, int height) {
        for (int i = 0; i <= numberOfSteps; i++) {
            int newX = (x - width) - (width * i);
            int newHeight = (numberOfSteps * height) - height * i;
            g.setColor(color);
            g.fillRect(newX, (y - newHeight), width, newHeight);
        }
    }
}
