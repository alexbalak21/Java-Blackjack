package game;

import window.*;
import game.cards.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create the main window
        window.Window window = new window.Window();
        
        // Create a panel to hold both dealer and player panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(1, 127, 1));
        
        // Create dealer panel
        DealerPanel dealerPanel = new DealerPanel();
        dealerPanel.setPreferredSize(new Dimension(window.frame.getWidth(), window.frame.getHeight() / 2));
        
        // Create player panel
        PlayerPanel playerPanel = new PlayerPanel();
        playerPanel.setPreferredSize(new Dimension(window.frame.getWidth(), window.frame.getHeight() / 2));
        
        // Create a test button to deal a card
        JButton dealButton = new JButton("Deal Card");
        dealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a test card (Ace of Spades)
                Card testCard = new Card(Rank.Ace, Suit.Spades);
                // Deal the card to the player
                playerPanel.dealCard(testCard);
            }
        });
        
        // Create a clear button to remove all cards
        JButton clearButton = new JButton("Clear Cards");
        clearButton.addActionListener(e -> playerPanel.clearCards());
        
        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(1, 127, 1));
        buttonPanel.add(dealButton);
        buttonPanel.add(clearButton);
        
        // Add components to the main panel
        mainPanel.add(dealerPanel, BorderLayout.NORTH);
        mainPanel.add(playerPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add the main panel to the window
        window.frame.getContentPane().add(mainPanel);
        
        // Display the window
        window.display();
        
        // Deal a test card when the application starts
        Card firstCard = new Card(Rank.Ten, Suit.Hearts);
        playerPanel.dealCard(firstCard);
    }
}
