// // // package edu.wofford.machiwoco;

// // // public class mock2 {
// // //     if(playerList.get(turn).isAi()){
// // //         //     SimpleAi ai = (SimpleAi) playerList.get(turn);
// // //         //     choice = ai.aiTurn(purchaseMenu, prompt, turn);
            
// // //         //     String s = String.format("The turn is %d and the ai player is player %d", turn, ai.getNum());
// // //         //     //System.out.println(s);

// // //         //     selection = display.getMarketSelection(choice, menuString);
// // //         //     Card purchasedCard = market.purchase(selection);
// // //         //     //getPlayer(currentPlayerNum).addEstablishment(selection);
            
// // //         //     getPlayer(turn).purchase(purchasedCard);
// // //         //     //cost = d.getPurchaseCost(choice, menuString);
// // //         //     //System.out.println(cost);
// // //         //    // getPlayer(currentPlayerNum).purchase(cost);
// // //         //    // System.out.println(selection);
// // //         //     //m.purchase(selection);
// // //         //     String t = String.format("%s purchased the %s", 
// // //         //     getPlayer(turn).getName(), selection);
// // //         //     System.out.println(t);

// // //         }
// // //         else{
// // //             while(scanner.hasNextInt() == false){
// // //                 System.out.println("Choose a number to purchase or construct");
// // //                 scanner.nextLine();
// // //             }
    
// // //             if(scanner.hasNextInt()){
    
// // //                 choice = scanner.nextInt();
    
// // //                 String purchaseTest = menu.createPurchaseMenu(market, getPlayer(turn));
// // //                 String[] lines = purchaseTest.split("\r\n|\r|\n");
// // //                 int purchaseOptions = lines.length - 4;
// // //                 while(choice >= purchaseOptions || choice  <= 0 ) {
                    
// // //                     System.out.println("Choose a number to purchase or construct");
// // //                     if(choice == 99){
// // //                         break;
// // //                     }
// // //                     //s.nextLine();
// // //                     choice = scanner.nextInt();
                    
// // //                 }
    
// // //                 selection = display.getMarketSelection(choice, menuString);
// // //                 if(selection.contains("Do nothing")){
// // //                     String t = String.format("%s chose not to make any improvements", 
// // //                     getPlayer(turn).getName());
// // //                     System.out.println(t);
                    
// // //                 }else if(selection.equals("City Hall")){
// // //                     getPlayer(turn).construct(selection);
// // //                     String t = String.format("%s built the %s", 
// // //                     getPlayer(turn).getName(), selection); //
// // //                     System.out.println(t);
// // //                 }else {
                    
// // //                     selection = display.getMarketSelection(choice, menuString);
// // //                     Card purchasedCard = market.purchase(selection);
// // //                     //getPlayer(currentPlayerNum).addEstablishment(selection);
                    
// // //                     getPlayer(turn).purchase(purchasedCard);
// // //                     //cost = d.getPurchaseCost(choice, menuString);
// // //                     //System.out.println(cost);
// // //                    // getPlayer(currentPlayerNum).purchase(cost);
// // //                    // System.out.println(selection);
// // //                     //m.purchase(selection);
// // //                     String t = String.format("%s purchased the %s", 
// // //                     getPlayer(turn).getName(), selection);
// // //                     System.out.println(t);
// // //                 }
// // //             }else {
// // //                 String t = String.format("%s did not have enough money to make \nimprovments", 
// // //                 getPlayer(turn).getName());
// // //                 System.out.println(t);
// // //             }

// // //         }
// // // }






// package edu.wofford.machiwoco;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.*;

// //import javax.smartcardio.Card;
// /** Represents an employee.
//  * @author Scotty Condo
// */

// /**
//  * This is the public game class that establishes key specific elements of the game. 
//  * Including the number of players, the market establishment, and the ending of the game.
//  * Will keep track of how many of each establishment there are in the market and will update. 
//  * The order is Wheat field, Ranch , Forest.
//  * Means num establishments for a particular establishments!
//  * 
//  */
// public class Game {  
//     private Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
//     private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
//     private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
//     private Card Bakery = new Card("Bakery", "C", "G", 1, 2, 3, 1);
//     private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
//     private Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
//     private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
//     private Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
//     private Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
//     private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 12, 2);
//     private int playerNum = 1;
//     /**The list of players playing the game. */
//     private List<Player> playerList;
//     /**A list of containing Ai players */
//     private Random random = new Random();
//     /**Number of players playing the game. */
//     private int numPlayers;
//     /**The list of establishment cards available in the market. */
//     private int numAIPlayers;
//     /**A boolean value defaulted to false that controls the gamees longevity. */
//     boolean gameOver = false;
//     /**Keeps track of player turn. */
//     private int turn;
//     private String phase;
//     private GameDisplay display;
//     private GameNotifications notifications;
//     private Scanner scanner;
//     private PrintCards print;
//     private Market market;
//     private GameMenu menu;
//     private List<Card> cardsInMarket;
//     private Map<String, Integer> availableProperties;
//     private int currentPlayerNum;
//     private int roll;
//     private String menuString;
//     private String cardName;
//     private String selection;
//     private int cost;
//     private Dice dice;
//     private boolean trainActivated = false;
//     //private Tableau t;

//     /**
//      * This Constructor does a few things. First it creates two object lists. playList initializes a list of Player objects
//      * and establishments intializes a list of Card objects. In addition it sets the number of players that will be playing.
//      * The number of establishments is here as well. The active market shows the total number of establishments based on what 
//      * their max is in the beginning. It then runs the three private functions documented below. Lastly it sets the players
//      * turn to a random turn so the first turn will always be random.
//      * @param numPlayers The total number of players.
//      */
//     /*
//     public Game(int numPlayers){
//         playerList = new ArrayList<>();
//         establishments = new ArrayList<>();
//         this.numPlayers = numPlayers;
//         numEstablishments = 6;
//         activeMarket = new HashMap<>();
//         activeMarket.put("Wheat Field", 6);
//         activeMarket.put("Ranch", 6);
//         activeMarket.put("Forest", 6);
//         this.PlayerCreate(numPlayers, 0);
//         //this.MarketCreate("phase1");
//         //this.CardCount();
//         turn = random.nextInt(numPlayers) + 1;

//     }
//     */
//     /**
//      *  This private method creates a list of players that will be used to run the game.
//      * @return The list of players in the game.
//      */
//     public Game(String phase){
//         this.phase = phase;
//         if(phase.equals("phase0")){
//             String[] AllCards = {"Wheat Field", "Ranch", "Forest"};
//             String card = "";
//             for (String cards : AllCards) {
//                 card = PrintCards.getFullDisplay(cards);
//                 System.out.print(card);
//             }
//         }
//     }

//      public Game(String phase, int numPlayers, int numAIPlayers){
//          this.phase = phase;
//          playerList = PlayerCreate(numPlayers, numAIPlayers);

//          gameSetup(phase);
//      }

//      private void gameSetup(String phase){
//         turn = random.nextInt(numPlayers) + 1;
//         currentPlayerNum = getTurn();
//         display = new GameDisplay();
//         notifications = new GameNotifications();
//         scanner = new Scanner(System.in);
//         print = new PrintCards();
//         //notificatoins.GameStartNotification(getTurn());
//         market = new Market(phase);
//         menu = new GameMenu();
//         //market = new Market(phase);
//         //turn = random.nextInt(numPlayers) + 1;
//         notifications.GameStartNotification(getTurn());
//         dice = new Dice();
//         //System.out.println(turn);
//         //t = new Tableau(phase);
//      }

   
     
//     private List<Player> PlayerCreate(int numPlayers, int numAIPlayers){
//         this.numPlayers = numPlayers;
//         this.numAIPlayers = numAIPlayers;
//         playerList = new ArrayList<>();

//         for (int i = 0; i < numPlayers; i++){
//             //playerList.add(new Player("Player " + Integer.toString(i+1)));
//             playerList.add(new Player(Integer.toString(i + 1), phase));
//             //numPlayers += 1;
//         }

//         for (int i = 0; i < numAIPlayers; i++){
//             //playerList.add(new Player("Player " + Integer.toString(i+1)));
//             playerList.add(new SimpleAi(Integer.toString(this.numPlayers + 1)));
//             this.numPlayers += 1;
//         }

//         //numPlayers = playerList.size();
//         return playerList;
//     }



//     /**
//      * This method returns the number of players in the game.
//      * @return Players list.
//      */
//     public void preRoll(){
        
//         //int[] availableProperties = g.activeMarketUpdate();
//         cardsInMarket = market.getCardTypes();
//         String gameInfo = menu.createGameStateDisplay(market, getPlayers(), turn);
        
//         //currentPlayerNum = getTurn();
//         notifications.turnStart(turn);
//         //System.out.println("\n");
//         System.out.println(gameInfo);
        
//     }

//     public void rollCheck(){
//         if(!phase.equals("phase0") && !phase.equals("phase1")){
//         boolean trainActivated = playerList.get(turn - 1).getLandmarks().get(1).isBuilt();
//         //System.out.println(trainActivated);
//         }
        
//         if(trainActivated){
//             System.out.println("like to roll 1 or 2");
//             if(scanner.hasNextInt()){
//                 int choice = scanner.nextInt();
//                 if(choice == 1){
//                     roll = dice.roll();
//                 }
//                 else if(choice == 2){
//                     roll = dice.doubleRoll();
//                 }
//                 else{
//                     while(choice > 2 || choice  <= 0) {
//                         System.out.println("like to roll 1 or 2");
//                         choice = scanner.nextInt();
//                     }
//                 }
//             }
//         }
//         else{
//             roll = dice.roll();
//         }
//         //roll = getPlayer(turn).rollDice();
//         notifications.rollNotification(turn, roll);//n.rollNotification(g.getPlayers.getPlayer(getTurn()).getNum, roll);
//         // After roll cards should be checked to see if they activated and this should be checked for every player in game
//         //player.addMoney(card.payout(roll));
//         checkPlayerCards(roll, turn);
//     }
//     public int getNumberOfPlayers(){
//         return playerList.size();
//     }

//     /**
//      * This method will be used to change the state in the console main to end the game.
//      * @return End of the game. 
//      */ 
//     public boolean isOver(){
//         //gameOver= false;
//         for(int i = 0; i < playerList.size(); i++){
//             Player p = playerList.get(i);
//             if(p.getNumLandmarksBuilt() == p.getLandmarks().size()){
//                 System.out.println(String s = s.format("the number of landmarks is %d and the size is %d", 
//                     p.getNumLandmarksBuilt(), ));
//                 return true;
//             }
//         }
//         return false;
//     }

    
  

//     /**
//      * This method will set the turn. 
//      * It will be run in the bottom of the while loop at the end of a persons turn.
//      */
//     public void nextTurn(){
//         if (turn == numPlayers){
//             turn = 1;
//         }
//         else if(turn < numPlayers){
//             turn ++;
//         }
//     }

//     /**
//      * This method returns the current turn of a player and will most likely be run at the top of the while loop to set the turn.
//      * @return true
//      */
//     public int getTurn(){
//         return turn;
//     }
    
//     public List<Player> getPlayers(){
//         return playerList;
//     }

//     public Player getPlayer(int turn){
    
//         Player player = playerList.get(turn - 1);
//         return player;
//     }

    

    

//     public void checkPlayerCards(int diceRoll, int turn){
//         for(int i = 0; i < playerList.size(); i++){
//             Player p = playerList.get(i);
//             p.checkCards(diceRoll, turn, p.getNum());
//         }

//         // for(int i = 0; i < aiPlayerList.size(); i++){
//         //     SimpleAi ai = aiPlayerList.get(i);
//         //     ai.checkCards(diceRoll, turn, ai.getNum());
//         // }

//     }

//     public void buyPrompt(){
//         notifications.buyPrompt(turn, getPlayer(turn));
//         System.out.println(notifications.viewPrompt());
//         //String menu = d.displayPurchaseMenu(availableProperties, cardsInMarket, g.getPlayer(currentPlayerNum));
//         menuString = menu.createPurchaseMenu(market, getPlayer(turn));
//         //menuString = menu.createGameStateDisplay(m, getPlayers(), turn);
//         System.out.println(menuString);
//     }

//     public void endTurn(){
//         notifications.endOfTurn(turn);
//         nextTurn();
//     }

//     public void gameWinner(){
//         String winner = String.format("Player %s is the winner.", getPlayer(getTurn()).getName());
//         System.out.println(winner);
//         scanner.close();

//     }

//     public void viewMenu(){
//         System.out.println("Choose a number to purchase or construct\n");
//         int viewChoice = 99;

//         // while(s.hasNextInt() == false && s.hasNext("view") == false && s.hasNextInt() == false){
//         //     System.out.println("Choose a number to purchase or construct:");
//         //     s.nextLine();
//         // }

//         if(scanner.hasNext("view")){  //s.next().equals("view")
//             //System.out.println("yaayy");
//             //viewChoice = s.nextInt();
//             String line = scanner.nextLine();
//             line = line.split(" ")[1];
//             viewChoice = Integer.parseInt(line);
//             if(viewChoice > cardsInMarket.size()){
//                 System.out.println("Invalid selection, choose again");
//                 //choice = s.nextInt();
//             }
//             cardName = display.getMarketSelection(viewChoice, menuString);
//             System.out.println(print.getFullDisplay(cardName));
//             //choice = s.nextInt();
//         }
//     }

//     public void purchaseEstablishmentLandmark(){
//         // if(aiPlayerList.get(turn).isAi()){
//         //     System.out.println("Start here");
//         //     SimpleAi ai = aiPlayerList.get(turn);
//         //     String prompt = "Choose a number to purchase or construct";
//         //     String purchaseMenu = menu.createPurchaseMenu(market, getPlayer(turn));
//         //     System.out.println(purchaseMenu);
//         //     ai.aiTurn(purchaseMenu, prompt, turn);
//         // }
//         int choice;

//         String prompt = "Choose a number to purchase or construct";
//         System.out.println(prompt);
//         String purchaseMenu = menu.createPurchaseMenu(market, getPlayer(turn));
//         //if(aiPlayerList.get(index))
//         if(getPlayer(turn).isAi()){
//             SimpleAi ai = (SimpleAi) getPlayer(turn);
//             choice = ai.aiTurn(purchaseMenu, prompt, turn);
//             System.out.println(choice);
        
//          String s = String.format("The turn is %d and the ai player is player %d", turn, ai.getNum());
//          System.out.println(s);

//             selection = display.getMarketSelection(choice, menuString);
//             System.out.println(selection);
//             Card purchasedCard = market.purchase(selection);
//             //getPlayer(currentPlayerNum).addEstablishment(selection);
//             getPlayer(turn).purchase(purchasedCard);
//     //     //cost = d.getPurchaseCost(choice, menuString);
//     //     //System.out.println(cost);
//     //    // getPlayer(currentPlayerNum).purchase(cost);
//     //    // System.out.println(selection);
//     //     //m.purchase(selection);
//             String t = String.format("%s purchased the %s",getPlayer(turn).getName(), selection);
//             System.out.println(t);
    
//             }
//             else{
//                 while(scanner.hasNextInt() == false){
//                     System.out.println("Choose a number to purchase or construct");
//                     scanner.nextLine();
//                 }
        
//                 if(scanner.hasNextInt()){
        
//                     choice = scanner.nextInt();
        
//                     String purchaseTest = menu.createPurchaseMenu(market, getPlayer(turn));
//                     String[] lines = purchaseTest.split("\r\n|\r|\n");
//                     int purchaseOptions = lines.length - 4;
//                     while(choice >= purchaseOptions || choice  <= 0 ) {
                        
//                         System.out.println("Choose a number to purchase or construct");
//                         if(choice == 99){
//                             break;
//                         }
//                         //s.nextLine();
//                         choice = scanner.nextInt();
                        
//                     }
        
//                     selection = display.getMarketSelection(choice, menuString);
//                     if(selection.contains("Do nothing")){
//                         String t = String.format("%s chose not to make any improvements", 
//                         getPlayer(turn).getName());
//                         System.out.println(t);
                        
//                     }else if(selection.equals("City Hall") || selection.equals("Train Station")){
//                         getPlayer(turn).construct(selection);
//                         String t = String.format("%s built the %s", 
//                         getPlayer(turn).getName(), selection); //
//                         System.out.println(t);
//                     }else {
                        
//                         selection = display.getMarketSelection(choice, menuString);
//                         Card purchasedCard = market.purchase(selection);
//                         //getPlayer(currentPlayerNum).addEstablishment(selection);
                        
//                         getPlayer(turn).purchase(purchasedCard);
//                         //cost = d.getPurchaseCost(choice, menuString);
//                         //System.out.println(cost);
//                        // getPlayer(currentPlayerNum).purchase(cost);
//                        // System.out.println(selection);
//                         //m.purchase(selection);
//                         String t = String.format("%s purchased the %s", 
//                         getPlayer(turn).getName(), selection);
//                         System.out.println(t);
//                     }
//                 }else {
//                     String t = String.format("%s did not have enough money to make \nimprovments", 
//                     getPlayer(turn).getName());
//                     System.out.println(t);
//                 }
    
//             }//
        
//     }
    
//     /*
//     public Card getCardByName(String name){
//         Card c = new Card("Ranch");
//         for(int i = 0; i < establishments.size(); i++){
//             if(establishments.get(i).getName().equals(name)){
//                 return establishments.get(i);
//             }
//         }
//         return c;
//     }
//     */
    

//     /*public List<Player> PlayerCreate(){
        
//     }*/

    
// }
