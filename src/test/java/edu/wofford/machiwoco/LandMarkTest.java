package edu.wofford.machiwoco;

import org.junit.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LandMarkTest {
    LandMark CityHall;
    private Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);

    @Before public void intialize(){
        CityHall = new LandMark("City Hall");
        CityHall.setCost(7);
    }

    @Test 
    public void isBuiltTest() {
        CityHall.setBuilt();
        assertTrue(CityHall.isBuilt());
    }

    @Test
    public void getIconTest(){
        assertEquals(CityHall.getIcon(), "T");
    }

    
    @Test 
    public void getColorTest(){
        assertEquals(CityHall.getColor(), "N");
    }

    
    @Test 

    public void equalsTest(){
        LandMark lm = CityHall;
        Card c = Ranch;
        int x = 3;
        assertThat(CityHall, is(lm));
        assertFalse(lm.equals(c));
        assertFalse(CityHall.equals(x));
    }
}