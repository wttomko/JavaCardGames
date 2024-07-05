package src;
import java.util.*;

public class Player {
    public String name;
    public ArrayList<Card> hand = new ArrayList<>();

    public Player(String name){
        this.name=name;
        PlayerList.players.add(this);
    }

    public void displayHand(){
        System.out.println(this.name + "'s cards:");
        System.out.println();
        for (int i=0; i<this.hand.size(); i++){
            this.hand.get(i).displayCard();
        }
        System.out.println();
    }

    public void addToHand(Card card){
        this.hand.add(card);
    }

    public void discard(Card card, ArrayList<Card> discardPile){
        this.hand.remove(card);
        discardPile.add(card);
    }

    public void drawCard(ArrayList<Card> deck){
        this.hand.add(deck.remove(0));
    }

    public void swapCard(String playerName, int yourCardNum, int theirCardNum){   
        for (Player otherPlayer : PlayerList.players) {
                if (playerName.equals(otherPlayer.name)) {
                    Card temp = new Card(otherPlayer.hand.get(theirCardNum).id, otherPlayer.hand.get(theirCardNum).suit, otherPlayer.hand.get(theirCardNum).value, otherPlayer.hand.get(theirCardNum).power);
                    otherPlayer.hand.add(this.hand.get(yourCardNum));
                    otherPlayer.hand.remove(theirCardNum);
                    this.hand.remove(yourCardNum);
                    this.hand.add(temp);
                    break;
            }
        }
    }
}