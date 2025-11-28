package window;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {
    private CardImg ace;
    private CardImg king;
    private CardImg queen;

    public CardPanel() {
        // Place cards at different positions
        ace = new CardImg("/cards_png/ace_of_spades.png");
        king = new CardImg("/cards_png/king_of_hearts.png");
        queen = new CardImg("/cards_png/queen_of_hearts.png");

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ace.draw(g);
        king.draw(g, 35, 0);
        queen.draw(g, 70, 0);
    }
}