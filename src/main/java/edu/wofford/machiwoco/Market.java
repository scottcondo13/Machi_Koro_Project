package edu.wofford.machiwoco;
import java.util.*;

/**
 * This public class 
 */

public abstract class Market {
    private int numCards;
    private int numTypesOfCards;
    private List<Card> cardTypes;
    private List<Card> cardsSixAndBelow;
    private List<Card> cardsSevenAndAbove;
    private List<Card> majorEstablishments;
    private Map<String, Integer>  marketStock;
    private Card wheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    private Card Bakery = new Card("Bakery", "B", "G", 1, 2, 3, 1);
    private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
    private Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
    private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
    private Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
    private Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
    private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 12, 2);
    private Card Cafe = new Card("Cafe", "U", "R", 2, 3, 1);
    private Card FamilyRestaurant = new Card("Family Restaurant", "U", "R", 3, 9, 10, 2); 
    private Card Stadium = new Card("Stadium", "T", "P", 6, 6, 2);   
    private Card TvStation = new Card("TV Station", "T", "P", 7, 6, 5);

    /**
     * Creates the Market and stocks it with the appropriate establishments for what phase 
     * the game will be run in
     * The phase that the game will be run in
     */
    public Market(){
        
    }

    /**
     * Returns the cardTypes list
     * 
     * @return The list cardTypes, containing the different types of cards in the
     *         Market
     */
    abstract List<Card> getCardTypes();

    /**
     * Gets the Market Stock
     * @return A Hash Map representing the establishments available in the Market
     */
    abstract Map<String, Integer> getMarketStock();

    abstract Card getSelectedCard(String nameOfCard);

    /**
     * Decreases the stock available for an establishment by 1 based on the 
     * name given 
     * @param nameOfCard String representing the name of the establishment
     */
    // Could change this to accept a number by which to decrease the stock or create 
    // another function which does that
    abstract Card purchase(String nameOfCard);

    /**
     * Gets the total number of establishments available in the Market
     * @return An int representing the number of establishments in the Market
     */
    abstract int getNumEstablishmentsInMarket();

 
}
