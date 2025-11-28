package window;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private final Image image;

    public ImagePanel(String path) {
        image = new ImageIcon(path).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw image scaled to panel size
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}