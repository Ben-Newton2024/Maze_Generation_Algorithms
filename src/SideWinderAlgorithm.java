import java.util.ArrayList;
import java.util.Random;

public class SideWinderAlgorithm
{
    private final Random rand = new Random();


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  CAN ONLY CARVE EAST OR NORTH																			//
    //  3 STATES																								//
    //  NORTH (EMPTY)				:			A																//
    //  EAST 	(TOP)				:			B																//
    //  EAST  (NO TOP)	     		:			C																//
    //																											//
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public MazeGen sidewinder(MazeGen visited_maze) {



        for(int y = 0; y<visited_maze.return_visited_maze().length; y++) {
            //ARRAY list SO IT CAN BE RESIZABLE AND EXPAND
            //NOT AN ARRAY BECAUSE ARRAYS CANNOT BE RESIZED/HAVE A NEW VALUE ADDED TO THE END
            ArrayList<Integer> list = new ArrayList<>();

            for (int x = 0; x< visited_maze.return_visited_maze().length; x++) {
                //ADDS TO list (SET) A NEXT VALUE
                list.add(x);

                //MUST BE AN EMPTY ROW ON THE TOP LEVEL

                if (y == 0) {
                    visited_maze.return_visited_maze()[y][x] = "B";
                }
                //IF NOT THE TOP ROW:
                else {
                    //TO RANDOMLY DECIDE TO STOP CARVING EAST WARDS
                    //TOP THEN RANDOMLY CARVE NORTH
                    //0 FOR RANDOM CARVE NORTH
                    int rando_num = rand.nextInt(2);



                    //CARVES A NORTH SO IT IS (EMPTY OF A TOP PART)

                    //WhETHER TO STOP CARVING EAST TO DO A RANDOM NORTH CARVE
                    if(rando_num == 0) {
                        int randomNorth = rand.nextInt(list.size());
                        //IF THE list IS == 1 THEN IT HAS TO BE A CARVED NORTH WITH EAST BARRIER
                        if(list.size() == 1) {
                            //CARVE NORTH
                            visited_maze.return_visited_maze()[y][x] = "D";//NORTHERN CARVE BUT WITH EAST BARRIER
                        }
                        else {

                            //IF THE RANDOM NORTH CARVE IS THE LENGTH OF THE SET
                            //THEN NEEDS TO BE A NORTHERN CARVE PLUS THE EASTERN WALL
                            if (randomNorth == list.size()) {
                                visited_maze.return_visited_maze()[y][x] = "D";
                            }
                            //PUTS A RANDOM NORTH IN A POSITION WITHING THE SET IN THE CORRECT X POS
                            else {
                                //AT THE END OF THE SET NEEDS A NON-NORTH CARVE WITH THE ESTER CARVE
                                visited_maze.return_visited_maze()[y][x] = "C";
                                visited_maze.return_visited_maze()[y][list.get(randomNorth)] = "A";



                            }

                        }
                        list = new ArrayList<>();
                    }
                    else if(list.contains(visited_maze.return_visited_maze()[0].length-1)) {
                        int randomNorth = rand.nextInt(list.size());
                        //IF THE list IS == 1 THEN IT HAS TO BE A CARVED NORTH WITH EAST BARRIER
                        if(list.size() == 1) {
                            //CARVE NORTH
                            visited_maze.return_visited_maze()[y][x] = "D";//NORTHERN CARVE BUT WITH EAST BARRIER
                        }
                        else {

                            //IF THE RANDOM NORTH CARVE IS THE LENGTH OF THE SET
                            //THEN NEEDS TO BE A NORTHERN CARVE PLUS THE EASTERN WALL
                            if (randomNorth == list.size()) {
                                visited_maze.return_visited_maze()[y][x] = "D";
                            }
                            //PUTS A RANDOM NORTH IN A POSITION WITHING THE SET IN THE CORRECT X POS
                            else {
                                //AT THE END OF THE SET NEEDS A NON-NORTH CARVE WITH THE ESTER CARVE
                                visited_maze.return_visited_maze()[y][x] = "C";
                                visited_maze.return_visited_maze()[y][list.get(randomNorth)] = "A";



                            }

                        }
                        list = new ArrayList<>();
                    }
                    else {
                        //CARVE EAST
                        visited_maze.return_visited_maze()[y][x] = "B";
                    }
                }
            }
        }
        return visited_maze;
    }


    //TODO \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
    //FLOODING SYSTEM WIP
//	
//	public void FloodSystem(MazeGen visitedmaze, JLabel Label, Bloc floodPoint) {
//		int[][] Flooding = new int[visitedmaze.returnvisitedMaze().length][visitedmaze.returnvisitedMaze()[0].length];
//		
//		int X = rand.nextInt(visitedmaze.returnvisitedMaze()[0].length);
//		int Y = rand.nextInt(visitedmaze.returnvisitedMaze().length);
//		
//		floodPoint.setPos(X, Y);
//		
//		Graphics Paint = Label.getGraphics();
//		int blockWidth = (int)Math.round((double)Label.getWidth()/(double)visitedmaze.returnvisitedMaze()[0].length-1);
//		int blockHeight = (int)Math.round((double)Label.getHeight()/(double)visitedmaze.returnvisitedMaze().length);
//		
//		
//		Paint.setColor(new Color(51,253,255,50));
//		
//		
//		Boolean isFlood = false;
//		
//		while (isFlood == false) {
//			Paint.fillRect((int)floodPoint.getXpos()*blockWidth, (int)floodPoint.getYpos()*blockHeight, blockWidth, blockHeight);
//			floodPoint.move();
//			
//			int Xpos = (int)floodPoint.getXpos();
//			int Ypos = (int)floodPoint.getYpos();
//			
//			if(visitedmaze.returnvisitedMaze()[Ypos][Xpos] == "A") {
//				floodPoint.setFace(Actor.UP);
//			}
//			else if (visitedmaze.returnvisitedMaze()[Ypos][Xpos] == "B") {
//				
//			}
//			else if (visitedmaze.returnvisitedMaze()[Ypos][Xpos] == "C") {
//				
//			}
//			else if (visitedmaze.returnvisitedMaze()[Ypos][Xpos] == "D") {
//				floodPoint.setFace(Actor.UP);
//			}
//			
//			for(int y = 0; y< visitedmaze.returnvisitedMaze().length;y++) {
//				for (int x = 0; x < visitedmaze.returnvisitedMaze().length; x++) {
//					if (Flooding[y][x] != 1) {
//						isFlood = false;
//					}
//					else {
//						isFlood = true;
//					}
//				}
//			}
//		}
//		
//		System.out.println("COMPLETE MAZE");
//		
//	}
}