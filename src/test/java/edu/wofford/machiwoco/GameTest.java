package edu.wofford.machiwoco;
import org.junit.*;
import org.junit.Test;

//import jdk.nashorn.internal.parser.Scanner;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.*;
//import java.io.ByteArrayInputStream;
//import java.lang.System;
import java.io.*;


public class GameTest {
    Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    Card Bakery = new Card("Bakery", "B", "G", 1, 2, 3, 1);
    Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
    Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
    Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
    Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
    Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
    Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 12, 2);
    Card Cafe = new Card("Cafe", "U", "R", 2, 3, 1);
    Card FamilyRestaurant = new Card("Family Restaurant", "U", "R", 3, 9, 10, 2);
    Card Stadium = new Card("Stadium", "T", "P", 6, 6, 2);
    Card TVStation = new Card("TV Station", "T", "P", 7, 6, 5);
    Card BusinessCenter = new Card("Business Center", "T", "P", 8, 6, 0);
    LandMark AmusementPark = new LandMark("Amusement Park");
    
    LandMark CityHall = new LandMark("City Hall");
    
    LandMark TrainStation = new LandMark("Train Station");
    
    LandMark ShoppingMall = new LandMark("Shopping Mall");
    
    LandMark RadioTower = new LandMark("Radio Tower");
    
    List<Card> phaseCards = new ArrayList<>();
    List<LandMark> phaseLandMarks = new ArrayList<>();
    Game game;
    List<Player> pList = new ArrayList<>();
    CardHandler cardHandler;
    
    private final ByteArrayOutputStream output= new ByteArrayOutputStream();
    private final PrintStream outputStream = System.out;
    List<LandMark> p2Land;
    List<LandMark> p3Land;
    List<LandMark> p4Land;
    List<LandMark> p5Land;
    List<Card> p2Card;
    Scanner scanner;
    


    //private ByteArrayInputStream testIn;


    @Before 
    public void initialize(){
        p2Land = new ArrayList<>();
        p3Land = new ArrayList<>();
        p4Land = new ArrayList<>();
        p5Land = new ArrayList<>();
        p2Card = new ArrayList<>();
        cardHandler = new CardHandler();
        phaseCards = new ArrayList<>();
        phaseLandMarks = new ArrayList<>();
        TrainStation.setCost(4);
        CityHall.setCost(7);
        AmusementPark.setCost(16);
        ShoppingMall.setCost(10);
        RadioTower.setCost(22);
        phaseCards.add(WheatField);
        phaseCards.add(Ranch);
        phaseCards.add(Forest);
        phaseLandMarks.add(CityHall);
        p2Card.add(WheatField);
        p2Card.add(Bakery);

        p2Land.add(TrainStation);
        p2Land.add(CityHall);
        
        p3Land.add(TrainStation);
        p3Land.add(CityHall);
        p3Land.add(ShoppingMall);

        p4Land.add(TrainStation);
        p4Land.add(ShoppingMall);
        p4Land.add(AmusementPark);

        p5Land.add(TrainStation);
        p5Land.add(ShoppingMall);
        p5Land.add(AmusementPark);
        p5Land.add(RadioTower);

        game = new Game("phase1", 2, " ", phaseCards, phaseLandMarks);
        pList = game.getPlayers();
        System.setOut(new PrintStream(output));
    }

    /*
    @After 
    public void restoreStreams(){
        System.setOut(outputStream);
    }

    public void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }*/


    @Test 

    public void numPlayersTest(){
        assertEquals(game.getNumberOfPlayers(), 2);
    }
    /*
    @Test

    public void playerCreateTest(){
        pList.add(new Player(Integer.toString(1)));
        pList.add(new Player("2"));
        assertArrayEquals(game.PlayerCreate().toArray(), pList.toArray());
    } 
    */

/*
    @Test

    public void rollCheck() {
        Game model = new Game("phase2", 2,"-ai", , );
        String input = "1";
        provideInput(input);
        game.rollCheck();
        assertTrue(true);
        //model.trainActivated = true;
        model.rollCheck();
        assertTrue(true);

    }
    */

    @Test
    public void gamePhase0Test(){
        Game g = new Game("phase0");
        List<String> c = new ArrayList<>();
        c.add("Wheat Field");
        c.add("Ranch");
        c.add("Forest");
        assertThat(g.getPhase0Cards(), is(c));
        
    }

    @Test

    public void getHumanPlayersTest(){
        assertThat(game.getHumanPlayers(), is(2));
    }

    @Test

    public void gamePrintCards(){
        
        String cards = ".-----------------------." + "\n" +
                        "| <B>      [1]      {W} |" + "\n" +
                        "|      Wheat Field      |" + "\n" +
                        "|                       |" + "\n" +
                        "|  Get 1 coin from the  |" + "\n" +
                        "|         bank.         |" + "\n" +
                        "|    (anyone's turn)    |" + "\n" +
                        "|                       |" + "\n" +
                        "| (1)                   |" + "\n" +
                        "|_______________________|" + "\n" +
                        ".-----------------------." + "\n" +
                        "| <B>      [2]      {C} |" + "\n" +
                        "|         Ranch         |" + "\n" +
                        "|                       |" + "\n" +
                        "|  Get 1 coin from the  |" + "\n" +
                        "|         bank.         |" + "\n" +
                        "|    (anyone's turn)    |" + "\n" +
                        "|                       |" + "\n" +
                        "| (1)                   |" + "\n" +
                        "|_______________________|" + "\n" +
                        ".-----------------------." + "\n" +
                        "| <B>      [5]      {G} |" + "\n" +
                        "|        Forest         |" + "\n" +
                        "|                       |" + "\n" +
                        "|  Get 1 coin from the  |" + "\n" +
                        "|         bank.         |" + "\n" +
                        "|    (anyone's turn)    |" + "\n" +
                        "|                       |" + "\n" +
                        "| (3)                   |" + "\n" +
                        "|_______________________|" + "\n";
                        
                        //String cards = "hi";
                        List<String> C = new ArrayList<>();
                        C.add("Wheat Field");
                        C.add("Ranch");
                        C.add("Forest");
                        System.out.println(cards);
                        System.out.println(game.printPhase(C));

                        assertThat(game.printPhase(C), is(cards));
    }

    @Test

    public void getAiPlayersTest(){
        assertThat(game.getAIPlayers(), is(0));
    }
    @Test

    public void playerCreatePhase1NoAI(){
        phaseCards = new ArrayList<>();
        phaseLandMarks = new ArrayList<>();
        phaseCards.add(WheatField);
        phaseLandMarks.add(CityHall);
        Game g = new Game("phase1", 2, " ", phaseCards, phaseLandMarks);
        assertThat(g.getNumberOfPlayers(), is(2));
    }
    @Test

    public void playerCreatePhase1AI(){
        phaseCards = new ArrayList<>();
        phaseLandMarks = new ArrayList<>();
        phaseCards.add(WheatField);
        phaseLandMarks.add(CityHall);
        Game g = new Game("phase1", 2, "-ai", phaseCards, phaseLandMarks);
        assertThat(g.getNumberOfPlayers(), is(2));
        assertThat(g.getAIPlayers(), is(1));
        assertThat(g.getHumanPlayers(), is(1));
    }
    @Test

    public void currentPlayerLandMarkBuiltTest(){
        Player player1 = pList.get(0);
        player1.getLandmarks().get(0).setBuilt();
        assertTrue(game.playerLandMarkBuilt("City Hall", 1));
        assertFalse(game.playerLandMarkBuilt("City Hall", 2));

    }

    @Test

    public void setTurnTest(){
        game.setTurn(2);
        assertThat(game.getTurn(), is(2));
    }

    @Test

    public void gameWinnerTest(){
        String winner = "Player 1 is the winner.";
        game.setTurn(1);
        assertThat(game.gameWinner(), is(winner));
    }
    @Test

    public void preRollTest(){
        String gameState = "" +
        "******************************************" + "\n" + 
        "                  MARKET                  " + "\n" + 
        "------------------------------------------" + "\n" +
        "Wheat Field        BW (1)  [1]      #6" + "\n" +
        "Ranch              BC (1)  [2]      #6" + "\n" + 
        "Forest             BG (3)  [5]      #6" + "\n" + "\n" +
        "             Player 1 [YOU]               " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1" + "\n" + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]" + "\n" + "\n" +
        "                 Player 2*                " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1" + "\n" + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]" + "\n" + "\n" +
        "******************************************" + "\n";

        game.setTurn(2);
        assertThat(game.preRoll(), is(gameState));

    }
    
    @Test

    public void trainActivatedTest(){
        assertThat(game.trainActivated(), is(false));
        game.setTrainActivated();
        assertThat(game.trainActivated(), is(true));
    }



    @Test

    public void endTurnTest(){
        String output = "Turn ended for Player 1";
        game.setTurn(1);
        game.endTurn();
        assertThat(game.getTurn(), is(2));
    }

    @Test 
    public void firstTurnTest(){
        int a = game.getTurn();
        assertEquals(game.getTurn(), a);
    }

    @Test
    //Need to think of how to test these
    public void consectutiveTurnTest(){
        int rollNum;
        int highestRoll = -10000;
        int lowestRoll = 10000;
        for (int i = 0; i < 100000; i++){
            game.nextTurn();
            rollNum = game.getTurn();
            if (rollNum < 0){
                fail("Roll out of bounds lower than expected");
            }

            if (rollNum > game.getNumberOfPlayers()){
                fail("Roll out of bounds higher than expected.");
            }

            if (lowestRoll >  rollNum){
                lowestRoll = rollNum;
            }

            if (highestRoll < rollNum){
                highestRoll = rollNum;
            }
        }
        if (lowestRoll == highestRoll){
            fail("The highest roll is equal to the lowest roll. Check the method returns a random number then check again.");
        }

        if (highestRoll != game.getNumberOfPlayers()){
            fail("The highest roll is " + highestRoll + " and it should be 6.");
        }
        
        if (lowestRoll != 1){
            fail("The lowest pin is " + lowestRoll + " and it should be 1.");
        }
        
    }

    @Test

    public void getPlayersTest(){
        game.getPlayers();
        pList.add(new Player("Player 1"));
        pList.add(new Player("Player 2"));
        
        for (int i = 0; i < game.getNumberOfPlayers(); i++){
            assertEquals(game.getPlayers().get(i).hashCode(), pList.get(i).hashCode());
        }
        
        
    }

    @Test
    
    public void playerCreateNumPlayersTest(){
        
        Game g2 = new Game("phase5", 4, "-ai", phaseCards, phaseLandMarks);
        Game g1 = new Game("phase1", 2, "-ai", phaseCards, phaseLandMarks);
        assertThat("asserts num total players for 2 players 1 ai 1 human!", g1.getNumberOfPlayers(), is(2));
        assertThat("asserts num humans for 2 players 1 ai and 1 human", g1.getHumanPlayers(), is(1));
        assertThat("asserts num ai for 2 players 1 ai and 1 human",g1.getAIPlayers(), is(1));
        assertThat("asserts num total players for 2 players 2 human!", game.getNumberOfPlayers(), is(2));
        assertThat("asserts num humans for 2 players 2 human", game.getHumanPlayers(), is(2));
        assertThat("asserts num ai for 2 players 2 human",game.getAIPlayers(), is(0));
        assertThat("asserts num total players for 4 players 1 human and 3 ai", g2.getNumberOfPlayers(), is(4));
        assertThat("asserts num humans for 4 players 1 human and 3 ai", g2.getHumanPlayers(), is(1));
        assertThat("asserts num ai for 4 players 1 human and 3 ai",g2.getAIPlayers(), is(3));
    }

    @Test

    public void playerCreateEstabLandTest(){
        Game gp2 = new Game("phase2", 2, "-ai", p2Card, p2Land);
        Game gp3 = new Game("phase3", 2, "-ai", p2Card, p3Land);
        Game gp4 = new Game("phase4", 2, "-ai", p2Card, p4Land);
        Game gp5 = new Game("phase5", 2, "-ai", p2Card, p5Land);
        List<String> se = new ArrayList<>();
        List<String> sl = new ArrayList<>();
        List<String> sl2 = new ArrayList<>();
        List<String> se2 = new ArrayList<>();
        List<String>sl5 = new ArrayList<>();
        se.add("Wheat Field");
        sl.add("City Hall");
        sl2.add("Train Station");
        sl2.add("City Hall");
        se2.add("Wheat Field");
        se2.add("Bakery");
        sl5.add("Train Station");
        sl5.add("Shopping Mall");
        sl5.add("Amusement Park");
        sl5.add("Radio Tower");
        //assertThat("reason", gp2.getAIPlayers(), is(5));
        for(int i =0; i < gp2.getNumberOfPlayers(); i++){
            //System.out.println(gp2.getPlayer(i).getLandmarks());
            //System.out.println(p3Land);
            assertThat("phase2 humanLandMarks",gp2.getPlayers().get(i).getLandMarkNames(), is(sl2));
            assertThat("phase2 humanEstablishments",gp2.getPlayers().get(i).getEstablishmentNames(), is(se2));
            assertThat("phase5 humanEstablishments", gp5.getPlayers().get(i).getEstablishmentNames(), is(se2));
            assertThat("phase5 humanEstablishments", gp5.getPlayers().get(i).getLandMarkNames(), is(sl5));
        }
    }

    @Test

    public void getPlayerTest(){
        int a = 1;
        pList.add(new Player("Player 1"));
        assertEquals(game.getPlayer(a).hashCode(), pList.get(0).hashCode());
    }

    @Test

    public void checkPlayerCardsTest(){
        int diceRoll = 1;
        List<Player> p = game.getPlayers();
        /*
        for(int i = 0; i < game.getPlayers().size(); i++){
            p.get(i).checkCards(diceRoll,1);
            //assertEquals(p.get(i).getWallet(), 4);
        }
        */
        cardHandler.cardCheck(scanner, p, game.getPlayer(game.getTurn()), diceRoll, game.getTurn());
        for(int i = 0; i < game.getPlayers().size(); i++){
            assertThat(p.get(i).getWallet(), is(4));
        }
    }

    @Test
    public void checkForRedCardActivation() {
        int diceRoll = 3;
        int turn = 2;
        List<Player> listPlayers = game.getPlayers();
        Player player1 = listPlayers.get(0);
        Player player2 = listPlayers.get(1);
        Card cafe = new Card("Cafe", "U", "R", 2, 3, 1);
        Card cafe1 = new Card("Cafe", "U", "R", 2, 3, 1);
        //Card FamilyRestaurant = new Card("Family Restaurant", "U", "R", 3, 9, 10, 2); 
        player1.tableau.addCard(cafe);
        player1.tableau.addCard(cafe1);
        //player1.tableau.addCard(FamilyRestaurant);
        Integer[] redCards = game.checkForRedCardActivation(diceRoll, turn);
        Integer[] test = {2, 0};
        assertArrayEquals(test, redCards);

        assertThat(player1.getWallet(), is(5));
        assertThat(player2.getWallet(), is(1));
    }

    @Test

    public void getCurrentPlayerTest(){
        Player currPlayer = game.getPlayer(game.getTurn());
        assertEquals("Tests that the current Player is obtained by getCurrentPlayer method", game.getCurrentPlayer(), currPlayer);
    }




    

    @Test 

    public void isOverTest(){
        assertFalse(game.isOver());
        game.getPlayer(1).getLandmarks().get(0).built = true;
        assertTrue(game.isOver());

    }

   


    @Test

    public void checkPlayerCards(){
        assertTrue(true);
        int a = 5;
        game.checkPlayerCards(1,1);
        for (int i = 0; i < game.getPlayers().size(); i++){
            assertEquals(game.getPlayers().get(i).wallet, 4);
        }
    }

    @Test

    public void rollCheckTrainTest(){
        Player player1 = game.getPlayer(1);
        player1.addLandmark(TrainStation);
        player1.getLandmarks().get(1).setBuilt();
        game.setTurn(1);
        String[] TrainStationInput = {"5", "3", "2"};
        scanner = new Scanner("2");
        Scanner scanner2 = new Scanner("1");
        List<String> output = new ArrayList<>();
        output.add("Player 1 would you like to roll 1 or 2 dice");
        output.add("2");
        List<String> output2 = new ArrayList<>();
        output2.add("Player 1 would you like to roll 1 or 2 dice");
        output2.add("1");

        String TrainRoll2 = "Player 1 would you like to roll 1 or 2 dice 2";
        String TrainRoll1 = "Player 1 would you like to roll 1 or 2 dice 1";

        
        assertThat("Checks for train station rolls 2 die", game.rollCheck(scanner), is(output));
        assertThat("Checks for train station rolls 1 die", game.rollCheck(scanner2), is(output2));
    }


    @Test

    public void rollCheckNoTrainStation(){
        Player player1 = game.getPlayer(1);
        game.setTurn(1);
        player1.addLandmark(RadioTower);
        player1.construct("Radio Tower");
        //ame.setTurn(1);
        String noProblems = "No Train Station";
        List<String> output = new ArrayList<>();
        output.add(noProblems);

        String rollCheckElseRadioYes = "No Train Station like to reroll y";
        String rollCheckElseRadioNo = "No Train Station z";
        Scanner yesResponse = new Scanner("y");
        Scanner noResponse = new Scanner("n");
        //assertThat("Checks to make sure else statement is reached in rollCheck method in game.java", game.rollCheck(scanner, game.getTurn()), is(output));
        assertThat("Checks to make sure else statement is reached in rollCheck method in game.java with Radio Tower yes", game.rollCheck(yesResponse), is(output));
        assertThat("Checks to make sure else statement is reached in rollCheck method in game.java with amusement park no", game.rollCheck(noResponse), is(output));
        //assertEquals(fudge, player1.getLandmarks());
        //assertThat("for reasons", player1.getLandmarks().get(1).getName(), is("Amusement Park"));
        //assertThat("for reasons 2", player1.getLandMarkNames().get(0), is("City Hall"));
    }
    @Test

    public void purchaseAvailableEstablishment(){
        int[] f = {1};
        List<String> output = new ArrayList<>();
        output.add("1");
        Player player1 = game.getPlayer(1);
        game.setTurn(1);
        player1.addMoney(10);
        Scanner buyFirstEstab = new Scanner("1");
        //int b = buyFirstEstab.nextInt();
        //game.purchaseEstablishmentLandmark(buyFirstEstab);
        //assertThat("purchase log is the same for a wheat field purchase", game.purchaseEstablishmentLandmark(buyFirstEstab), is(output));
    }

    @Test

    public void getRollTest(){
        game.setRoll(4);
        assertThat("gets the roll", game.getRoll(), is(4));
    }
    
    

    

    


}



