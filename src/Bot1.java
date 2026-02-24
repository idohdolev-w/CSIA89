import java.util.Random;
public class Bot1 extends Player{
    Random random = new Random();
    enum actions {
        CHECK,
        RAISE,
        CALL,
        FOLD
    }
    int round = 1;

    public Bot1() {
        this.name = ("brin wei");
    }

    public void setMoney(int m) {
        this.money = m;
    }

    public void increaseRound() { round++; }

    public actions chooseAction() {
      // fold if cards are same suit but less than a collective value of 13, or diff suit and collective value less than 9 --> fold
      // if no hand higher than pair after second river, fold
      // as time goes on, these selections change and flip, he will no longer fold after multiple times playing together.
    }



}
