import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.*;
public class Game {

    Scanner s = new Scanner(System.in);
    int counter = 0;
    Deck d = new Deck();
    int baseAnte = 10;
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Integer> order = new ArrayList<>();
    ArrayList<Card> river = new ArrayList<>();
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

    public Game(Player p) {
        players.add(p);
    }

    public void drawRiver() {
        for (Card c: river) {
            System.out.println(c.toString());
        }
    }

    public void addBots() {
        int g =1;
    }

    public void riverProgression() {
        if (counter == 0) {
            Card burn = d.draw();
            for (int i = 0; i < 3; i++) {
                river.add(d.draw());
            }

            counter++;
            drawRiver();

        }
        else if (counter == 1) {
            Card burn = d.draw();
            river.add(d.draw());

            counter++;
            drawRiver();
        }
        else {
            Card burn = d.draw();
            river.add(d.draw());

            drawRiver();
        }

    }

    public int rCounter() { return counter; }

    public void gameLoop() {
        d.shuffle();
        for (int i = 0; i < 4; i++) {
            order.add(i);
        }
        Collections.shuffle(order);

    }

    }



// make game code, make bots, make it so that hands get added value for the cards in the win
