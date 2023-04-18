package assignment3a;

import javafx.scene.control.*;
import javafx.scene.image.*;

public class Card{
    private Label image = new Label();
    private Image cardImg;
    private int value;
    private String name = new String();
    private Suit suit;
    
    private boolean loadCard(String imgName){
        cardImg = new Image(imgName);
        image.setGraphic(new ImageView(cardImg));
        getCardValue(imgName);
        return true;
    }
    
    public void setImage(String imgName){
        name = imgName;
        loadCard(name);
    }
    
    public Label getCard(){
        return image;
    }
    
    private void getCardValue(String imgName){    
        int number = Integer.parseInt(imgName.substring(9,12));
        int testNum = number % 100;
        while(testNum > 13)
            testNum-=13;           
        
        if(number >= 140 && number <=152)
            this.suit = Suit.Spades;
        else if(number >= 127 && number <=139)
            this.suit = Suit.Hearts;
        else if(number >= 114 && number <=126)
            this.suit = Suit.Clubs;
        else if(number >= 101 && number <=113)
            this.suit = Suit.Diamonds;
        
        if(testNum == 1)
            this.value = 11;
        else if(testNum >= 10 && testNum <= 13)
            this.value = 10;
        else
            this.value = testNum;
    }
    
    public Card(String imgName){
        this.setImage(imgName);
    }
    
    public Card(){
        this("file:img/155.gif");
    }
    
    public int getValue(){
        return value;
    }
    
    public Suit getSuit(){
        return suit;
    }
    
    public static void main(String[] args){    
    }
}
   
