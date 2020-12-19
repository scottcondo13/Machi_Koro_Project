package edu.wofford.machiwoco;

import org.junit.*;
import org.junit.Test;

//import jdk.nashorn.internal.AssertsEnabled;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.*;


public class GameDisplayTest{
    GameDisplay d;
    private Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    LandMark CityHall = new LandMark("CityHall");

    @Before public void initialize(){
        d = new GameDisplay();
        int[] arr = {6, 6, 6};
        d.setAvailableProperties(arr);
        CityHall.setCost(7);

    }


    @Test
    public void setAvailablePropertiesTest() {
        int[] arr = {6, 6, 6};
        d.setAvailableProperties(arr);
        assertThat(d.availableProperties, is(arr));
    }

    @Test 
    public void padTest(){
        String str = "Wheat Field";
        assertEquals("Wheat Field        ", d.pad(str, 19));
    }

    @Test 
    public void setWheatFieldLineTest(){
        assertEquals(d.setWheatFieldLine(), "Wheat Field        BW (1)  [1]      #6    \n");
        int[] arr = {0,0,0};
        d.setAvailableProperties(arr);
        assertEquals(d.setWheatFieldLine(), "");
    }

    @Test
    public void setRanchLineTest(){
        assertEquals(d.setRanchLine(), "Ranch              BC (1)  [2]      #6    \n");
        int[] arr = {0,0,0};
        d.setAvailableProperties(arr);
        assertEquals(d.setRanchLine(), "");
    }

    @Test
    public void setForestLineTest(){
        assertEquals(d.setForestLine(), "Forest             BG (3)  [5]      #6    \n");
        int[] arr = {0,0,0};
        d.setAvailableProperties(arr);
        assertEquals(d.setForestLine(), "");
    }

    @Test
    public void setLineEstablishmentTest(){
        assertEquals(d.setLineEstablishment("Wheat Field"), "Wheat Field        BW (1)  [1]      #6    \n");
        assertEquals(d.setLineEstablishment("Ranch"), "Ranch              BC (1)  [2]      #6    \n");
        assertEquals(d.setLineEstablishment("Forest"), "Forest             BG (3)  [5]      #6    \n");
        assertEquals(d.setLineEstablishment(""), "");
    }

    @Test 
    public void setCityHallLineTest(){
        assertEquals(d.setCityHallLine(true), "City Hall          NT (7)  [X]            " + '\n');
        assertEquals(d.setCityHallLine(false), "City Hall          NT (7)  [ ]            " + '\n');
    }

    @Test
    public void setLineLandmarksTest(){
        assertEquals(d.setLineLandmarks("City Hall", true), "City Hall          NT (7)  [X]            " + '\n');
        assertEquals(d.setLineLandmarks("", false), "");
    }

    @Test
    public void displayMarketTest(){
        int[] arr = {6, 6, 6};
        d.setAvailableProperties(arr);
        String string1 = "" +
    "******************************************" + "\n" + 
    "                  MARKET                  " + "\n" + 
    "------------------------------------------" + "\n" +
    "Wheat Field        BW (1)  [1]      #6    " + "\n" +
    "Ranch              BC (1)  [2]      #6    " + "\n" + 
    "Forest             BG (3)  [5]      #6    " + "\n" + "\n";
    
        //System.out.println(d.displayMarket());
        //System.out.println(string1);
        assertEquals(string1, d.displayMarket());
    }
/*
    @Test

    public void displayPlayerInfoTest(){
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.add(new Player("1", "phase1"));
        players.add(new Player("2", "phase1"));
        //players.get(0).addMoney(10);

        String s = "" + 
        "             Player 1* [YOU]              " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1    " + "\n" + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]            " + "\n" + "\n" +
        "                 Player 2                 " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1    " + "\n" + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]            " + "\n" + "\n" +
        "******************************************"; //+ "\n";

        String st = "" + 
        "                 Player 1                 " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1    " + "\n" + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]            " + '\n' + "\n" + 
        "             Player 2* [YOU]              " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1    " + "\n" + "\n" + 
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]            " + '\n' + "\n" +
        "******************************************"; //+ "\n";


        //System.out.println(st);
        //System.out.println("\n");
        //System.out.println(d.displayPlayerInfo(2, players));
        //assertEquals(s, d.displayPlayerInfo(1, players));
        //assertEquals(st, d.displayPlayerInfo(2, players));

    }
*/
    @Test
    public void displayGameInfoTest(){
        // int[] arr = {6, 6, 6};
        // List<Player> players = new ArrayList<>();
        // players.add(new Player("Player 1", "phase1"));
        // players.add(new Player("Player 2", "phase1"));
        // players.add(new Player("Player 3", "phase1"));
        // String s = d.displayMarket();
        // String st = d.displayPlayerInfo(1, players);
        // String str = s + st;
        
        //System.out.println(s);
        //System.out.println(st);
        //System.out.println(d.displayGameInfo(arr, 2, players));
        //assertEquals(str, d.displayGameInfo(arr, 1, players));
    }
    /*
    @Test 
    public void displayPurchaseMenuTest(){
        int[] arr = {6,6,6};
        Player p = new Player("1", "phase1");
        p.addMoney(20);
        List<Card> cardsInMarket = new ArrayList<>();
        cardsInMarket.add(WheatField);
        cardsInMarket.add(Ranch);
        cardsInMarket.add(Forest);
        List<LandMark> landmarksInMarket = new ArrayList<>();
        landmarksInMarket.add(CityHall);

        String s = "" + 
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 3. Forest             BG (3)  [5]      #6" + "\n" + 
        "---------       CONSTRUCT        ---------" + "\n" + 
        " 4. City Hall          NT (7)  [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================" ;

        //System.out.println(s);
        //System.out.println(d.displayPurchaseMenu(arr, cardsInMarket, p));
        assertEquals(s, d.displayPurchaseMenu(arr, cardsInMarket, p));

        String st = "" + 
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 3. Forest             BG (3)  [5]      #6" + "\n" + 
        " 4. Forest             BG (3)  [5]      #6" + "\n" + 
        " 5. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 6. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 7. Forest             BG (3)  [5]      #6" + "\n" + 
        " 8. Forest             BG (3)  [5]      #6" + "\n" + 
        " 9. Forest             BG (3)  [5]      #6" + "\n" +
        "10. Wheat Field        BW (1)  [1]      #6" + "\n" +
        "---------       CONSTRUCT        ---------" + "\n" + 
        "11. City Hall          NT (7)  [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================" ;
        int[] a = {6, 6, 6, 6, 6, 6, 6, 6, 6, 6,};
        cardsInMarket.add(Forest);
        cardsInMarket.add(WheatField);
        cardsInMarket.add(Ranch);
        cardsInMarket.add(Forest);
        cardsInMarket.add(Forest);
        cardsInMarket.add(Forest);
        cardsInMarket.add(WheatField);
        //System.out.println(cardsInMarket.size());
        //System.out.println(d.displayPurchaseMenu(a, cardsInMarket, p));
        assertEquals(st, d.displayPurchaseMenu(a, cardsInMarket, p));
    }
    */

    @Test

    public void getMarketSelectionTest(){
        int choice = 1;
        int[] arr = {6,6,6};
        Player p = new Player("Player 1");
        p.addMoney(20);
        List<Card> cardsInMarket = new ArrayList<>();
        cardsInMarket.add(WheatField);
        cardsInMarket.add(Ranch);
        cardsInMarket.add(Forest);
        List<LandMark> landmarksInMarket = new ArrayList<>();
        landmarksInMarket.add(CityHall);
        String mkt = d.displayPurchaseMenu(arr, cardsInMarket, p);
        //String purchaseMenuChoice = d.getMarketSelection(choice);

        assertEquals("Wheat Field", d.getMarketSelection(1, mkt));
        assertEquals("Do nothing", d.getMarketSelection(99, mkt));
    }

    @Test 
    public void getLineTest(){
        String menuLineNeeded = "Ranch              BC (1)  [2]      #1    ";

        String menu = "" + 
        "             Player 1* [YOU]              " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1    " + "\n" +
        "Forest             BG (3)  [5]      #1    " + "\n" + 
        "Ranch              BC (1)  [2]      #1    " + "\n"  + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]            " + "\n" + "\n" +
        "                 Player 2                 " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1    " + "\n" + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]            " + "\n" + "\n" +
        "******************************************"; //+ "\n";

        String test = d.getLine(menuLineNeeded, menu);
        assertEquals(menuLineNeeded, test);
    }
    
    @Test 
    public void orderByActivationNumberTest(){
        List<Player> players = new ArrayList<>();
        // players.add(new Player("1", "phase1"));
        // players.add(new Player("2", "phase1"));

        String s = "" + 
        "             Player 1* [YOU]              " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1    " + "\n" +
        "Forest             BG (3)  [5]      #1    " + "\n" + 
        "Ranch              BC (1)  [2]      #1    " + "\n"  + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]            " + "\n" + "\n" +
        "                 Player 2                 " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1    " + "\n" + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]            " + "\n" + "\n" +
        "******************************************"; //+ "\n";

        String properDisplay =  "" +
        "             Player 1* [YOU]              " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1    " + "\n" +
        "Ranch              BC (1)  [2]      #1    " + "\n" + 
        "Forest             BG (3)  [5]      #1    " + "\n"  + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]            " + "\n" + "\n" +
        "                 Player 2                 " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1    " + "\n" + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]            " + "\n" + "\n" +
        "******************************************"; 

        String test = d.orderByActivationNumber(s);
        //assertEquals(properDisplay, test);
    }

}