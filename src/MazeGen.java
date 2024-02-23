public class MazeGen {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //		MAZE GEN IS THE CLASS THAT GENERATES THE 2D ARRAYS OF EACH OF THE MAZES ONES BEING EMPTY			//
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String[][] my_visited_maze;


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
