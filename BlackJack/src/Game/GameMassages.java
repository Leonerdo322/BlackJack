package Game;

public class GameMassages {
    public static void gameIntro(){
        System.out.println("\t\t\t\t\tWelcome to BlackJack!");
        System.out.println("Dealer and you will have two cards! ");
    }

    public static void StartTheGame() {
        System.out.print("Please enter 1 to start the game! ");
    }

    public static void drawingMoreCard() {
        System.out.println("Would you like to draw more card!\n" +
                "If you draw more! Dealer also draw more!");
        System.out.print("If you do not draw a card, the game will stop! (enter 'f' to stop)");
    }


    public static void Winner(double money) {
        System.out.println("The player beat down the dealer!, with winning amount: $" + money);
    }
    public static void Loser(double money) {
        System.out.println("The player was defeated!, player goes broke with: $"+ money );
    }

    public static void PlayerBuzz(double money) {
        System.out.println("Player are over 21! See you next time!");
    }

    public static void DealerBuzz(double money) {
        System.out.println("Dealer are over 21! This dealer is suck!\n" +
                "player has won: $"+ money);
    }

    public static void gameIsDraw() {
        System.out.println("DRAWWWWWW!");
    }

    public static void BlackJack(double money) {
        System.out.println("Yayyyy! Player has blackjack!! with total money has: $"+ money);
    }

    public static void BlackJackDealer(double money) {
        System.out.println("Oh NOOOO, Dealer has blackjack!!\nThe player goes broke! $"+money);
    }

    public static void betAmount() {
        System.out.print("Enter the amount you would like to bet for this game: $");
    }

    public static void GameStart(double pot) {
        System.out.println("Total money in the pot: $" + pot +" Game has started!");
    }
}
