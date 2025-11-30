package game.output;

import game.cards.Card;

public class PrintCard {

    public static void print(Card card){
        String output = "";
        switch (card.suit) {
            case Hearts :
                output += "♥";
                break;
            case Diamonds :
                output += "♦";
                break;
            case Clubs :
                output += "♣";
                break;
            case Spades :
                output += "♠";
                break;
            default:
                break;
        }
        output += " " + card.rank;
        System.out.println(output);
    }

}
