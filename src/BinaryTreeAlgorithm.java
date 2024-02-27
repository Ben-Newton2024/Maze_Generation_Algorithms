import java.util.Random;

public class BinaryTreeAlgorithm
{
    private final Random rand = new Random();



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public MazeGen binary_tree(MazeGen visited_maze) {

        for(int y = 0; y<visited_maze.return_visited_maze().length; y++) {
            for (int x = 0; x< visited_maze.return_visited_maze().length; x++) {


                int num = rand.nextInt(2);
                if (y == 0) {
                    visited_maze.return_visited_maze()[y][x] = "Q";
                }
                else if (x == 0) {
                    visited_maze.return_visited_maze()[y][x] = "S";
                }
                else {
                    if(num == 0) {
                        visited_maze.return_visited_maze()[y][x] = "Q";
                    }
                    else {
                        visited_maze.return_visited_maze()[y][x] = "S";
                    }
                }
            }
        }
        return visited_maze;
    }


}
