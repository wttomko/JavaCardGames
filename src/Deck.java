package src;
import java.util.*;

public class Deck {
    public ArrayList<Card> deck = new ArrayList<>();
    public ArrayList<Card> discardPile = new ArrayList<>();

    public Deck(String mod){
        String[] ids = {"2","3","4","5","6","7","8","9","Ten","Jack","Queen","King","Ace"};
        String[] suits = {"Spades", "Hearts","Clubs","Diamonds"};
        String[] powers = new String[ids.length];
        int[] values = new int[ids.length];

        if (mod.equals("Normal")){
            values[0]=2;
            values[1]=3;
            values[2]=4;
            values[3]=5;
            values[4]=6;
            values[5]=7;
            values[6]=8;
            values[7]=9;
            values[8]=10;
            values[9]=10;
            values[10]=10;
            values[11]=10;
            values[12]=11;

            for (int i=0; i<ids.length; i++){
                powers[i]="N/A";
            }
        }

        for (int s=0; s<suits.length; s++){
            for (int i=0; i<ids.length; i++){
                this.deck.add(new Card(ids[i], suits[s], values[i], powers[i]));
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
        System.out.println("Deck has been shuffled");
    }

    public void displayDeck(int style){

        /* Styles

         1 - Normal -- this.id of this.suit
         
         2 - Debug -- ID - this.id
                      SUIT - this.suit
                      VALUE - this.value
                      POWER - this.power
                      
         */

        for (int i=0; i<this.deck.size(); i++){
            if (style==1) {
                this.deck.get(i).displayCard();
            } else if (style==2){
                System.out.println("ID: " + this.deck.get(i).id);
                System.out.println("SUIT: " + this.deck.get(i).suit);
                System.out.println("VALUE: " + this.deck.get(i).value);
                System.out.println("POWER: " + this.deck.get(i).power);
                System.out.println();
            } else {
                System.out.println("Parameter can be 1 or 2");
                break;
            }
        }
    }

    public void displayDiscardPile(){
        if (this.discardPile.size()==0){
            System.out.println("Discard pile is empty.");
        } else {
            for (int i=0; i<this.discardPile.size(); i++){
                this.discardPile.get(i).displayCard();
            }
        }
    }

    public void deal(ArrayList<Player> players, int cardAmount){
        for (int c=0; c<cardAmount; c++){
            for (int p=0; p<players.size(); p++){
                players.get(p).drawCard(this.deck);
            }
        }
    }

    public void restoreDeck(){
        for (Card card : this.discardPile){
            this.deck.add(card);
        }
        this.discardPile.clear();
        shuffleDeck();
    }
}