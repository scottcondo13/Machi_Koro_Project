package edu.wofford.machiwoco;

import java.util.ArrayList;
import java.util.*;

/**
 * This public class is the where the landmark Radio Tower is created giving the player the option to re-roll if desired. 
 */
public class RadioTowerStatement {
    private List<String> outputList;
    private String radioPrompt;
    private Scanner scanner;
    private int diceTotal;
    private GameNotifications notifications;
    private Player currPlayer;
    private int roll;
    private int roll2;
    private Dice dice;

    public RadioTowerStatement(List<Player> playerList, int Turn){
        outputList = new ArrayList<>();
        radioPrompt = "like to reroll";
        scanner = new Scanner(System.in);
        currPlayer = playerList.get(Turn - 1);
        notifications = new GameNotifications();
        dice = new Dice();
    }
    
    

    public String rerollPrompt(){
        return radioPrompt;
    }

    public List<String> radioTowerYesorNoResponse1Die(Scanner scanner){
        String rerollResponse;
        outputList.add(radioPrompt); 
                     
        if(currPlayer.isAi() == false && currPlayer.isStrategic() == false){
            System.out.println(radioPrompt);
        }
        System.out.println("pls pick again.");
        

        if(scanner.hasNext()){
            rerollResponse = scanner.nextLine();
            while(!rerollResponse.equals("y") && !rerollResponse.equals("n") ){
                //System.out.println(rerollResponse);
                if(currPlayer.isAi() == false && currPlayer.isStrategic() == false){
                    System.out.println(radioPrompt);    
                }
                System.out.println("pls pick again.");
                rerollResponse = scanner.nextLine();
            }
            //System.out.println(rerollResponse);
            if(rerollResponse.equals("y")){
                outputList.add("y");
                diceTotal = 0;
                roll = dice.roll();
                notifications.rollNotification(currPlayer.getNum(), roll);
                diceTotal += roll;
            }
            else{
                outputList.add("n");
            }
        
    }
    return outputList;
}

public List<String> radioTowerYesorNoResponse2Dice(Scanner scanner){
    String rerollResponse;
    outputList.add(radioPrompt);              
    if(currPlayer.isAi() == false && currPlayer.isStrategic() == false){
        System.out.println(radioPrompt);
    }
    System.out.println("pls pick again.");
    

    if(scanner.hasNext()){
        rerollResponse = scanner.nextLine();
        while(!rerollResponse.equals("y") && !rerollResponse.equals("n") ){
            System.out.println(rerollResponse);
            if(currPlayer.isAi() == false && currPlayer.isStrategic() == false){
                System.out.println(radioPrompt);
            }
            System.out.println("pls pick again");
            
            rerollResponse = scanner.nextLine();
        }
        //System.out.println(rerollResponse);
        if(rerollResponse.equals("y")){
            outputList.add("y");
            //total += " " + "y";
            //total += " " + "1";
            diceTotal = 0;
            roll = dice.roll();
            roll2 = dice.roll();
            notifications.rollNotification(currPlayer.getNum(), roll, roll2);
            
            diceTotal += roll + roll2;
            
        }
        else{
            outputList.add("n");
        }
    
}
return outputList;
}

}
