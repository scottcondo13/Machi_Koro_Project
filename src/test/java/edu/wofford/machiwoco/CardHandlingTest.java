package edu.wofford.machiwoco;
import org.junit.*;
import org.junit.Test;
//import org.omg.CORBA.INITIALIZE;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.*;
import java.lang.System;
import java.io.*;

public class CardHandlingTest {
    private Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    private Card TvStation = new Card("TV Station", "T", "P", 7, 6, 5);
    private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
    private Card Cafe = new Card("Cafe", "U", "R", 2, 3, 1);

    List<Player> pList = new ArrayList<>();
    Player player1;
    Player player2;
    CardHandler cardHandler;

    @Before
    public void intialize() {
        player1 = new Player("1");
        player2 = new Player("2");
        pList.add(player1);
        pList.add(player2);
        cardHandler = new CardHandler();
    }

    @Test
    public void payPlayerTest() {
        cardHandler.payPlayer(WheatField, player1);
        assertThat(player1.getWallet(), is(4));
        cardHandler.payPlayer(Forest, player1);
        assertThat(player1.getWallet(), is(5));
    }

    @Test
    public void blueCardActivatedTest() {
        cardHandler.blueCardActivated(WheatField, player1);
        assertThat(player1.getWallet(), is(4));
        cardHandler.blueCardActivated(WheatField, player2);
        assertThat(player2.getWallet(), is(4));

    }

    @Test
    public void greenCardActivatedTest() {
        // convenience store pays out 3 coins
        cardHandler.greenCardActivated(ConvenienceStore, player1, player1);
        assertThat(player1.getWallet(), is(6));
        cardHandler.greenCardActivated(ConvenienceStore, player2, player1);
        assertThat(player2.getWallet(), is(3));
    }

    @Test
    public void redCardActivationTest() {
        Collections.reverse(pList);
        player2.addEstablishment(Cafe);
        Player player3 = new Player("3");
        pList.add(player3);

        cardHandler.redCardActivated(pList, player1, 3, 1);
        assertThat(player1.getWallet(), is(2));
        assertThat(player2.getWallet(), is(4));
        assertThat(player3.getWallet(), is(3));
    }

    @Test
    public void tvStationActivatedPromptTest() {

        String menu = "" + "-------     AVAILABLE PLAYERS      -------" + "\n"
                + "1. Player 2             (3 coins)         " + "\n" + "Player 1, who would you like to target?   "
                + "\n";

        String out = cardHandler.tvStationActivatedPrompt(TvStation, pList, player1, player1);
        assertThat(out, is(menu));

    }
/*
    @Test
    public void tvStationActivatedTest() throws IOException {
        int input = 1;
        Scanner scan = new Scanner(System.in);
        // System.out.println(1);
        System.in.read();
        

        //int choice = cardHandler.tvStationActivated(scan, TvStation, pList, player1, player1);
        System.out.println(1);
        // Need to figure out a better way to test this
        // assertThat(choice, is(1));
    }
    */

    
}
