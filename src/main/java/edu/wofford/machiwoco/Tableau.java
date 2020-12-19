package edu.wofford.machiwoco;

import java.util.*;
/**
 * This class represents the player's cards or Tableau 
 * with appropiate methods for handling card counting 
 * and activation 
 * @author Noah Gwinn
 */
public class Tableau {
    private int numCards;
    private int numTypesOfCards;
    private List<Card> cards;
    private List<Card> cardTypes;
    private List<LandMark> landmarks;
    /*
    private Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    private Card Bakery = new Card("Bakery", "B", "G", 1, 2, 3, 1);
    private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
    private Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
    private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
    private Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
    private Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
    private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 2);
    private LandMark TrainStation = new LandMark("Train Station");
    private LandMark ShoppingMall = new LandMark("Shopping Mall");
    private LandMark CityHall = new LandMark("City Hall");
    */


    /**
     * Constructor for the Tableau class and adds cards based on the phase of the game
     * A string representing the phase that the game will be played in 
     */
    public Tableau(){
        cards = new ArrayList<>();
        cardTypes = new ArrayList<>();
        landmarks = new ArrayList<>();
    }


    /**Adds a card to the cards list 
     * @param c the card to be added to the Tableau
     */
    public void addCard(Card c){
        cards.add(c);
    }

     /**
     * This method adds a new Establishment
     * @param name  Name of the Establishment as a String
     */
    // Could be nice for this to take a Card object and then add a new one to 
    // the player's deck based on what the card passed in was
    /*
    public void addCard(String name){
        if(name.equals("Wheat Field")){
            cards.add(WheatField);
        }else if(name.equals("Ranch")){
            cards.add(Ranch);
        }else if(name.equals("Forest")){
            cards.add(Forest);
        }else if(name.equals("Bakery")){
            cards.add(Bakery);
        }else if(name.equals("Convenience Store")){
            cards.add(ConvenienceStore);
        }else if(name.equals("Mine")){
            cards.add(Mine);
        }else if(name.equals("Furniture Factory")){
            cards.add(FurnitureFactory);
        }else if(name.equals("Cheese Factory")){
            cards.add(CheeseFactory);
        }else if(name.equals("Apple Orchard")){
            cards.add(AppleOrchard);
        }else if(name.equals("Farmers Market")){
            cards.add(FarmersMarket);
        }
    }
    */

    /**
     * Removes the given card from the deck
     * @param c The card to be removed
     */
    public void removeCard(Card c){
        cards.remove(c);
    }

    /**
     * Returns a list representing the cards currently in the Tableau
     * @return List of cards representing the Tableau
     */
    public List<Card> getCards(){
        return cards;
    }
    /**
     * Gets the number of different types of cards in the tableau
     * @return number of different card types in the tableau
     */
    public int getNumTypesOfCards(){
        cardTypes = new ArrayList<>();
        
        for(int i = 0; i < cards.size(); i++){
            Card c = cards.get(i);
            if(cardTypes.contains(c) == false){
                cardTypes.add(c);
            }
        }
        return cardTypes.size();
    }
    /**
     * Gets the number of cards in the tableau
     * @return the number of cards in the tableau
     */
    public int getNumberOfCards(){
        return cards.size();
    }
/**
 * This method loops through and gets the icon of the card. 
 * @param Icon
 * @return The cards with the icon. 
 */
    public int getNumCardsWithIcon(String Icon){
        int cardsWithIcon = 0;
        for(int i = 0; i < cards.size(); i++){
            Card c = cards.get(i);
            
            if(c.getIcon().equals(Icon)){
                cardsWithIcon += 1;
            }
        }
        return cardsWithIcon;
    }

    public Card getCardByName(String name){
        for(Card card : cards){
            if(card.getName().equals(name)){
                return card;
            }
        }
        return null;
    }

    public LandMark getSpecifiedLandmark(String specifiedLandmark){
        for(LandMark l : landmarks){
            String name = l.getName();
            if(name.equals(specifiedLandmark)){
                return l;
            }
        }
        return null;
    }

    public List<LandMark> getLandmarks(){
        return landmarks;
    }

    public void addLandmark(LandMark l){
        landmarks.add(l);
    }

    public int getNumLandmarksBuilt(){
        int numLandmarks = 0;
        for(int i = 0; i < landmarks.size(); i++){
            if(landmarks.get(i).isBuilt() == true){
                numLandmarks += 1;
            }
        }
        return numLandmarks;
    }

    public boolean contains(Card cardToCheck){
        for(Card card : cards){
            String cardName = card.getName();
            String nameCheck = cardToCheck.getName();
            if(cardName.equals(nameCheck)){
                return true;
            }
        }

        return false;
    }

      /**
     * This method returns the amount of cards.
     * @param name Name of the Establishment as a String.
     * @return  The number of Establishment as a String.
     */

    public int getNumberOfSpecifiedCards(String name){
        int numberOfSpecifiedcards = 0;
        for(int i = 0; i < cards.size(); i++){
            Card c = cards.get(i);
            if(c.getName().equals(name)){
                numberOfSpecifiedcards += 1;
            }
        }
        return numberOfSpecifiedcards;
    }

    public boolean hasBuilt(String landmarkToCheck){
        for (LandMark landmark : landmarks){
            String name = landmark.getName();
            if(landmarkToCheck.equals(name)){
                if(landmark.isBuilt()){
                    return true;
                }
            }
        }
        return false;
    }

    public List<Card> getCardTypes(){

        for(Card card : cards){
            if(cardTypes.contains(card) == false){
                cardTypes.add(card);
            }
        }

        return cardTypes;
    }

}
