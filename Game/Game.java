package Game;

import Player.Player;
import deck.Deck;

import java.util.Objects;
import java.util.Scanner;

public class Game {
    private double pot; // The sum of all bet money between player and dealer
    Scanner input = new Scanner(System.in);
    Deck d = new Deck();
    //public Game(Player p, Player d){
    Player player = new Player();
    Player dealer = new Player();

    public void GameStart(){
        GameMassages.gameIntro();
        GameMassages.betAmount();
        pot = input.nextDouble()*2;
        GameMassages.GameStart(pot);
        if (FirstRound()){                      // Checking blackjack boolean return if true game will end, if not true game will continue
        }else {
            gameLoop();
        }
    }
    public void gameLoop(){                     // Gaming looping for drawing next card
        while(true){
            GameMassages.drawingMoreCard();
            String Drawing = input.next();
            if (Objects.equals(Drawing, "f")){
                System.out.println("I'm finalizing the result!");
                finalizingResult();             // When the player chose to end the game, the system will finalize and display the result
                break;                          // Break the loop
            }
            drawCards();                        // Drawing the next card method.
            if (totalCardsValue()){             // Checking for total card on both hands, if 21 game will end.
                break;
            }
        }
    }
    private void finalizingResult() {
        int playerValue = player.totalValueOnHand();
        int dealerValue = dealer.totalValueOnHand();
        System.out.println("Player total: " + player.totalValueOnHand());   // get total value of all cards
        System.out.println("Dealer total: " + dealer.totalValueOnHand());
        if (playerValue > dealerValue) {         // player more value than player, player will win (if the player choose to end the game early)
            player.setMoney(pot);
            GameMassages.Winner(player.getMoney());
        } else if(playerValue < dealerValue) {
            player.setMoney(0);
            GameMassages.Loser(player.getMoney());                   // same in opposite
        }else{
            GameMassages.gameIsDraw();
        }
    }
    public boolean FirstRound(){                // First round
        boolean blackjackCheck = false;
        d.shuffleDeck();     // Shuffle the deck
        firstHandOut();// Handing the fist two card to the player and dealer
        if (firstTwoCard()){                    // Checking for blackjack with the first two cards.
            blackjackCheck = true;
        }
        return blackjackCheck;
    }
    private boolean firstTwoCard() {
        boolean gameEnded = false;
        System.out.println("Player total: " + player.totalValueOnHand());   // get total value of all cards
        //System.out.println("Dealer total: " + dealer.totalValueOnHand());    // comment out for hide dealer value
        int playerValue = player.totalValueOnHand();
        int dealerValue = dealer.totalValueOnHand();
        if (playerValue == 21){                 // 21 will be blackjack with the first two cards.
            player.setMoney(pot*1.5);
            GameMassages.BlackJack(player.getMoney());
            gameEnded = true;
        }
        if (dealerValue == 21){
            player.setMoney(0);
            GameMassages.BlackJackDealer(player.getMoney());
            gameEnded = true;
        }
        if (playerValue == 21 && dealerValue == 21){
            GameMassages.gameIsDraw();
        }
        return gameEnded;
    }
    public boolean totalCardsValue(){           // Checking total cards in both hands
        boolean gameEnded = false;
        System.out.println("Player total: " + player.totalValueOnHand());   // get total value of all cards
        //System.out.println("Dealer total: " + dealer.totalValueOnHand());     //comment out for hide dealer value
        int playerValue = player.totalValueOnHand();
        int dealerValue = dealer.totalValueOnHand();

        // If one of both OR both are over 21 points, game will end immediately.
        if (playerValue > 21){
            player.setMoney(0);
            gameEnded = true;
            GameMassages.PlayerBuzz(player.getMoney());
        }
        if (dealerValue > 21) {
            player.setMoney(pot);
            gameEnded = true;
            GameMassages.DealerBuzz(player.getMoney());
        }
        if (playerValue > 21 && dealerValue > 21){
            GameMassages.gameIsDraw();
        }
        System.out.println("\n");
        return gameEnded;
    }

    private void firstHandOut() {   // First-hand out two cards
        player.putCardOnHand(d);
        dealer.putCardOnHand(d);
        player.putCardOnHand(d);
        dealer.putCardOnHand(d);



    }
    public void drawCards(){       // Draw card method.
        System.out.println(player.putCardOnHand(d));
        System.out.println(dealer.putCardOnHand(d));
    }






    // handle all rules for the game
    // handle the game loop
    // handle all hand comparisons and win conditions


    // should consist of player and dealer
    // aggregation of player and dealer
    // should have a deck
}

