package edu.wofford.machiwoco;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class displays notifications within the console of the game. 
 * @author Noah Gwinn
 */
public class GameNotifications{

    /**
     * This method prints a line once the indicating that the game has started for a certain player.
     * @param  startingPlayer Integer indicating the current player.
     */
    public String GameStartNotification(int startingPlayer){
        String prompt = String.format("The game has started. Player %d will go first.", startingPlayer);
        System.out.println(prompt);
        return prompt;
    }
/**
 * This method prints the turn for a certain player.
 * @param playerNum Integer indicating the current player.
 */
    public String turnStart(int playerNum){
        String prompt = String.format("Turn started for Player %d.", playerNum);
        System.out.println(String.format("Turn started for Player %d.", playerNum));
        return prompt;
    }
/**
 * This method prints whe the turn has ended for a certain player.
 * @param playerNum Integer indicating the current player.
 */
    public String endOfTurn(int playerNum){
        String prompt = String.format("Turn ended for Player %d.", playerNum);
        System.out.println(String.format("Turn ended for Player %d.", playerNum));
        return prompt;
    }
/**
 * This method returns what the player has rolled.
 * @param playerNum Integer indicating the current player.
 * @param diceRoll Integer indicating the roll of the dice.
 */
    public String rollNotification(int playerNum, int diceRoll){
        String output  = String.format("Player %d rolled [%d] = %d.", playerNum, diceRoll,diceRoll ); //"Player " + currentPlayerNum + " rolled"
        System.out.println(output);
        return output;
    }
/**
 * This method returns what the player has rolled.
 * @param playerNum Integer indicating the current player.
 * @param diceRoll1 Integer indicating the roll of the dice.
 * @param diceRoll2 Integer indicating the second roll of the dice. 
 */
    public String rollNotification(int playerNum, int diceRoll1, int diceRoll2){
        int sum = diceRoll1 + diceRoll2;
        String output  = String.format("Player %d rolled [%d][%d] = %d.", playerNum, diceRoll1,diceRoll2, sum ); //"Player " + currentPlayerNum + " rolled"
        System.out.println(output);
        return output;
    }
/**
 * This method prompts the user to buy an establishment or landmark.
 * @param playerNum Integer indicating the current player.
 * @param p Player object.
 * @return Prompot to the user.
 */
    public String buyPrompt(int playerNum, Player p){
      
        String prompt = String.format("\nPlayer %d, would you like to purchase an \nestablishment or construct a landmark? \n(%d coins)\n",
            p.getNum(), p.getWallet());

        System.out.println(prompt);
        return prompt;
    }
/**
 * This method returns the prompt of to view item.
 * @return The prompt as a string.
 */
    public String viewPrompt(){
        String s = "(To view details of an item, type 'view'  " + "\n" +
        "followed by the item number. For example,            " + "\n" +
        "to view item 2, type 'view 2'.)           "; //+ "\n"; 
        return s;
    }
/**
 * This method prints the prompt to roll the dice
 */
    public void promptForRoll(){
        System.out.println("Enter roll to roll the dice");
    }
/**
 * This method prints the purchase of a player
 * @param playerNum Integer indicating the current player
 * @param card String that represents the card
 */
    public String playerPurchased(int playerNum, String card){
        String s = String.format("Player %d purchased the %s", playerNum, card);
        System.out.println(s);
        return s;
    }
/**
 * This method prints when a player does not have sufficient money
 * @param playerNum Integer indicating the current player
 */
    public void insufficientFunds(int playerNum){
        String s = String.format("Player %d did not have enough money to make\n imporvements", playerNum);
        System.out.println(s);
    }


    public String chosePlayerPrompt(List<Player> players, Player curPlayer){
        String prompt = "";
        prompt += "-------     AVAILABLE PLAYERS      ------- " + "\n";


            for(Player p : players){
                int num = 0;

                if(!p.equals(curPlayer)){
                    num += 1;
                    String s = String.format("%d. Player %s%12s (%d coins)%9s", num, p.getName(), "", p.getWallet(), "");
                    prompt += s + "\n";

                }
            }
            String s = String.format("Player %s, who would you like to target?   ", curPlayer.getNum());
            prompt += s + "\n";



        
        return prompt;

    }

    public String choseEstablishmentPrompt(List<Player> playerList, Player selectedPlayer, Player curPlayer){
        GameMenu menu = new GameMenu();
        String prompt = "";
        List<Card> cards;
        List<Player> players = new ArrayList<>(playerList);
        Collections.reverse(players);

        String selectedPlayerCardInfo = "";
        String curPlayerCardInfo = "";
        String title = "-------  AVAILABLE ESTABLISHMENTS  ------- " + "\n";
        String playerPrompt = String.format("Player %d, select an establishment:%8s", curPlayer.getNum(), "") + "\n";

        for(Player player : players){
            cards = menu.sortByActNum(player.getEstablishments());

            String playerName = String.format("%-17sPlayer %-18d", "", player.getNum()) + "\n";
            prompt += title + playerName;

            List<Card> cardTypes = player.getTableau().getCardTypes();

            int numCards = 0;
            for(Card card : cardTypes){
                numCards++;
                String name = card.getName();

                if(!card.getColor().equals("P")){

                    if(player == selectedPlayer && !selectedPlayerCardInfo.contains(name)){

                        prompt += menu.purchaseMenuLineFormatter(numCards, card, player.getNumEstablishment(name));
                        prompt = prompt.replaceAll("#\\d", "");

                    }else if(player == curPlayer && !curPlayerCardInfo.contains(name)){

                        prompt += menu.purchaseMenuLineFormatter(numCards, card, player.getNumEstablishment(name));
                        prompt = prompt.replaceAll("#\\d", "");
                        //prompt += "|";

                    }

                }
            }
            prompt += playerPrompt;

        }

        //prompt += selectedPlayerCardInfo + curPlayerCardInfo + "\n";
        return prompt;
    }




   // 
}