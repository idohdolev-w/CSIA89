import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
public class Game {

    Scanner s = new Scanner(System.in);
    int counter = 0;
    Deck d = new Deck();
    int ante = 10;
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Card> river = new ArrayList<Card>();
    public Map<Integer, String> dictionary = Map.of(
            1,"High Card",
            2,"Pair",
            3,"Two Pair",
            4,"Three of a Kind",
            5,"Straight",
            6,"Flush",
            7,"Full House",
            8,"Four of a Kind",
            9,"Straight Flush",
            10,"Royal Flush"
);

    public Game(Player p) { //shuffle players later so random turn order trust
        players.add(p);
    }

    public void riverProgression() {
        if (counter == 0) {
            Card burn = d.draw();
            for (int i = 0; i < 3; i++) {
                river.add(d.draw());
            }

            counter++;
        }
        else if (counter == 1) {
            Card burn = d.draw();
            river.add(d.draw());

            counter++;
        }
        else {
            Card burn = d.draw();
            river.add(d.draw());
        }

    }

    public int rCounter() { return counter; }

    public void gameLoop() {
        d.shuffle();
        String check="a";

        if (players.get(1).checkMoney() >= ante) {
            System.out.println("Would you like to play this round? the ante is " + ante + ". (Y/N)");
            check = s.nextLine();
        }

        if (check.equals("Y") || check.equals("y")) {

            for (Player p : players) {
                d = p.drawHand(d);
            }

        }

    }

}

// make game code, make bots, make it so that hands get added value for the cards in the win
