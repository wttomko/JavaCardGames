import src.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    public static void displayTotal(Player player){
        int total=0;
        for (Player p : PlayerList.players){
            if (p.name.equals(player.name)){
                for (int i=0; i<p.hand.size(); i++){
                    total+=p.hand.get(i).getValue();
                }
            }
        }
        System.out.println("total: " + total);
    }

    public static int getTotal(Player player){
        int total=0;
        for (Player p : PlayerList.players){
            if (p.name.equals(player.name)){
                for (int i=0; i<p.hand.size(); i++){
                    total+=p.hand.get(i).getValue();
                }
            }
        }
        return total;
    }

    public static String hitOrStay(Player player){
        Scanner scan = new Scanner(System.in);
        player.displayHand();
        displayTotal(player);
        System.out.println("Select:  [H] Hit  -  [S] Stay");
        String choice="";
        while (!choice.toLowerCase().equals("h") && !choice.toLowerCase().equals("s")){
            choice = scan.nextLine();   
        }
        scan.close();
        return choice.toLowerCase();
    }

    public static int dealerTurn(Player dealer, ArrayList<Card> deck){
        int total = getTotal(dealer);
        while (total < 16){
            dealer.drawCard(deck);
            total = getTotal(dealer);
        }
        return total;
    }



    public static void main(String[] args){
        Deck deck = new Deck("Normal");
        Player player1 = new Player("Tyler");
        Player dealer = new Player("Dealer");
        deck.shuffleDeck();
        deck.deal(PlayerList.players, 2);
        String player1Choice = hitOrStay(player1);

        while (!player1Choice.equals("s") || getTotal(player1)>21){
            player1Choice = hitOrStay(player1);
        }

        if (getTotal(player1)>21){
            System.out.println("Player 1: " + getTotal(player1));
            System.out.println("Dealer: " + getTotal(dealer));
            System.out.println("You lose");
        }

        if (player1Choice.equals("s")){
            dealerTurn(dealer, deck.deck);
            int dealerTotal = getTotal(dealer);
        }
    }
}