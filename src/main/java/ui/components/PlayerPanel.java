package ui.components;

import game.cards.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerPanel extends JPanel {
    private final JPanel cardsPanel;
    private final JPanel buttonPanel;
    private final JLabel scoreLabel;
    private final JButton hitButton;
    private final JButton standButton;
    private final List<JLabel> cardLabels;
    private int currentScore;
    
    public PlayerPanel(ActionListener hitAction, ActionListener standAction) {
        setBackground(new Color(1, 127, 1)); // Match window background
        setBorder(BorderFactory.createTitledBorder("Player"));
        
        // Initialize components
        currentScore = 0;
        cardLabels = new ArrayList<>();
        
        // Create panels
        cardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        cardsPanel.setBackground(new Color(1, 127, 1));
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(1, 127, 1));
        
        // Create score display
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Create buttons
        hitButton = new JButton("Hit");
        standButton = new JButton("Stand");
        
        // Style buttons
        styleButton(hitButton, new Color(0, 180, 0));
        styleButton(standButton, new Color(200, 0, 0));
        
        // Add action listeners
        hitButton.addActionListener(hitAction);
        standButton.addActionListener(standAction);
        
        // Add components to button panel
        buttonPanel.add(scoreLabel);
        buttonPanel.add(Box.createHorizontalStrut(40));
        buttonPanel.add(hitButton);
        buttonPanel.add(standButton);
        
        // Set up the main layout
        setLayout(new BorderLayout(5, 5));
        add(cardsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(100, 35));
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
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
        
        // Update score (simplified - you'll need to implement actual Blackjack scoring)
        updateScore(card.getValue());
        
        // Refresh the panel to show the new card
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }
    
    /**
     * Updates the player's score display
     * @param points The points to add to the current score
     */
    public void updateScore(int points) {
        currentScore += points;
        scoreLabel.setText("Score: " + currentScore);
    }
    
    /**
     * Gets the current player's score
     * @return The current score
     */
    public int getScore() {
        return currentScore;
    }
    
    /**
     * Enables or disables the action buttons
     * @param enabled true to enable buttons, false to disable
     */
    public void setButtonsEnabled(boolean enabled) {
        hitButton.setEnabled(enabled);
        standButton.setEnabled(enabled);
    }
    
    /**
     * Clears all cards from the player's hand
     */
    public void clearCards() {
        cardsPanel.removeAll();
        cardLabels.clear();
        currentScore = 0;
        scoreLabel.setText("Score: 0");
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }
}
