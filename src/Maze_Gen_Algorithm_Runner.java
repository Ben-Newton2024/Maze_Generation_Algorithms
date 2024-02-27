import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Maze_Gen_Algorithm_Runner {

    // runner class, to be the '.exe' file for the application.
    public static void main(String[] args) {
        Main display_window = new Main();

        // settings for the frame of the application, and what will be displayed upon it.
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(display_window);
        window.setIconImage(new ImageIcon("ICON.png").getImage());
        window.pack();
        window.setVisible(true);
    }
}