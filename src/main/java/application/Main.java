package application;

import game.GameController;
import game.cards.Card;
import game.cards.Deck;
import ui.MainWindow;
import ui.components.PlayerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main {
    private static GameController gameController;
    private static MainWindow mainWindow;
    private static PlayerPanel playerPanel;

    public static void main(String[] args) {
        // Initialize the game controller
        gameController = new GameController();
        
        // Initialize the main window
        SwingUtilities.invokeLater(() -> {
            mainWindow = new MainWindow();
            mainWindow.setVisible(true);
            
            // Get references to UI components
            playerPanel = mainWindow.getPlayerPanel();
            
            // Set up game controls
            setupGameControls();
            
            // Start a new game
            startNewGame();
        });
    }
    
    private static void setupGameControls() {
        // Set up hit action
        playerPanel.setHitAction(e -> {
            gameController.playerHits();
            updateGameState();
        });
        
        // Set up stand action
        playerPanel.setStandAction(e -> {
            gameController.playerStands();
            updateGameState();
        });
    }
    
    private static void startNewGame() {
        gameController.startNewGame();
        updateGameState();
    }
    
    private static void updateGameState() {
        // Update UI based on game state
        int playerScore = gameController.getPlayerScore();
        playerPanel.updateScore(playerScore);
        
        // Enable/disable buttons based on game state
        boolean canHit = gameController.canPlayerHit();
        playerPanel.setButtonsEnabled(canHit);
        
        // Check for game over
        if (gameController.isGameOver()) {
            showGameResult();
        }
    }
    
    private static void showGameResult() {
        String message = gameController.getGameResult();
        JOptionPane.showMessageDialog(mainWindow, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        startNewGame(); // Start a new game after showing the result
    }
}