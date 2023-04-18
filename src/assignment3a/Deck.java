package assignment3a;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    int index = 0;
    private final int LAST_CARD = 45;
    ArrayList<Card> deck = new ArrayList<>();

    public void shuffle(){
        Collections.shuffle(deck);
    }
    
    private void loadCards(String imgName){
        for(int i = 101; i <= 152; i++){
            deck.add(new Card(imgName + i + ".gif"));
        }
        this.shuffle();
    }
    
    public Card deal(){
        if(this.index >= LAST_CARD){
            this.shuffle();
            index = 0;
        }   
        return deck.get(index++);
    }
    
    public Deck(String imgName){
        loadCards(imgName);
    }
    
    public Deck(){
        this("file:img\\");
    }
}

