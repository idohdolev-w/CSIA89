import java.util.*;
import java.util.ArrayList;
public class Deck {

    public ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        String[] a = {"Diamond","Club","Heart","Spade"};
        for (int g = 0; g < 4; g++) {
            for (int i = 1; i < 14; i++) {
                cards.add(new Card(a[g],i));
            }
        }

    }

    public void printCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public Card draw() {
        return cards.removeFirst();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
