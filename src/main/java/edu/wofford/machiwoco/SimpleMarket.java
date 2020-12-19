package edu.wofford.machiwoco;
import java.util.*;

/**
 * This public class is an extension of the Market class.
 * This class handles the buying and displaying of purchased cards. 
 * It hold the max amount of cards. 
 */
public class SimpleMarket extends Market {
    private List<Card> cardTypes;
    private Map<String, Integer>  marketStock;
    private Card wheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1); //////
    private Card Bakery = new Card("Bakery", "B", "G", 1, 2, 3, 1);
    private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
    private Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
    private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
    private Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
    private Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
    private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 12, 2); /////
    private Card Cafe = new Card("Cafe", "U", "R", 2, 3, 1);
    private Card FamilyRestaurant = new Card("Family Restaurant", "U", "R", 3, 9, 10, 2); 
    private Card Stadium = new Card("Stadium", "T", "P", 6, 6, 2);   
    private Card TvStation = new Card("TV Station", "T", "P", 7, 6, 5);
    private Card BusinessComplex = new Card("Business Complex", "T", "P", 8, 6, 0);



    public SimpleMarket(List<Card> phaseCards) {
        super();
        //cardTypes = phaseCards;
        cardTypes = new ArrayList<>(phaseCards);

        marketStock = new HashMap<>();
            for(int i = 0; i < cardTypes.size(); i++){
                Card c = cardTypes.get(i);
                String name = c.getName();
                marketStock.put(name, 6);
                if(c.getColor() == "P"){
                    marketStock.put(name, 4);
                }
            }


    }

 
     /**
      * Returns the cardTypes list
      * @return The list cardTypes, containing the different types of cards in the Market
      */
      @Override
     public List<Card> getCardTypes(){
         return cardTypes;
     }
 
     /**
      * Gets the Market Stock
      * @return A Map representing the establishments available in the Market
      */
      @Override
     public Map<String, Integer> getMarketStock(){

         return marketStock;
     }
 
     @Override
     public Card getSelectedCard(String nameOfCard){
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
     /**
      * Decreases the stock available for an establishment by 1 based on the 
      * name given 
      * @param nameOfCard String representing the name of the establishment
      */
     // Could change this to accept a number by which to decrease the stock or create 
     // another function which does that
     @Override
     public Card purchase(String nameOfCard){
         int numberAvailable = marketStock.get(nameOfCard);
         numberAvailable = numberAvailable - 1;
         marketStock.put(nameOfCard, numberAvailable);
 
         Card purchasedCard = getSelectedCard(nameOfCard);
 
         return purchasedCard;
     }
 
     /**
      * Gets the total number of establishments available in the Market
      * @return An int representing the number of establishments in the Market
      */
      @Override
     public int getNumEstablishmentsInMarket(){
         int totalStock = 0;
 
         for(int numberAvailable : marketStock.values()){
             totalStock += numberAvailable;
         }
 
         return totalStock;
     }




     //
    
}
