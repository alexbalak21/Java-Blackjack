package game;

import game.cards.Card;
import game.cards.Deck;
import game.cards.Rank;
import game.cards.Suit;

public class Main {
    static void main() {
        Deck deck = new Deck();
        deck.shuffle();
        deck.printDeck();
    }
}
