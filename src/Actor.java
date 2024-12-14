import java.awt.*;

public abstract class Actor {


    /*
        Actor Class
            Used to set attributes for playable 'characters' that need these attributes

            the attributes listed are movements speeds, directional facing for movement, such as up down left right.
            get and set methods for color, speeds, directions, positional data such as setting the
            players X position and Y position, or getting their position for valid movement checks.
     */

    // Movement based Data
    public static final int UP = 270;
    public static final int DOWN = 90;
    public static final int LEFT = 180;
    public static final int RIGHT = 0;
    public double my_speed = 1;

    // Positional Data
    private double myYpos;
    private double myXpos;

    // Directional Data
    private int my_current_face = RIGHT;


    // Get and Set methods for above public variables that need to be changes and called when needed.
    public void setPos(double x, double y) {
        myYpos = y;
        myXpos = x;
    }

    public double getXpos() {
        return myXpos;
    }

    public double getYpos() {
        return myYpos;
    }

    public double getSpeed() {
        return my_speed;
    }

    public void setFace(int d) {
        my_current_face = d;
    }

    public int getFace() {
        return my_current_face;
    }

    //method for moving an instance of a class that inherits these attributes,
    // moving along an array, from re setting their position from the current plus their speed.
    public void move() {
        if (my_current_face == RIGHT) {
            setPos(getXpos() + my_speed, getYpos());
        }
        if (my_current_face == DOWN) {
            setPos(getXpos(), getYpos() + my_speed);
        }
        if (my_current_face == LEFT) {
            setPos(getXpos() - my_speed, getYpos());
        }
        if (my_current_face == UP) {
            setPos(getXpos(), getYpos() - my_speed);
        }
    }

    // draw method - to draw the Bloc, if needed to show its movements around the space.
    // for some reason if I try to delete the below, it breaks, even though it isn't used.
    // I HAVE NO IDEA WHAT I DID TO CAUSE THIS.
    public abstract void draw(Graphics2D g, int x, int y, int width, int height);
}
