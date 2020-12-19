package edu.wofford.machiwoco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This public class is an extension of the Market class
 * This class displays only a specific amount of cards(5-5-2).
 */
public class HybridMarket extends Market {
    private List<Card> cardTypes;
    private List<Card> cardsSixAndBelow;
    private List<Card> cardsSevenAndAbove;
    private List<Card> majorEstablishments;
    private Map<String, Integer> displayStock;
    private Map<String, Integer> totalStock;

    private Card wheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    private Card Bakery = new Card("Bakery", "B", "G", 1, 2, 3, 1);
    private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
    private Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
    private Card FamilyRestaurant = new Card("Family Restaurant", "U", "R", 3, 9, 10, 2); 
    private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
    private Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
    private Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
    private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 12, 2);
    private Card Cafe = new Card("Cafe", "U", "R", 2, 3, 1);
    private Card Stadium = new Card("Stadium", "T", "P", 6, 6, 2);   
    private Card TvStation = new Card("TV Station", "T", "P", 7, 6, 5);
    private Card BusinessComplex = new Card("Business Complex", "T", "P", 8, 6, 0);
    private int num6AndBelow;
    private int num7AndAbove;
    private int numMajorProperties;
    private int numCardTypesOnDisplay;



    public HybridMarket(int numberOfPlayers){
        super();

        cardTypes = new ArrayList<>();
        cardTypes.add(wheatField);
        cardTypes.add(Ranch);
        cardTypes.add(Forest);
        cardTypes.add(Bakery);
        cardTypes.add(ConvenienceStore);
        cardTypes.add(Mine);
        cardTypes.add(FamilyRestaurant);
        cardTypes.add(AppleOrchard);
        cardTypes.add(CheeseFactory);
        cardTypes.add(FurnitureFactory);
        cardTypes.add(FarmersMarket);

        cardTypes.add(Cafe);
        cardTypes.add(Stadium);
        cardTypes.add(TvStation);
        cardTypes.add(BusinessComplex);

      

        totalStock = new HashMap<>();
        for(int i = 0; i < cardTypes.size(); i++){
            Card c = cardTypes.get(i);
            String name = c.getName();
            totalStock.put(name, 6);
            if(c.getColor() == "P"){
                totalStock.put(name, 2); // name, numberOfPlayers
            }
        }

        displayStock = new HashMap<>();
        hybridMarketSetUp();
        numCardTypesOnDisplay = 12;
    }

    @Override
    List<Card> getCardTypes() {
        return cardTypes;
    }

    @Override
    Map<String, Integer> getMarketStock() {
        return displayStock;
    }

    @Override
    Card getSelectedCard(String nameOfCard) {
        Card selectedCard = null;
 
        for(int i = 0; i < cardTypes.size(); i++){
            Card c = cardTypes.get(i);
            String name = c.getName();
            String icon = c.getIcon();
            String color = c.getColor();
            int cost = c.getCost();
            int actNum = c.getActNum();
            int range1 = c.getActRange()[0];
            int range2 = c.getActRange()[1];
            int income = c.getIncome();

            if(c.getName().equals(nameOfCard)){
                if(c.getActNum() != 0){
                    selectedCard = new Card(name, icon, color, cost, actNum, income);
                }else{
                    selectedCard = new Card(name, icon, color, cost, range1, range2, income);
                }
                
            }
        }

        return selectedCard;
    }

    @Override
    Card purchase(String nameOfCard) {
        // TODO Auto-generated method stub
        Card purchasedCard = getSelectedCard(nameOfCard);

        int totalStockAvailable = totalStock.get(nameOfCard);
        if(totalStockAvailable > 1){
            totalStock.put(nameOfCard, totalStockAvailable -1);

        }else{
            totalStock.put(nameOfCard, totalStockAvailable -1);
            //numCardTypesOnDisplay -= 1;
            //totalStock.remove(nameOfCard);

            if(cardsSixAndBelow.contains(purchasedCard)){
                cardsSixAndBelow.remove(purchasedCard);
            }else if(cardsSevenAndAbove.contains(purchasedCard)){
                cardsSevenAndAbove.remove(purchasedCard);
            }else{
                majorEstablishments.remove(purchasedCard);
            }

        }
        

        int displayStockAvailable = displayStock.get(nameOfCard);
        displayStockAvailable -= 1;

        if(displayStockAvailable <= 0){
            displayStock.remove(nameOfCard);
            numCardTypesOnDisplay -= 1;
            //restockDisplay(purchasedCard);
            restock(purchasedCard);

        }else{
            //numCardTypesOnDisplay -= 1;

            displayStock.put(nameOfCard, displayStockAvailable);

            // if(cardsSixAndBelow.contains(purchasedCard)){
            //     num6AndBelow -= 1;
            //     System.out.println("Subtracting 1 from the num six and below " + num6AndBelow);
            // }else if(cardsSevenAndAbove.contains(purchasedCard)){
            //     num7AndAbove -= 1;
            // }else if(majorEstablishments.contains(purchasedCard)){
            //     numMajorProperties -= 1;
            // }

            //restockDisplay(purchasedCard);
        }



        
        return purchasedCard;
    }

    public void restockDisplay(Card purchasedCard){
        System.out.println("Going into the restock function");
        String name = purchasedCard.getName();
        if(cardsSixAndBelow.contains(purchasedCard)){
            num6AndBelow -= 1;
            System.out.println("Subtracting 1 from the num six and below " + num6AndBelow);
        }else if(cardsSevenAndAbove.contains(purchasedCard)){
            num7AndAbove -= 1;
        }else if(majorEstablishments.contains(purchasedCard)){
            numMajorProperties -= 1;
        }

        int cardsAvailable = 0;
        for(int numberAvailable : totalStock.values()){
            if(numberAvailable > 0){
                cardsAvailable += 1;
            }
        }
        System.out.println("The number of card types available to buy" + cardsAvailable);

        int typesOfCards = 12;
        if(totalStock.size() < 12){
            typesOfCards = totalStock.size();
            System.out.println("The types of cards variable " + typesOfCards);
        }
        int limit = cardsSixAndBelow.size() + cardsSevenAndAbove.size() + majorEstablishments.size();
        System.out.println("This is the limit variable: " + limit);

        //numCardTypesOnDisplay
        while (numCardTypesOnDisplay < 12 || numCardTypesOnDisplay < limit){ //numCardTypesOnDisplay < typesOfCards - 1) {  // || numCardTypesOnDisplay < cardsAvailable
            System.out.println("In the while loop");
            System.out.println("The number of card types available to buy " + cardsAvailable);
            System.out.println("This is the limit variable: " + limit);
            System.out.println("This is the display stock size: " + displayStock.size());

            System.out.println(numCardTypesOnDisplay);
            int numLowerCards = 5;
            int numHigherCards = 5;
            int numMajorCards = 2;

            if(cardsSixAndBelow.size() < 5){
                numLowerCards = cardsSixAndBelow.size();
                System.out.println("The size of the six and below deck " + cardsSixAndBelow.size());
            }else if(cardsSevenAndAbove.size() < 5){
                numHigherCards = cardsSevenAndAbove.size();
                System.out.println("The size of the seven and above deck " + cardsSevenAndAbove.size());
            }else if(majorEstablishments.size() < 2){
                numMajorCards = majorEstablishments.size();
                System.out.println("The size of major establishments deck " + majorEstablishments.size());
            }

            if (num6AndBelow < numLowerCards) {
                System.out.println("In the num lower card check");
                num6AndBelow += hybridDeckDraw(cardsSixAndBelow);
                System.out.println("After the hybrid deck draw: " + num6AndBelow);
            }
            if (num7AndAbove < numHigherCards) {
                num7AndAbove += hybridDeckDraw(cardsSevenAndAbove);
            }
            if (numMajorProperties < numMajorCards) {
            numMajorProperties += hybridDeckDraw(majorEstablishments);
            }

            numCardTypesOnDisplay = num6AndBelow + num7AndAbove + numMajorProperties;
            System.out.println("number of card types on display " + numCardTypesOnDisplay);
            System.out.println("Num 6 and below " + num6AndBelow);
            System.out.println("Num 7 and above " + num7AndAbove);
            System.out.println("Major properties " + numMajorProperties);

            if(numCardTypesOnDisplay == 12){
                break;
             }


        }

    }

    public int getNumberOfDifferentCardTypesOnDisplay(List<Card> cards){
        int numberOfCards = 0;
        for(Card card : cards){
            String cardName = card.getName();
            if(displayStock.keySet().contains(cardName)){
                numberOfCards += 1;
            }
        }
        return numberOfCards;
    }

    
    public void restock(Card purchasedCard){
        int cardTypes = cardsSixAndBelow.size() + cardsSevenAndAbove.size() + majorEstablishments.size();
        int totalTypes = 0;

        while(displayStock.size() < 12 && displayStock.size() != cardTypes || displayStock.size() < totalTypes){
            System.out.println("This is the number of cardTypes available: " + cardTypes);
            System.out.println("The display stock size is: " + displayStock.size());
            System.out.println("The total types of cards is: " + totalTypes);
            // if(cardsSixAndBelow.contains(purchasedCard)){
            //     hybridDeckDraw(cardsSixAndBelow);

            // }else if(cardsSevenAndAbove.contains(purchasedCard)){
            //     hybridDeckDraw(cardsSevenAndAbove);

            // }else if(majorEstablishments.contains(purchasedCard)){
            //     hybridDeckDraw(majorEstablishments);

            // }
            int num6AndBelow = getNumberOfDifferentCardTypesOnDisplay(cardsSixAndBelow);
            int num7AndAbove = getNumberOfDifferentCardTypesOnDisplay(cardsSevenAndAbove);
            int numMajorProperties = getNumberOfDifferentCardTypesOnDisplay(majorEstablishments);

            // if(cardsSixAndBelow.size() > 0){ //cardsSixAndBelow.size() > 0
            //     if(num6AndBelow < 5 || num6AndBelow < cardsSixAndBelow.size()){
            //         hybridDeckDraw(cardsSixAndBelow);
            //     }
                
            // }else if(cardsSevenAndAbove.size() > 0){
            //     if(num7AndAbove < 5 || num7AndAbove < cardsSevenAndAbove.size()){
            //         hybridDeckDraw(cardsSevenAndAbove);
            //     }
                
            // }else if(majorEstablishments.size() > 0){
            //     System.out.println("It gets into the first purple card if statement");
            //     if(numMajorProperties < 2 || numMajorProperties < majorEstablishments.size()){
            //         System.out.println("Now it's in the second if statement");
            //         hybridDeckDraw(majorEstablishments);
            //     }
                
            // }

            if(num6AndBelow < 5){ //|| num6AndBelow < cardsSixAndBelow.size()){ //&& displayStock.size() < totalTypes){
                if(cardsSixAndBelow.size() > 0){
                    hybridDeckDraw(cardsSixAndBelow);
                }
            }if(num7AndAbove < 5){ //|| num7AndAbove < cardsSevenAndAbove.size(){
                if(cardsSevenAndAbove.size() > 0){
                    hybridDeckDraw(cardsSevenAndAbove);
                }
            }if(numMajorProperties < 2){ // || numMajorProperties < majorEstablishments.size()){
                if(majorEstablishments.size() > 0){
                    System.out.println("Now it's in the second if statement");
                    hybridDeckDraw(majorEstablishments);
                }
            }

            //hybridDeckDraw(majorEstablishments);
            
            totalTypes = num6AndBelow + num7AndAbove + numMajorProperties;

            System.out.println("The display stock size is: " + displayStock.size());
            System.out.println("The size of 6 and below cards " + cardsSixAndBelow.size());
            System.out.println("The size of 7 and above cards " + cardsSevenAndAbove.size());
            System.out.println("The size of major establishments deck " + majorEstablishments.size());

            for(String name : displayStock.keySet()){
                //System.out.println("This is the name of the card: " + name);
                //System.out.println("This is how many that are on display: " + displayStock.get(name));
            }

            if(displayStock.size() >= totalTypes){
                System.out.println("This is the display stock size after drawing cards: " + displayStock.size());
                System.out.println("This is the totalTypes number: " + totalTypes);
                break;
            }
            
        }
    }

    @Override
    int getNumEstablishmentsInMarket() {
        int totalNumEstablishments = 0;

        for (int numberAvailable : totalStock.values()) {
            totalNumEstablishments += numberAvailable;
        }

        return totalNumEstablishments;
    }

    public void createDecksByActNum() {
        cardsSixAndBelow = new ArrayList<>();
        cardsSevenAndAbove = new ArrayList<>();
        majorEstablishments = new ArrayList<>();
    

        for (int i = 0; i < cardTypes.size(); i++) {
            Card c = cardTypes.get(i);

            if (c.getColor() == "P") {
                majorEstablishments.add(c);

            } else {
                if (c.getActNum() <= 6 && c.getActNum() != 0 || c.getActRange()[1] <= 6 && c.getActRange()[1] != 0) {
                    cardsSixAndBelow.add(c);
                } else {
                    System.out.println(c.getName());
                    cardsSevenAndAbove.add(c);
                }
            }
        }
    }

    public void drawCard() {
        Random rand = new Random();
    }

    public int hybridDeckDraw(List<Card> cards) {
        Random rand = new Random();
        int draw = rand.nextInt(cards.size());
        int cardTypes = 0;

        Card c = cards.get(draw);
        String cardName = c.getName();

        if (!displayStock.containsKey(cardName) && totalStock.get(cardName) > 0) {
            displayStock.put(cardName, 1);
            cardTypes += 1;
        } else {
            int stock = displayStock.get(cardName);
            if(stock < 6){
                stock += 1;
                displayStock.put(cardName, stock);
            }
           

        }

        return cardTypes;
    }

    public void hybridMarketSetUp() {
        numCardTypesOnDisplay = 0;
        createDecksByActNum();

        int x = 0;
        num6AndBelow = 0;
        num7AndAbove = 0;
        numMajorProperties = 0;

        while (numCardTypesOnDisplay != 12) {

            if (num6AndBelow < 5) {
                num6AndBelow += hybridDeckDraw(cardsSixAndBelow);
            }
            if (num7AndAbove < 5) {
                num7AndAbove += hybridDeckDraw(cardsSevenAndAbove);
            }
            if (numMajorProperties < 2) {
                numMajorProperties += hybridDeckDraw(majorEstablishments);
            }

            // int deck7AndAbove = hybridDeckDraw(cardsSevenAndAbove);

            numCardTypesOnDisplay = num6AndBelow + num7AndAbove + numMajorProperties;

        }
        System.out.println(num6AndBelow);
        for (int i = 0; i < cardsSixAndBelow.size(); i++) {
            Card c = cardsSixAndBelow.get(i);
            System.out.println(c.getName());
        }
        System.out.println(num7AndAbove);
        for (int i = 0; i < cardsSevenAndAbove.size(); i++) {
            Card c = cardsSevenAndAbove.get(i);
            System.out.println(c.getName());
        }
        System.out.println(numMajorProperties);
    }




    //
    
}
