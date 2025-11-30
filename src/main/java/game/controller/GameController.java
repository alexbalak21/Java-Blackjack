package game.controller;

import game.cards.Card;
import game.cards.Deck;
import game.model.Dealer;
import game.model.Player;
import game.model.Hand;
import game.service.GameRules;
import game.service.DeckService;

public class GameController {
    private final Player player;
    private final Dealer dealer;
    private final DeckService deckService;
    private final GameRules gameRules;
    private boolean gameInProgress;

    public GameController() {
        this.player = new Player();
        this.dealer = new Dealer();
        this.deckService = new DeckService();
        this.gameRules = new GameRules();
        this.gameInProgress = false;
    }

    public void startNewGame() {
        deckService.initializeDeck();
        player.getHand().clear();
        dealer.getHand().clear();
        gameInProgress = true;
        
        // Deal initial cards
        dealInitialCards();
    }

    private void dealInitialCards() {
        // Deal two cards to player
        player.addCard(deckService.dealCard());
        player.addCard(deckService.dealCard());
        
        // Deal two cards to dealer (one face down)
        dealer.addCard(deckService.dealCard());
        dealer.addCard(deckService.dealCard());
    }

    public void playerHits() {
        if (gameInProgress) {
            player.addCard(deckService.dealCard());
            if (gameRules.isBust(player.getHand().getValue())) {
                gameInProgress = false;
            }
        }
    }

    public void playerStands() {
        if (gameInProgress) {
            dealerPlay();
            gameInProgress = false;
        }
    }

    private void dealerPlay() {
        // Dealer reveals their face-down card
        dealer.revealCards();
        
        // Dealer hits until they have at least 17
        while (dealer.getHand().getValue() < 17) {
            dealer.addCard(deckService.dealCard());
        }
    }

    public int getPlayerScore() {
        return player.getHand().getValue();
    }

    public boolean canPlayerHit() {
        return gameInProgress && !gameRules.isBust(player.getHand().getValue());
    }

    public boolean isGameOver() {
        return !gameInProgress;
    }

    public String getGameResult() {
        int playerScore = player.getHand().getBestValue();
        int dealerScore = dealer.getHand().getBestValue();
        
        if (gameRules.isBust(playerScore)) {
            return "Bust! You lose!";
        } else if (gameRules.isBust(dealerScore)) {
            return "Dealer busts! You win!";
        } else if (playerScore > dealerScore) {
            return "You win! " + playerScore + " to " + dealerScore;
        } else if (dealerScore > playerScore) {
            return "You lose! " + dealerScore + " to " + playerScore;
        } else {
            return "Push! It's a tie!";
        }
    }
}