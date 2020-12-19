package edu.wofford.machiwoco;
import java.util.*;

import org.apache.logging.log4j.core.config.yaml.YamlConfiguration;

/** 
 * This Class represents a player in the game.
 * The methods in this class will do actions of the player such as rolling the dice or purchasing establishments and Landmarks.
 */
public class Player {
    private Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    protected String name;
    protected int playerNumber;
    protected int wallet;
    protected List<Card> establishments;
    //protected List<LandMark> landmarks;
    protected Tableau tableau;
    protected boolean isAi;
    protected boolean isStrategic;

    /**
     * This is the constructor of the player
     * @param name String representing the name of the player
     */
    public Player(String name){
        this.name = name;
        this.wallet = 3;
        tableau = new Tableau();
        isAi = false;
        isStrategic = false;


    }

/**
 * This method 
 * @param name 
 */
    public void setName(String name){
        this.name = name;
    }
/**
 * This method returns the Name
 * @return  The name as a string
 */
    public String getName(){
        return name;
    }
/**
 * This method returns the number
 * @return  The number as an integer
 */
    public int getNum(){
        int pNum = Integer.parseInt(name);
        return pNum;
    }

    /**
     * This method returns the player's tableau
     * @return A tableau object
     */
    public Tableau getTableau(){
        return tableau;
    }

    /**
     * This method rolls the dice
     * @return Number of dice as an integer
     */
    public int rollDice() {
        Random rnd = new Random();
        return 1 + rnd.nextInt(6);
    }

    /**
 * This method returns the wallet of the player
 * @return  The wallet as a integer
     */
    public int getWallet() {
        return this.wallet;
    }

    public int payPlayer(int coins){
        if(wallet != 0 && coins < wallet){
            wallet = wallet - coins;
            return coins;
        }
        return 0;
    }

    public boolean isAi(){
        return isAi;
    }

    public boolean isStrategic(){
        return isStrategic;
    }

    /**
     * This method adds money to the wallet
     * @param money Money or coins represented as an integer
     */
    public void addMoney(int money) {
        if (money > 0) {
            this.wallet = this.wallet + money;
        }
    }

    public int subtractMoney(int money){
        if(wallet > 0){
            if(wallet - money >= 0){
                wallet = wallet - money;
                return 0;
            }else{
                int deficit = wallet - money;
                wallet = 0;
                deficit = deficit * -1;
                return deficit;
            }
        }
        // If the player's wallet is zero, no money is subtracted, and the entire amount is 
        // returned as the deficit
        return money;
    }
   
    /**
     * this method takes the money spent on purchase from wallet
     * @param purchaseCard integer representing the purchase
     */
    public boolean purchase(Card purchaseCard) {
        if (purchaseCard.getCost() <= wallet) {
            wallet = wallet - purchaseCard.getCost();
            addEstablishment(purchaseCard);
            return true;
        }else{
            return false;
        }
    }

    /**
     * This method returns the Establishments
     * @return  The establishments as a list
     */
    public List<Card> getEstablishments(){
        return tableau.getCards();
    }

    /**
     * This method returns the Landmarks
     * @return  The Landmarks as a List
     */
    public List<LandMark> getLandmarks(){
        return tableau.getLandmarks();
    }
    /**
     * This method adds establishments to the player
     * @param c Card object to be added
     */

    public void addEstablishment(Card c){
        tableau.getCards().add(c);
    }
    /**
     * This method adds a new Establishment
     * @param name  Name of the Establishment as a String
     */
    /*
    public void addEstablishment(String name){
        tableau.addCard(name);
    }
    */
    /**
     * This method returns the amount of Establishments.
     * @param name Name of the Establishment as a String.
     * @return  The number of Establishment as a String.
     */

    public int getNumEstablishment(String name){
        return tableau.getNumberOfSpecifiedCards(name);
    }

    /**
     * This method adds Landmark to player
     * @param l Landmark ojbect
     */
    public void addLandmark(LandMark l){
        tableau.addLandmark(l);
    } 

    /**
     * This method returns the Number of Landmarks that are built
     * @return Number of Landmarks as an integer
     */

    public int getNumLandmarksBuilt(){
        return tableau.getNumLandmarksBuilt();
    }
    /**
     * This method checks to see if the mall is built. 
     * @return True
     * @return False 
     */
    public boolean isLandMarkBuilt(String name){
        for(int i = 0; i < getLandmarks().size(); i++){
            LandMark l = getLandmarks().get(i);
            if(l.getName().equals(name) && l.isBuilt()){
                return true;
            }
        }
        return false;
    }


    /**
     * This method checks if cards are activated
     * @param diceRoll  Returns the number of the dice as an integer
     */
    public List<Card> checkCards(int diceRoll, int turn){
        int moneyAmount = 0;
        String s ="";
        String output = "";
        List<Card> cards = tableau.getCards();
        List<Card> activatedCards = new ArrayList<>();
        int playerNumber = getNum();
        //int number = getNum();

        for(int i = 0; i < cards.size(); i++){
            Card c = cards.get(i);
           
            // This should be moved to the game class
            if(c.isActivated(diceRoll, turn, playerNumber)){
                activatedCards.add(c);
                s = String.format("The %s was activated for Player %s", c.getName(), getName());
                if(output.contains(s) == false){
                    //System.out.println(s);
                    output += s;
                }
            }
        }
        //Need to put this change back in as it's responsible for notifiying the players when a card has activated.
       
        //addMoney(moneyAmount);
        //wallet += moneyAmount;
        //System.out.println(moneyAmount);
        return activatedCards;
        
    }

    public List<String> getLandMarkNames(){
        List<String> landMarkNames = new ArrayList<>();
        List<LandMark> l = new ArrayList<>();
        l = getLandmarks();
        for(int i = 0; i < l.size(); i++){
            landMarkNames.add(l.get(i).getName());
        }
        return landMarkNames ;
    }

    public List<String> getEstablishmentNames(){
        List<String> establishmentNames = new ArrayList<>();
        List<Card> c = new ArrayList<>();
        c = getEstablishments();
        for(int i = 0; i < c.size(); i++){
            establishmentNames.add(c.get(i).getName());
        }
        return establishmentNames;
    }

    @Override

    /** 
     * This method overrides the equal method so that cards can be compared. 
     * @param o Will be the object compared.
     * @return true
     * @return false
     * @return Name of the card
     */
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Player player = (Player) o;
        return name == player.getName();
     }
     /**
      * This method constructs a landmark by getting the name
      * @param name String representing the name of the Landmark
      */
     public void construct(String name){
        List<LandMark> landmarks = tableau.getLandmarks();
        for(int i = 0; i < landmarks.size(); i++){
            LandMark l = landmarks.get(i);
            if(l.getName().equals(name) && l.isBuilt() == false){
            //System.out.println(landmarks.size());
                l.setBuilt();
                wallet = wallet - l.getCost();
                //System.out.println(wallet);
            }     
        }
     }

    /**
     * This override method is comparing the hashCode in memory depending on the attribute of the object.
     * @return Result of the comparison.
     */
     @Override
     public final int hashCode(){
         int result = 69;
         if (name != null){
             result = 31 * result + name.hashCode();
         }
         return result;
     }


     public boolean hasCard(Card cardToCheck){
        if(tableau.contains(cardToCheck)){
            return true;
        }
        return false;
    }

    public boolean hasBuilt(String landmarkToCheck){
       if(tableau.hasBuilt(landmarkToCheck)){
           return true;
       }
       return false;
    }


    //

}







    


 




