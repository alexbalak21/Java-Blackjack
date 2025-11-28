package window;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {
    private CardImg ace;
    private CardImg king;

    public CardPanel() {
        // Place cards at different positions
        ace = new CardImg("/cards_png/ace_of_spades.png", 100, 100);
        king = new CardImg("/cards_png/king_of_hearts.png", 250, 100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ace.draw(g);
        king.draw(g);
    }
}