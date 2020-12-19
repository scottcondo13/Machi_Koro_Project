package edu.wofford.machiwoco;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

    /**
     * This is a public class that prints to the console customize statments regarding the availability of establishments and landmarks.
     * @author Noah Gwinn
     */
public class GameDisplay{
    protected int numWheatFieldsAvailable = 6;
    protected int[] availableProperties;
    protected String[] establishments = {"Wheat Field", "Ranch", "Forest"};
    protected String[] landmarks = {"City Hall"};

    /**
     * This is a public void that sets the availability properties for the user.
     * @param arr Integer array
     */
    public void setAvailableProperties(int[] arr){
        availableProperties = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            availableProperties[i] = arr[i];
        }
    }
    /**
     * This method adds pad to a string given as a parameter.
     * @param str String
     * @param lineLength Integer as lenght of the line
     * @return String with pad
     */
    public String pad(String str, int lineLength){
        int padding = lineLength - str.length();
        for(int i = 0; i < padding; i++){
            str += " ";
        }
        return str;
    }
    /**
     * This method sets the String name of the card WheatField.
     * @return String The WheatField Line.
     */
    public String setWheatFieldLine(){
        if(availableProperties[0] != 0){
            return "Wheat Field        BW (1)  [1]      #" + availableProperties[0] + "    \n";
        }else {
            return "";
        }
    }
    /**
     * This method sets the String name of the card Ranch.
     * @return String The Ranch Line.
     */
    public String setRanchLine(){
       if(availableProperties[1] != 0){
           return "Ranch              BC (1)  [2]      #" + availableProperties[1] + "    \n";
       }else{
           return "";
       }
    }
    /**
     * This method sets the String name of the card Forest.
     * @return String The Forest Line.
     */
    public String setForestLine(){
        if(availableProperties[2] != 0){
            return "Forest             BG (3)  [5]      #" + availableProperties[2] + "    \n";
        }else {
            return "";
        }
    }

    /**
     * This method sets the String name of the card Ranch.
     * @param name String as name of the Establishment
     * @return String The Line of the Establishment.
     */
    public String setLineEstablishment(String name){
        if(name.equals("Wheat Field")){
            return setWheatFieldLine();
        }else if(name.equals("Ranch")){
            return setRanchLine();
        }else if(name.equals("Forest")){
            return setForestLine();
        } else{
            return "";
        } 
        
    }
    /**
     * This method sets the City Hall line.
     * @param isBuilt A boolean that indicates if the City Hall is built.
     * @return The City Hall Line as a string.
     */
    public String setCityHallLine(boolean isBuilt){
        if(isBuilt){
            return "City Hall          NT (7)  [X]            " + '\n';
        }else{
            return "City Hall          NT (7)  [ ]            " + '\n';
        }
    }
    /**
     * This method sets the the Landmark Line.
     * @param name String of the Landmark.
     * @param isBuilt Boolean that indicates if the City Hall is built.
     * @return Landmark as a string.
     */
    public String setLineLandmarks(String name, boolean isBuilt){
        if(name.equals("City Hall")){
            return setCityHallLine(isBuilt);
        }else {
            return "";
        }
    }

    /**
     * This method gets a specific line from a menu based on string given
     * @param lineIdentifier String indentifying which line should be retrieved
     * @param menu String that represents the menu that the line shold be retrived from
     * @return String
     */
    // Method that needs to be implemented
    public String getLine(String lineIdentifier, String menu){
        int index = menu.indexOf(lineIdentifier);
        String line = menu.substring(index, index + 42);
        //System.out.println(line);
        //System.out.println(line.length());
        return line;
    }


    /**
     * This method orders establishments in the Player Info menu by activation number
     * @param playerInfoMenu String representing the properties each player has
     * @return It returns the player Info display with properties ordered by activation number
     */
    public String orderByActivationNumber(String playerInfoMenu){
        Pattern pattern = Pattern.compile("^\n*([a-zA-Z].{1,18}).{24}\n*$", Pattern.MULTILINE);
        Matcher m = pattern.matcher(playerInfoMenu);
        m.find();
        //System.out.println(m.group());
        String s = m.group(1);
        //System.out.println(m.groupCount());
        
        return s;
    }


    /**
     * This method displays the market.
     * @return It returns the market as a string.
     */
    public String displayMarket(){
        String market = "";
        
        for(int i = 0; i < 42; i++){
            market += "*";
        }

        market += "\n";
        market += "                  MARKET                  ";
        market += "\n";

        for(int i = 0; i < 42; i++){
            market += "-";
        }

        market += "\n";
        market += setWheatFieldLine();
        market += setRanchLine();
        market += setForestLine();
        market += "\n";

        return market;
    }

    /**
     * This method displays the information of the player.
     * @param currentPlayerNum Integer indicating the player number.
     * @param players A list with the number of players.
     * @return The information of the player as a string.
     */
    public String displayPlayerInfo(int currentPlayerNum, List<Player> players){
        String playerInfo = "";
        List<Card> establishments;
        List<LandMark> landmarks;

        for(int i = 0; i < players.size(); i++){
            Player player = players.get(i);
            int playerNum = i + 1;
            if(players.get(i).getName().equals("Player 1") && currentPlayerNum == playerNum){
                playerInfo += "             " + players.get(i).getName() + "*" + " [YOU]" + "              " + "\n";
            }else if(players.get(i).getName().equals("Player 2") && currentPlayerNum == playerNum){
                playerInfo += "             " + players.get(i).getName() + "*" + " [YOU]" + "              " + "\n";
            }else{
                if(currentPlayerNum == playerNum){
                    
                    playerInfo += "                " + players.get(i).getName() + "*" + "     " + "            " + "\n";
                }else{
                    playerInfo += "                 " + players.get(i).getName() + "                 " + "\n";
                }
            }
           
            
            playerInfo += "------------------------------------------" + "\n";
            playerInfo += "                (" + players.get(i).getWallet() + " coins)                 " + "\n";

            establishments = player.getEstablishments();
            int establishmentNum = establishments.size();
            String cards = "";
            for(int j = 0; j < establishmentNum; j++){ 
                Card c = establishments.get(j);
                String name = establishments.get(j).getName();
                String s = String.format("%-18s %s%s (%d)  [%d]      #%d    ", c.getName(), c.getColor(), c.getIcon(), 
                        c.getCost(), c.getActNum(), player.getNumEstablishment(name));
                if(cards.contains(name) == false){     
                    playerInfo += s + "\n";
                    
                }else{
                    
                    playerInfo.replaceFirst(s, s);
                }
                
                cards += c.getName();

                
            }

            playerInfo +=  "\n" + ".........................................." + "\n";

            landmarks = players.get(i).getLandmarks();
            int landmarkNum = landmarks.size();
            for(int j = 0; j < landmarkNum; j++){
                LandMark l = landmarks.get(j);
                playerInfo += setLineLandmarks(l.getName(), l.isBuilt());
            }
            playerInfo += "\n";
    
        }
        playerInfo += "******************************************"; 

       
        return playerInfo;
    }

  
    
    /**
     * This method returns the Game information.
     * @param availableProperties Array of Integers with the available Properties
     * @param cardsInMarket Integer indicating the player number.
     * @param p A list with the number of players.
     * @return The information of the String of the Game.
     */
   
    public String displayPurchaseMenu(int[] availableProperties, List<Card> cardsInMarket, Player p){
        String purchaseMenu = "";
        setAvailableProperties(availableProperties);
        int numEntries = 0;

        purchaseMenu += "==========================================" + "\n";
        purchaseMenu += "---------        PURCHASE        ---------" + "\n";
        // Need to go back and change this and make sure it works correctly because the cards in the market could change
        for(int i = 0; i < availableProperties.length; i++){
            Card c = cardsInMarket.get(i);
            numEntries += 1;
            String str = "";
            if(availableProperties[i] != 0 && p.getWallet() >= c.getCost() ){
               if(numEntries < 10){
                    str = String.format(" %d%s %-18s %s%s", numEntries, ".", c.getName(), c.getColor(), c.getIcon());
                    purchaseMenu += str;
                    str = String.format(" (%s)  [%s]  %5s%d", c.getCost(), c.getActNum(), "#", availableProperties[i]);
                    purchaseMenu += str + "\n";

               } else {
                    str = String.format("%d%s %-18s %s%s", numEntries, ".", c.getName(), c.getColor(), c.getIcon());
                    purchaseMenu += str;
                    str = String.format(" (%s)  [%s]  %5s%d", c.getCost(), c.getActNum(), "#", availableProperties[i]);
                    purchaseMenu += str + "\n";
               }
               
            }
        }


        for(int i = 0; i < p.getLandmarks().size(); i++){  
            LandMark l = p.getLandmarks().get(i);
            String str = "";
            numEntries += 1;
            if(l.isBuilt() == false && p.getWallet() >= l.getCost()){
                if(i == 0){
                    purchaseMenu += "---------       CONSTRUCT        ---------" + "\n";
                }
                if(numEntries < 10){
                    str = String.format(" %d%s %-18s %s%s", numEntries, ".", l.getName(), l.getColor(), l.getIcon());
                    purchaseMenu += str;
                    str = String.format(" (%s)  %-11s", l.getCost(), "[ ]");
                    purchaseMenu += str + "\n";
                }else{
                    str = String.format("%d%s %-18s %s%s", numEntries, ".", l.getName(), l.getColor(), l.getIcon());
                    purchaseMenu += str;
                    str = String.format(" (%s)  %-11s", l.getCost(), "[ ]");
                    purchaseMenu += str + "\n";
                }
             
            }
        }
        purchaseMenu += "---------         CANCEL         ---------" + "\n";
        purchaseMenu += "99. Do nothing                            " + "\n";
        purchaseMenu += "=========================================="; 
       


        return purchaseMenu;
    }

    /**
     * This method returns the Selection of the Market.
     * @param choiceNum Integer that indicates the choice.
     * @param menu Strings that indicates the menu.
     * @return The Market Selection as a string.
     */
    public String getMarketSelection(int choiceNum, String menu){
        //System.out.println("MarketSelection " + choiceNum);
        String selection;
        String choice = String.valueOf(choiceNum) + ".";
        int index = menu.indexOf(choice);
        selection = menu.substring(index + 3, index + 21); 
        selection = selection.trim();
        return selection;
    }
    /**
     * This method returns the Purchase cost.
     * @param choiceNum Integer that indicates the choice.
     * @param menu String that indicates the menu.
     * @return The cost of the Purchase as an integer.
     */
    public int getPurchaseCost(int choiceNum, String menu){
        String selection;

        String choice = String.valueOf(choiceNum) + ".";
        int index = menu.indexOf(choice);
        selection = menu.substring(index, index + 42);
        index = selection.indexOf("(");
        String cost = selection.substring(index + 1, index + 2);

        return Integer.parseInt(cost);
    }


}