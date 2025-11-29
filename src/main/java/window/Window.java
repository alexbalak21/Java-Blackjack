package window;
import javax.swing.*;

public class Window {
    private final int WIDTH = 1200;
    private final int HEIGHT = 800;
    public final JFrame frame;

    public Window(){
            frame = new JFrame("Black Jack");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);
            frame.getContentPane().setBackground(new java.awt.Color(1, 127, 1)); // #017F01
        }

    public void display(){
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

