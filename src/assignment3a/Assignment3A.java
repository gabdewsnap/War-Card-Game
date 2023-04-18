/*
    Name: Gabrielle Dewsnap
    ID: 0713071
    Date: 04/12/2023
    Description: Static Classes
*/
package assignment3a;

import java.io.FileNotFoundException;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Assignment3A extends Application {
    Label lblScore = new Label("Score: ");
    TextField tfLeft = new TextField("");
    TextField tfRight = new TextField("");
    Label lblCardLeft = new Label();
    Label lblCardRight = new Label();
    Label lblCardDeck = new Label();
    Button btnReset = new Button("Reset");
    int rightVal = 0;
    int leftVal = 0;
    //int score = 0;
    boolean rightsTurn = true;
    Deck deck = new Deck();
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        //the reset button
        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Score.resetScore();
                tfRight.setText("0");
                tfLeft.setText("0");
                rightsTurn = true;
               
                resetCardImages();  
                deck.deal();
            }
        });

        //mouse clicked event
        lblCardDeck.setOnMouseClicked((MouseEvent arg0) -> {           
            Random rand = new Random();
            int num = rand.nextInt(155 - 101) + 101;
            String str = "file:img/" + Integer.toString(num) + ".gif";
            Card imgCardLeft = deck.deal();
            Card imgCardRight = deck.deal();
                
            if(rightsTurn){    
                lblCardRight.setGraphic(imgCardRight.getCard()); 
                rightVal = imgCardRight.getValue();        
            }
            else{
                lblCardLeft.setGraphic(imgCardLeft.getCard());  
                leftVal = imgCardLeft.getValue();               
            }
            
            if(rightVal > leftVal){
                Score.setRightScore(rightVal);
                tfRight.setText(Integer.toString(Score.getRightScore()));
            }
            else if(rightVal < leftVal){
                Score.setLeftScore(leftVal);
                tfLeft.setText(Integer.toString(Score.getLeftScore()));
            }
            rightsTurn = !rightsTurn;
        });

        //the layout
        BorderPane root = new BorderPane();
        GridPane topPane = new GridPane();
        GridPane cardPane = new GridPane();
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Assignment 2B");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //the top pane
        Font fontScore = Font.font("Arial", FontWeight.BOLD, 24);
        lblScore.setFont(fontScore);
        lblScore.setTextFill(Color.RED);
           
        tfLeft.setPrefWidth(50);
        tfLeft.setDisable(true);
        tfLeft.setText("0");
        tfRight.setPrefWidth(50);
        tfRight.setDisable(true);
        tfRight.setText("0");
        topPane.add(lblScore, 0, 0);
        topPane.add(new Label("Left: "), 0, 1);
        topPane.add(tfLeft, 1, 1);
        topPane.add(new Label("Right: "), 2, 1);
        topPane.add(tfRight, 3, 1);
        topPane.setHgap(20);
        topPane.setVgap(10);
        root.setTop(topPane);
        
        //the center pane
        cardPane.setHgap(20.0);
        cardPane.add(lblCardLeft, 0, 0);
        cardPane.add(lblCardRight, 2, 0);
        cardPane.add(lblCardDeck, 1, 0);
        cardPane.setAlignment(Pos.CENTER);
        root.setCenter(cardPane);
        
        //the button
        root.setBottom(btnReset);
        
        //load default images
        resetCardImages();
    }
    
    public void resetCardImages(){    
        Card imgCardLeft = new Card();    
        lblCardLeft.setGraphic(imgCardLeft.getCard());        
          
        Card imgCardRight = new Card();  
        lblCardRight.setGraphic(imgCardRight.getCard());
          
        Card imgCardDeck = new Card();  
        lblCardDeck.setGraphic(imgCardDeck.getCard());      
    }

    public static void main(String[] args) {        
        launch(args);      
    }   
}