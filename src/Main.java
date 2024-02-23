import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Main extends JPanel implements ActionListener, ChangeListener{

    ///////////////////////////////////////////////////ALL THE VARIABLES//////////////////////////////////////////////////////////

    //EACH OF THE MAZES
    private final MazeGen my_visited_maze = new MazeGen();
    private MazeGen CurrentMaze  = new MazeGen();
    private final MazePanel painter = new MazePanel();



    //EAH OF THE pointS FOR EACH FOR CURRENTLY DISPLAYED DEVELOPING MAZES
    private final Bloc point	= new Bloc(Color.RED);


    //EACH OF THE ALGORITHMS TO BE RECALLED FROM THERE CLASS
    //ONE OF EACH AS WHO WOULD DECIDE TO RUN THE SAME AGAINST EACH OTHER - WHAT KINDA STATE OF MIND WOULD THEY BE IN
    private final SideWinderAlgorithm sidewinder = new SideWinderAlgorithm();
    private final WilsonAlgorithm wilson = new WilsonAlgorithm();
    private final BinaryTreeAlgorithm binary_tree = new BinaryTreeAlgorithm();

    //NORTH PANEL BUTTONS

    private final JSlider size = new JSlider(JSlider.HORIZONTAL,10,100,50);
    private final JButton Reset = new JButton("Blank Canvas");

    //WEST PANEL BUTTONS
    private final JButton side_winder_button = new JButton("Sidewinder Algorithm");
    private final JButton binary_tree_button = new JButton("Binary tree Algorithm");
    private final JButton wilson_button = new JButton("Wilson Algorithm");



    //FUNCTION THAT IS CALLED TO ALL THE MAZES CAN HAVE A VALUE ASSIGNED TO THEM TO MAKE THEIR size
    public void set_maze_size(int xq) {

        //TO MAKE EMPTY MAZES
        my_visited_maze.emtpy_visited_maze(xq);
    }

    //CONSTRUCTOR
    public Main() {

        //MUST SET SIZE OF MAZES SO WHEN IT DRAWS EMPTY MAZE TO BEGIN WITH IT DOESN'T CAUSE
        //A NULL POINTER ERROR

        int x = size.getValue();
        set_maze_size(x);
        CurrentMaze.emtpy_visited_maze(x);
        painter.paint_Maze(CurrentMaze);


        //SETTING MAIN CLASS OF EXTENDED JPANEL TO HAVE A BORDER LAYOUT
        BorderLayout MainLayout = new BorderLayout();
        this.setLayout(MainLayout);

        /////////////////////WEST///////////////////////////////


        //WEST JPANEL FOR THE ALGORITHM ACTIVATION BUTTONS
        JPanel WestPanel = new JPanel();

        //WEST PANEL HAS A GRID LAYOUT OF THE 3 BUTTONS
        //MAY NEED TO INCREASE IF MORE ALGORITHMS ARE ADDED
        GridLayout WestLayout = new GridLayout(3,1);

        //SETTING THR WEST JPANEL OF BUTTONS A GRIDLAYOUT
        WestPanel.setLayout(WestLayout);

        WestPanel.add(side_winder_button);
        WestPanel.add(binary_tree_button);
        WestPanel.add(wilson_button);



        /////////////////////NORTH//////////////////////////////

        //NORTHERN JPANEL
        JPanel NorthPanel = new JPanel();
        //GRID LAYOUT FOR THE NEW PANEL THAT LIES ON TOP
        GridLayout NorthLayout = new GridLayout(1,2);

        //GRID BUTTON AND SLIDER FOR NORTH
        NorthPanel.setLayout(NorthLayout);

        NorthPanel.add(size);
        NorthPanel.add(Reset);

        ///////////ACTION LISTENERS/////////////////////////////
        side_winder_button.addActionListener(this);
        binary_tree_button.addActionListener(this);
        wilson_button.addActionListener(this);
        Reset.addActionListener(this);

        //do all the fancy JSlider stuff.
        size.setMajorTickSpacing(10);
        size.setMinorTickSpacing(5);
        size.setPaintTicks(true);
        size.setPaintLabels(true);
        size.addChangeListener(this);

        //adding all the panels to main display
        this.add(NorthPanel, BorderLayout.NORTH);
        this.add(WestPanel, BorderLayout.WEST);
        this.add(painter, BorderLayout.CENTER);
    }




    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////MAIN PAINT COMPONENT//////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////ACTION EVENTS//////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == side_winder_button) {
            CurrentMaze = (sidewinder.sidewinder(my_visited_maze));
            painter.paint_Maze(CurrentMaze);
        }
        if(e.getSource() == binary_tree_button) {
            CurrentMaze = binary_tree.binary_tree(my_visited_maze);
            painter.paint_Maze(CurrentMaze);
        }
        if(e.getSource() == wilson_button) {
            CurrentMaze = wilson.wilson(point, my_visited_maze);
            painter.paint_Maze(CurrentMaze);
        }
        if(e.getSource() == Reset) {
            int x = size.getValue();
            set_maze_size(x);
            painter.paint_Maze(my_visited_maze);
        }
        repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int x = size.getValue();
        set_maze_size(x);

    }
}