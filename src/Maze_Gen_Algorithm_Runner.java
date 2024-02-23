import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Maze_Gen_Algorithm_Runner {

    /////////////////////////////////IS THE MESS OF THE RUNNER FOR THE STUFF//////////////////////////////////////
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main display_window = new Main();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(display_window);
        window.setIconImage(new ImageIcon("ICON.png").getImage());
        window.pack();
        window.setVisible(true);
    }
}