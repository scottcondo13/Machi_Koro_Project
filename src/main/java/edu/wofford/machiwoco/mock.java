// package edu.wofford.machiwoco;

// public class mock {

//     //  if(input.contains("phase1")){ //|| input.contains("phase2")){
//     //         //Using two players for now, but we need to get the input when the game is run
//     //         // System.out.println("is the winner");
//     //         // System.out.println("\n");
//     //         g = new Game(input, 2, 0);
         
//     //         GameNotifications n = new GameNotifications();
//     //         GameMenu gameMenu = new GameMenu();
//     //         Market market = new Market("phase1");
//     //         Scanner s = new Scanner(System.in);
//     //         PrintCards print = new PrintCards();
//     //         GameDisplay d = new GameDisplay();
//     //        // try{
//     //         int currentPlayerNum = g.getTurn();
               
//     //             while(g.isOver() == false){
//     //                 List<Card> cardsInMarket = market.getCardTypes();
//     //                 currentPlayerNum = g.getTurn();
                   

//     //                 g.preRoll();

//     //                 g.rollCheck(g.getTurn());
                

//     //                 if(g.getPlayer(g.getTurn()).getWallet() > 0){
//     //                     n.buyPrompt(currentPlayerNum, g.getPlayer(currentPlayerNum));
//     //                     System.out.println(n.viewPrompt());
//     //                     //String menu = d.displayPurchaseMenu(availableProperties, cardsInMarket, g.getPlayer(currentPlayerNum));
//     //                     String menu = gameMenu.createPurchaseMenu(market, g.getPlayer(currentPlayerNum));
//     //                     System.out.println(menu);

//     //                     System.out.println("Choose a number to purchase or construct:\n");
//     //                     int viewChoice = 99;

//     //                     while(s.hasNextInt() == false && s.hasNext("view") == false && s.hasNextInt() == false){
//     //                         System.out.println("Choose a number to purchase or construct:");
//     //                         s.nextLine();

//     //                     }

//     //                     if(s.hasNext("view")){  //s.next().equals("view")
//     //                         //System.out.println("yaayy");
//     //                         //viewChoice = s.nextInt();
//     //                         String line = s.nextLine();
//     //                         line = line.split(" ")[1];
//     //                         viewChoice = Integer.parseInt(line);
//     //                         if(viewChoice > cardsInMarket.size()){
//     //                             System.out.println("Invalid selection, choose again");
//     //                             //choice = s.nextInt();
//     //                         }
//     //                         String cardName = d.getMarketSelection(viewChoice, menu);
//     //                         System.out.println(print.getFullDisplay(cardName));
//     //                         //choice = s.nextInt();
//     //                     }if(s.hasNextInt()){
//     //                         int choice = s.nextInt();
//     //                         while(choice > gameMenu.getNumEntries() || choice < 1){
//     //                             if(choice == 99){
//     //                                 break;
//     //                             }
//     //                             String str = "Choose a number to purchase or construct:" + "\n";
//     //                             System.out.println(str);
//     //                             s.nextLine();
//     //                             //choice = s.nextInt();
//     //                             if(s.hasNextInt()){
//     //                                 choice = s.nextInt();
//     //                             }
//     //                         }
//     //                         //choice = s.nextInt();
//     //                         String selection = d.getMarketSelection(choice, menu);
//     //                         System.out.println(selection);
//     //                         //System.out.println("City Hall");
//     //                         if(selection.contains("Do nothing")){
//     //                             String t = String.format("%s chose not to make any improvements", 
//     //                                 g.getPlayer(currentPlayerNum).getName());
//     //                             System.out.println(t);
                                
//     //                         }else if(selection.equals("City Hall")){
//     //                             g.getPlayer(currentPlayerNum).construct(selection);
//     //                             String t = String.format("%s built the %s", 
//     //                                 g.getPlayer(currentPlayerNum).getName(), selection);
//     //                             System.out.println(t);
//     //                             break;
//     //                         }else {
//     //                             //int size = g.getPlayer(currentPlayerNum).getEstablishments().size();
//     //                             g.getPlayer(currentPlayerNum).addEstablishment(selection);
//     //                             int cost = d.getPurchaseCost(choice, menu);
//     //                             //System.out.println(cost);
//     //                             g.getPlayer(currentPlayerNum).purchase(cost);
//     //                             System.out.println(selection);
//     //                             market.setMarketStock(selection);
//     //                             String t = String.format("%s purchased the %s", 
//     //                                 g.getPlayer(currentPlayerNum).getName(), selection);
//     //                             System.out.println(t);
//     //                         }
//     //                     }else {
//     //                         String t = String.format("%s did not have enough money to make \nimprovments", 
//     //                             g.getPlayer(currentPlayerNum).getName());
//     //                         System.out.println(t);
//     //                     }
//     //                 }
//     //                     /*
//     //                     s.nextLine();
//     //                     int choice;
//     //                     String line = s.findInLine(Pattern.compile("[view ]+\\d+\\d*"));
//     //                     String choiceNum = s.findInLine(Pattern.compile("\\d+\\d*"));

//     //                         if(choiceNum != null){
//     //                             choice = Integer.parseInt(choiceNum);
//     //                             //System.out.println(line);
//     //                         }else if(choiceNum != null && Integer.parseInt(choiceNum) > cardsInMarket.size()){
//     //                             System.out.println("Invalid input enter choice again");
//     //                             choice = s.nextInt();
//     //                             choice = 1;
//     //                         }else{
//     //                             line = line.split(" ")[1];
//     //                             int num = Integer.parseInt(line);
//     //                             String cardName = d.getMarketSelection(num, menu);
//     //                             System.out.println(print.getFullDisplay(cardName));
//     //                             choice = s.nextInt();
//     //                         }
//     //                         //n.choseLine(); chose the thing you want to purchase/construct
//     //                         // Take input from the console and update market to reflect purchase choice or lack thereof
//     //                         */

//     //                         //int choice = s.nextInt();
                            
                   
//     //                 //int choice = s.nextInt();
//     //                 /*
//     //                 if(choice > 4 || choice != 99){
//     //                     System.out.println("Invalid choice, chose again");
//     //                     choice = s.nextInt();
//     //                     //n.purchaseChoice();
//     //                 }
//     //                 */
                    

//     //                 n.endOfTurn(currentPlayerNum);
//     //                 g.nextTurn();
//     //                 //g.nextTurn();

                  
//     //             }
//     //             String winner = String.format("Player %s is the winner.", g.getPlayer(g.getTurn()).getName());
//     //             System.out.println(winner);
//     //             s.close();
//     //         //}catch(Exception e){
//     //         //    System.out.println(e);
//     //         //}
            
//     //     }
    
    
// }

















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
//             playerList.add(new SimpleAi(Integer.toString(this.numPlayers + 1), phase));
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
//         trainActivated = false;
//         int diceTotal = 0;
//         // if(!phase.equals("phase0") && !phase.equals("phase1")){
//         //     trainActivated = playerList.get(turn - 1).getLandmarks().get(0).isBuilt();
//         // //System.out.println(trainActivated);
//         // }
//         Player player = getPlayer(turn);
//         for(int i = 0; i < player.getLandmarks().size(); i++){
//             LandMark l = player.getLandmarks().get(i);
//             if(l.getName().equals("Train Station") && l.isBuilt()){
//                 trainActivated = true;
//             }
//         }
        
//         if(trainActivated){
//             Player p = getPlayer(turn);
//             int choice = 1;
//             String prompt = String.format("Player %d would you like to roll 1 or 2 dice", p.getNum());
//             System.out.println(prompt);

//             if(getPlayer(turn).isAi()){
//                 SimpleAi ai = (SimpleAi) getPlayer(turn);
//                 choice = ai.RollSelect();

//             }else{

//                 while(scanner.hasNextInt() == false){
//                     System.out.println("Choose a number to purchase or construct");
//                     scanner.nextLine();
//                 }
//                 if(scanner.hasNextInt()){
                    
//                     choice = scanner.nextInt();
//                     while(choice > 2 || choice  <= 0) {
//                         System.out.println(prompt);
//                         choice = scanner.nextInt();
//                     }
//                 }

//             }if(choice == 1){
//                     roll = dice.roll();
//                     notifications.rollNotification(player.getNum(), roll);
//                     diceTotal += roll;

//             }else if(choice == 2){
//                 int diceRoll1 = dice.roll();
//                 int diceRoll2 = dice.roll();
//                 notifications.rollNotification(player.getNum(), diceRoll1, diceRoll2);
//                 diceTotal += diceRoll1 + diceRoll2;
//             }   
               
//         }else{
//             diceTotal= dice.roll();
//             notifications.rollNotification(getPlayer(turn).getNum(), diceTotal);
//         }
//         //roll = getPlayer(turn).rollDice();
//         //notifications.rollNotification(turn, roll);//n.rollNotification(g.getPlayers.getPlayer(getTurn()).getNum, roll);
//         // After roll cards should be checked to see if they activated and this should be checked for every player in game
//         //player.addMoney(card.payout(roll));
//         checkPlayerCards(diceTotal, turn);
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
//             int num = p.getNumLandmarksBuilt();
//             int size = p.getLandmarks().size();
//             //String s = String.format("the number of landmarks is %d and the size is %d", 
//                 //num, size );
//             //System.out.println(s);

//             if(p.getNumLandmarksBuilt() == p.getLandmarks().size()){
               
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
//         String winner = String.format("Player %s is the winner.", getPlayer(turn).getName());
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
//         int choice = 99;
//         boolean validPurchase = false;
//         String prompt = "Choose a number to purchase or construct";
//         System.out.println(prompt);
//         String purchaseMenu = menu.createPurchaseMenu(market, getPlayer(turn));

//         if(getPlayer(turn).isAi()){
//             SimpleAi ai = (SimpleAi) getPlayer(turn);
//             choice = ai.aiTurn(purchaseMenu, prompt, turn);
//             System.out.println(choice);

//         }else{

//             while(scanner.hasNextInt() == false){
//                 System.out.println("Choose a number to purchase or construct");
//                 scanner.nextLine();
//             }

//             if(scanner.hasNextInt()){
//                 choice = scanner.nextInt();
//                 String purchaseTest = menu.createPurchaseMenu(market, getPlayer(turn));
//                 String[] lines = purchaseTest.split("\r\n|\r|\n");
//                 int purchaseOptions = lines.length - 4;

//                 while(choice >= purchaseOptions || choice  <= 0) {
//                     System.out.println("Choose a number to purchase or construct");
//                     if(choice == 99){
//                         break;
//                     }
//                     //s.nextLine();
//                     choice = scanner.nextInt();
//                 }
//             }
//         }

//         selection = display.getMarketSelection(choice, menuString);

//         if(selection.contains("Do nothing")){
//             String t = String.format("%s chose not to make any improvements", 
//             getPlayer(turn).getName());
//             System.out.println(t);
                
//         }else if(selection.equals("City Hall") || selection.equals("Train Station") || selection.equals("Shopping Mall")){
//             getPlayer(turn).construct(selection);
//             String t = String.format("%s built the %s", 
//             getPlayer(turn).getName(), selection); //
//             System.out.println(t);

//         }else {
            
//             selection = display.getMarketSelection(choice, menuString);
//             Card purchasedCard = market.purchase(selection);
//             validPurchase = getPlayer(turn).purchase(purchasedCard);

//             String t = String.format("%s purchased the %s", 
//             getPlayer(turn).getName(), selection);
//             System.out.println(t);
//         }
//         if(!validPurchase) {

//             String t = String.format("%s did not have enough money to make \nimprovments", 
//             getPlayer(turn).getName());
//             //System.out.println(t);
//         }
    
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











// public void rollCheck(){
//     trainActivated = false;
//     int diceTotal = 0;
//     // if(!phase.equals("phase0") && !phase.equals("phase1")){
//     //     trainActivated = playerList.get(turn - 1).getLandmarks().get(0).isBuilt();
//     // //System.out.println(trainActivated);
//     // }
//     Player player = getPlayer(turn);
//     for(int i = 0; i < player.getLandmarks().size(); i++){
//         LandMark l = player.getLandmarks().get(i);
//         if(l.getName().equals("Train Station") && l.isBuilt()){
//             trainActivated = true;
//         }
//     }
    
//     if(trainActivated){
//         Player p = getPlayer(turn);
//         int choice = 1;
//         String prompt = String.format("Player %d would you like to roll 1 or 2 dice", p.getNum());
//         System.out.println(prompt);

//         if(getPlayer(turn).isAi()){
//             SimpleAi ai = (SimpleAi) getPlayer(turn);
//             choice = ai.RollSelect();

//         }else{

//             while(scanner.hasNextInt() == false){
//                 System.out.println("Choose a number to purchase or construct");
//                 scanner.nextLine();
//             }
//             if(scanner.hasNextInt()){
                
//                 choice = scanner.nextInt();
//                 while(choice > 2 || choice  <= 0) {
//                     System.out.println(prompt);
//                     choice = scanner.nextInt();
//                 }
//             }

//         }if(choice == 1){
//                 roll = dice.roll();
//                 notifications.rollNotification(player.getNum(), roll);
//                 diceTotal += roll;

//         }else if(choice == 2){
//             int diceRoll1 = dice.roll();
//             int diceRoll2 = dice.roll();
//             notifications.rollNotification(player.getNum(), diceRoll1, diceRoll2);
//             diceTotal += diceRoll1 + diceRoll2;
//         }   
           
//     }else{
//         diceTotal= dice.roll();
//         notifications.rollNotification(getPlayer(turn).getNum(), diceTotal);
//     }
//     //roll = getPlayer(turn).rollDice();
//     //notifications.rollNotification(turn, roll);//n.rollNotification(g.getPlayers.getPlayer(getTurn()).getNum, roll);
//     // After roll cards should be checked to see if they activated and this should be checked for every player in game
//     //player.addMoney(card.payout(roll));
//     checkPlayerCards(diceTotal, turn);
// }
































// // package edu.wofford.machiwoco;
// // import java.util.ArrayList;
// // import java.util.List;
// // import java.util.*;

// // //import javax.smartcardio.Card;
// // /** Represents an employee.
// //  * @author Scotty Condo
// // */

// // /**
// //  * This is the public game class that establishes key specific elements of the game. 
// //  * Including the number of players, the market establishment, and the ending of the game.
// //  * Will keep track of how many of each establishment there are in the market and will update. 
// //  * The order is Wheat field, Ranch , Forest.
// //  * Means num establishments for a particular establishments!
// //  * 
// //  */
// // public class Game {  
// //     private Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
// //     private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
// //     private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
// //     private Card Bakery = new Card("Bakery", "C", "G", 1, 2, 3, 1);
// //     private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
// //     private Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
// //     private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
// //     private Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
// //     private Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
// //     private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 12, 2);
// //     private int playerNum = 1;
// //     /**The list of players playing the game. */
// //     private List<Player> playerList;
// //     private Random random = new Random();
// //     /**Number of players playing the game. */
// //     private int numPlayers;
// //     /**The list of establishment cards available in the market. */
// //     private int numAIPlayers;
// //     /**A boolean value defaulted to false that controls the gamees longevity. */
// //     boolean gameOver = false;
// //     /**Keeps track of player turn. */
// //     private int turn;
// //     private String phase;
// //     private GameDisplay d;
// //     private GameNotifications n;
// //     private Scanner s;
// //     private PrintCards print;
// //     private Market m;
// //     private GameMenu menu;
// //     private List<Card> cardsInMarket;
// //     private HashMap<String, Integer> availableProperties;
// //     private int currentPlayerNum;
// //     private int roll;
// //     private String menuString;
// //     private String cardName;
// //     private String selection;
// //     private int cost;
// //     private Tableau t;

// //     /**
// //      * This Constructor does a few things. First it creates two object lists. playList initializes a list of Player objects
// //      * and establishments intializes a list of Card objects. In addition it sets the number of players that will be playing.
// //      * The number of establishments is here as well. The active market shows the total number of establishments based on what 
// //      * their max is in the beginning. It then runs the three private functions documented below. Lastly it sets the players
// //      * turn to a random turn so the first turn will always be random.
// //      * @param numPlayers The total number of players.
// //      */
// //     /*
// //     public Game(int numPlayers){
// //         playerList = new ArrayList<>();
// //         establishments = new ArrayList<>();
// //         this.numPlayers = numPlayers;
// //         numEstablishments = 6;
// //         activeMarket = new HashMap<>();
// //         activeMarket.put("Wheat Field", 6);
// //         activeMarket.put("Ranch", 6);
// //         activeMarket.put("Forest", 6);
// //         this.PlayerCreate(numPlayers, 0);
// //         //this.MarketCreate("phase1");
// //         //this.CardCount();
// //         turn = random.nextInt(numPlayers) + 1;

// //     }
// //     */
// //     /**
// //      *  This private method creates a list of players that will be used to run the game.
// //      * @return The list of players in the game.
// //      */
// //     public Game(String phase){
// //         this.phase = phase;
// //         if(phase.equals("phase0")){
// //             String[] AllCards = {"Wheat Field", "Ranch", "Forest"};
// //             String card = "";
// //             for (String cards : AllCards) {
// //                 card = PrintCards.getFullDisplay(cards);
// //                 System.out.print(card);
// //             }
// //         }
// //     }

// //      public Game(String phase, int numPlayers){
// //          this.phase = phase;
// //          playerList = new ArrayList<>();
// //          playerList = PlayerCreate(numPlayers, numAIPlayers);
// //          gameSetup(phase);
// //      }

// //      private void gameSetup(String phase){
// //          turn = random.nextInt(numPlayers) + 1;
// //         currentPlayerNum = getTurn();
// //         d = new GameDisplay();
// //         n = new GameNotifications();
// //         s = new Scanner(System.in);
// //         print = new PrintCards();
// //         n.GameStartNotification(getTurn());
// //         m = new Market(phase);
// //         menu = new GameMenu();
// //         m = new Market(phase);
// //         n.GameStartNotification(getTurn());
// //         //t = new Tableau(phase);
// //      }

   
     
// //     private List<Player> PlayerCreate(int numPlayers, int numAIPlayers){
// //         this.numPlayers = numPlayers;
// //         this.numAIPlayers = numAIPlayers;
// //         playerList = new ArrayList<>();
// //         for (int i = 0; i < numPlayers; i++){
// //             //playerList.add(new Player("Player " + Integer.toString(i+1)));
// //             playerList.add(new Player(Integer.toString(i + 1)));
// //             playerNum += 1;
// //         }
        
// //         for (int i = 0; i < numAIPlayers; i++){
// //             numPlayers += 1;
// //             SimpleAi a = new SimpleAi();
// //             a.setName("Player " + Integer.toString(numPlayers));
// //             playerList.add(a);
// //             playerNum += 1;
// //         }
        
// //         return playerList;
// //     }



// //     /**
// //      * This method returns the number of players in the game.
// //      * @return Players list.
// //      */
// //     public void preRoll(){
        
// //         //int[] availableProperties = g.activeMarketUpdate();
// //         cardsInMarket = m.getCardTypes();
// //         String gameInfo = menu.createGameStateDisplay(m, getPlayers(), turn);
        
// //         currentPlayerNum = getTurn();
// //         n.turnStart(currentPlayerNum);
// //         //System.out.println("\n");
// //         System.out.println(gameInfo);
        
// //     }

// //     public void rollCheck(){
// //         roll = getPlayer(turn).rollDice();
// //         n.rollNotification(turn, roll);//n.rollNotification(g.getPlayers.getPlayer(getTurn()).getNum, roll);
// //         // After roll cards should be checked to see if they activated and this should be checked for every player in game
// //         //player.addMoney(card.payout(roll));
// //         checkPlayerCards(roll, turn);
// //     }
// //     public int numPlayers(){
// //         return playerList.size();
// //     }

// //     /**
// //      * This method will be used to change the state in the console main to end the game.
// //      * @return End of the game. 
// //      */ 
// //     public boolean isOver(){
// //         //gameOver= false;
// //         for(int i = 0; i < playerList.size(); i++){
// //             Player p = playerList.get(i);
// //             if(p.getNumLandmarksBuilt() == 1){
// //                 return true;
// //             }
// //         }
// //         return false;
// //     }

    
  

// //     /**
// //      * This method will set the turn. 
// //      * It will be run in the bottom of the while loop at the end of a persons turn.
// //      */
// //     public void nextTurn(){
// //         if (turn == numPlayers){
// //             turn = 1;
// //         }
// //         else if(turn < numPlayers){
// //             turn ++;
// //         }
// //     }

// //     /**
// //      * This method returns the current turn of a player and will most likely be run at the top of the while loop to set the turn.
// //      * @return true
// //      */
// //     public int getTurn(){
// //         return turn;
// //     }
    
// //     public List<Player> getPlayers(){
// //         return playerList;
// //     }

// //     public Player getPlayer(int turn){
// //         Player player = playerList.get(turn - 1);
// //         return player;
// //     }

    

    

// //     public void checkPlayerCards(int diceRoll, int turn){
// //         for(int i = 0; i < playerList.size(); i++){
// //             Player p = playerList.get(i);
// //             p.checkCards(diceRoll, turn, p.getNum());
// //         }
// //     }

// //     public void buyPrompt(){
// //         n.buyPrompt(currentPlayerNum, getPlayer(currentPlayerNum));
// //         System.out.println(n.viewPrompt());
// //         //String menu = d.displayPurchaseMenu(availableProperties, cardsInMarket, g.getPlayer(currentPlayerNum));
// //         menuString = menu.createPurchaseMenu(m, getPlayer(currentPlayerNum));
// //         //menuString = menu.createGameStateDisplay(m, getPlayers(), turn);
// //         System.out.println(menuString);
// //     }

// //     public void endTurn(){
// //         n.endOfTurn(turn);
// //         nextTurn();
// //     }

// //     public void gameWinner(){
// //         String winner = String.format("Player %s is the winner.", getPlayer(getTurn()).getName());
// //         System.out.println(winner);
// //         s.close();

// //     }

// //     public void viewMenu(){
// //         System.out.println("Choose a number to purchase or construct\n");
// //         int viewChoice = 99;

// //         // while(s.hasNextInt() == false && s.hasNext("view") == false && s.hasNextInt() == false){
// //         //     System.out.println("Choose a number to purchase or construct:");
// //         //     s.nextLine();
// //         // }

// //         if(s.hasNext("view")){  //s.next().equals("view")
// //             //System.out.println("yaayy");
// //             //viewChoice = s.nextInt();
// //             String line = s.nextLine();
// //             line = line.split(" ")[1];
// //             viewChoice = Integer.parseInt(line);
// //             if(viewChoice > cardsInMarket.size()){
// //                 System.out.println("Invalid selection, choose again");
// //                 //choice = s.nextInt();
// //             }
// //             cardName = d.getMarketSelection(viewChoice, menuString);
// //             System.out.println(print.getFullDisplay(cardName));
// //             //choice = s.nextInt();
// //         }
// //     }

// //     public void purchaseEstablishmentLandmark(){
// //         if(s.hasNextInt()){
// //             int choice = s.nextInt();

// //             String purchaseTest = menu.createPurchaseMenu(m, getPlayer(currentPlayerNum));
// //             String[] lines = purchaseTest.split("\r\n|\r|\n");
// //             int purchaseOptions = lines.length - 4;
// //             while(choice >= purchaseOptions || choice  <= 0 ) {
// //                 System.out.println("Choose a number to purchase or construct");
// //                 if(choice == 99){
// //                     break;
// //                 }
// //                 choice = s.nextInt();
                
// //             }

// //             selection = d.getMarketSelection(choice, menuString);
// //             if(selection.contains("Do nothing")){
// //                 String t = String.format("%s chose not to make any improvements", 
// //                 getPlayer(currentPlayerNum).getName());
// //                 System.out.println(t);
                
// //             }else if(selection.equals("City Hall")){
// //                 getPlayer(currentPlayerNum).construct(selection);
// //                 String t = String.format("%s built the %s", 
// //                 getPlayer(currentPlayerNum).getName(), selection);
// //                 System.out.println(t);
// //             }else {
                
// //                 selection = d.getMarketSelection(choice, menuString);
// //                 Card purchasedCard = m.purchase(selection);
// //                 //getPlayer(currentPlayerNum).addEstablishment(selection);
// //                 getPlayer(turn).purchase(purchasedCard);
// //                 //cost = d.getPurchaseCost(choice, menuString);
// //                 //System.out.println(cost);
// //                // getPlayer(currentPlayerNum).purchase(cost);
// //                // System.out.println(selection);
// //                 //m.purchase(selection);
// //                 String t = String.format("%s purchased the %s", 
// //                 getPlayer(currentPlayerNum).getName(), selection);
// //                 System.out.println(t);
// //             }
// //         }else {
// //             String t = String.format("%s did not have enough money to make \nimprovments", 
// //             getPlayer(currentPlayerNum).getName());
// //             System.out.println(t);
// //         }
// //     }
    
// //     /*
// //     public Card getCardByName(String name){
// //         Card c = new Card("Ranch");
// //         for(int i = 0; i < establishments.size(); i++){
// //             if(establishments.get(i).getName().equals(name)){
// //                 return establishments.get(i);
// //             }
// //         }
// //         return c;
// //     }
// //     */
    

// //     /*public List<Player> PlayerCreate(){
        
// //     }*/

    
// // }

