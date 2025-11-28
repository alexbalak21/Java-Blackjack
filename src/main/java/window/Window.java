package window;
import javax.swing.*;

public class Window {
    private final int WIDTH = 1200;
    private final int HEIGHT = 800;
    public final JFrame frame;

    public Window(){
            frame = new JFrame("Black Jack");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 800);
            frame.getContentPane().setBackground(java.awt.Color.GREEN);
        }

    public void display(){
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

