package edu.wofford.machiwoco;
import java.util.ArrayList;
import java.util.List; 


/**
 * This public class establishes a class "Card" that 
 * simmply protects and initializes components of the cards
 * to its nessesary type 
 * @author Noah Gwinn
 * @author Scott Condo
 */
public class Card {
    protected String name;
    protected String color;
    protected String icon;
    protected int cost;
    protected int actNum;
    protected int range1;
    protected int range2;
    protected int[] range;
    protected int income;

    /** 
     * This method overrides the equal method so that cards can be compared. 
     * @param o Will be the object compared.
     * @return true
     * @return false
     * @return Name of the card
     */

    @Override
    
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Card card = (Card) o;
        return name == card.getName() &&
        icon == card.getIcon() && color == card.getColor() &&
        cost == card.getCost();
    }


    @Override
     public final int hashCode(){
         int result = 101;
         if (name != null){
             result = 31 * result + name.hashCode();
         }
         return result;
     }

     
/**
 * This constructor creates a new card and setting the objects name equal to name. 
 * @param name The string name of the card.
 */

    public Card(String name){
        this.name = name;
    }

    /**
     * This constructor creates a new card and sets the objects attributes.
     * @param name Is the name of the card given as a string.
     * @param icon Is the icon of the card given as a string.
     * @param color Is the color of the card given as a string.
     * @param cost Is the cost of the card given as an integer.
     * @param actNum Is the activation number of the card given as an integer.
     * @param income Is the income of the card given as an integer.
     */
    public Card(String name, String icon, String color, int cost, int actNum, int income){
        this.name = name;
        this.icon = icon;
        this.color = color;
        this.cost = cost;
        this.actNum = actNum;
        this.income = income;
    }
    public Card(String name, String icon, String color, int cost, int range1, int range2, int income){
        this.name = name;
        this.icon = icon;
        this.color = color;
        this.cost = cost;
        this.range1 = range1;
        this.range2 = range2;
        this.income = income;
    }

    
/** 
 *  This method retrives the card name.
 * @return The name of the card. 
 */
    public String getName(){
        return name;
    }
    // 861
/** 
 * This method sets string name to name 
 * @param name This sets the name of the card.
 */
    public void setName(String name){
        this.name = name;
    }
/** 
 * This method sets string color to color
 * @param color This sets the color of the card.
 */
    
    public void setColor(String color){
        this.color = color;
    }
/** 
 * This method gets card's color. 
 * @return The color of the card. 
 */
    public String getColor(){
        return color;
    }
/** 
 * This void method sets string icon and sets it to "icon."
 * @param icon The unique icon of the card.
 */
    public void setIcon(String icon){
        this.icon = icon;
    }

/** 
 * This method gets card icon. 
 * @return The icon designated to the card.
 */
    public String getIcon(){
        return icon;
    }
/** 
 * This void method sets int cost to "cost." 
 * @param cost The cost of each card.
 */
    public void setCost(int cost){
        this.cost = cost;
    }
/** 
 * This method gets cost of the card.  
 * @return The cost of the card.
 */

    public int getCost(){
        return cost;
    }

    /**
     * This method gets the amount payed out by the card when activated
     * @return The payout of the card
     */
    public int getIncome(){
        return income;
    }

/** 
 * This method sets int actNum which is the activation number of the card selected.
 * @param actNum Is the activation number of the card.
 */
    public void setActNum(int actNum){
        this.actNum = actNum;
    }

/** 
 * This method gets ActNum of the card.
 * @return The action number of the card needed to activate it. 
 */
    public int getActNum(){
        return actNum;
    }
/**
 * This method returns activation range as a two element array were first element is low bound and second element is high bound.
 * @return Returns the action range of the card.
 */
    public int[] getActRange(){
        range = new int[2];
        range[0] = range1;
        range[1] = range2;
        return range;
    }
/** 
 * If players dice roll number is equal to the activation number of the card, then isActivated will be set to ture.
 * This will insure that the card is shown and activated based of the roll of the player.
 * @param  roll Is the dise roll of the Player.
 * @return if roll == actNum return true
 * @return if not return false
 */
    public boolean isActivated(int roll, int turn, int playerNum){
        if(roll == actNum){
            if(color.equals("G") && turn != playerNum){
                return false;
            }else if(color.equals("R") && turn == playerNum){
                return false;
            }else if(color.equals("P") && turn != playerNum){
                return false;
            }
            else{
                return true;
            }
        }
        else if (range1 != 0 && range2 != 0){
            if(roll == range1 || roll == range2){
                if(color.equals("G") && turn != playerNum){
                    return false;
                }else if(color.equals("R") && turn == playerNum){
                    return false;
                }else if(color.equals("P") && turn != playerNum){
                    return false;
                }
                else{
                    return true;
                }
            }

            // if(color.equals("G") && turn != playerNum){
            //     return false;
            // }
            // if (roll == range1){
            //     return true;
            // }
            // else if(roll == range2){
            //     return true;
            // }
            // else{
            //     return false;
            // }
        }
        else{
            return false;
        }
        return false;
    }
/** 
 * This void method sets how much the card pays the player when it is activated.
 * @param income How much the card pays the player.
 */
    public void setPayout(int income){
        this.income = income;
    }
/** 
 * This method calles the previous method 
 * isActivated. If isActivated is true the diceRoll int is called then it will return the income set from the previous method.
 * Otherwise it returns 0.
 * @param diceRoll The number that the player rolls.
 * @return Income
 * @return 0
 */
    public int Payout(int diceRoll, int turn, int playerNum){
        if (isActivated(diceRoll, turn, playerNum)){
            return income;

        }else{
            return 0;
        }
    }



}