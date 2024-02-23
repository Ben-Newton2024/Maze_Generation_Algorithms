import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bloc extends Actor {
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////IS THE 'ENTITY' OF TH 'HEAD' OF THE MAZE//////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final Color mycolor;

    //ALLOWS THE COLOUR TO CHANGE
    public Bloc(Color c)
    {
        mycolor = c;
    }
    //FOR DRAWING ON LABELS
    public void draw1(Graphics g, int x, int y, int width, int height) {
        // TODO Auto-generated method stub

        g.setColor(mycolor);
        g.fillRect(x, y, width, height);
    }
    //FOR 2D DRAWING ON JPANEL ATTRIBUTES
    @Override
    public void draw(Graphics2D g, int x, int y, int width, int height) {
        // TODO Auto-generated method stub


        g.setColor(mycolor);
        g.fillRect(x, y, width, height);
    }

}
