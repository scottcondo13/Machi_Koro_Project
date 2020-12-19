package edu.wofford.machiwoco;

import org.junit.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GameMenuTest {
    GameMenu menu;
    Market market;
    Market phase2Market;
    Market phase3Market;
    Game game;
    Game game2;
    private Card wheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    private Card Bakery = new Card("Bakery", "B", "G", 1, 2, 3, 1);
    private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
    private Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
    private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
    private Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
    private Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
    private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11,12, 2);
    private LandMark CityHall = new LandMark("City Hall");
    private LandMark CityHall2 = new LandMark("City Hall");
    private LandMark TrainStation = new LandMark("Train Station");
    private LandMark ShoppingMall = new LandMark("Shopping Mall");
    private List<Card> phase1;
    private List<Card> phase2;
    private List<Card> phase3;
    private List<LandMark> phase1L;
    private List<LandMark> phase2L;
    private Player player1;
    private Player player2;

    @Before public void intialize(){
        CityHall.setCost(7);
        CityHall2.setCost(7);
        TrainStation.setCost(4);
        ShoppingMall.setCost(10);
        phase1 = new ArrayList<>();
        phase2 = new ArrayList<>();
        phase3 = new ArrayList<>();
        
        phase1.add(wheatField);
        phase1.add(Ranch);
        phase1.add(Forest);
        phase2.add(wheatField);
        phase2.add(Ranch);
        phase2.add(Forest);
        phase2.add(Bakery);
        phase2.add(ConvenienceStore);
        phase2.add(Mine);
        phase2.add(AppleOrchard);
        phase3.add(wheatField);
        phase3.add(Ranch);
        phase3.add(Forest);
        phase3.add(Bakery);
        phase3.add(ConvenienceStore);
        phase3.add(Mine);
        phase3.add(AppleOrchard);
        phase3.add(CheeseFactory);
        phase3.add(FurnitureFactory);
        phase3.add(FarmersMarket);
       
        
        menu = new GameMenu();
        market = new SimpleMarket(phase1);
        phase2Market = new SimpleMarket(phase2);
        phase3Market = new SimpleMarket(phase3);
        player1 = new Player("1");
        player1.addEstablishment(wheatField);
        player1.addLandmark(CityHall);
        player2 = new Player("2");
        player2.addEstablishment(wheatField);
        player2.addLandmark(CityHall2);

    }

    @Test
    public void sortListByActNum(){
        List<Card> cards = new ArrayList<>();
        cards.add(wheatField);
        cards.add(Ranch);
        cards.add(Bakery);
        cards.add(ConvenienceStore);
        cards.add(Forest);
        cards.add(Mine);
        cards.add(FarmersMarket);

        List<Card> outOfOrder = new ArrayList<>();
        outOfOrder.add(Forest);
        outOfOrder.add(wheatField);
        outOfOrder.add(Ranch);
        outOfOrder.add(Mine);
        outOfOrder.add(ConvenienceStore);
        outOfOrder.add(Bakery);
        outOfOrder.add(FarmersMarket);

        for(int i = 0; i < cards.size(); i++){
            String info = cards.get(i).getName() + " " + cards.get(i).getActNum();
            //System.out.println(info);
        }
        //System.out.println("\n");
        outOfOrder = menu.sortByActNum(outOfOrder);
        for(int i = 0; i < cards.size(); i++){
            String info = outOfOrder.get(i).getName() + " " + outOfOrder.get(i).getActNum();
            //System.out.println(info); 
        }

        //outOfOrder = menu.sortByActNum(outOfOrder);
        assertThat(outOfOrder, is(cards));

        for(int i = 0; i < outOfOrder.size(); i++){
            String s = menu.sortByActNum(outOfOrder).get(i).getName();
            assertEquals(cards.get(i).getName(), s);
            //System.out.println(s);
        }
        assertTrue(outOfOrder.equals(cards));
    
    }

    @Test
    public void menuLineFormatterTest(){
        String s = "Wheat Field        BW (1)  [1]      #6" + "\n";

        assertThat(menu.menuLineFormatter(wheatField, 6), is(s));
    }

    @Test
    public void purchaseMenuLineFormatterTest(){
        String s =  " 1. Wheat Field        BW (1)  [1]      #6" + "\n";

        assertThat(menu.purchaseMenuLineFormatter(1, wheatField, 6), is(s));
    }

    @Test
    public void createMarketMenuPhase1Test(){
        String marketMenu = "" +
        "******************************************" + "\n" + 
        "                  MARKET                  " + "\n" + 
        "------------------------------------------" + "\n" +
        "Wheat Field        BW (1)  [1]      #6" + "\n" +
        "Ranch              BC (1)  [2]      #6" + "\n" + 
        "Forest             BG (3)  [5]      #6" + "\n";

        //System.out.println( "Forest             BG (3)  [5]      #6    ");
        //System.out.println(menu.createMarketMenu(map, cardTypes));
        assertThat(menu.createMarketMenu(market), is(marketMenu));
    }

    @Test
    public void createMarketMenuPhase2Test(){
        //System.out.println(menu.createMarketMenu(phase2Market));

        String marketMenu = "" + 
        "******************************************" + "\n" + 
        "                  MARKET                  " + "\n" + 
        "------------------------------------------" + "\n" +
        "Wheat Field        BW (1)  [1]      #6" + "\n" +
        "Ranch              BC (1)  [2]      #6" + "\n" + 
        "Bakery             GB (1)  [2-3]    #6" + "\n" +
        "Convenience Store  GB (2)  [4]      #6" + "\n" +
        "Forest             BG (3)  [5]      #6" + "\n" +
        "Mine               BG (6)  [9]      #6" + "\n" +
        "Apple Orchard      BW (3)  [10]     #6" + "\n";

        assertThat(menu.createMarketMenu(phase2Market), is(marketMenu));
    }

    @Test 
    public void getPlayerNameMoneyTest(){
        Player playerOne = new Player("1");
        //Player playerTwo = new Player("2");
        String playerNameAndMoney = "" +
        "             Player 1* [YOU]              " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n";
        String playerNameAndMoneyDifferentTurn = "" +
        "             Player 1 [YOU]               " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n";

        

        //System.out.println(playerNameAndMoney);
        //System.out.println(menu.getPlayerNameMoney(playerOne, 1));
        assertThat(menu.getPlayerNameMoney(playerOne, 1), is(playerNameAndMoney));
        assertThat(menu.getPlayerNameMoney(playerOne, 2), is(playerNameAndMoneyDifferentTurn));
        //assertThat(menu.getPlayerNameMoney(playerTwo, 1), is(""));
        //assertThat(menu.getPlayerNameMoney(playerTwo, 2), is(""));

    }

    @Test
    public void getPlayerCardInfoTest(){
        //Player player = new Player("1");
        player1.addEstablishment(wheatField);
        player1.addEstablishment(Forest);
        player1.addEstablishment(wheatField);
        player1.addEstablishment(Ranch);
        player1.addEstablishment(Ranch);
        player1.addEstablishment(Forest);
        player1.addEstablishment(Ranch);
        player1.addEstablishment(wheatField);
        player1.addEstablishment(Bakery);

        String playerCardInfo = "" + 
        "Wheat Field        BW (1)  [1]      #4" + "\n" +
        "Ranch              BC (1)  [2]      #3" + "\n" + 
        "Bakery             GB (1)  [2-3]    #1" + "\n" +
        "Forest             BG (3)  [5]      #2" + "\n" + "\n";

        //System.out.println(menu.getPlayerCardInfo(player));
        assertThat(menu.getPlayerCardInfo(player1), is(playerCardInfo));
    }

    @Test
    public void getPlayerLandmarkInfoTest(){
        //Player player = new Player("1");
        String landmarkInfo = "" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]" + "\n";

        assertThat(menu.getPlayerLandmarkInfo(player1), is(landmarkInfo));

        String builtLandmark = "" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [X]" + "\n";

        player1.construct("City Hall");
        assertThat(menu.getPlayerLandmarkInfo(player1), is(builtLandmark));
    }
    

    @Test 
    public void getPlayerInfoTest(){
        //Player player = new Player("1");
        player1.addEstablishment(Forest);
        player1.addEstablishment(Ranch);
        String playerInfo = "" + 
        "             Player 1* [YOU]              " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1" + "\n" +
        "Ranch              BC (1)  [2]      #1" + "\n" + 
        "Forest             BG (3)  [5]      #1" + "\n" +  "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]" + "\n";

        //System.out.println(menu.getPlayerInfo(player, 1));
        //System.out.println(playerInfo);

        assertThat(menu.getPlayerInfo(player1, 1), is(playerInfo));
    }

    @Test 
    public void createPlayerMenuTest(){
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.get(1).getLandmarks().get(0).setBuilt();

        String s = "" + 
        "             Player 1* [YOU]              " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1" + "\n" + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [ ]" + "\n" + "\n" +
        "                 Player 2                 " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1" + "\n" + "\n" +
        ".........................................." + "\n" +
        "City Hall          NT (7)  [X]" + "\n" + "\n" +
        "******************************************" + "\n";

        //System.out.println(menu.createPlayerMenu(players, 1));
        assertThat(menu.createPlayerMenu(players, 1), is(s));

    }

    @Test 
    public void createPurchaseFieldTest(){
        //Market market = new Market("phase1");
        //Player player = new Player("1");
        // Market market = new SimpleMarket("phase1");
        // Player player = new Player("1", "phase1");

        String purchaseField = "" + 
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 3. Forest             BG (3)  [5]      #6" + "\n"; 
        // + 
        // "---------       CONSTRUCT        ---------" + "\n" + 
        // " 4. City Hall          NT (7)  [ ]        " + "\n" + 
        // "---------         CANCEL         ---------" + "\n" + 
        // "99. Do nothing                            " + "\n" +
        // "==========================================" ;

        assertEquals(purchaseField, menu.createPurchaseField(market, player1));

        player1.purchase(wheatField);

        String notEnoughMoney = "" + 
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 2. Ranch              BC (1)  [2]      #6" + "\n";

        //System.out.println(menu.createPurchaseField(market, player));
        assertThat(menu.createPurchaseField(market, player1), is(notEnoughMoney));



    }

    @Test 
    public void createConstructionFieldTest(){
        //Player player = new Player("1");
        player1.addMoney(10);
        menu.createPurchaseField(market, player1);

        String constructionField = "" +
        "---------       CONSTRUCT        ---------" + "\n" + 
        " 4. City Hall          NT (7)  [ ]        " + "\n";

        assertThat(menu.createConstructionField(player1), is(constructionField));

    }

    @Test 
    public void createDoNothingFieldTest(){
        String doNothingField = "" +
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "=========================================="; //+ "\n";

        assertThat(menu.createDoNothingField(), is(doNothingField));
    }

    @Test 
    public void createPurchaseMenuTest(){
        //Player player = new Player("1");

        String purchaseMenu =  "" + 
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 3. Forest             BG (3)  [5]      #6" + "\n" +
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "=========================================="; //+ "\n";

        assertThat(menu.createPurchaseMenu(market,player1), is(purchaseMenu));

        Player p = new Player("1");
        p.addMoney(10);
        p.addLandmark(TrainStation);
        p.addLandmark(CityHall);
        p.addLandmark(ShoppingMall);
        //System.out.println(menu.createPurchaseMenu(market,player));


        purchaseMenu = "" +
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 3. Bakery             GB (1)  [2-3]    #6" + "\n" +
        " 4. Convenience Store  GB (2)  [4]      #6" + "\n" +
        " 5. Forest             BG (3)  [5]      #6" + "\n" +
        " 6. Cheese Factory     GF (5)  [7]      #6" + "\n" +
        " 7. Furniture Factory  GF (3)  [8]      #6" + "\n" +
        " 8. Mine               BG (6)  [9]      #6" + "\n" +
        " 9. Apple Orchard      BW (3)  [10]     #6" + "\n" +
        "10. Farmers Market     GO (2)  [11-12]  #6" + "\n" +    
        "---------       CONSTRUCT        ---------" + "\n" + 
        "11. Train Station      NT (4)  [ ]        " + "\n" + 
        "12. City Hall          NT (7)  [ ]        " + "\n" + //"\n" +
        "13. Shopping Mall      NT (10) [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "=========================================="; //+ "\n" ;

        assertThat(menu.createPurchaseMenu(phase3Market, p), is(purchaseMenu));
        // Market phase3Market = new SimpleMarket("phase3");
        // Player p = new Player("1", "phase3");
        player2.addMoney(20);

        //System.out.println(menu.createPurchaseMenu(phase3Market, p));
        //System.out.println("My menu ^");
        //System.out.println(purchaseMenu);
        //assertThat(menu.createPurchaseMenu(phase3Market, player2), is(purchaseMenu));
    }

    @Test
    public void createGameStateDisplayTest(){
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("1");
        Player player2 = new Player("2");
        player1.addEstablishment(wheatField);
        player1.addEstablishment(Bakery);
        player1.addLandmark(TrainStation);
        player1.addLandmark(CityHall);
        player1.addLandmark(ShoppingMall);
        player2.addEstablishment(wheatField);
        player2.addEstablishment(Bakery);
        player2.addLandmark(TrainStation);
        player2.addLandmark(CityHall2);
        player2.addLandmark(ShoppingMall);
        players.add(player1);
        players.add(player2);
        int turn = 2;

        String gameState = "" +
        "******************************************" + "\n" + 
        "                  MARKET                  " + "\n" + 
        "------------------------------------------" + "\n" +
        "Wheat Field        BW (1)  [1]      #6" + "\n" +
        "Ranch              BC (1)  [2]      #6" + "\n" + 
        "Bakery             GB (1)  [2-3]    #6" + "\n" +
        "Convenience Store  GB (2)  [4]      #6" + "\n" +
        "Forest             BG (3)  [5]      #6" + "\n" +
        "Cheese Factory     GF (5)  [7]      #6" + "\n" +
        "Furniture Factory  GF (3)  [8]      #6" + "\n" +
        "Mine               BG (6)  [9]      #6" + "\n" +
        "Apple Orchard      BW (3)  [10]     #6" + "\n" +
        "Farmers Market     GO (2)  [11-12]  #6" + "\n" + "\n" +
        "             Player 1 [YOU]               " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1" + "\n" + 
        "Bakery             GB (1)  [2-3]    #1" + "\n" + "\n" +
        ".........................................." + "\n" +
        "Train Station      NT (4)  [ ]" + "\n" +
        "City Hall          NT (7)  [ ]" + "\n" + //"\n" +
        "Shopping Mall      NT (10) [ ]" + "\n" + "\n" +
        "                 Player 2*                " + "\n" +
        "------------------------------------------" + "\n" + 
        "                (3 coins)                 " + "\n" + 
        "Wheat Field        BW (1)  [1]      #1" + "\n" + 
        "Bakery             GB (1)  [2-3]    #1" + "\n" + "\n" +
        ".........................................." + "\n" +
        "Train Station      NT (4)  [ ]" + "\n" + 
        "City Hall          NT (7)  [ ]" + "\n" + //"\n" +
        "Shopping Mall      NT (10) [ ]" + "\n" + "\n" +
        "******************************************" + "\n";

        //System.out.println(menu.createGameStateDisplay(phase3Market, players, turn));
        //System.out.println(gameState);
        assertThat(menu.createGameStateDisplay(phase3Market, players, turn), is(gameState));
    }


}
