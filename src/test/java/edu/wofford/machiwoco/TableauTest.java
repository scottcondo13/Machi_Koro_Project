package edu.wofford.machiwoco;
import org.junit.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.*;



public class TableauTest {
    Tableau t;
    private Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    private Card Bakery = new Card("Bakery", "B", "G", 1, 2, 3, 1);
    private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
    private Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
    private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
    private Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
    private Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
    private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 2);
    private LandMark CityHall = new LandMark("City Hall");
    Player player;

    @Before public void initialize() {
        //player = new Player("bob");
        t = new Tableau();
        t.addCard(WheatField); 
        CityHall.setCost(7);
        t.addLandmark(CityHall);;
     }

     @Test
     public void tableauConstructorTest(){
         assertThat(t.getCards().size(), is(1));
         assertTrue(t.getCards().contains(WheatField));
     }

     @Test
     public void getNumTypesOfCardsTest(){
         int numberOfDifferentCards = t.getNumTypesOfCards();
         assertThat(numberOfDifferentCards, is(1));
         t.addCard(WheatField);
         numberOfDifferentCards = t.getNumTypesOfCards();
         assertThat(numberOfDifferentCards, is(1));
     }
     @Test
     public void getNumberOfCardsTest(){
         assertThat(t.getNumberOfCards(), is(1));

     }
     @Test
     public void removeCardTest(){
        t.addCard(Ranch);
        assertTrue(t.getCards().contains(Ranch));
        t.addCard(Ranch);
        t.removeCard(Ranch);
        assertThat(t.getCards().size(), is(2));
     }

     @Test
     public void getNumLandmarksTest(){
         assertThat(t.getLandmarks().size(), is(1));
     }

    
     @Test

     public void addCardStringTest(){
         t.addCard(WheatField);
         t.addCard(Ranch);
         t.addCard(Forest);
         
         assertEquals(t.getNumberOfSpecifiedCards("Wheat Field"), 2);
         assertEquals(t.getNumberOfSpecifiedCards("Ranch"), 1);
         assertEquals(t.getNumberOfSpecifiedCards("Forest"), 1);
         assertEquals(t.getNumberOfSpecifiedCards("test"), 0);
         //assertTrue(t.establishments.contains(new WheatField()));
     }     


    @Test 
    public void addLandmarkTest(){
        t.addLandmark(CityHall);
        int size = t.getLandmarks().size();
        assertTrue(t.getLandmarks().contains(CityHall));
        assertEquals(size, t.getLandmarks().size());
    }     


    @Test

    public void getNumLandmarksBuiltTest(){
        assertEquals(0, t.getNumLandmarksBuilt());
        t.getLandmarks().get(0).setBuilt();
        assertEquals(1, t.getNumLandmarksBuilt());
        Player s = new Player("Bobby");
        s.construct("");
        //assertFalse(s.getLandmarks().get(0).isBuilt());
    }


}
