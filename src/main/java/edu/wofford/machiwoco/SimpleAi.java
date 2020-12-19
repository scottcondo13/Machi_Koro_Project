package edu.wofford.machiwoco;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.Phaser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This public class is an extension of the player class.
 * The simple ai player randomly chooses from given choices.
 * If it is given the option to buy a landmark, it will. 
 */
public class SimpleAi extends Player {
    private Random rand;
    private PrintWriter terminalOutput;
    private boolean isAi;

    public SimpleAi(String name){
        super(name); 
        rand = new Random();
        isAi = true;
        //terminalOutput = new Scanner((Readable) System.out);
        terminalOutput = new PrintWriter(System.out);
    }


    /**
     * This void method sets the boolean of isAi to true or false
     * @param isAIState boolean that is passed to set the state of isAi
     */
    public void setAI(boolean isAIState){
        isAi = isAIState;
    }
/**
 * This boolean method check if the ai is set to true.
 * @return a boolen value of the AI is established 
 */
    public boolean isAi(){
        return isAi;
    }
/**
 * This method generates a random int in the bound.
 * @param bound The range.
 * @return 0.
 */
    public int generateRandomInt(int bound){
        if(bound > 0){
            int r = rand.nextInt(bound) + 1;
            return r;
        }else {
            return 0;
        }
        
    }
/**
 * This method gets the number of entries in the menu.  
 * @param menu The game menu. 
 * @return 
 */
    public int getNumEntriesInMenu(String menu){
        int numEntries = 0;
        int countTemp = 1;
        
        String practice[] = menu.split("\\r?\\n");
        String[] practice2 = menu.split(".", practice.length - 5);

        for(int i = 0; i < practice.length; i++){
            //System.out.println(practice.length);
            //System.out.println(practice[i] + "yay!");
            if(practice[i].contains("CONSTRUCT")){
                countTemp -= 1;
            }
            if(practice[i].contains("CANCEL")){
                countTemp -=1;
            }
            if(practice[i].contains("Train Station")){
                countTemp -= 2;
                //System.out.println("Choo Choo" + countTemp);
            }
            if(practice[i].contains("Do Nothing")){
                countTemp -= 2;
                //System.out.println("nah im Chill" + countTemp);
            }

            countTemp+=1;
        }
        
        String[] count = menu.split("\\d.");
        
        /*
        for(int i = 0; i < count.length; i++){
            countTemp+=1;
            //System.out.println(count[i]);
            if(i % 3 == 1){
               // System.out.println(count[i]);
            }
            
            if(count[i].contains("Convenience Store")){
                countTemp = countTemp / 3 + 1;
               // System.out.println("I want a bakery" + countTemp);
            }
            
        }
        */
        Matcher match = Pattern.compile("\\d+\\.{1}", Pattern.MULTILINE).matcher(menu);
        //System.out.println(match);

        while(match.find()){
            numEntries += 1;
        }
        //match.find();
        //match.group();

        // if(menu.contains("Construct")){

        // }
       
        return numEntries - 1;
    }
/**
 * This method outputs the random ai's purchase selection. 
 * @param selection
 */
    public void aiPurchaseOutput(int selection){
        //int selection = generateRandomInt(numEntries);
        //System.out.println(selection);
        System.out.print(selection);
    }
/**
 * This method selects the pruchase of the ai and sets it to selection. 
 * @param numEntries
 * @return The selection 
 */

    public int aiPurchaseSelect(int numEntries, String menu){
        int selection = generateRandomInt(numEntries);
        //System.out.println(selection);
        //String s = String.format("%d", selection);
        //terminalOutput.println("This should work");
        //System.out.printf("%d\n",selection);

        if(menu.contains("---------       CONSTRUCT        ---------")){
           String[] s =  menu.split("---------       CONSTRUCT        ---------");
          
            // int numLandmarkChoices = getNumEntriesInMenu(s[1]);
            // int numChoices = numEntries - numLandmarkChoices;
            // selection = numChoices + rand.nextInt(numChoices) + 1;
            //return selection;
            return numEntries;


        }

        return selection;
    }
/**
 * This method allows  the ai the ability to make a purchase decision form the menu. 
 * @param menu The game menu.   
 * @param prompt The prompt for the ai. 
 * @param turn The ai's given turn. 
 * @return 0.
 */
    public int aiTurn(String menu, String prompt, int turn){
        if(getNum() == turn){
            //String line = terminalOutput.;
            if(prompt.contains("Choose a number to purchase or construct")){
                int numMenuEntries = getNumEntriesInMenu(menu);
                int choice = aiPurchaseSelect(numMenuEntries, menu);
                if(choice == 0 || getWallet() < 3){
                    return 99;
                }
                return choice;
            }else if(prompt.contains("would you like to roll 1 or 2 dice")){
                return generateRandomInt(2);
            }
        }
        return 99;
    }
/**
 * This method selects the roll of the number generation. 
 * @return A random generation integer. 
 */
    public int RollSelect(){
        return generateRandomInt(2);
    }

    public String yesOrNo(){
        int r = rand.nextInt(2) + 1;
        if(r == 1){
            return "y";
        }
        else{
            return "n";  
        }
}   


}