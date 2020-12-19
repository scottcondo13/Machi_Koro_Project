package edu.wofford.machiwoco;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * This public class is the information displayed in the GUI.
 */
public class PlayerInfoGui {
    Label label;
    boolean landmarkConstructed;
    Player player;
    BorderPane playerMenu;
    // BorderPane playerMenuLayout = new BorderPane();
    List<Card> playerCardTypes;
    HBox playerNameAndCoins;
    HBox playerCards;
    ScrollPane gameLog;
    HBox landmarkInfo;


    public PlayerInfoGui(Player player){
        landmarkConstructed = false;
        this.player = player;

        playerMenu = setPlayerInfoMenu(player);

    }


    public String getCardColor(Card card){
        String color = "-fx-background-color:";

        if(card.getColor() == "B"){
            return color + "DeepSkyBlue";
        }else if(card.getColor() == "G"){
            return color + "green";
        }
        return color + "white";
    }
    
    public HBox setPlayerCardLayout(List<Card> cards, Player player){
        HBox playerCardLayout = new HBox(15);
        // cards.add(new Card("w"));
        // cards.add(new Card("w"));
        // cards.add(new Card("w"));
        // cards.add(new Card("w"));
        // cards.add(new Card("w"));
        // cards.add(new Card("w"));cards.add(new Card("w"));cards.add(new Card("w"));
        // cards.add(new Card("w"));
        // cards.add(new Card("w"));
        // cards.add(new Card("w"));

        for(Card card : cards){
            String name = card.getName();
            String cardColor = getCardColor(card);
            String numberOfCards = String.valueOf(player.getNumEstablishment(name));
            //System.out.println(numberOfCards);
            String info = String.format("%s\n# In Tableau: %s", name, numberOfCards);

            label = new Label();
            label.setText(info);
            label.setStyle(cardColor);
            label.setTextFill(Color.BLACK);
            label.setTextAlignment(TextAlignment.CENTER);
            label.setMinSize(90, 70);

            playerCardLayout.getChildren().add(label);
        }

        playerCardLayout.setAlignment(Pos.CENTER);
        return playerCardLayout;
    }


    public HBox setPlayerNameAndCoins(Player player){
        HBox playerInfo = new HBox();
        String info = String.format("Player %s \nNumber Of Coins: %d", player.getName(), player.getWallet());
        label = new Label(info);
        label.setMinSize(75, 75);

        playerInfo.getChildren().add(label);
        playerInfo.setAlignment(Pos.CENTER);
        return playerInfo;
    }

    public ScrollPane setGameLog(){
        ScrollPane gameLog = new ScrollPane();
        TextArea textArea = new TextArea();
        int height = 100;
        int width = 125;

        textArea.setMaxSize(width, height);
        gameLog.setMaxSize(width, height);
        gameLog.setContent(textArea);

        return gameLog;
    }

    public HBox setLandmarkInfo(Player player){
        HBox landmarkInfo = new HBox(15);
        List<LandMark> landmarks = player.getLandmarks();
        int width = 70;
        int height = 50;

        for(LandMark landmark : landmarks){
            Button button = new Button();
            button.setText(landmark.getName());
            button.setTextFill(Color.BLACK);
            button.setStyle("-fx-background-color:orange");
            button.setMinSize(width, height);

            button.setOnAction(e -> {
                System.out.println(landmark.getName());
                if(player.getWallet() >= landmark.getCost()){
                    player.addLandmark(landmark);
                    button.setText(landmark.getName() + ": Constructed");
                    button.setTextAlignment(TextAlignment.CENTER);
                }
            });

            landmarkInfo.getChildren().add(button);
        }

        landmarkInfo.setMinHeight(50);
        landmarkInfo.setAlignment(Pos.TOP_CENTER);
        return landmarkInfo;
    }
    
    public BorderPane setPlayerInfoMenu(Player player){
        playerMenu = new BorderPane();
        // BorderPane playerMenuLayout = new BorderPane();
        playerCardTypes  = player.getTableau().getCardTypes();

        playerNameAndCoins = setPlayerNameAndCoins(player);
        playerCards = setPlayerCardLayout(playerCardTypes, player);
        gameLog = setGameLog();
        landmarkInfo = setLandmarkInfo(player);
        

        playerMenu.setCenter(playerCards);
        playerMenu.setTop(playerNameAndCoins);
        playerMenu.setRight(gameLog);
        //playerMenu.setBottom(setPlayerCardLayout(playeCards, player));
        playerMenu.setBottom(landmarkInfo);
        //playerMenu.setAlignment(gameLog, Pos.BOTTOM_LEFT);

        playerMenu.setMinHeight(200);
        playerMenu.setMaxWidth(800);
        playerMenu.setStyle("-fx-background-color:lightBlue");
        


        return playerMenu;
    }

    public BorderPane getPlayerInfoMenu(){
        return playerMenu;
    }

    public ScrollPane getGameLog(){
        return gameLog;
    }

    public void updateInfo(){
        setPlayerInfoMenu(player);

    }
    

}
