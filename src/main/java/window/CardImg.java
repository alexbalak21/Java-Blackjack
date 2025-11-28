package window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class CardImg {
    private BufferedImage image;
    private final float RATIO = 1.452f;
    private final int WIDTH = 200;
    private final int HEIGHT = (int) (WIDTH * RATIO);

    public CardImg(String resourcePath) {
        try {
            // Load card image from resources (e.g. /cards_png/ace_of_spades.png)
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(resourcePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Draw the card at any position you pass in
    public void draw(Graphics g, int x, int y) {
        if (image != null) {
            g.drawImage(image, x, y, WIDTH, HEIGHT, null);
        }
    }


    public void draw (Graphics g){
        if (image != null) {
            g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
        }

    }
}
