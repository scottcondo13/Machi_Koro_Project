package edu.wofford.machiwoco;
import java.util.*;

/**
 * This public class is and extension of the Player class. 
 * This player will strategically choose establishments to win the game. 
 */
public class StrategicAI extends Player {
    
    private Random random;
    //private boolean isStrategicAI;

    public StrategicAI(String name){
        super(name);
        random = new Random();
        isStrategic= true;
        isAi = false;
        //setAI(false);
        
    }
    public void setStrategicAI(boolean aiStatus){
        isStrategic = aiStatus;
    }

    public boolean isStrategicAI(){
        return isStrategic;
    }
    public int getDieRoll(Game game){
        return game.getRoll();
    }

    
    
    public boolean inMarket(String menu, String potentialPurchase){
        String practice[] = menu.split("\\r?\\n");
        for(int i = 0; i < practice.length; i++){
            if(practice[i].contains(potentialPurchase)){
                return true;
            }
        
        }
        return false;
    }
    public int inList(String menu, String establishment){
        int count = 1;
        String practice[] = menu.split("\\r?\\n");
        for(int i = 0; i < practice.length; i++){
            //System.out.println(practice.length);
            //System.out.println(practice[i] + "yay!");
            if(practice[i].contains("CONSTRUCT")){
                count -= 1;
            }
            if(practice[i].contains(establishment)){
                count -= 2;
                return count;
                //System.out.println("Choo Choo" + countTemp);
            }

            count+=1;
        }
        return count;
    }

    //public getGameRoll()
    
    public int strategicBuy(String menu, String prompt, int turn){
        if(getNum() == turn){
            
            
            if(prompt.contains("Choose a number to purchase or construct")){
                if(inMarket(menu, "Shopping Mall")){
                    return inList(menu, "Shopping Mall");
                }
                else if(inMarket(menu, "Radio Tower")){
                    return inList(menu, "Radio Tower");
                }
                else if(inMarket(menu, "Train Station") && isLandMarkBuilt("Shopping Mall") && isLandMarkBuilt("Radio Tower")){
                    return inList(menu, "Train Station");
                }
                else if(inMarket(menu, "Amusement Park") && isLandMarkBuilt("Train Station")){
                    return inList(menu, "Amusement Park");
                }
                else if(inMarket(menu, "Ranch") && getNumEstablishment("Ranch") <= 2){
                    
                        return inList(menu, "Ranch");
                }
                else if(inMarket(menu, "Bakery") && getNumEstablishment("Bakery") <= 2){
                        return inList(menu, "Bakery");
                    
                }
                else if(inMarket(menu, "Convenience Store") && getNumEstablishment("Convenience Store") <= 2){
                        return inList(menu, "Convenience Store");
                    
                }
                else if(inMarket(menu, "Cafe") && getNumEstablishment("Cafe") <= 2){
                        return inList(menu, "Cafe");
                    
                }
               
                else{
                    return 99;
                }
            }else if(prompt.contains("would you like to roll 1 or 2 dice")){
                return 1;
            }
        }
        return 99;
    }

    public String likeToReroll(int roll){
        if(roll == 2 || roll == 3 || roll == 4){
            return "n";
        }
        return "y";
        
    }

    
    /*
    public boolean twoConveinienceStores(){
        int conveinienceCount = 0;
        for(int i = 0; i < getLandMarkNames().size(); i++){
            if(getLandMarkNames().get(i) == "")
        }
    }
    */
}
