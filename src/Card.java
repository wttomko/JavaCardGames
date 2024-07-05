package src;

public class Card {
    String id;
    String suit;
    int value;
    String power;
    

    public Card(String id, String suit, int value, String power){
        this.id=id;
        this.suit=suit;
        this.value=value;
        this.power=power;
    }

    public void displayCard(){
        System.out.println(this.id + " of " + this.suit);
    }

    public String getId(){
        return this.id;
    }

    public String getSuit(){
        return this.suit;
    }

    public int getValue(){
        return this.value;
    }

    public String getPower(){
        return this.power;
    }

    public void displayCardGraphic(){
        switch (this.suit){
            case "Hearts":
                switch (this.id){
                    case "2":
                        CardGraphics.hearts2();
                        break;
                    case "3":
                        CardGraphics.hearts3();
                        break;
            }
            break;
        }
    }
}
