package deck;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        loadDeck();
    }

    public void loadDeck(){
        for (Suit s: Suit.values()){
            for (Rank r: Rank.values()){
                deck.add(new Card(s,r));
            }
        }
    }
    public Card dealCard(){
        return deck.remove(0);
    }

    public void shuffleDeck(){
        int min = 1;
        int max = 50;
        Card C1, C2;
        for (int i = 0; i < deck.size(); i++){
            // generate random from i+1 - 51
            int randomCard = (int)Math.floor(Math.random()*(max-min+1)+min);
            C1 = deck.get(i);           // get value of index 0
            C2 = deck.get(randomCard);  // get value of index random number
            deck.set(i, C2);            // set the index i to be the "value of index random"
            deck.set(randomCard, C1);   // set back the "index of random number" to the "value of index i"
        }
        System.out.println("Cards are already shuffled!");
    }


    public void printDeck(){
        for (Card c: deck) {
            System.out.println(c);
        }
        System.out.println("Total card remaining: "+deck.size());
    }
    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

}
