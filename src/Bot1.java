import java.util.ArrayList;
import java.util.Random;

public class Bot1 extends Player {

    Random random = new Random();

    enum actions {
        CHECK,
        RAISE,
        CALL,
        FOLD
    }

    int round = 1;

    public Bot1(String name, int money) {
        super(name, money);
    }

    public Bot1() {
        super("brin wei", 0);
    }

    public void increaseRound() {
        round++;
    }

    public actions chooseAction(ArrayList<Card> river) {

        ArrayList<Card> hand = returnCards();

        Card c1 = hand.get(0);
        Card c2 = hand.get(1);

        int v1 = c1.returnValue();
        int v2 = c2.returnValue();

        int totalValue = v1 + v2;
        boolean sameSuit = c1.returnSuit().equals(c2.returnSuit());
        boolean pair = (v1 == v2);

        // ------------------------------------------------
        // PRE-FLOP (no river yet)
        // ------------------------------------------------
        if (river.isEmpty()) {

            // Early rounds = tight
            if (round <= 3) {

                if (sameSuit && totalValue < 13)
                    return actions.FOLD;

                if (!sameSuit && totalValue < 9)
                    return actions.FOLD;

                if (pair && v1 >= 10)
                    return actions.RAISE;

                return actions.CALL;
            }

            // Mid rounds = looser
            if (round <= 6) {

                if (pair)
                    return actions.RAISE;

                if (sameSuit)
                    return actions.CALL;

                return random.nextBoolean() ? actions.CALL : actions.FOLD;
            }

            // Late rounds = bluff mode
            int bluff = random.nextInt(100);

            if (bluff < 35)
                return actions.RAISE;

            if (bluff < 80)
                return actions.CALL;

            return actions.FOLD;
        }

        // ------------------------------------------------
        // POST-FLOP / TURN / RIVER
        // ------------------------------------------------

        int rank = checkWin(river);

        // After river (5 cards on table)
        if (river.size() == 5) {

            // Fold if no pair or better
            if (rank <= 1)
                return actions.FOLD;

            if (rank >= 4)
                return actions.RAISE;

            return actions.CALL;
        }

        // Before full river — evaluate strength
        if (rank >= 5)   // straight or better
            return actions.RAISE;

        if (rank >= 2)   // pair+
            return actions.CALL;

        // Weak hand — sometimes bluff
        if (round > 5 && random.nextInt(100) < 25)
            return actions.RAISE;

        return actions.FOLD;
    }
}