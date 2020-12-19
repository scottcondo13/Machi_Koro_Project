// package edu.wofford.machiwoco;

// public class mock3 {
    



//     public class CardHandling implements CardActivationHandling {

//         @Override
//         public void payPlayer(Card card, Player player) {
//             int payOut = card.getIncome();
//             player.addMoney(payOut);
//         }
    
//         public int modifiedPayout(Card card, Player player){
    
//             return 0;
//         }
    
//         @Override
//         public void blueCardActivated(Card card, List<Player> players, Player curPlayer){
//             for (Player player : players){
//                 System.out.println(players.size());
//                 if(player.hasCard(card)){
//                     payPlayer(card, player);
//                     System.out.println(player.getName());
//                 }
              
//             }
    
            
//         }
    
//         @Override
//         public void greenCardActivated(Card card, List<Player> players, Player curPlayer){
//             for(Player player : players){
//                 String cardName = card.getName();
    
//                 if(player == curPlayer){
//                     payPlayer(card, player);
//                 }
    
//                 if(cardName.equals("Farmers Market")){
    
    
//                 }else if(cardName.equals("Furniture Factory")){
    
//                 }else if(cardName.equals("Cheese Factory")){
    
//                 }else{
//                     if(player == curPlayer){
//                         //payPlayer(card, player);
//                     }
//                 }
//             }
    
//         }
    
//         @Override
//         public void redCardActivated(Card card, List<Player> players, Player curPlayer){
    
//         }
    
//         @Override
//         public void stadiumActivated(Card card, List<Player> players, Player currentPlayer){
//             for (Player player : players) {
//                 if(player != currentPlayer){
//                     player.subtractMoney(card.getIncome());
//                 }else{
//                     currentPlayer.addMoney(card.getIncome());
//                 }
//             }
    
//         }
    
    
//         public void cardCheck(List<Player> players, Player curPlayer, int diceRoll, int turn){
//             for(Player player : players){
//                 List<Card> activatedCards = new ArrayList<>();
//                 activatedCards = player.checkCards(diceRoll, turn);
    
//                 for(Card card : activatedCards){
//                     cardPayout(card, player, curPlayer);
//                 }
//             }
    
    
//         }
    
//         public void cardPayout(Card card, Player player, Player curPlayer){
            
//             if(card.getColor() == "B"){
//                 blueCardActivated(card, player, curPlayer);
//             }else if(card.getColor() == "G"){
//                 greenCardActivated(card, player, curPlayer);
//             }else if(card.getColor() == "R"){
//                 redCardActivated(card, player, curPlayer);
//             }else if(card.getColor() == "P"){
//                 if(card.getName().equals("Stadium")){
//                     stadiumActivated(card, player, curPlayer);
//                 }
//             }
    
//         }

// }
