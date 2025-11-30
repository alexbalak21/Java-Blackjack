package game.cards;

public class Card {
    public final Rank rank;
    public final Suit suit;
    //public final int value;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
