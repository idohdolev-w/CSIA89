import java.util.ArrayList;
import java.util.*;
public class Player {

    Scanner s = new Scanner(System.in);
    private ArrayList<Card> cards = new ArrayList<Card>();
    public String name;
    public int money;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String returnName() { return name; }

    public Deck drawHand(Deck d) {
        for (int i = 0; i < 2; i++) {
            cards.add(d.draw());
        }
        return d;
    }

    public void tellCards() {
        for (Card c: cards) {
            System.out.println(c.toString());
        }
    }

    public void win(int j) {
        money+=j;
    }

    public int bet() {
        int playerBet = -1;
        System.out.println("You have $" + money);

        while (playerBet <= 0) {
            System.out.print("How much do you want to bet?  ");

            try {
                playerBet = s.nextInt();

                if (playerBet < 0) {
                    System.out.println("you can't bet negative money");
                } else if (playerBet == 0) {
                    System.out.println("you have to bet money");
                }
            } catch (InputMismatchException e) {
                System.out.println("you have to bet a whole number.");
                s.nextLine();
            }
        }



        return playerBet;
    }

    public int checkWin(ArrayList<Card> river) {

        ArrayList<Card> all = new ArrayList<>();
        all.addAll(cards);
        all.addAll(river);

        int[] valueCount = new int[15];
        int[] suitCount = new int[4];

        for (Card c : all) {

            int value = c.returnValue();
            String suit = c.returnSuit();

            valueCount[value]++;

            if (value == 1) {
                valueCount[14]++;
            }

            switch (suit) {
                case "Heart": suitCount[0]++; break;
                case "Diamond": suitCount[1]++; break;
                case "Club": suitCount[2]++; break;
                case "Spade": suitCount[3]++; break;
            }
        }


        boolean flush = false;
        String flushSuit = null;

        if (suitCount[0] >= 5) { flush = true; flushSuit = "Heart"; }
        if (suitCount[1] >= 5) { flush = true; flushSuit = "Diamond"; }
        if (suitCount[2] >= 5) { flush = true; flushSuit = "Club"; }
        if (suitCount[3] >= 5) { flush = true; flushSuit = "Spade"; }


        boolean straight = false;
        int consecutive = 0;

        for (int i = 14; i >= 1; i--) {
            if (valueCount[i] > 0) {
                consecutive++;
                if (consecutive >= 5) {
                    straight = true;
                }
            } else {
                consecutive = 0;
            }
        }


        if (flush) {

            ArrayList<Integer> flushValues = new ArrayList<>();

            for (Card c : all) {
                if (c.returnSuit().equals(flushSuit)) {

                    int v = c.returnValue();
                    flushValues.add(v);

                    if (v == 1) {
                        flushValues.add(14);
                    }
                }
            }

            Collections.sort(flushValues);

            int count = 1;

            for (int i = 1; i < flushValues.size(); i++) {

                if (flushValues.get(i) == flushValues.get(i - 1) + 1) {
                    count++;

                    if (count >= 5) {

                        if (flushValues.get(i) == 14 || flushValues.get(i)+1 == 14) {
                            return 10;
                        }

                        return 9;
                    }

                } else if (!flushValues.get(i).equals(flushValues.get(i - 1))) {
                    count = 1;
                }
            }
        }

        int pairs = 0;
        int threeCount = 0;
        boolean four = false;

        for (int i = 1; i <= 14; i++) {

            if (valueCount[i] == 4) four = true;
            if (valueCount[i] == 3) threeCount++;
            if (valueCount[i] == 2) pairs++;
        }

        if (four) return 8;

        if (threeCount >= 2 || (threeCount == 1 && pairs >= 1))
            return 7;

        if (flush) return 6;

        if (straight) return 5;

        if (threeCount == 1) return 4;

        if (pairs >= 2) return 3;

        if (pairs == 1) return 2;

        return 1;
    }




}
