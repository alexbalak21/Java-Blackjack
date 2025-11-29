package window;

import game.cards.Card;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerPanel extends JPanel {
    private final JPanel cardsPanel;
    private final List<JLabel> cardLabels;
    
    public PlayerPanel() {
        setBackground(new Color(1, 127, 1)); // Match window background
        setBorder(BorderFactory.createTitledBorder("Player"));
        
        // Create a panel to hold the cards
        cardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        cardsPanel.setBackground(new Color(1, 127, 1));
        
        // Initialize the list to hold card labels
        cardLabels = new ArrayList<>();
        
        // Set up the layout
        setLayout(new BorderLayout());
        add(cardsPanel, BorderLayout.CENTER);
    }
    
    /**
     * Adds a card to the player's hand and updates the display
     * @param card The card to be added to the player's hand
     */
    public void dealCard(Card card) {
        // Create a label for the card
        String imagePath = String.format("/PNG-cards/%s_of_%s.png", 
            card.rank.toString().toLowerCase(),
            card.suit.toString().toLowerCase());
        
        // Load the card image
        ImageIcon cardIcon = new ImageIcon(getClass().getResource(imagePath));
        
        // Scale the image if needed (adjust size as needed)
        Image scaledImage = cardIcon.getImage().getScaledInstance(100, 145, Image.SCALE_SMOOTH);
        cardIcon = new ImageIcon(scaledImage);
        
        // Create and add the label to the panel
        JLabel cardLabel = new JLabel(cardIcon);
        cardLabels.add(cardLabel);
        cardsPanel.add(cardLabel);
        
        // Refresh the panel to show the new card
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }
    
    /**
     * Clears all cards from the player's hand
     */
    public void clearCards() {
        cardsPanel.removeAll();
        cardLabels.clear();
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }
}
