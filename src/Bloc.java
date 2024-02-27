import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bloc extends Actor {

    /*
        Bloc class
            has the attributes of actor,
            this is going to be our 'move-able character' around the board/play space

            in the context of making mazes it is the head of the maze snake.
            as the maze is drawn part by part, it'll move around the map filling in gaps that haven't been filled
            leaving behind the body of the 'snake' being the complete (visited_maze) to be drawn.
     */
    private final Color mycolor;

    // constructor - mostly just for colors.
    public Bloc(Color c)
    {
        mycolor = c;
    }

    // draw method - to draw the Bloc, if needed to show its movements around the space.
    @Override
    public void draw(Graphics2D g, int x, int y, int width, int height) {
        // TODO Auto-generated method stub


        g.setColor(mycolor);
        g.fillRect(x, y, width, height);
    }

}
