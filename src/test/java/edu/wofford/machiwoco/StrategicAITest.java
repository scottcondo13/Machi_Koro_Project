package edu.wofford.machiwoco;
import org.junit.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;
import java.security.cert.TrustAnchor;

public class StrategicAITest{
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
    boolean isAi;
    StrategicAI player;
    String purchaseMenu;
    Game game;
    List<Card> cards;
    List<LandMark> landmarks;
    LandMark AmusementPark = new LandMark("Amusement Park");
    
    LandMark CityHall = new LandMark("City Hall");
    
    LandMark TrainStation = new LandMark("Train Station");
    
    LandMark ShoppingMall = new LandMark("Shopping Mall");
    
    LandMark RadioTower = new LandMark("Radio Tower");
    @Before
    public void initialize(){
        cards = new ArrayList<>();
        landmarks = new ArrayList<>();
        game = new Game("phase3", 2, "-ai", cards, landmarks);
        player = new StrategicAI("1");
        player.addLandmark(TrainStation);
        player.addLandmark(ShoppingMall);
        player.addLandmark(RadioTower);
        player.addLandmark(AmusementPark);
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
        "==========================================";
    }

    @Test

    public void checkAI(){
        player.setStrategicAI(false);
        assertThat("checks if is strategic AI", player.isStrategicAI(), is(false));
    }

    @Test 
    public void obtainShoppingMallTest(){
    
        assertThat("Tests where Shopping Mall is in the list", player.inList(purchaseMenu, "Shopping Mall"), is(13));
        
    }


    @Test 
    public void obtainRanchTest(){
        

        assertThat("Tests where Ranch is in the list", player.inList(purchaseMenu, "Ranch"), is(2));
        
    }

    @Test

    public void inMarketTest(){
        
        assertThat("an item is in the list", player.inMarket(purchaseMenu, "Bakery"), is(true));
        assertThat("item isnt in list", player.inMarket(purchaseMenu, "Taffy Factory"), is(false));

    }

    @Test

    public void strategicBuyTest(){
        String purchaseMenu9 = "" +
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
       // " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        //" 3. Bakery             GB (1)  [2-3]    #6" + "\n" +
        //" 4. Convenience Store  GB (2)  [4]      #6" + "\n" +
        " 5. Forest             BG (3)  [5]      #6" + "\n" +
        " 6. Cheese Factory     GF (5)  [7]      #6" + "\n" +
        " 7. Furniture Factory  GF (3)  [8]      #6" + "\n" +
        " 8. Mine               BG (6)  [9]      #6" + "\n" +
        " 9. Apple Orchard      BW (3)  [10]     #6" + "\n" +
        "10. Farmers Market     GO (2)  [11-12]  #6" + "\n" +    
        "---------       CONSTRUCT        ---------" + "\n" + 
        //"11. Train Station      NT (4)  [ ]        " + "\n" + 
        "12. City Hall          NT (7)  [ ]        " + "\n" + //"\n" +
        //"13. Shopping Mall      NT (10) [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================";
        String purchaseMenu8 = "" +
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
       // " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        //" 3. Bakery             GB (1)  [2-3]    #6" + "\n" +
        //" 4. Convenience Store  GB (2)  [4]      #6" + "\n" +
        " 5. Cafe               BG (3)  [5]      #6" + "\n" +
        " 5. Forest             BG (3)  [5]      #6" + "\n" +
        " 6. Cheese Factory     GF (5)  [7]      #6" + "\n" +
        " 7. Furniture Factory  GF (3)  [8]      #6" + "\n" +
        " 8. Mine               BG (6)  [9]      #6" + "\n" +
        " 9. Apple Orchard      BW (3)  [10]     #6" + "\n" +
        "10. Farmers Market     GO (2)  [11-12]  #6" + "\n" +    
        "---------       CONSTRUCT        ---------" + "\n" + 
        //"11. Train Station      NT (4)  [ ]        " + "\n" + 
        //"12. City Hall          NT (7)  [ ]        " + "\n" + //"\n" +
        //"11. Amusement Park     GO (2)  [11-12]  #6" + "\n" + 
        //"13. Shopping Mall      NT (10) [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================";
        String purchaseMenu7 = "" +
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        //" 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        //" 3. Bakery             GB (1)  [2-3]    #6" + "\n" +
        " 4. Convenience Store  GB (2)  [4]      #6" + "\n" +
        " 5. Forest             BG (3)  [5]      #6" + "\n" +
        " 6. Cheese Factory     GF (5)  [7]      #6" + "\n" +
        " 7. Furniture Factory  GF (3)  [8]      #6" + "\n" +
        " 8. Mine               BG (6)  [9]      #6" + "\n" +
        " 9. Apple Orchard      BW (3)  [10]     #6" + "\n" +
        "10. Farmers Market     GO (2)  [11-12]  #6" + "\n" +    
        "---------       CONSTRUCT        ---------" + "\n" + 
        //"11. Train Station      NT (4)  [ ]        " + "\n" + 
        //"12. City Hall          NT (7)  [ ]        " + "\n" + //"\n" +
        //"13. Shopping Mall      NT (10) [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================";
        String purchaseMenu6 = "" +
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        //" 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 3. Bakery             GB (1)  [2-3]    #6" + "\n" +
        " 4. Convenience Store  GB (2)  [4]      #6" + "\n" +
        " 5. Forest             BG (3)  [5]      #6" + "\n" +
        " 5. Cafe               BG (3)  [5]      #6" + "\n" +
        " 6. Cheese Factory     GF (5)  [7]      #6" + "\n" +
        " 7. Furniture Factory  GF (3)  [8]      #6" + "\n" +
        " 8. Mine               BG (6)  [9]      #6" + "\n" +
        " 9. Apple Orchard      BW (3)  [10]     #6" + "\n" +
        "10. Farmers Market     GO (2)  [11-12]  #6" + "\n" +    
        "---------       CONSTRUCT        ---------" + "\n" + 
        //"11. Train Station      NT (4)  [ ]        " + "\n" + 
        //"12. City Hall          NT (7)  [ ]        " + "\n" + //"\n" +
        //"13. Shopping Mall      NT (10) [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================";
        String purchaseMenu5 = "" +
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
        //"11. Train Station      NT (4)  [ ]        " + "\n" + 
        //"12. City Hall          NT (7)  [ ]        " + "\n" + //"\n" +
        //"13. Shopping Mall      NT (10) [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================";
        String purchaseMenu4 = "" +
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
        //"11. Train Station      NT (4)  [ ]        " + "\n" + 
        //"12. City Hall          NT (7)  [ ]        " + "\n" + //"\n" +
        //"13. Shopping Mall      NT (10) [ ]        " + "\n" + 
        "14. Amusement Park     NT (4)  [ ]        " + "\n" +
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================";
        String purchaseMenu3 = "" +
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
        //"13. Shopping Mall      NT (10) [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================";
        String purchaseMenu2 = "" +
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
        //"13. Shopping Mall      NT (10) [ ]        " + "\n" +
        "14. Radio Tower        NT (10) [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================";
        LandMark t = new LandMark("Train Station");
        LandMark s = new LandMark("Shopping Mall");
        LandMark r = new LandMark("Radio Tower");
        LandMark a = new LandMark("Amusement Park");
        player.getLandmarks().get(1).setBuilt();
        player.getLandmarks().get(2).setBuilt();

        assertThat("Buys a Shopping Mall when necessary.", player.strategicBuy(purchaseMenu, "Choose a number to purchase or construct", 1), is(13));
        assertThat("Buys a Radio Tower when necessary.", player.strategicBuy(purchaseMenu2, "Choose a number to purchase or construct", 1), is(13));
        assertThat("Buys a Train Station when necessary.", player.strategicBuy(purchaseMenu3, "Choose a number to purchase or construct", 1), is(11));
        //assertThat("Buys a Amusement Park when necessary.", player.strategicBuy(purchaseMenu4, "Choose a number to purchase or construct", 2), is(10));
        assertThat("Buys a Ranch when necessary.", player.strategicBuy(purchaseMenu5, "Choose a number to purchase or construct", 1), is(2));
        assertThat("Buys a Bakery when necessary.", player.strategicBuy(purchaseMenu6, "Choose a number to purchase or construct", 1), is(2));
        assertThat("Buys a Convenience Store when necessary.", player.strategicBuy(purchaseMenu7, "Choose a number to purchase or construct", 1), is(2));
        assertThat("Buys a Cafe when necessary.", player.strategicBuy(purchaseMenu8, "Choose a number to purchase or construct", 1), is(2));
        assertThat("Buys Nothing", player.strategicBuy(purchaseMenu9, "Choose a number to purchase or construct", 1), is(99));
    }

    @Test

    public void trainStationPromptTest(){
        assertThat("Makes Sure 1 die is returned when asked", player.strategicBuy(purchaseMenu, "would you like to roll 1 or 2 dice", 1), is(1));
    }

    @Test

    public void getRollTest(){
        game.setRoll(3);
        assertThat("gets the roll on the specific turn", player.getDieRoll(game), is(3));
    }

    @Test

    public void reRollTest(){
        game.setRoll(1);
        player.addEstablishment(Ranch);
        player.addEstablishment(Bakery);
        assertThat("Makes Sure 1 die is returned when asked", player.likeToReroll(1), is("y"));
    }


}
