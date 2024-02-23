import java.awt.Graphics2D;

public abstract class Actor {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //				IS TO ALLOW ANY 'ENTITY' TO INHERIT THESE ATTRIBUTES LISTED									//
    //				MEANS THAT FUNCTIONS CAN BE CALLED ON THAT OBJECT EASILY  									//
    //				WITHOUT MIXING WITH OTHER 'ENTITY'S'														//
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final int UP = 270;
    public static final int DOWN = 90;
    public static final int LEFT = 180;
    public static final int RIGHT = 0;

    public double my_speed = 1;

    private double myYpos;
    private double myXpos;

    public abstract void draw(Graphics2D g, int x, int y, int width, int height);

    private int my_current_face = RIGHT;
    private int my_last_face = RIGHT;
    private int my_next_face = RIGHT;


    //GETTERS AND SETTERS
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

    public void setlastFace(int d) {
        my_last_face = d;
    }

    public int getlastFace() {
        return my_last_face;
    }

    public void setnextFace(int d) {
        my_next_face = d;
    }

    public int getnextFace() {
        return my_next_face;
    }

    //MOVES ANYTHING THAT NEEDS TO MOVE
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
}
