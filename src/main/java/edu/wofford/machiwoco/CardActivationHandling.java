package edu.wofford.machiwoco;

import java.util.List;


import java.util.Scanner;
/**
 * This abstract class implements card handeling behavior. 
 */
public interface CardActivationHandling {

    void payPlayer(Card card, Player player);

    void blueCardActivated(Card card, Player player);

    void greenCardActivated(Card card, Player player, Player curPlayer);

    void redCardActivated(List<Player> players, Player curPlayer, int diceRoll, int turn);

    void redCardPayout(Card card, List<Player> reversedPlayerOrder, Player curPlayer);

    void stadiumActivated(Card card, List<Player> players, Player player, Player curPlayer);

    String tvStationActivatedPrompt(Card card, List<Player> players, Player player, Player curPlayer);

    int tvStationActivated(Scanner scanner, Card card, List<Player> players, Player player, Player curPlayer);

    List<String> cardCheck(Scanner scanner, List<Player> players, Player curPlayer, int diceRoll, int turn);
    
    void cardPayout(Scanner scanner, Card card, List<Player> players, Player player, Player curPlayer);

    


    // void payPlayer(Card card, Player player);

    // void blueCardActivated(Card card, List<Player> players, Player curPlayer);

    // void greenCardActivated(Card card, List<Player> players, Player curPlayer);

    // void redCardActivated(Card card, List<Player> players, Player curPlayer);

    // void stadiumActivated(Card card, List<Player> players, Player curPlayer);
    
}
