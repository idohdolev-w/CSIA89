import java.util.HashMap;
import java.util.Map;
public class Game {

    Deck GameDeck = new Deck();
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


}

// make game code, make bots, make it so that hands get added value for the cards in the win
