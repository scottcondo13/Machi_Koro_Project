package edu.wofford.machiwoco;

import org.junit.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.*;




public class PlayerTest {
    Player model;
    private Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    private Card Bakery = new Card("Bakery", "B", "G", 1, 2, 3, 1);
    private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 12, 2);
    private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
    private LandMark CityHall = new LandMark("City Hall");
    private LandMark ShoppingMall = new LandMark("Shopping Mall");
    private Card Cafe = new Card("Cafe", "U", "R", 2, 3, 1);

    @Before public void initialize() {
        model = new Player("1");
        CityHall.setCost(7);
        model.addEstablishment(WheatField);
        model.addLandmark(CityHall);

    }

    @Test 
    public void getNameTest(){
        assertEquals(model.getName(), "1");
    }

    @Test
    public void rollDice(){
        int x = model.rollDice();
        if (x >= 0 && x<= 6) {
        assertTrue(true);
        } else {
            assertTrue(false);
        }
 
    }

    @Test
    public void getWalletTest() {
        assertEquals(model.getWallet(), 3);
    }
    /*
    @Test 
    public void setWalletTest(){
        model.wallet = 3;
        //model.subtractFromWallet(1);
        assertEquals(2, model.wallet);
    }
    */
    @Test
    public void addMoneyTest() {
        model.addMoney(1);
        int x = model.getWallet();
        assertEquals(x, 4);
    }
    @Test 
    public void addEstablishmentTest(){
        Card w = WheatField;
        model.addEstablishment(w);
        assertTrue(model.getEstablishments().contains(w));
        assertEquals(2, model.getEstablishments().size());

        Card f = Forest;
        model.addEstablishment(f);
        assertTrue(model.getEstablishments().contains(f));
        assertEquals(3, model.getEstablishments().size());
    }

    @Test 
    public void addLandmarkTest(){
        int size = model.getLandmarks().size();
        model.addLandmark(CityHall);
        assertTrue(model.getLandmarks().contains(CityHall));
        assertEquals(2, model.getLandmarks().size());
    }

    @Test
    public void getEstablishmentTest(){
        List<Card> establishments = new ArrayList<>();
        establishments.add(WheatField);
        assertThat(model.getEstablishments(), is(establishments));
        /*
        List<Card> Cards = model.getEstablishments();
        if(establishments.size() == Cards.size()){
            for(int i = 0; i < Cards.size(); i++){
                assertTrue(establishments.get(i).equals(Cards.get(i)));
            }
        }else{
            assertTrue(false);
        }
        */

    }

    @Test
    public void getLandmarksTest(){
        List<LandMark> landmarks = new ArrayList<>();
        landmarks.add(CityHall);
        //establishments.add(new WheatField());
        assertThat(model.getLandmarks(), is(landmarks));
    }    

    @Test
    public void getEstablishmentsTest() {
        List<Card> list;
        list = new ArrayList<>();
        list.add(WheatField);
        assertEquals(model.getEstablishments().get(0).getName(), list.get(0).getName());
    }

    @Test 
    public void equalsTest(){
        Player p = new Player("Bob Ross");
        Player pl = new Player("DaVinci");
        String c = "painter";

        assertThat(p, is(p));
        assertFalse(pl.equals(p));
        assertFalse(p.equals(c));
    }

    @Test

    public void getNumTest(){
        int a = 1;
        assertEquals(model.getNum(), a);
    }

    @Test

    public void getLandMarkNames(){
        List<String> s = new ArrayList<>();
        s.add("City Hall");
        assertThat("Making Sure names are same.", model.getLandMarkNames(), is(s));
        
    }

    @Test

    public void getEstablishmentNames(){
        List<String> s = new ArrayList<>();
        s.add("Wheat Field");
        assertThat("Estab name equals estab name", model.getEstablishmentNames(), is(s));
    }

    /*
    @Test

    public void checkCardsTest(){
        // int roll = 1;
        // model.checkCards(roll,1);
        // assertEquals(4, model.getWallet());
        // model.checkCards(8,1);
        // assertEquals(4, model.getWallet());

        // model.addLandmark(ShoppingMall);
        // model.construct("Shopping Mall");
        // model.addEstablishment(Bakery);
        // model.checkCards(2, 1);
        // assertThat(model.getWallet(), is(6));

        // // model.addEstablishment(WheatField);
        // model.addEstablishment(WheatField);
        // model.addEstablishment(FarmersMarket);
        // model.checkCards(11, 1);
        // assertThat(model.getWallet(), is(10));

        // Player p = new Player("1", "phase3");
        // p.addEstablishment(FarmersMarket);
        // p.addEstablishment(WheatField);
        // p.addEstablishment(AppleOrchard);
        // p.checkCards(11, 1);
        // assertThat(p.getWallet(), is(9));


        

    }*/

    @Test 

    public void isMallBuiltTest(){
        assertFalse(model.isLandMarkBuilt("Shopping Mall"));
        model.addLandmark(ShoppingMall);
        model.construct("Shopping Mall");
        assertTrue(model.isLandMarkBuilt("Shopping Mall"));
    }

    @Test

    public void addEstablishmentStringTest(){
        model.addEstablishment(WheatField);
        model.addEstablishment(Ranch);
        model.addEstablishment(Forest);
        
        assertEquals(model.getNumEstablishment("Wheat Field"), 2);
        assertEquals(model.getNumEstablishment("Ranch"), 1);
        assertEquals(model.getNumEstablishment("Forest"), 1);
        //assertTrue(model.establishments.contains(new WheatField()));
    }


    @Test

    public void getNumLandmarksBuiltTest(){
        assertEquals(0, model.getNumLandmarksBuilt());
        model.construct("City Hall");
        assertEquals(1, model.getNumLandmarksBuilt());
        Player s = new Player("Bobby");
        s.construct("");
        //assertFalse(s.getLandmarks().get(0).isBuilt());
    }

    @Test

    public void purchaseTest(){
        Card test = new Card("Test", "t", "t", 2, 1, 1);
        model.purchase(test);
        assertEquals(1, model.wallet);
        model.addMoney(-1);
        test.setCost(100);
        model.purchase(test);
        assertEquals(1, model.wallet);
    }    

    @Test
    public void redCardActivationTest(){
        int roll = 3;
        List<Card> c = new ArrayList<>();
        //c = model.checkCards(1, 1, 1);
        //assertThat(c.get(0).getName(), is("Wheat Field"));
    }

  
}