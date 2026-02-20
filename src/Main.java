import java.util.*;
public static void main(String[] args) {
    Deck d = new Deck();
    d.shuffle();
    ArrayList<Card> river = new ArrayList<Card>();
    for (int i = 0; i < 5; i++) {
        river.add(d.draw());
    }



    Player luke = new Player("Luke", -10);

    System.out.println(luke.returnName());
    d = luke.drawHand(d);
    luke.tellCards();

    System.out.println("");

    for (Card rc: river) {
        System.out.println(rc.toString());
    }

    System.out.println(luke.checkWin(river));

    boolean b = true;
    while (b) {
        int f = luke.bet();
        if (f > 0) {
            b = false;
        }
    }
}