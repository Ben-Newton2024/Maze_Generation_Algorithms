import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JPanel implements ActionListener, ChangeListener{

   /*
        Main is the JPanel that is used for User Interface.
            this includes the action listeners, and maze panel for where the generated maze is going to nbe displayed.
            it is done in boarder layouts, layered with extra panels holding their components, as well, in groups.

    */



    /*
        create 2 2D array sets.
            for the mazes, to be drawn onto and later displayed.
            one for error checking to ensure no mistakes.
     */
    private final MazeGen my_visited_maze = new MazeGen();
    private MazeGen CurrentMaze  = new MazeGen();

    // create an instance of MazePanel - a JPanel used for mazes to be drawn on for the application.
    private final MazePanel painter = new MazePanel();
    // create the 'head' of the maze a movable 'character' that will draw the maze,
    // as it moves around the 'map' (2D array)
    private final Bloc point = new Bloc(Color.RED);


    // Create an instance of the maze generation algorithms to be used for calling and drawing the mazes.
    private final SideWinderAlgorithm sidewinder = new SideWinderAlgorithm();
    private final WilsonAlgorithm wilson = new WilsonAlgorithm();
    private final BinaryTreeAlgorithm binary_tree = new BinaryTreeAlgorithm();

    /*
        UI for application

            Starting with the North side,
                size - slider panel that will move to set the size of the desired 'map'
                reset - button that will be used to reset the 2D array (map) to empty with boarders.

            West side
                3 buttons - one for each of the algorithms
                when pressed they will call their corresponding class to start that section of the code
                to start creating a maze.
     */

    // north
    private final JSlider size = new JSlider(JSlider.HORIZONTAL,10,100,50);

    // west
    private final JButton side_winder_button = new JButton("Sidewinder Algorithm");
    private final JButton binary_tree_button = new JButton("Binary tree Algorithm");
    private final JButton wilson_button = new JButton("Wilson Algorithm");



    // to set the size of the maze whenever the slider moves position to that digit size.
    public void set_maze_size(int xq) {
        // recreates the maze, as a blank type ready to be used.
        my_visited_maze.emtpy_visited_maze(xq);
    }

    //constructor
    public Main() {

        // set the size of the maze else when maze panel jpanel is called, it will cause null pointer error out of bounds
        // as there won't be a maze to draw, it'll be an empty 2D array.
        int x = size.getValue();
        set_maze_size(x);
        CurrentMaze.emtpy_visited_maze(x);
        // call painter, to redraw the maze, using the paint component.
        painter.paint_Maze(CurrentMaze);


        // setting main to have a boarder layout for the corresponding components to be drawn where needed.
        BorderLayout MainLayout = new BorderLayout();
        this.setLayout(MainLayout);

        /*
            Grouping the west side buttons in a grid layout,
            3, 1
            leaving a column of buttons on the west boarder of the application.
         */
        JPanel WestPanel = new JPanel();
        GridLayout WestLayout = new GridLayout(3,1);
        WestPanel.setLayout(WestLayout);
        // adding components to the JPanel
        WestPanel.add(side_winder_button);
        WestPanel.add(binary_tree_button);
        WestPanel.add(wilson_button);



        /*
            grouping the north side components, in a grid layout.
            1,2
            size and reset button, to be drawn on the north border of the Main JPanel.
         */
        JPanel NorthPanel = new JPanel();
        GridLayout NorthLayout = new GridLayout(1,2);
        NorthPanel.setLayout(NorthLayout);
        NorthPanel.add(size);


        // setting action listeners to main.
        side_winder_button.addActionListener(this);
        binary_tree_button.addActionListener(this);
        wilson_button.addActionListener(this);

        // J slider settings, such as length, spacing, how it needs to be drawn basically.
        size.setMajorTickSpacing(10);
        size.setMinorTickSpacing(5);
        size.setPaintTicks(true);
        size.setPaintLabels(true);
        size.addChangeListener(this);

        //adding earlier panels, to the main panel. in earlier stated grid layout.
        this.add(NorthPanel, BorderLayout.NORTH);
        this.add(WestPanel, BorderLayout.WEST);
        this.add(painter, BorderLayout.CENTER);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////ACTION EVENTS//////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /*
        action events, for capturing, whenever anything is pressed on the application, to allow for them to have logic,
        else a button could be clicked and would do anything as the action taken wouldn't be recorded and sent here.
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == side_winder_button) {
            int x = size.getValue();
            set_maze_size(x);
            painter.paint_Maze(my_visited_maze);
            CurrentMaze = (sidewinder.sidewinder(my_visited_maze));
            painter.paint_Maze(CurrentMaze);
        }
        if(e.getSource() == binary_tree_button) {
            int x = size.getValue();
            set_maze_size(x);
            painter.paint_Maze(my_visited_maze);
            CurrentMaze = binary_tree.binary_tree(my_visited_maze);
            painter.paint_Maze(CurrentMaze);
        }
        if(e.getSource() == wilson_button) {
            int x = size.getValue();
            set_maze_size(x);
            painter.paint_Maze(my_visited_maze);
            CurrentMaze = wilson.wilson(point, my_visited_maze);
            painter.paint_Maze(CurrentMaze);
        }
        repaint();
    }

    // to capture the slider, as it changes state, it doesn't just turn on and off like a button.
    @Override
    public void stateChanged(ChangeEvent e) {
        int x = size.getValue();
        set_maze_size(x);

    }
}