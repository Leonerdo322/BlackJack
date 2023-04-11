package deck;

public enum Suit {
    HEART("Hearts"), DIAMOND("Diamonds"), CLUB("Club"), SPADES("Spades");
    String name;
    Suit (String n){
        name = n;
    }

    public String getName() {
        return name;
    }
}
