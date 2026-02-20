public class Card {

    String suit;
    int rank;


    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;

    }

    public String toString() {
        if (rank < 11 && rank > 1) {
            return rank + " of " + suit+"s";
        } else if(rank>10) {
            String[] h = {"jack", "queen", "king"};
            return h[rank%10-1] + " of " + suit+"s";
        } else {
            return "Ace of " + suit + "s";
        }
    }

    public int returnValue() {
        return rank;
    }
    public String returnSuit() { return suit; }



}
