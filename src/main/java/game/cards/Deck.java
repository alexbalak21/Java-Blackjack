package game.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
    public final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

   public void printDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
