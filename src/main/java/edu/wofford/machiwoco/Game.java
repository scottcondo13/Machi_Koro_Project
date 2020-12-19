package edu.wofford.machiwoco;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

//import javax.smartcardio.Card;
/** Represents an employee.
 * @author Scotty Condo
*/

public class Game {  
    private int playerNum = 1;
    /**The list of players playing the game. */
    private List<Player> playerList;
    /**A list of containing Ai players */
    private Random random = new Random();
    /**Number of players playing the game. */
    private int numPlayers;
    /**The list of establishment cards available in the market. */
    private int numAIPlayers;
    private int humanPlayers;
    /**A boolean value defaulted to false that controls the gamees longevity. */
    boolean gameOver = false;
    /**Keeps track of player turn. */
    private int turn;
    private String phase;
    private GameDisplay display;
    private GameNotifications notifications;
    protected Scanner scanner;
    private PrintCards print;
    private Market market;
    private GameMenu menu;
    private List<Card> cardsInMarket;
    private Map<String, Integer> availableProperties;
    private int currentPlayerNum;
    private int roll;
    private String menuString;
    private String cardName;
    private String selection;
    private int cost;
    private Dice dice;
    private boolean trainActivated = false;
    private boolean aiPlayers = false;
    private boolean AmusementParkisActivated = false;
    private List<String> AllCards;
    private String total;
    private RadioTowerStatement radioTowerStatement;
    private boolean strategicAI = false;
    
    protected boolean extraTurn = false;
    protected CardActivationHandling cardHandler;
    protected List<String> gameLog;
    //private Tableau t;

    
    /**
     *  This private method creates a list of players that will be used to run the game.
     * @param phase is the phase of the game 
     */
    public Game(String phase){
        this.phase = phase;
        AllCards = new ArrayList<>();
        //String card = "";
        if(phase.equals("phase0")){
            AllCards.add("Wheat Field");
            AllCards.add("Ranch");
            AllCards.add("Forest");
            //AllCards = {"Wheat Field", "Ranch", "Forest"}; 
        }
        printPhase(AllCards);
    }

     public Game(String phase, int numPlayers, String aiPlayers, List<Card> phaseCards, List<LandMark> phaseLandMark){
        humanPlayers = 1;
        numAIPlayers = 0;
        this.phase = phase;
        if (aiPlayers.equals("-ai")){
            this.aiPlayers = true;
        }
        if(phase.equals("phase1") && this.aiPlayers == false){
            humanPlayers = 2;
        }
        if(phase.equals("phase1") && this.aiPlayers){
            //numPlayers = numPlayers - 1;
            numAIPlayers = numAIPlayers + 1;
        }
        if(phase.equals("phase6")){
            strategicAI = true;
            numAIPlayers = numPlayers - humanPlayers;
        }

        else{
            numAIPlayers = numPlayers - humanPlayers;
        }

        //System.out.println(getHumanPlayers() + " is number of human players.");
        
        playerList = PlayerCreate(numPlayers, phaseCards, phaseLandMark);

        gameSetup(phaseCards);

     }


     private void gameSetup(List<Card> phaseCards){
        turn = random.nextInt(numPlayers) + 1;
        //turn = 1;
        currentPlayerNum = getTurn();
        display = new GameDisplay();
        notifications = new GameNotifications();
        scanner = new Scanner(System.in);
        print = new PrintCards();
        menu = new GameMenu();
        //notifications.GameStartNotification(getTurn());
        dice = new Dice();
        cardHandler = new CardHandler();

        if(phase.contains("phase6")){
            market = new HybridMarket(numPlayers);
            //market = new HybridMarket();
            //market = new SimpleMarket(phaseCards);
        }else{
            market = new SimpleMarket(phaseCards);
        }

        gameLog = new ArrayList<>();

        // Scanner sc = new Scanner("this is invalid\n this is valid");
        // String s = sc.nextLine();
        // System.out.println("This is the scanner stuff: " + s);
        // s = sc.nextLine();
        // System.out.println("This is the scanner stuff: " + s); 
        
     }

     public Market getMarket(){
         return market;
     }

   /**
    * This method creates a player with users and ai players. 
    * @param numPlayers 
    * @param numAIPlayers 
    * @return List of Players.
    */
     
    private List<Player> PlayerCreate(int numPlayers, List<Card> phaseCards, List<LandMark> phaseLandmarks){
        //System.out.println(numPlayers);
        //System.out.println(aiPlayers);
        this.numPlayers = numPlayers;
        playerList = new ArrayList<>();
        int playerId = 1;
        int numStrategicAI = 0;
       
        playerList = new ArrayList<>();
        
        if(strategicAI == true && numAIPlayers > 0){
            numStrategicAI = 1;
            numAIPlayers = numAIPlayers -1;
            //System.out.println("im strategic");
        }
        
        
        for (int i = 0; i < humanPlayers; i++){
            Player player = new Player(Integer.toString(playerId));
            for(int j = 0; j < phaseCards.size(); j++ ){
                if(phaseCards.get(j).getName().equals("Wheat Field")){
                    player.addEstablishment(phaseCards.get(j));
                    //System.out.println(playerId + "Wheat");
                }
                else if(phaseCards.get(j).getName().equals("Bakery")){
                    player.addEstablishment(phaseCards.get(j));
                    //System.out.println(playerId + "Bake");
                    
                }
                
            }
            for(int k = 0; k < phaseLandmarks.size(); k++){
                if(phaseLandmarks.get(k).getName().equals("City Hall")){
                    LandMark temp = new LandMark("City Hall");
                    temp.setCost(7);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "City Hall");
                }
                else if(phaseLandmarks.get(k).getName().equals("Train Station")){
                    LandMark temp = new LandMark("Train Station");
                    temp.setCost(4);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
                else if(phaseLandmarks.get(k).getName().equals("Shopping Mall")){
                    LandMark temp = new LandMark("Shopping Mall");
                    temp.setCost(10);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
                else if(phaseLandmarks.get(k).getName().equals("Amusement Park")){
                    LandMark temp = new LandMark("Amusement Park");
                    temp.setCost(16);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
                else if(phaseLandmarks.get(k).getName().equals("Radio Tower")){
                    LandMark temp = new LandMark("Radio Tower");
                    temp.setCost(22);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
            }
            //System.out.println(player.getEstablishments().size());
            playerList.add(player);
            playerId ++;
        }

        for (int i = 0; i < numAIPlayers; i++){
            SimpleAi player = new SimpleAi(Integer.toString(playerId));
            for(int j = 0; j < phaseCards.size(); j++ ){
                if(phaseCards.get(j).getName().equals("Wheat Field")){
                    player.addEstablishment(phaseCards.get(j));
                }
                else if(phaseCards.get(j).getName().equals("Bakery")){
                    player.addEstablishment(phaseCards.get(j));
                }
                
            }
            for(int k = 0; k < phaseLandmarks.size(); k++){
                //System.out.println(phaseLandmarks.get(k).getName());
                if(phaseLandmarks.get(k).getName().equals("City Hall")){
                    LandMark temp = new LandMark("City Hall");
                    temp.setCost(7);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "City Hall");
                }
                else if(phaseLandmarks.get(k).getName().equals("Train Station")){
                    LandMark temp = new LandMark("Train Station");
                    temp.setCost(4);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
                else if(phaseLandmarks.get(k).getName().equals("Shopping Mall")){
                    LandMark temp = new LandMark("Shopping Mall");
                    temp.setCost(10);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
                else if(phaseLandmarks.get(k).getName().equals("Amusement Park")){
                    LandMark temp = new LandMark("Amusement Park");
                    temp.setCost(16);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
                else if(phaseLandmarks.get(k).getName().equals("Radio Tower")){
                    LandMark temp = new LandMark("Radio Tower");
                    temp.setCost(22);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
            }
            playerList.add(player);
            playerId ++;
        }
        for (int i = 0; i < numStrategicAI; i++){
            StrategicAI player = new StrategicAI(Integer.toString(playerId));
            //System.out.println("New Strategic AI" + playerId);
            for(int j = 0; j < phaseCards.size(); j++ ){
                if(phaseCards.get(j).getName().equals("Wheat Field")){
                    player.addEstablishment(phaseCards.get(j));
                    //System.out.println(playerId + "Wheat");
                }
                else if(phaseCards.get(j).getName().equals("Bakery")){
                    player.addEstablishment(phaseCards.get(j));
                    //System.out.println(playerId + "Bake");
                    
                }
                
            }
            for(int k = 0; k < phaseLandmarks.size(); k++){
                if(phaseLandmarks.get(k).getName().equals("City Hall")){
                    LandMark temp = new LandMark("City Hall");
                    temp.setCost(7);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "City Hall");
                }
                else if(phaseLandmarks.get(k).getName().equals("Train Station")){
                    LandMark temp = new LandMark("Train Station");
                    temp.setCost(4);
                    //temp.setBuilt();
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
                else if(phaseLandmarks.get(k).getName().equals("Shopping Mall")){
                    LandMark temp = new LandMark("Shopping Mall");
                    temp.setCost(10);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
                else if(phaseLandmarks.get(k).getName().equals("Amusement Park")){
                    LandMark temp = new LandMark("Amusement Park");
                    temp.setCost(16);
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
                else if(phaseLandmarks.get(k).getName().equals("Radio Tower")){
                    LandMark temp = new LandMark("Radio Tower");
                    temp.setCost(22);
                    //temp.setBuilt();
                    player.addLandmark(temp);
                    //System.out.println(playerId + "Train");  
                }
            }
            //System.out.println(player.getEstablishments().size());
            playerList.add(player);
            playerId ++;
        }
        return playerList;
    }

    public List<String> getPhase0Cards(){
        return AllCards;
    }


    /**
     * This method gets all the different cards in the market.
     * In addition, it outputs a string saying whos going to go first along with the current contents 
     * of the players and the market.
     */
    public String printPhase(List<String> AllCards){
        String card = "";
        for (String cards : AllCards) {
            card = card + PrintCards.getFullDisplay(cards);
            //System.out.print(card);
        }
        System.out.print(card);
        return card;
    }
    public void setRoll(int setRoll){
        roll = setRoll;
    }
    public int getRoll(){
        return roll;
    }
    public String preRoll(){
        
        cardsInMarket = market.getCardTypes();
        String gameInfo = menu.createGameStateDisplay(market, getPlayers(), turn);
        gameLog.add(notifications.turnStart(turn));
        //System.out.println(notifications.turnStart(turn));
        System.out.println(gameInfo);
        return gameInfo;
        
    }
    public void setTurn(int setTurn){
        if(setTurn < 1 || setTurn > numPlayers){
            System.out.println("Out of bounds");
        }
        else{
            turn = setTurn;
        }
    }
    public int getHumanPlayers(){
        return humanPlayers;
    }

    public int getAIPlayers(){
        return numAIPlayers;
    }

    public boolean trainActivated(){
        return trainActivated;
    }

    public void setTrainActivated(){
        trainActivated = true;
    }


    /**
     * Sets the extra turn boolean to the value that is given
     * @param value the boolean value that the extra turn variable will be set to
     */
    public void setExtraTurn(boolean value){
        extraTurn = value;
    }

    /**
     * Returns the scanner that the game class uses
     * @return the scanner that is used to get player input for the game class
     */
    public Scanner getGameScanner(){
        return scanner;
    }

    /**
     * Sets the scanner that the game uses to get player input to the one thats given
     * @param scanner the scanner that the game will use to get player input
     */
    public void setGameScanner(Scanner scanner){
        this.scanner = scanner;
    }
   
    public List<String> rollCheck(Scanner scanner){
        int turn = getTurn();
        radioTowerStatement = new RadioTowerStatement(playerList, turn);
        String total = "";
        extraTurn = false;
        trainActivated = false;
        AmusementParkisActivated = false;
        List<String> output = new ArrayList<>();

        gameLog = new ArrayList<>();
        extraTurn = false;
        trainActivated = false;
        boolean radioTowerBuilt = false;
        int diceTotal = 0;
        //gameLog = new ArrayList<>();

        // if(!phase.equals("phase0") && !phase.equals("phase1")){
        //     trainActivated = playerList.get(turn - 1).getLandmarks().get(0).isBuilt();
        // //System.out.println(trainActivated);
        // }
        Player player = getPlayer(turn);
        for(int i = 0; i < player.getLandmarks().size(); i++){
            LandMark l = player.getLandmarks().get(i);
            if(l.getName().equals("Train Station") && l.isBuilt()){
                trainActivated = true;
            }
        }

        if(trainActivated){
            Player p = getPlayer(turn);
            int choice = 1;
            String rerollResponse;
            String prompt = String.format("Player %d would you like to roll 1 or 2 dice", player.getNum());
            //System.out.println(prompt);
            output.add(prompt);
            //String prompt = String.format("Player %d would you like to roll 1 or 2 dice", p.getNum());
            gameLog.add(prompt);

           

            if(getPlayer(turn).isAi()){
                SimpleAi ai = (SimpleAi) getPlayer(turn);
                choice = ai.RollSelect();

            }
            else if(getPlayer(turn).isStrategic()){
                StrategicAI strategic = (StrategicAI) getPlayer(turn);
                choice = 1;
            }
            else{
                System.out.println(prompt);
                /*
                while(scanner.hasNextInt() == false){
                    System.out.println("Choose a number to purchase or construct");
                    scanner.nextLine();
                }
                */
                if(scanner.hasNextInt() && getPlayer(turn).isStrategic() == false && getPlayer(turn).isAi() == false ){
                    
                    
                    choice = scanner.nextInt();
                    
                    while(choice > 2 || choice  <= 0) {
                        System.out.println(prompt);
                        choice = scanner.nextInt();
                    }
                }

            }if(choice == 1){
                    roll = dice.roll();
                    prompt = notifications.rollNotification(player.getNum(), roll);
                    diceTotal = roll;
                    output.add("1");
                    gameLog.add(prompt);
                    
                    
                    if (playerLandMarkBuilt("Radio Tower", turn)){
                        if(getPlayer(turn).isStrategic()){
                    
                            StrategicAI strategic = (StrategicAI) getPlayer(turn);
                            rerollResponse = strategic.likeToReroll(roll);
                            Scanner s = new Scanner(rerollResponse);
                            radioTowerStatement.radioTowerYesorNoResponse1Die(s);
                        }
                        else if(getPlayer(turn).isAi()){
                            SimpleAi ai = (SimpleAi) getPlayer(turn);
                            rerollResponse = ai.yesOrNo();
                            Scanner s = new Scanner(rerollResponse);
                            radioTowerStatement.radioTowerYesorNoResponse1Die(s);
                        }
                        else{
                            radioTowerStatement.radioTowerYesorNoResponse1Die(scanner);
                        }
                        
                        
                    }
                    
                    


            }else if(choice == 2){
                int diceRoll1 =  dice.roll();
                int diceRoll2 =  dice.roll();
                //total += " " + "2";
                output.add("2");
                //total += " " + Integer.toString(diceRoll1);
                //total += " " + Integer.toString(diceRoll2);
                if(playerLandMarkBuilt("Amusement Park", turn) && diceRoll1 == diceRoll2){
                    extraTurn = true;
                    //System.out.println("another turn");
                }
                prompt = notifications.rollNotification(player.getNum(), diceRoll1, diceRoll2);
                gameLog.add(prompt);
                diceTotal += diceRoll1 + diceRoll2;
                
                if (playerLandMarkBuilt("Radio Tower", turn)){
                    
                    radioTowerStatement.radioTowerYesorNoResponse2Dice(scanner);
                }
                
            } 
                
        }else{
            //total += "No Train Station";
            output.add("No Train Station");
            diceTotal= dice.roll();
            String prompt = notifications.rollNotification(getPlayer(turn).getNum(), diceTotal);
            gameLog.add(prompt);
            String rerollResponse;
            
            

            if (playerLandMarkBuilt("Radio Tower", turn)){
                if(getPlayer(turn).isAi()){
                    SimpleAi ai = (SimpleAi) getPlayer(turn);
                    rerollResponse = ai.yesOrNo();
                    Scanner s = new Scanner(rerollResponse);
                    radioTowerStatement.radioTowerYesorNoResponse1Die(s);
                    
    
                }
                if(getPlayer(turn).isStrategic()){
                    
                    StrategicAI strategic = (StrategicAI) getPlayer(turn);
                    rerollResponse = strategic.likeToReroll(roll);
                    Scanner s = new Scanner(rerollResponse);
                    radioTowerStatement.radioTowerYesorNoResponse1Die(s);
                }
                else{
                    radioTowerStatement.radioTowerYesorNoResponse1Die(scanner);
                }
                
                
            }
            
            
        }
        //roll = getPlayer(turn).rollDice();
        //notifications.rollNotification(turn, roll);//n.rollNotification(g.getPlayers.getPlayer(getTurn()).getNum, roll);
        // After roll cards should be checked to see if they activated and this should be checked for every player in game
        //player.addMoney(card.payout(roll));
        checkPlayerCards(diceTotal, turn);

        //return gameLog;
        return output;
    }

    public List<String> getGameLog(){
        return gameLog;
    }

    


    /**
     * This class 
     * @return The size of the list of players.
     */
    public boolean extraTurnCheck(int diceRoll1, int diceRoll2, Player player){
        if(player.hasBuilt("Amusement Park")){
            if(diceRoll1 == diceRoll2){
                return true;
            }
        }
        return false;
    }

    public int getNumberOfPlayers(){
        return playerList.size();
    }
    
    public boolean playerLandMarkBuilt(String LandMarkName, int turn){
        Player player = getPlayer(turn);
        LandMark lm;
        for(int i = 0; i < player.getLandmarks().size(); i++){
            LandMark l = player.getLandmarks().get(i);
            if(l.getName().equals(LandMarkName)){
                if(l.isBuilt()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method will be used to change the state in the console main to end the game.
     * @return End of the game. 
     */ 
    public boolean isOver(){
        //gameOver= false;
        for(int i = 0; i < playerList.size(); i++){
            Player p = playerList.get(i);
            int num = p.getNumLandmarksBuilt();
            int size = p.getLandmarks().size();
            if(p.getNumLandmarksBuilt() == p.getLandmarks().size()){
               
                return true;
            }
        }
        return false;
    }

    
  

    /**
     * This method will set the turn. 
     * It will be run in the bottom of the while loop at the end of a persons turn.
     */
    public void nextTurn(){
        if (turn == numPlayers && extraTurn == false){
            turn = 1;
        }
        else if(turn < numPlayers && extraTurn == false){
            turn ++;
        }
        else if(turn == numPlayers && extraTurn == true){
            turn = numPlayers;
            //System.out.println("yipee another go for player " + numPlayers);
        }
        else if(turn < numPlayers && extraTurn == true){
           // System.out.println("yipee another go for player " + turn);
            
        }
        

    }

    /**
     * This method returns the current turn of a player and will most likely be run at the top of the while loop to set the turn.
     * @return true
     */
    public int getTurn(){
        return turn;
    }
    
    /**
     * This method returns all of the players.
     * @return a list of Player objects.
     */
    public List<Player> getPlayers(){
        return playerList;
    }

    /**
     * This method takes the list of players and returns the player with the current turn.
     * @param turn This is the current turn given as an integer.
     * @return Returns a player object.
     */
    public Player getPlayer(int turn){
    
        Player player = playerList.get(turn - 1);
        return player;
    }

    

    
    /**
     * This method goes through all characters tableaus checking if their establishments were activated
     * from a given dice roll.
     * @param diceRoll This is the Dice Roll on a specific turn given as an int. 
     * @param turn This is the current turn given as an int.
     */
    public List<String> checkPlayerCards(int diceRoll, int turn){
        CardActivationHandling cardHandler = new CardHandler();
        List<Card> activatedCards;
        List<String> activationNotifications;

        Player curPlayer = getPlayer(turn);
        activationNotifications = cardHandler.cardCheck(scanner, playerList, curPlayer, diceRoll, turn);

        return activationNotifications;
                   
    }
    /***
     * This method activates the red cards for all the players. Each position of the List returned represents
     *  the number of red card activated for each respective player.
     * @param turn Integer that represents the turn of the game. It is always bigger than 0.
     * @return Returns a List of integers representing the amount of redCards that were activated
     */
    public Integer[] checkForRedCardActivation(int diceRoll, int turn) {
        Player currentPlayer = getPlayer(turn);
        int currentPlayerWallet = currentPlayer.getWallet();
        Integer[] redCardsActivated = new Integer[playerList.size()];
        for (int i = 0; i< playerList.size(); i++) {
            redCardsActivated[i] = 0;
        }
        int listPosition = turn - 1;
        Player player;
        if ((diceRoll == 3 || diceRoll == 9 || diceRoll == 10)) {
            while(listPosition >= 1 && listPosition != turn && currentPlayerWallet > 0) {
                player = getPlayer(listPosition);
                int cafeCards = player.tableau.getNumberOfSpecifiedCards("Cafe");
                int familyRestaurantCards = player.tableau.getNumberOfSpecifiedCards("Family Restaurant");
                if (cafeCards > 0) {
                    for (int i = 0; i < cafeCards; i++) {
                        if (currentPlayerWallet > 0) {
                            player.addMoney(1);
                            currentPlayer.payPlayer(1);
                            redCardsActivated[listPosition - 1] += 1;
                        }
                    }
                }
                if (familyRestaurantCards > 0 && (diceRoll == 9 || diceRoll == 10)) {
                    for (int i = 0; i < familyRestaurantCards; i++) {
                        if (currentPlayerWallet > 1) {
                            player.addMoney(2);
                            currentPlayer.payPlayer(2);
                            redCardsActivated[listPosition - 1] += 1;
                        }
                    }
                }
                listPosition = listPosition - 1;
                if (listPosition < 1) {
                    listPosition = playerList.size();
                }
            }
        }
        return redCardsActivated;
    }

    // public void checkForRedCardActivation(){
    //     for(int j = 0; j < activatedCards.size(); j++){
    //         Card c = activatedCards.get(i);

    
    /**
     * This method is used to output the purchase menu into the terminal.
     * It takes the current player object, check its variables such as wallet,
     * and from there determines what is on the purchase menu.
     */
    public void buyPrompt(){
        notifications.buyPrompt(turn, getPlayer(turn));
        System.out.println(notifications.viewPrompt());
        menuString = menu.createPurchaseMenu(market, getPlayer(turn));
        System.out.println(menuString);
    }

    /**
     * This method prints out the string stating the current turn has ended then changes the 
     * integer variable turn to be the next turn.
     */
    public void endTurn(){
        notifications.endOfTurn(turn);
        nextTurn();
    }

    /**
     * This method prints who the winner of the game is, and then closes the scanner ending the game.
     */
    public String gameWinner(){
        String winner = String.format("Player %s is the winner.", getPlayer(turn).getName());
        System.out.println(winner);
        scanner.close();
        return winner;

    }

    public Player getCurrentPlayer(){
        Player currentPlayer = getPlayer(turn);
        return currentPlayer;
    }

    /**
     * This method is used to determine what a player constructs. It prints the prompt
     * that the acceptance test looks for then allows the player to choose what available
     * establishment to construct.
     */
    /*
    public String viewMenu(){
        System.out.println("Choose a number to purchase or construct:\n");
        int viewChoice = 99;


        if(scanner.hasNext("view")){  
            String line = scanner.nextLine();
            line = line.split(" ")[1];
            viewChoice = Integer.parseInt(line);
            if(viewChoice > cardsInMarket.size()){
                System.out.println("Invalid selection, choose again");
            }
            cardName = display.getMarketSelection(viewChoice, menuString);
            System.out.println(print.getFullDisplay(cardName));
            return print.getFullDisplay(cardName);
        }
        else{
            return "";
        }
    }
    */
/**
 * This method established the purchasing of a landmark. 
 */
    public String purchaseEstablishmentLandmark(){
        int choice = 99;
        int aiChoice = 1;
        boolean validPurchase = false;
        String prompt = "Choose a number to purchase or construct:";

        
        
        
        String purchaseMenu = menu.createPurchaseMenu(market, getPlayer(turn));
        scanner.reset();
        //Scanner sc;

        if(getPlayer(turn).isStrategic()){
            StrategicAI strategic = (StrategicAI) getPlayer(turn);
            choice = strategic.strategicBuy(purchaseMenu, prompt, turn);
            //System.out.println(strategic.strategicBuy(purchaseMenu, prompt, turn));
            System.out.println("im strategic woop woop");
        }
        else if(getPlayer(turn).isAi()){
            SimpleAi ai = (SimpleAi) getPlayer(turn);
            aiChoice = ai.aiTurn(purchaseMenu, prompt, turn);
            //choice = ai.aiTurn(purchaseMenu, prompt, turn);
            System.out.println("This is the AIs choice: " + aiChoice);
            //scanner.nextLine();

        }else{
            //sc = new Scanner(System.in);
            scanner = new Scanner(System.in);
            System.out.println(prompt);

            // while(scanner.hasNextInt() == false){
            //     System.out.println("Choose a number to purchase or construct:");
            //     String s  = scanner.nextLine();
            //     System.out.println(s + ": has next int is false");
            // }

            //System.out.println("|" + scanner.nextLine() + "|");
            if(scanner.hasNextInt()){ //scanner.hasNextInt()
                
                //System.out.println("This is the whole line: " + scanner.nextLine() );

                System.out.println("Choice before: " + choice);
                //choice = sc.nextInt();
                //System.out.println("This from a different scanner" + choice);
                //scanner.nextInt();
                //scanner.remove();
                choice = scanner.nextInt();
                //choice = sc.nextInt();
                //System.out.println("Garrett "+ scanner.nextLine());

                //String input = scanner.nextLine();
                //choice = Integer.valueOf(input);

                //System.out.println("This is the input string: " + input);
                //scanner.nextLine();

                //String input = scanner.nextLine();
                //System.out.println("This is the whole line: " + input);
                //choice = Integer.valueOf(input);
                System.out.println("Choice after: " + choice);

                String purchaseTest = menu.createPurchaseMenu(market, getPlayer(turn));
                String[] lines = purchaseTest.split("\r\n|\r|\n");
                int purchaseOptions = lines.length - 4;

                System.out.println("Number of Entries: " + menu.getNumEntries());

                while((choice > menu.getNumEntries() || choice  <= 0) && choice != 99) {
                    //System.out.println(choice);
                    System.out.println("Choose a number to purchase or construct:");
                    // if(choice == 99){
                    //     //break;
                    // }
                    //s.nextLine();
                    if(scanner.hasNextInt()){
                        choice = scanner.nextInt();
                        System.out.println("Getting the next int");
                    }else{
                        scanner.nextLine();
                        System.out.println("Going to the next line");
                    }
                    
                }
            }
        }

        System.out.println("The current choice: " + choice);
        // if(aiChoice != 0){
        //     selection = display.getMarketSelection(aiChoice, purchaseMenu);
        // }else{
        //     selection = display.getMarketSelection(choice, purchaseMenu); //menuString 
        // }

        if(getPlayer(turn).isAi() == true){
            selection = display.getMarketSelection(aiChoice, purchaseMenu);
            System.out.println("This is the selection: " + selection);
        }
        else if(getPlayer(turn).isStrategic() == true){
            selection = display.getMarketSelection(choice, purchaseMenu);
            System.out.println("This is the selection: " + selection);
        }else{
             selection = display.getMarketSelection(choice, purchaseMenu); //menuString 
        }

       //selection = display.getMarketSelection(choice, purchaseMenu); //menuString 

        if(selection.contains("Do nothing")){
            String t = String.format("Player %s chose not to make any improvements.", getPlayer(turn).getName());
            System.out.println(t);
            //purchaseOutput.add(t);
            return t;
                

            // LandmarkOptions = "City Hall Train Station Shopping Mall"
        }else if(selection.equals("City Hall") || selection.equals("Train Station") || selection.equals("Shopping Mall") || 
            selection.equals("Amusement Park") || selection.equals("Radio Tower")){
            getPlayer(turn).construct(selection);
            String t = String.format("Player %s constructed the %s.", getPlayer(turn).getName(), selection); //
            System.out.println(t);
            //purchaseOutput.add(t);
            return t;

        }else {
            
            //selection = display.getMarketSelection(choice, purchaseMenu);
            Card purchasedCard = market.purchase(selection);
            validPurchase = getPlayer(turn).purchase(purchasedCard);

            String t = String.format("Player %s purchased the %s", getPlayer(turn).getName(), selection);
            System.out.println(t);
           // purchaseOutput.add(t);

            return t;
        }
        //System.out.println(purchaseOutput);
        //return purchaseOutput;
    }

   

    //
}