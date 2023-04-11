package Player;

import deck.Card;
import deck.Deck;
import deck.Rank;

import java.util.ArrayList;

public class Player {
    private double money;
    private ArrayList<Card> onHand = new ArrayList<>();
    public Player() {
    }

    // Constructor for money bet
    public Player(int money){
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }






    public ArrayList putCardOnHand(Deck d){
        onHand.add(d.dealCard());
        return onHand;
    }
    public void totalCardOnHand(){
        System.out.println(onHand.size());
    }

    public int totalValueOnHand(){
        int totalCardOnHand = 0;
        int totalACEs = 0;
        int totalRemove = 0;
        for (int i = 0; i < onHand.size(); i++){
            if (onHand.get(i).getRank() == Rank.ACE){   // If ACEs Card detected the total cards will add up
                totalACEs++;
                if (totalACEs >= 2){                    // if more than two ACEs cards the total card - 1 will have value as 1
                   totalRemove = 10*(totalACEs-1);      // Therefore the 2nd cards and after will add up to total cards and * with 10, =>> remove to total.
                }
            }
            totalCardOnHand += onHand.get(i).getRankValue() - totalRemove;

        }
        return totalCardOnHand;
    }

}
