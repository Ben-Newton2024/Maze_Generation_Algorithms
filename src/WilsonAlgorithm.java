import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class WilsonAlgorithm
{
    private final Random direct = new Random();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //	The algorithm goes something like this:																	//
    //																											//
    //		Choose any vertex at random and add it to the UST.													//
    //		Select any vertex that is not already in the UST and perform a random walk until you encounter a  	//
    //		vertex that is in the UST.																			//
    //		Add the vertices and edges touched in the random walk to the UST.									//
    //		Repeat 2 and 3 until all vertices have been added to the UST.										//
    //		So, it’s still doing the random walk, but I think you’ll see that this algorithm converges much more//
    //		rapidly than Aldous-Broder. It’s still annoying to watch an animation of the early stages of the 	//
    //		process, but not nearly as bad as the other.														//
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public MazeGen wilson(Bloc maze_point_head, MazeGen visited_maze)
    {


        //RANDOM START BLOCK
        int xx = direct.nextInt(visited_maze.return_visited_maze().length);
        int yy = direct.nextInt(visited_maze.return_visited_maze().length);
        while (true) {
            if(Objects.equals(visited_maze.return_visited_maze()[yy][xx], "AA")) {
                yy = direct.nextInt(visited_maze.return_visited_maze().length);
                xx = direct.nextInt(visited_maze.return_visited_maze().length);

            }
            else {
                break;
            }
        }
        int last_direction = 1;
        visited_maze.return_visited_maze()[yy][xx] = "E";
        while(!isMaze_Full(visited_maze)) {
            reset_Path(visited_maze);
            ArrayList<Integer> position = random_walk_path(maze_point_head, visited_maze);
            maze_point_head.setPos(position.get(0), position.get(1));

            while(true) {


                //up	1
                //down	2
                //left	3
                //right	4

                if(last_direction == 1) {
                    if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "1")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "F";
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "2")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "F";
                        last_direction = 2;
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "3")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "H";
                        last_direction = 3;
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "4")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "I";
                        last_direction = 4;
                    }
                }
                else if(last_direction == 2) {
                    if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "1")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "F";
                        last_direction = 1;
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "2")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "F";
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "3")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "K";
                        last_direction = 3;
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "4")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "J";
                        last_direction = 4;
                    }
                }
                else if(last_direction == 3) {
                    if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "1")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "J";
                        last_direction = 1;
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "2")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "I";
                        last_direction = 2;
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "3")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "G";
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "4")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "G";
                        last_direction = 4;
                    }
                }
                else {
                    if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "1")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "K";
                        last_direction = 1;
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "2")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "H";
                        last_direction = 2;
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "3")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "G";
                        last_direction = 3;
                    }
                    else if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "4")) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "G";
                    }
                }
                //alternative block changes
                if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "F")) {
                    if(last_direction == 1) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "F";
                    }
                    else if(last_direction == 2) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "F";
                    }
                    else if(last_direction == 3) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "L";
                    }
                    else {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "N";
                    }
                    break;
                }
                if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "G")) {
                    if(last_direction == 1) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "O";
                    }
                    else if(last_direction == 2) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "N";
                    }
                    else if(last_direction == 3) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "G";
                    }
                    else {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "G";

                    }
                    break;
                }
                //UP LEFT    RIGHT DOWN
                if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "H")) {
                    if(last_direction == 1) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "H";
                    }
                    else if(last_direction == 2) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "L";
                    }
                    else if(last_direction == 3) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "H";
                    }
                    else {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "N";
                    }
                    break;
                }
                //UP RIGHT OR LEFT DOWN
                if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "I")) {
                    if(last_direction == 1) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "I";
                    }
                    else if(last_direction == 2) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "M";
                    }
                    else if(last_direction == 3) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "I";
                    }
                    else {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "N";
                    }
                    break;
                }
                //DOWN RIGHT or LEFT UP
                if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "J")) {
                    if(last_direction == 1) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "M";
                    }
                    else if(last_direction == 2) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "J";
                    }
                    else if(last_direction == 3) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "J";
                    }
                    else {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "O";
                    }
                    break;
                }
                //DOWN LEFT OR RIGHT UP
                if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "K")) {
                    if(last_direction == 1) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "L";
                    }
                    else if(last_direction == 2) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "K";
                    }
                    else if(last_direction == 3) {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "O";
                    }
                    else {
                        visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "K";
                    }
                    break;
                }
                //walls of sort blocking paths to end
                if(Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "AA") ||
                        Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "E")) {
                    break;
                }


                maze_point_head.move();
            }
        }
        return visited_maze;
    }

    /*
        Is the path blocked - if so reset the path to start at the next opening previously made.
     */
    public void reset_Path(MazeGen visited_maze) {
        for(int y = 0; y<visited_maze.return_visited_maze().length; y++) {
            for (int x = 0; x<visited_maze.return_visited_maze().length; x++) {
                if (Objects.equals(visited_maze.return_visited_maze()[y][x], "1") ||
                        Objects.equals(visited_maze.return_visited_maze()[y][x], "2") ||
                        Objects.equals(visited_maze.return_visited_maze()[y][x], "3") ||
                        Objects.equals(visited_maze.return_visited_maze()[y][x], "4")) {
                    visited_maze.return_visited_maze()[y][x] = "0";
                }
            }
        }
    }

    /*
       Once the maze is believed to be completed/ or it is checked every time via this function

       if the maze is full then return true to exit any loops that may be given when it is called.

       if it not fully filled AKA any position in the 2D array is == 0 (empty when maze 'map' is initialised
       then it is false and code continues from previous call position.

       //call the map inside as a parameter to check the current map that is being 'drawn' to
     */
    public boolean isMaze_Full(MazeGen visited_maze) {
        //set up check boolean value local to this function
        boolean is_empty= true;
        //loop through all positions of 2D array to find any 'empty' values (set to 0) to confirm if map is empty or not
        for(int y = 0; y<visited_maze.return_visited_maze().length; y++) {
            for (int x = 0; x<visited_maze.return_visited_maze().length; x++) {
                if (Objects.equals(visited_maze.return_visited_maze()[y][x], "0")) {
                    is_empty =  false;
                }
            }
        }
        return is_empty;
    }

    //the below function is the random walk path that incorporates the random direction method.
    // this is to randomly draw a path onto the 'canvas'
    // when certain moves have been made, it will leave behind a letter to the tile
    // so the painter can paint the corresponding move to the canvas.
    // e.g. if it came from above, moved down and turned left
    // the path would be something like that with is corresponding letter that tells the painter that that is what
    // it needs to paint.
    public ArrayList<Integer> random_walk_path(Bloc maze_point_head, MazeGen visited_maze) {
        //RANDOM WALK RANDOMS START POINT
        int x = direct.nextInt(visited_maze.return_visited_maze().length);
        int y = direct.nextInt(visited_maze.return_visited_maze().length);

        while(true) {
            if (Objects.equals(visited_maze.return_visited_maze()[y][x], "AA") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][x], "E") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][x], "F") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][x], "G") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][x], "H") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][y], "I") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][x], "J") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][x], "K") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][x], "L") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][y], "M") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][x], "N") &&
                    Objects.equals(visited_maze.return_visited_maze()[y][x], "O")) {
                x = direct.nextInt(visited_maze.return_visited_maze().length);
                y = direct.nextInt(visited_maze.return_visited_maze().length);
            }
            else {
                break;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        //FIRST TWO POSITIONS OF THE LIST IS POSITION OF THZ RANDOM START POINT
        list.add(x);
        list.add(y);


        maze_point_head.setPos(x, y);
        while (!Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "AA")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "E")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "F")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "G")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "H")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "I")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "J")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "K")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "L")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "M")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "N")
                && !Objects.equals(visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()], "O")) {
            //IF IT EVER HITS A CONFIRMED PATH ON THE MAZE ENDS IT
            //RANDOM DIRECTION
            random_direction(maze_point_head);
            //CHECKING THE DIRECTION O THAT RANDOM DIRECTION CAN BE APPLIED TO THE MAZE
            if (maze_point_head.getFace() == Actor.UP) {
                visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "1";
            }
            if (maze_point_head.getFace() == Actor.DOWN) {
                visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "2";
            }
            if (maze_point_head.getFace() == Actor.LEFT) {
                visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "3";
            }
            if (maze_point_head.getFace() == Actor.RIGHT) {
                visited_maze.return_visited_maze()[(int) maze_point_head.getYpos()][(int) maze_point_head.getXpos()] = "4";
            }
            if (isValidMove(maze_point_head, maze_point_head.getFace(), visited_maze)) {
                maze_point_head.move();
            }
        }
        return list;
    }

    //Chooses a random direction for the maze pointer to start walking to, this is done from 0 to 3
    //being, 0 being up, down, 2 left, 3 right.
    public void random_direction(Bloc maze_point_head) {
        int direction;

        direction = direct.nextInt(4);

        if(direction == 0) {
            maze_point_head.setFace(Actor.UP);
        }
        else if(direction == 1) {
            maze_point_head.setFace(Actor.DOWN);
        }
        else if(direction == 2) {
            maze_point_head.setFace(Actor.LEFT);
        }
        else {
            maze_point_head.setFace(Actor.RIGHT);
        }
    }

    //valid move checker, since we cant have the maze pointer that moves and paints the maze start walking into walls
    // and repainting the walls to new values.
    // this just checks if the move that the point is going to make is valid before it performs the move and actually
    // walks forward.
    // this is done being getting the XY coords of the Actor 'a', (AKA THE POINTER OF THE MAZE/MAZE HEAD)
    // its predicted direction it wants to go, and then calculates each 4 point of a valid tile its top left XY
    // and then top right, bottom right, bottom left coords, this is done by adding the size of block itself to get the
    // corners.
    private boolean isValidMove(Actor a, int direction, MazeGen maze)
    {

        double speed = a.getSpeed();
        ////////////////////////////////////////////////////////
        ///////////////////FOR CHECKING NEXT BLOCK//////////////
        ////////////////////////////////////////////////////////

        //CO-ORDS FROM THE TOP LEFT POINT ETC
        double top_left_x = a.getXpos();
        double top_left_y = a.getYpos();

        double top_right_x = a.getXpos()+0.5;
        double top_right_y = a.getYpos();

        double bottom_left_x = a.getXpos();
        double bottom_left_y = a.getYpos()+0.5;


        double bottom_right_x = a.getXpos()+0.5;
        double bottom_right_y = a.getYpos()+0.5;

        ////////////////////////////////////////////////////////
        ////////FOR CHECKING BLOCS ITS MOVING INTO//////////////
        ////////////////////////////////////////////////////////
        if(direction == Actor.UP)
        {
            //FOR CHECKING NEXT BLOC
            top_left_y-=speed;
            top_right_y-=speed;
        }
        if(direction == Actor.DOWN)
        {
            //FOR CHECKING NEXT BLOC
            bottom_left_y+=speed;
            bottom_right_y+=speed;
        }
        if(direction == Actor.LEFT)
        {
            //FOR CHECKING NEXT BLOC
            top_left_x-=speed;
            bottom_left_x-=speed;
        }
        if(direction == Actor.RIGHT)
        {
            //FOR CHECKING NEXT BLOC
            top_right_x+=speed;
            bottom_right_x+=speed;
        }

        //CHECKING NEXT BLOC
        //MUST BE A WALL FOR IT TO REPLACE AS PATH
        return !Objects.equals(maze.return_visited_maze()[(int) top_left_y][(int) top_left_x], "AA")
                &&
                !Objects.equals(maze.return_visited_maze()[(int) top_right_y][(int) top_right_x], "AA")
                &&
                !Objects.equals(maze.return_visited_maze()[(int) bottom_left_y][(int) bottom_left_x], "AA")
                &&
                !Objects.equals(maze.return_visited_maze()[(int) bottom_right_y][(int) bottom_right_x], "AA");
    }
}

