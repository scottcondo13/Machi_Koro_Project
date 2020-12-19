package edu.wofford.machiwoco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This public class deals with the implementation of the various colors of cards.
 * It handles the payement methods and the cards interactions with the players.
 */
public class CardHandler implements CardActivationHandling { // implements blueCardActivationHandling, greenCardActivationHandling, redCardActivationHandling
    PlayerInputHandler playerInput = new PlayerInputHandler();

    @Override
    public void payPlayer(Card card, Player player) {
        int payOut = card.getIncome();
        player.addMoney(payOut);
    }

    public void payoutPlusNum(Card card, Player player, int numToIncreasePayout){
        int payOut = card.getIncome();
        player.addMoney(payOut + numToIncreasePayout);
    }

    public boolean modifiedPayout(Card card, Player player){
        String name = card.getName();
        String icon = card.getIcon();
        int income = card.getIncome();
        Tableau tableau = player.getTableau();

        if(name.equals("Farmers Market")){
            int numWithIcon = tableau.getNumCardsWithIcon("W");
            int payOut = numWithIcon * income;
            player.addMoney(payOut);
            return true;
        }else if(name.equals("Cheese Factory")){
            int numWithIcon = tableau.getNumCardsWithIcon("C");
            int payOut = numWithIcon * income;
            player.addMoney(payOut);
            return true;
        }else if(name.equals("Furniture Factory")){
            int numWithIcon = tableau.getNumCardsWithIcon("G");
            int payOut = numWithIcon * income;
            player.addMoney(payOut);
            return true;
        }

        return false;
    }


    @Override
    public void blueCardActivated(Card card, Player player){
        //System.out.println(card.getName());
        if(player.hasBuilt("Shopping Mall") && card.getIcon() == "B"){
            int numToIncreasePayout = 1;
            payoutPlusNum(card, player, numToIncreasePayout);
        }else{
            payPlayer(card, player);
        }
        
    }

    @Override
    public void greenCardActivated(Card card, Player player, Player curPlayer){
            String cardName = card.getName();

        if(player == curPlayer){
            if(modifiedPayout(card, player) == false){
                //modifiedPayout(card, player);
                payPlayer(card, player);
            }
        }

    }

    @Override
    public void redCardActivated(List<Player> reversedPlayerOrder, Player curPlayer, int diceRoll, int turn){
        List<Card> activatedCards;
       for(Player player : reversedPlayerOrder){
           int payout = 0;
           System.out.println("im player " + player.getName());
           activatedCards = player.checkCards(diceRoll, turn);
           String activationNotification;
           String output = "";

           for(Card card : activatedCards){
               
            activationNotification = String.format("The %s was activated for Player %s", card.getName(), player.getName());
            //System.out.println(activationNotification);
                if(output.contains(activationNotification) == false && card.getColor() == "R"){ // && curPlayer.getWallet() > 0
                    System.out.println(activationNotification);
                    output += activationNotification;
                    //activatedCardNotifications.add(activationNotification);
                }

                if(player != curPlayer && curPlayer.getWallet() > 0 && card.getColor().equals("R")){
                    payout = card.getIncome();
                    if(player.hasBuilt("Shopping Mall")){
                        System.out.println("Player has built the shopping mall and the payout is increased by one: " + payout);
                        payout += 1;
                    }
                    System.out.println("The cards payout is: " + payout);
                    int deficit = curPlayer.subtractMoney(payout);
                    System.out.println("The deficit was: " + deficit);
                    //System.out.println(player.getName());

                    int addedMoney = payout - deficit;
                    //addedMoney += 1;

                    System.out.println("Player " + player.getNum() + " is getting paid: " + addedMoney);
                    player.addMoney(addedMoney);
                    //System.out.println(addedMoney);

                }else if(player != curPlayer && card.getColor().equals("R")){
                    payout = card.getIncome();
                    //player.addMoney(payout);
                }

           }
                      
       }        

    }

    @Override
    public void redCardPayout(Card card, List<Player> reversedPlayerOrder, Player curPlayer){
        // if(card.getColor() == "R"){
        //     redCardActivated(card, reversedPlayerOrder, curPlayer);
        // }
    }

    @Override
    public void stadiumActivated(Card card, List<Player> playerList, Player player, Player currentPlayer){

        for(Player p : playerList){
            if(p != currentPlayer){
                int defecit = p.subtractMoney(card.getIncome());
                int money = card.getIncome() - defecit;
                System.out.println("Money the player is given on stadium activation: " + money);
                currentPlayer.addMoney(money);
            }
        }
       

    }

    @Override
    public String tvStationActivatedPrompt(Card card, List<Player> players, Player player, Player curPlayer){
        String prompt = "";
        prompt += "-------     AVAILABLE PLAYERS      -------" + "\n";

        if(player == curPlayer){
            int num = 0;
            for(Player p : players){
                

                if(!p.equals(curPlayer) && p.getWallet() > 0){
                    num += 1;
                    String s = String.format("%d. Player %s%12s (%d coins)%9s", num, p.getName(), "", p.getWallet(), "");
                    prompt += s + "\n";

                }
            }
            String s = String.format("Player %s, who would you like to target?   ", curPlayer.getNum());
            prompt += s + "\n";



        }
        return prompt;

    }
    
    @Override
    public int tvStationActivated(Scanner scanner, Card card, List<Player> players, Player player, Player curPlayer){
        int numTargetablePlayers = 0;
        int choice = 1;
        System.out.println("Went into the function");

        for(Player p : players){
            if(p != curPlayer && p.getWallet() > 0){
                numTargetablePlayers += 1;
            }

        }

        //Scanner scan = new Scanner(System.in);
        if(player == curPlayer && numTargetablePlayers > 0){
            //System.out.println("Player is the current player");

            String prompt =  tvStationActivatedPrompt(card, players, player, curPlayer);
            //System.out.println(prompt);
            String activationMessage = String.format("Player %s, who would you like to target?   ", curPlayer.getNum());

            if(player.isAi() == false){
                System.out.println(prompt);
                choice = playerInput.getPlayerNumberInput(scanner, numTargetablePlayers, activationMessage);
            }else{
                SimpleAi ai = (SimpleAi) player;
                choice = ai.generateRandomInt(numTargetablePlayers);
            }
            System.out.println(choice);
            
            //System.out.println("Right after call to get player input");

            int chosenPlayer = 0;
            if(choice != 99){
                int index = prompt.indexOf(String.valueOf(choice) + ".");
                
                String line = prompt.substring(index, index + 41);
                // System.out.println("The line retrieved: " + line);
                String[] arr = line.split(" ");
                for(String s : arr){
                    // System.out.println("Each piece of the array" + s);
                }
                chosenPlayer = Integer.valueOf(arr[2]);
              
            }
           

            //int choice = scan.nextInt();

            for(Player p : players){
                if(p.getNum() == chosenPlayer && p.getWallet() > 0){
                    //System.out.println("Inside the loop to give and take money");
                    int payout = card.getIncome();
                    // System.out.println("The payout");
                    // System.out.println(payout);
                    // System.out.println(p.getWallet());
                    int deficit = p.subtractMoney(payout);
                    // System.out.println(p.getWallet());
                    // System.out.println("The deficit");
                    // System.out.println(deficit);
                    // System.out.println("The current players wallet");
                    // System.out.println(curPlayer.getWallet());                   
                    int moneyAdded = payout - deficit;
                    curPlayer.addMoney(moneyAdded);
                }
            }
        }

        return choice;

    }

    public String bussinessComplexActivationPrompt(Card card, List<Player> players, Player player, Player curPlayer){
        String prompt = "";
        prompt += "-------     AVAILABLE PLAYERS      -------" + "\n";

        if(player == curPlayer){
            int num = 0;
            for(Player p : players){
                

                if(!p.equals(curPlayer)){
                    num += 1;
                    String s = String.format("%d. Player %s%12s (%d coins)%9s", num, p.getName(), "", p.getWallet(), "");
                    prompt += s + "\n";

                }
            }
            String s = String.format("Player %s, who would you like to target?   ", curPlayer.getNum());
            prompt += s + "\n";



        }
        return prompt;
    }

    public void businessComplexActivated(Scanner scanner, Card card, List<Player> players, Player player, Player curPlayer){
        int numTargetablePlayers = 0;
        int choice = 1;

        for(Player p : players){
            if(p != curPlayer){
                numTargetablePlayers += 1;
            }
        }

        if(player == curPlayer && numTargetablePlayers > 0){

            String prompt =  bussinessComplexActivationPrompt(card, players, player, curPlayer);
            //System.out.println(prompt);
            String activationMessage = String.format("Player %s, who would you like to target?   ", curPlayer.getNum());

            if(player.isAi() == false){
                System.out.println(prompt);
                choice = playerInput.getPlayerNumberInput(scanner, numTargetablePlayers, activationMessage);
            }else{
                SimpleAi ai = (SimpleAi) player;
                choice = ai.generateRandomInt(numTargetablePlayers);
            }
            System.out.println(choice);
            
            //System.out.println("Right after call to get player input");

            int chosenPlayer = 0;
            if(choice != 99){
                int index = prompt.indexOf(String.valueOf(choice) + ".");
                
                String line = prompt.substring(index, index + 41);
                // System.out.println("The line retrieved: " + line);
                String[] arr = line.split(" ");
                for(String s : arr){
                    // System.out.println("Each piece of the array" + s);
                }
                chosenPlayer = Integer.valueOf(arr[2]);
            }

            Player playerChosen = null;
            for(Player p : players){
                if(p.getNum() == chosenPlayer){
                    playerChosen = p;
                }
            }

            if(curPlayer.isAi() == false){
                GameNotifications notifications = new GameNotifications();
                prompt = notifications.choseEstablishmentPrompt(players, playerChosen, curPlayer);
                System.out.println(prompt);
                String[] menus = prompt.split("select an establishment");
                String chosenPlayerMenu = menus[0];
                String currentPlayerMenu = menus[1];
                String cardChosen;

                choice = playerInput.getPlayerNumberInput(scanner, numTargetablePlayers, activationMessage);

                int index = chosenPlayerMenu.indexOf(String.valueOf(choice) + ".");
                String line = chosenPlayerMenu.substring(index, index + 41);
                cardChosen = line.split("\\d.")[1];
                System.out.println("This is the line being split: " + cardChosen);
                cardChosen.trim();
                System.out.println("This is the line being trimmed: " + cardChosen);
                cardChosen = cardChosen.split(" ")[1] + " " + cardChosen.split(" ")[2];
                System.out.println("This is the name hopefully: " + cardChosen);
                System.out.println("This is the name of the card that was chosen: " + cardChosen);

                //Card chosenCard = playerChosen.getTableau().getCardTypes().get(choice);
                Card chosenCard = playerChosen.getTableau().getCardByName(cardChosen);
                playerChosen.getTableau().removeCard(chosenCard);
                curPlayer.addEstablishment(chosenCard);


                choice = playerInput.getPlayerNumberInput(scanner, numTargetablePlayers, "select an establishment:");

                index = currentPlayerMenu.indexOf(String.valueOf(choice) + ".");
                line = currentPlayerMenu.substring(index, index + 41);
                cardChosen = line.split("\\d.")[1];
                System.out.println("This is the line being split: " + cardChosen);
                cardChosen.trim();
                System.out.println("This is the line being trimmed: " + cardChosen);
                cardChosen = cardChosen.split(" ")[1] + " " + cardChosen.split(" ")[2];
                System.out.println("This is the name hopefully: " + cardChosen);
                System.out.println("This is the name of the card that was chosen: " + cardChosen);

                //chosenCard = curPlayer.getTableau().getCardTypes().get(choice);
                chosenCard = curPlayer.getTableau().getCardByName(cardChosen);
                curPlayer.getTableau().removeCard(chosenCard);
                playerChosen.addEstablishment(chosenCard);

            }
    

        }
        //return choice;

    }


    @Override
    public List<String> cardCheck(Scanner scanner, List<Player> playerList, Player curPlayer, int diceRoll, int turn){
        List<String> activatedCardNotifications = new ArrayList<>();
        //List<Player> reversedOrder = players;
        List<Player> reversedOrder = new ArrayList<>(playerList);
        //Collections.copy(reversedOrder, players);
        Collections.reverse(reversedOrder);

        redCardActivated(reversedOrder, curPlayer, diceRoll, turn);
        //redCardActivated(playerList, curPlayer, diceRoll, turn);

        for(Player player : playerList){
            List<Card> activatedCards = new ArrayList<>();
            activatedCards = player.checkCards(diceRoll, turn);
            String activationNotification;
            String output = "";
            
            

            for(Card card : activatedCards){
                // System.out.println(card.getName());

                // Printing out the activation notification for all card types except red
                activationNotification = String.format("The %s was activated for Player %s", card.getName(), player.getName());
                if(output.contains(activationNotification) == false && card.getColor() != "R"){
                    System.out.println(activationNotification);
                    output += activationNotification;
                    activatedCardNotifications.add(activationNotification);
                }

                cardPayout(scanner, card, playerList, player, curPlayer);
            }
        }
        //redCardActivated(reversedOrder, curPlayer, diceRoll, turn);

        return activatedCardNotifications;

    }

    @Override
    public void cardPayout(Scanner scanner, Card card, List<Player> players, Player player, Player curPlayer){

        if(player.hasBuilt("Shopping Mall") && card.getIcon() == "B"){
            int payout = card.getIncome();
            curPlayer.addMoney(payout + 1);

        }else if(card.getColor() == "B"){
            blueCardActivated(card, player);
        }else if(card.getColor() == "G"){
            greenCardActivated(card, player, curPlayer);
        }else if(card.getColor() == "R"){
            //redCardActivated(card, reversedPlayerOrder, curPlayer);
        }else if(card.getColor() == "P"){
            if(card.getName().equals("Stadium")){
                stadiumActivated(card,players, player, curPlayer);
            }else if(card.getName().equals("TV Station")){
                tvStationActivated(scanner, card, players, player, curPlayer);
            }else if(card.getName().equals("Business Complex")){
                //businessComplexActivated(scanner, card, players, player, curPlayer);
            }
        }

    }



    //    
}
