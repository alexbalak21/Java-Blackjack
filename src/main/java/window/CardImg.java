package window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class CardImg {
    private BufferedImage image;
    private int x;
    private int y;

    public CardImg(String resourcePath, int x, int y) {
        try {
            // Load card image from resources (e.g. /cards_png/ace_of_spades.png)
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(resourcePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
        }
    }

    // Optional setters if you want to move the card later
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}