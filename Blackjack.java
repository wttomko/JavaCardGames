import java.util.ArrayList;

import src.Deck;
import src.Player;
import src.PlayerList;

public class Blackjack {

    public static void total(Player player){
        int total=0;
        for (Player p : PlayerList.players){
            if (p.name.equals(player.name)){
                for (int i=0; i<p.hand.size(); i++){
                    total+=p.hand.get(i).getValue();
                }
            }
        }
        System.out.println(player.name + "'s total: " + total);
    }

    public static void main(String[] args){
        Deck deck = new Deck("Normal");
        Player tyler = new Player("Tyler");
        Player matt = new Player("Matt");
        deck.shuffleDeck();
        deck.deal(PlayerList.players, 2);
        tyler.displayHand();
        total(tyler);
    }
}