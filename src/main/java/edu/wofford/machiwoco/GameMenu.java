package edu.wofford.machiwoco;
//import org.apache.logging.log4j.util.PropertySource.Comparator;
import java.util.*;

/**
 * The GameMenu is where the purchasing menu is constructed and implements the line format. 
 */
public class GameMenu {
    private int numEntries;
/**
 * This method gets the number of entries in the menu.
 * 
 * @return The number of entries 
 */
    public int getNumEntries(){
        return numEntries;
    }

    

    /**
     * This method sorts the cards by their activation number. 
     * @param cardTypes The type of card.
     */
    public List<Card> sortByActNum(List<Card> cardTypes) {
        List<Card> orderedCardList = new ArrayList<>();

        for (int i = 0; i < cardTypes.size(); i++) {
       
            for (int j = i + 1; j < cardTypes.size(); j++) {
                Card a = cardTypes.get(i);
                int cardA = a.getActNum();
    
                if(a.getActNum() == 0){
                    cardA = a.getActRange()[1];
                }else{
                    cardA = a.getActNum();
                }

                Card b = cardTypes.get(j);
                int cardB = b.getActNum();

                if(b.getActNum() == 0){
                    cardB = b.getActRange()[1];
                }else {
                    cardB = b.getActNum();
                }
                
                if(cardA > cardB){ // cardB > cardA
                    cardTypes.remove(j);
                    cardTypes.add(i,b);   
                }
            }
        }

        return cardTypes;
    }
/**
 * This method establishes the line format in the menu. 
 * @param c
 * @param numAvailable The number of available 
 * @return Menu lines.
 */
    public String menuLineFormatter(Card c, int numAvailable){
        String menuLine = "";

        if(c.getActNum() == 0){
            int[] range = c.getActRange();
            int range1 = range[0];
            int range2 = range[1];
    
            if(range1 > 9){
                menuLine += String.format("%-18s %s%s (%d)  [%d-%d]%-2s#%d\n", c.getName(), c.getColor(), c.getIcon(),
                    c.getCost(), range1, range2, "", numAvailable); // -5 

            }else if(range1 < 10 && range2 > 9){
                menuLine += String.format("%-18s %s%s (%d)  [%d-%d]%-3s#%d\n", c.getName(), c.getColor(), c.getIcon(),
                    c.getCost(), range1, range2, "", numAvailable); // -5
            }
            else{
                menuLine += String.format("%-18s %s%s (%d)  [%d-%d]%-4s#%d\n", c.getName(), c.getColor(), c.getIcon(),
                    c.getCost(), range1, range2, "", numAvailable); // -5
            }
           

        }else if(c.getActNum() > 9) {
            menuLine += String.format("%-18s %s%s (%d)  [%d]%-5s#%d\n", c.getName(), c.getColor(), c.getIcon(),
                c.getCost(), c.getActNum(), "", numAvailable); // -5
        }else{
            menuLine += String.format("%-18s %s%s (%d)  [%d]%-6s#%d\n", c.getName(), c.getColor(), c.getIcon(),
                c.getCost(), c.getActNum(), "", numAvailable); // -5
        }

        return menuLine;
    }
/**
 * This method helps establish the purchase menu line format 
 * @param entries the number of entries
 * @param c
 * @param numAvailable the number of available 
 * @return Purchase lines.
 */
    public String purchaseMenuLineFormatter(int entries, Card c, int numAvailable){
        String purchaseLine = "";

        if(c.getActNum() == 0){
            int[] range = c.getActRange();
            int range1 = range[0];
            int range2 = range[1];

            if(range1 > 9){
                purchaseLine += String.format("%2d. %-18s %s%s (%d)%2s[%d-%d]%-2s#%d", entries, c.getName(), c.getColor(), c.getIcon(),
                    c.getCost(), "", range1, range2, "", numAvailable) + "\n";

            }else if(range1 < 10 && range2 > 9){
                purchaseLine += String.format("%2d. %-18s %s%s (%d)%2s[%d-%d]%-3s#%d\n", entries, c.getName(), c.getColor(), c.getIcon(),
                    c.getCost(), "", range1, range2, "", numAvailable);
            }
            else{
                purchaseLine += String.format("%2d. %-18s %s%s (%d)%2s[%d-%d]%-4s#%d", entries, c.getName(), c.getColor(), c.getIcon(),
                    c.getCost(), "", range1, range2, "", numAvailable) + "\n";
            }

        }else if(c.getActNum() > 9) {
            purchaseLine += String.format("%2d. %-18s %s%s (%d)%2s[%d]%-5s#%d", entries, c.getName(), c.getColor(), c.getIcon(),
                c.getCost(), "", c.getActNum(), "", numAvailable) + "\n";
        }else{
            purchaseLine += String.format("%2d. %-18s %s%s (%d)%2s[%d]%-6s#%d", entries, c.getName(), c.getColor(), c.getIcon(),
                c.getCost(), "", c.getActNum(), "", numAvailable) + "\n";
        }

        return purchaseLine;
    }
/**
 * This method creates the market menu
 * @param market the location of the market 
 * @return The market menu.
 */
    public String createMarketMenu(Market market) {
        Map<String, Integer> marketStock = market.getMarketStock();
        List<Card> cardTypes = market.getCardTypes();

        String marketMenu = "";
        marketMenu += "******************************************" + "\n";
        marketMenu += "                  MARKET                  " + "\n";
        marketMenu += "------------------------------------------" + "\n";

        cardTypes = sortByActNum(cardTypes);

        for (int i = 0; i < cardTypes.size(); i++) {
            Card c = cardTypes.get(i);
            String name = c.getName();

            if(marketStock.get(name) != null && marketStock.get(name) > 0){
                marketMenu += menuLineFormatter(c, marketStock.get(name));
            }
            
   
        }

        return marketMenu;
    }
    /**
     * This method gets the players name and their money. 
     * @param player The player
     * @param turn  The players turn
     * @return The money and name of the player.
     */
    public String getPlayerNameMoney(Player player, int turn) {
        String playerNameAndMoney = "";

        if (player.getName().equals("1")) {
            if (turn == player.getNum()) {
                
                playerNameAndMoney += String.format("%13s%s %d* %-19s", "", "Player", player.getNum(), "[YOU]", "") + "\n";
            } else {
                playerNameAndMoney += String.format("%13s%s %d %-20s", "", "Player", player.getNum(), "[YOU]", "") + "\n";
            }

        } else {
            if (turn == player.getNum()) {
                playerNameAndMoney+= String.format("%17s%s %d*%-16s", "", "Player", player.getNum(), "") + "\n";
            } else {
                playerNameAndMoney += String.format("%17s%s %d%-17s", "", "Player", player.getNum(), "") + "\n";
            }

        }
        playerNameAndMoney += "------------------------------------------" + "\n";
        playerNameAndMoney += String.format("%17s%d coins)%-17s\n", "(", player.getWallet(), "");

        return playerNameAndMoney;

    }
    /**
     * This method gets the information about the players cards 
     * @param player 
     * @return A string containing the player's card information.
     */
    public String getPlayerCardInfo(Player player){
        String playerCardInfo = "";

        List<Card> cards = sortByActNum(player.getEstablishments());
        cards = sortByActNum(cards);
        for (int i = 0; i < cards.size(); i++) {
            Card c = cards.get(i);
            String name = c.getName();
            
            if(!playerCardInfo.contains(c.getName())){
                playerCardInfo += menuLineFormatter(c, player.getNumEstablishment(name));

            }
        }
        playerCardInfo += "\n";

        return playerCardInfo;
    }
/**
 * This method gets the status of the player's landmarks.
 * @param  player
 * @return The landmark information of a player.
 */
    public String getPlayerLandmarkInfo(Player player){
        String playerLandmarkInfo = "";
        List<LandMark> landmarks = player.getLandmarks();

        playerLandmarkInfo += ".........................................." + "\n";

        for(int i = 0; i < landmarks.size(); i++){
            LandMark l = landmarks.get(i);

            if(l.isBuilt()){
                if(l.getCost() < 10){
                    playerLandmarkInfo += String.format("%-18s %s%s (%d) %4s%s", 
                        l.getName(), l.getColor(), l.getIcon(), l.getCost(), "[X]", "") + "\n"; //-12
                }else{
                    playerLandmarkInfo += String.format("%-18s %s%s (%d) %2s%s", 
                        l.getName(), l.getColor(), l.getIcon(), l.getCost(), "[X]", "") + "\n"; //-12
                }
                
            }else{

                if(l.getCost() < 10){
                    playerLandmarkInfo += String.format("%-18s %s%s (%d) %4s%s", 
                        l.getName(), l.getColor(), l.getIcon(), l.getCost(), "[ ]", "") + "\n"; //-12
                }else{
                    playerLandmarkInfo += String.format("%-18s %s%s (%d) %2s%s", 
                        l.getName(), l.getColor(), l.getIcon(), l.getCost(), "[ ]", "") + "\n"; //-12
                }
               
            }
        }


        return playerLandmarkInfo;
    }
/**
 * This method compiles the players informaiton. 
 * @param player
 * @param player
 * @return Information of the player
 */
    public String getPlayerInfo(Player player, int turn) {
        String playerNameAndMoney = getPlayerNameMoney(player, turn);
        String playerCardInfo = getPlayerCardInfo(player);
        String playerLandMarkInfo = getPlayerLandmarkInfo(player);

        String playerInfo = playerNameAndMoney + playerCardInfo + playerLandMarkInfo;

        return playerInfo;
    }
/**
 * This method helps create the player menu. 
 * @param players
 * @param turn
 * @return The playrs menu.
 */
    public String createPlayerMenu(List<Player> players, int turn) {
        String playerMenu = "";

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            playerMenu += getPlayerInfo(player, turn) + "\n";
        }
        playerMenu += "******************************************" +"\n";

        return playerMenu;
    }

/**
 * This method helps create the purshase ability of the feild. 
 * @param market The market available. 
 * @param player The player.
 * @return The purchase of the field. 
 */
    public String createPurchaseField(Market market, Player player){
        Map<String, Integer> marketStock = market.getMarketStock();
        List<Card> cardTypes = market.getCardTypes();
        String purchaseField = "";
        int totalStock = market.getNumEstablishmentsInMarket();
        numEntries = 0;

        if(totalStock != 0 && player.getWallet() > 0){ // || true
            purchaseField+= 
            "==========================================" + "\n" +
            "---------        PURCHASE        ---------" + "\n";
    
            cardTypes = sortByActNum(cardTypes);
    
            
            for (int i = 0; i < cardTypes.size(); i++){
                Card c = cardTypes.get(i);
                String name = c.getName();
    
                if(marketStock.get(name) != null && marketStock.get(c.getName()) != 0){
                    if(player.getWallet() >= c.getCost() && c.getColor() != "P"){
                        numEntries += 1;
                        purchaseField += purchaseMenuLineFormatter(numEntries, c, marketStock.get(name));
                    }else if(player.hasCard(c) == false && player.getWallet() >= c.getCost()){
                        numEntries += 1; 
                        purchaseField += purchaseMenuLineFormatter(numEntries, c, marketStock.get(name));
                    }
                }
              
            }
            // if(player.getWallet() == 0){
            //     purchaseField = "";
            // }
        }
        //numEntries = 0;

        return purchaseField;
    }
/**
 * This method constructs the feild in the menu. 
 * @param player The player. 
 * @return The conctruction of the field.
 */
    public String createConstructionField(Player player){
        List<LandMark> landmarks = player.getLandmarks();
        String constructionField = "";

        String constructionFieldTitle = "---------       CONSTRUCT        ---------" + "\n";

        for(int i = 0; i < landmarks.size(); i++){
            LandMark l = landmarks.get(i);

            if(player.getWallet() >= l.getCost() && !l.isBuilt()){
                if(!constructionField.contains(constructionFieldTitle)){
                    constructionField += constructionFieldTitle;
                }
                
                
                numEntries += 1;

                if(l.getCost() < 10){
                    constructionField += String.format("%2d. %-18s %s%s (%d) %4s%-8s",
                        numEntries, l.getName(), l.getColor(), l.getIcon(), l.getCost(), "[ ]", "") + "\n";
                }else{
                    constructionField += String.format("%2d. %-18s %s%s (%d) %3s%-8s",
                        numEntries, l.getName(), l.getColor(), l.getIcon(), l.getCost(), "[ ]", "") + "\n";
                }
                    
            }
        }


        return constructionField;
    }
/**
 * If the player chooses to nothing, this method addreses that. 
 * @return Nothing done with the field.
 */
    public String createDoNothingField(){

        String doNothingField = "" +
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "=========================================="; //+ "\n";

        return doNothingField;
    }
/**
 * This method helps construct the purchase menu. 
 * @param market the market in the menu.
 * @param player The player
 * @return The purchase menu.
 */
    public String createPurchaseMenu(Market market, Player player){
        String purchaseField = createPurchaseField(market, player);
        String constructionField = createConstructionField(player);
        String noActionField = createDoNothingField();

        String purchaseMenu = purchaseField + constructionField + noActionField;

        // if(player.wallet == 0){
        //     purchaseMenu = "";
        // }

        return purchaseMenu;
    }
/**
 * This method creates the state of the game display. 
 * @param market The market in the menu.
 * @param players The player. 
 * @param turn the players turn.
 * @return The current state of the game.
 */
    public String createGameStateDisplay(Market market, List<Player> players, int turn){

        String marketMenu = createMarketMenu(market);
        String playerInfo = createPlayerMenu(players, turn);
        String gameState = marketMenu + "\n" + playerInfo;

        return gameState;
    }
}