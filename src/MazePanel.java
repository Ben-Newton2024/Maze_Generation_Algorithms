import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;

import javax.swing.JPanel;

public class MazePanel extends JPanel
{
    MazeGen CurrentMaze = new MazeGen();

    private int blockWidth;
    private int blockHeight;

    //CONSTRUCTOR
    public void paint_Maze(MazeGen current_maze) {
        CurrentMaze = current_maze;
        setBlockWH();
        repaint();
    }

    //TO SET THE WIDTH OF EACH 2D MAZE SPACE TO A SPACE FOR THE GRAPHICAL DRAWINGS
    public void setBlockWH() {
        blockWidth = (int)Math.round((double)getWidth()/(double)CurrentMaze.return_visited_maze()[0].length);
        blockHeight = (int)Math.round((double)getHeight()/(double)CurrentMaze.return_visited_maze().length);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////MAIN PAINT COMPONENT//////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void paintComponent(Graphics g)
    {
        //AVOID THIS
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //SIDE WINDER CHARACTERS
        for(int y = 0; y < CurrentMaze.return_visited_maze().length; y++)
        {
            for(int x = 0; x < CurrentMaze.return_visited_maze()[0].length; x++)
            {
                ///IS UNASSIGNED
                if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "A")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                }
                //IS A TOP WALL
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "B")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    //TOP
                    g2.fillRect(x*blockWidth-blockWidth/3, (y*blockHeight),blockWidth+blockWidth/3, (blockHeight/3));


                }
                //NORTH + EAST C
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "C")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth-blockWidth/3, (y*blockHeight),blockWidth+blockWidth/3, (blockHeight/3));
                    g2.fillRect(x*blockWidth, (y*blockHeight),blockWidth, (blockHeight/3));
                }
                //EAST BARRIER
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "D")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth+(blockWidth)-blockWidth/3, (y*blockHeight),blockWidth/3, (blockHeight));
                }

                ///WILSON PAINTING

                ///IS UNASSIGNED
                if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "1")
                        || Objects.equals(CurrentMaze.return_visited_maze()[y][x], "2")
                        || Objects.equals(CurrentMaze.return_visited_maze()[y][x], "3")
                        || Objects.equals(CurrentMaze.return_visited_maze()[y][x], "4"))
                {
                    g2.setColor(new Color(51,204,255));
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                }


                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "AA")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);


                }
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "0")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                }
                //IS A TOP WALL
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "E")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                }
                //UP, UP OR DOWN, DOWN
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "F")) {
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth+(blockWidth/3), (y*blockHeight),blockWidth/3, blockHeight);
                }
                //RIGHT, RIGHT OR LEFT, LEFT
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "G")) {
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, (y*blockHeight)+blockHeight/2,blockWidth, blockHeight-blockHeight/2);
                }
                //UP LEFT OR RIGHT DOWN
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "H")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth, (y*blockHeight),blockWidth, blockHeight/3);
                    g2.fillRect(x*blockWidth+blockWidth-(blockWidth/3), y*blockHeight,blockWidth/3, blockHeight);

                }
                //UP RIGHT OR LEFT DOWN
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "I")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth, (y*blockHeight),x*blockWidth/3, (y*blockHeight));
                    g2.fillRect(x*blockWidth, (y*blockHeight),blockWidth, blockHeight/3);
                }
                //DOWN RIGHT or LEFT UP
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "J")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth, (y*blockHeight),blockWidth/3, blockHeight);
                    g2.fillRect(x*blockWidth, y*blockHeight+(blockHeight/3)*2,blockWidth, blockHeight/3);
                }
                //DOWN LEFT OR RIGHT UP
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "K")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth+(blockHeight/3)*2, (y*blockHeight),blockWidth/3, (blockHeight));
                    g2.fillRect(x*blockWidth, y*blockHeight+(blockHeight/3)*2,blockWidth, blockHeight/3);
                }
                //EMPTIES REPLACEMENTS WHEN CONNECTING
                //RIGHT WALL
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "L")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth+blockWidth - blockWidth/3, (y*blockHeight),blockWidth/3, (blockHeight));
                }
                //LEFT WALL
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "M")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth, (y*blockHeight),blockWidth/3, blockHeight);
                }
                //TOP WALL
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "N")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth, (y*blockHeight),blockWidth, blockHeight/3);				}
                //BOTTOM WALL
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "O")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth, y*blockHeight+blockHeight-blockHeight/3,blockWidth, blockHeight/3);
                }

                //BINARY TREE

                ///IS UNASSIGNED
                if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "P")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                }
                //IS A TOP WALL
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "Q")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    //TOP
                    g2.fillRect(x*blockWidth, (y*blockHeight),blockWidth, blockHeight/3);


                }
                //NORTH + EAST C
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "R")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth, (y*blockHeight),blockWidth/3, (blockHeight+blockHeight));
                    g2.fillRect(x*blockWidth, (y*blockHeight),blockWidth, blockHeight/3);
                }
                //EAST BARRIER
                else if (Objects.equals(CurrentMaze.return_visited_maze()[y][x], "S")) {
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(x*blockWidth, (y*blockHeight),blockWidth/3, (blockHeight));
                }
            }
        }
    }
}
