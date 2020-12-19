package edu.wofford.machiwoco;

import org.junit.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameNotificationsTest{
    GameNotifications n;
    private final ByteArrayOutputStream output= new ByteArrayOutputStream();
    private final PrintStream outputStream = System.out;
    String s;

    @Before public void intialize(){
        n = new GameNotifications();
        System.setOut(new PrintStream(output));
        // put this back in 
    }

    @After 
    public void restoreStreams(){
        System.setOut(outputStream);
    }

    @Test
    public void startGameStartNotificationTest(){
        int startingPlayer = 1;
        n.GameStartNotification(startingPlayer);
        s = output.toString();
        System.out.println(s);
        assertTrue(s.contains("The game has started. Player 1 will go first."));
    }

    @Test 
    public void turnStartTest(){
        int playerNum = 1;
        n.turnStart(playerNum);
        s = output.toString();
        System.out.println(s);
        assertTrue(s.contains("Turn started for Player 1"));
    }

    @Test 
    public void endOfTurnTest(){
        int playerNum = 2;
        n.endOfTurn(playerNum);
        s = output.toString();
        System.out.println(s);
        assertTrue(s.contains("Turn ended for Player 2"));
    }

    @Test
    public void rollNotificationTest(){
        int playerNum = 1;
        int diceRoll = 2;
        n.rollNotification(playerNum, diceRoll);
        String s = output.toString();
        System.out.println(s);
        assertTrue(s.contains("Player 1 rolled [2] = 2."));
    }

    @Test 
    public void buyPromptTest(){
        int playerNum = 1;
        Player p = new Player("1");

        n.buyPrompt(playerNum, p);
        String prompt = n.buyPrompt(playerNum, p);
        String s = output.toString();
        System.out.println(s);
        String st = "\nPlayer 1, would you like to purchase an   \n" +
        "establishment or construct a landmark? (3\n" + 
        "coins)                                    "; //+ "\n";

        String test = "\nPlayer 1, would you like to purchase an \nestablishment or construct a landmark? \n(3 coins)\n";

        assertEquals(test, prompt); 
        //assertTrue(st.contains(g));
    }

    @Test 
    public void viewPromptTest(){
        String output = n.viewPrompt();
        String out = output.toString();
        String s = "(To view details of an item, type 'view'  " + "\n" +
        "followed by the item number. For example,            " + "\n" +
        "to view item 2, type 'view 2'.)           "; //+ "\n"; 
        assertEquals(s, output);
    }

    @Test
    public void purchaseNotification(){
        int playerNum = 2;
        String cardName = "Wheat Field";
        n.playerPurchased(playerNum, cardName);
        s = output.toString();
        s.trim();
        System.out.println(s);

        assertTrue(s.contains("Player 2 purchased the Wheat Field"));
        //assertEquals(s, "Player 2 purchased the Wheat Field\n");
    }

    @Test 
    public void insuficientFundsTest(){
        int playerNum = 1;
        n.insufficientFunds(playerNum);
        s = output.toString();
        assertTrue(s.contains("Player 1 did not have enough money to make\n imporvements"));
    }

    @Test
    public void promptForRoll(){
        n.promptForRoll();
        s = output.toString();
        System.out.println(s);
        //assertEquals("Enter roll to roll the dice", s);
        assertTrue(s.contains("Enter roll to roll the dice"));
    }

    @Test 
    public void chosePlayerPromptTest(){
        String prompt = "-------     AVAILABLE PLAYERS      ------- " + "\n" + 
                        "1. Player 2             (3 coins)         " + "\n" + 
                        "Player 1, who would you like to target?   " + "\n";

        List<Player> players = new ArrayList<>();
        Player curPlayer = new Player("1");
        Player player = new Player("2");
        players.add(curPlayer);
        players.add(player);
        

        assertThat(n.chosePlayerPrompt(players, curPlayer), is(prompt));
    }

    @Test
    public void choseEstablishmentPromptTest(){
        String prompt = "" + 
        "-------  AVAILABLE ESTABLISHMENTS  ------- |" + "\n" +
        "                 Player 2                 |" + "\n" +
        " 1. Wheat Field        BW (1)  [1]        |" + "\n" +
        " 2. Ranch              BC (1)  [2]        |" + "\n" + 
        "Player 1, select an establishment:        |" + "\n" +
        "-------  AVAILABLE ESTABLISHMENTS  ------- |" + "\n" +
        "                 Player 1                 " + "\n" + 
        " 1. Wheat Field        BW (1)  [1]        " + "\n" +
        " 2. Ranch              BC (1)  [2]        " + "\n" +
        "Player 1, select an establishment:        " + "\n";

        Card wheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
        Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
        List<Player> players = new ArrayList<>();
        Player curPlayer = new Player("1");
        Player player = new Player("2");
        players.add(curPlayer);
        players.add(player);

        curPlayer.addEstablishment(wheatField);
        curPlayer.addEstablishment(Ranch);
        player.addEstablishment(wheatField);
        player.addEstablishment(Ranch);

        String s = n.choseEstablishmentPrompt(players, player, curPlayer);
        
        System.out.println(s);
        System.out.println(prompt);

        //assertThat(s, is(prompt));
        
     }
}