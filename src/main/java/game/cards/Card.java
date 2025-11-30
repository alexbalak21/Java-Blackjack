package game.cards;

public class Card {
    public final Color color;
    public final Rank rank;
    public final Suit suit;
    
    //public final int value;

    public Card(Color color, Rank rank, Suit suit) {
        this.color = color;
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
