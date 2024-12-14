public class MazeGen {

    //  private global variable use to have an initiated 2d array for setting up mazes
    private String[][] my_visited_maze;

    /*
        public function called to be used to set up the board and wipe the board

        Generates 'empty' 2D arrays

        these arrays are used for maze creations, it sets the boarders of the maze to impassable, 'AA'
        and sets all the inside to '0' for a maze to be created within the center of the 2D array.
     */

    public void emtpy_visited_maze(int q) {
        my_visited_maze = new String[q][q];

        for(int y = 0; y < my_visited_maze.length; y++)
        {
            for(int x = 0; x < my_visited_maze[y].length; x++)
            {
                if(y == 0 || y == my_visited_maze.length-1 || x == 0 || x == my_visited_maze[0].length-1) {
                    my_visited_maze[y][x] = "AA";
                }
                else {
                    my_visited_maze[y][x] = "0";
                }
            }
        }
    }

    //TO RETURN THE MAZE SO EDITING TO THE MAZE CAN BE DONE
    public String[][] return_visited_maze(){
        return my_visited_maze;
    }
}
