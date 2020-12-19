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
import javafx.stage.Window;

/**
 * This public class is a GUI method that displays the in game market. 
 */
public class MarketMenuGui {
    Market market;
    HBox cardsOnDisplay;
    HBox purchaseMenu;
    Label label;
    //Button button;
    List<Card> cardTypesInMarket;
    Player player;
    List<Button> purchaseMenuButtons;
    boolean hasPurchased;


    public MarketMenuGui(Market market){
        this.market = market;
        cardTypesInMarket = market.getCardTypes();
        purchaseMenuButtons = new ArrayList<>();
        hasPurchased = false;

    }

    

    public String getCardColor(Card card){
        String color = "-fx-background-color:";

        if(card.getColor() == "B"){
            return color + "DeepSkyBlue";
        }else if(card.getColor() == "G"){
            return color + "Green";
        }
        return color + "white";
    }


    public HBox setCardsOnDisplay(){
        List<Card> cardsInMarket = new ArrayList<>();

        Map<String, Integer> availableStock = market.getMarketStock();
        cardsOnDisplay = new HBox(20);
        cardsInMarket = market.getCardTypes();

        for(Card card : cardsInMarket){
            String cardName = card.getName();
            label = new Label();
            String info = "";
            int numAvailable = availableStock.get(cardName);

            info = cardName + "\n" + String.valueOf(numAvailable) + " available.";
            label.setText(info);
            label.setTextFill(Color.BLACK);
            label.setStyle(getCardColor(card));
            label.setMinSize(50, 100);

            cardsOnDisplay.getChildren().addAll(label);


        }
        cardsOnDisplay.setAlignment(Pos.CENTER);        

        return cardsOnDisplay;
    }

    public HBox getCardsOnDisplay(){
        setCardsOnDisplay();
        return cardsOnDisplay;
    }

    public HBox setPurchaseMenu(Player player){
        cardsOnDisplay = new HBox(25);
        Map<String, Integer> marketStock = market.getMarketStock();
        //Card purchasedCard;
        for(Card card : cardTypesInMarket){
            String cardName = card.getName();
            int cardCost = card.getCost();
            Button button = new Button();
            this.player = player;
            if(player.getWallet() >= cardCost && marketStock.get(cardName) > 0){
                String info = card.getName() + "\nCard Cost: " + String.valueOf(cardCost) + "\n";
                String numAvailable = "Number In Market:" + String.valueOf(marketStock.get(cardName));
                button.setText(info + numAvailable);
                button.setStyle(getCardColor(card));
                button.setMinSize(75, 150);
                button.setTextAlignment(TextAlignment.CENTER);

                button.setOnAction(e -> {
                    Card purchasedCard = market.purchase(cardName);
                    player.purchase(purchasedCard);
                    String update = card.getName() + "\nCard Cost " + String.valueOf(cardCost) + "\n";
                    String available = "Number In Market:" + String.valueOf(marketStock.get(cardName));
                    button.setText(update + available);
                    hasPurchased = true;

                   // update();
                    String output = String.format("Player %d purchased a %s and has %d coins", player.getNum(), cardName, player.getWallet());
                    System.out.println(output);
                });

                cardsOnDisplay.getChildren().add(button);
            }

        }

        cardsOnDisplay.setAlignment(Pos.CENTER);
        return cardsOnDisplay;

    }

    public HBox getPurchaseMenu(Player player){
        setPurchaseMenu(player);
        return cardsOnDisplay;
    }

    public boolean hasPurchaseBeenMade(){
        return hasPurchased;
    }


    public HBox update(){
        setPurchaseMenu(player);
        return setCardsOnDisplay();
    }


    //

}
