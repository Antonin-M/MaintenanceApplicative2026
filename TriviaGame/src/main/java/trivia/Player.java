package trivia;

public class Player {
    private String name;
    private int place;
    private int coins;
    private boolean inPenaltyBox;

    public Player(String name) {
        this.name = name;
        this.place = 1;
        this.coins = 0;
        this.inPenaltyBox = false;
    }

    public String getName() {
        return name;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {this.place = place;}

    public int getCoins() {
        return coins;
    }

    public void addCoins() {
        this.coins++;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }
}
