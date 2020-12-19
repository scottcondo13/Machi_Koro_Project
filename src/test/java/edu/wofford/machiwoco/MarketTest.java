package edu.wofford.machiwoco;
import org.junit.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MarketTest {
    Market market;
    private Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    private Card Bakery = new Card("Bakery", "B", "G", 1, 2, 2, 1);
    private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
    private Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
    private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
    private Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
    private Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
    private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 2);
    HashMap<String, Object> map;
    List<Card> phase1;
    List<Card> phase2;
    List<Card> phase3;

    @Before public void initialize() {
        phase1 = new ArrayList<>();
        phase2 = new ArrayList<>();
        phase3 = new ArrayList<>();
        phase1.add(WheatField);
        phase1.add(Ranch);
        phase1.add(Forest);
        phase2.add(WheatField);
        phase2.add(Ranch);
        phase2.add(Forest);
        phase2.add(Bakery);
        phase2.add(ConvenienceStore);
        phase2.add(Mine);
        phase2.add(AppleOrchard);
        phase3.add(WheatField);
        phase3.add(Ranch);
        phase3.add(Forest);
        phase3.add(Bakery);
        phase3.add(ConvenienceStore);
        phase3.add(Mine);
        phase3.add(AppleOrchard);
        phase3.add(CheeseFactory);
        phase3.add(FurnitureFactory);
        phase3.add(FarmersMarket);
        market = new SimpleMarket(phase1);
        map = new HashMap<>();
        map.put(WheatField.getName(), 6);
        map.put(Ranch.getName(), 6);
        map.put(Forest.getName(), 6);
     }

     @Test 
     public void marketConstructorTest(){
         assertTrue(market.getCardTypes().contains(WheatField));
         assertTrue(market.getCardTypes().contains(Ranch));
         assertTrue(market.getCardTypes().contains(Forest));
     }

     @Test 
     public void phase1MarketCreateTest(){
         assertThat(market.getMarketStock(), is(map));
     }

     @Test 
     public void phase2MarketCreateTest(){
         List<Card> cards = new ArrayList<>();
         cards.add(WheatField);
         cards.add(Ranch);
         cards.add(Forest);
         cards.add(Bakery);
         cards.add(ConvenienceStore);
         cards.add(Mine);
         cards.add(AppleOrchard);
         Market m = new SimpleMarket(phase2);

         assertThat(m.getCardTypes(), is(cards));
     }

     @Test 
     public void phase3MarketCreateTest(){
        List<Card> cards = new ArrayList<>();
        cards.add(WheatField);
        cards.add(Ranch);
        cards.add(Forest);
        cards.add(Bakery);
        cards.add(ConvenienceStore);
        cards.add(Mine);
        cards.add(AppleOrchard);
        cards.add(CheeseFactory);
        cards.add(FurnitureFactory);
        cards.add(FarmersMarket);
        Market m = new SimpleMarket(phase3);

        assertThat(m.getCardTypes(), is(cards));

     }
     
     @Test 
     public void getSelectedCardTest(){
         assertThat(market.getSelectedCard("Wheat Field"), is(WheatField));
     }

     @Test
     public void setMarketStockTest(){
        map = new HashMap<>();
        map.put("Wheat Field", 6);
        map.put("Ranch", 4);
        map.put("Forest", 5);

        market.purchase("Forest");
        market.purchase("Ranch");
        market.purchase("Ranch");
        assertThat(market.getMarketStock(), is(map));

     }

     @Test 

     public void getNumEstablishmentsInMarketTest(){
         assertThat(market.getNumEstablishmentsInMarket(), is(18));
         market.getMarketStock().put("Bakery", 3);
         assertThat(market.getNumEstablishmentsInMarket(), is(21));
     }
    
}
