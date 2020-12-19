package edu.wofford.machiwoco;

import org.junit.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;



public class CardTest {
    String name;
    Card c;
    

    @Before public void initialize() {
        name = "Wheat Field";
        c = new Card(name);
     }
 

    @Test
    public void cardConstructorTest() {
        assertEquals(c.getName(), name);
    }

    @Test
    public void cardOverloadConstructor(){
        Card z = new Card("Wheat Field", "W", "B", 1, 1, 1);
        c.setActNum(1);
        c.setColor("B");
        c.setCost(1);
        c.setIcon("W");
        c.setPayout(1);
        assertTrue(c.equals(z));
    }

    @Test
    public void setNameTest(){
        c.setName("Wheat");
        assertEquals(c.getName(), "Wheat");
    }


    @Test
    public void cardSetColorTest(){
        c.setColor("red");
        assertEquals(c.getColor(), "red");
    }

    @Test
    public void cardIconTest(){
        c.setIcon("W");
        assertEquals(c.getIcon(), "W");
    }

    @Test
    public void cardCostTest(){
        c.setCost(1);
        assertEquals(c.getCost(), 1);
    }

    @Test 
    public void cardActivationNumberTest(){
        c.setActNum(2);
        assertEquals(c.getActNum(), 2);
    }

    @Test
    public void cardActivationRangeTest(){
        int[] range = {1,2};
        //c.setActRange(1,2);
        //assertArrayEquals(c.getActRange(), range);
    }

    @Test

    public void isActivatedTest(){
        c.setActNum(1);
        c.setColor("B");
        assertTrue(c.isActivated(1,1,1));
        assertFalse(c.isActivated(2,1,2));

    }

    @Test

    public void isActivatedFalseTest() {
        c.setActNum(2);
        c.setColor("G");
        assertFalse(c.isActivated(2, 2, 1));
    }

    @Test
    public void isActivatedDifferentRangeTest() {
        c.range1 = 1;
        c.range2 = 2;
        c.setActNum(4);
        c.setColor("G");
        assertFalse(c.isActivated(2, 2, 1));
        assertTrue(c.isActivated(1, 2, 2));
        assertTrue(c.isActivated(2, 2, 2));
        assertFalse(c.isActivated(3, 2, 2));
    }

    @Test

    public void hashCodeTest() {
        c.name = null;
        assertSame(101, c.hashCode());

    }

    @Test

    public void PayoutTest(){
        c.setColor("B");
        c.setActNum(5);
        c.setPayout(1);
        assertEquals(c.Payout(5,1,1), 1 );
        assertEquals(c.Payout(3,1,1), 0);
    }

    @Test 

    public void equalsTest(){
        Card w = new Card("Wheat Field", "W", "B", 1, 1, 1);
        Card wf = new Card("Wheat Field", "W", "B", 1, 1, 1);
        Card r = new Card("Ranch", "C", "B", 1, 2, 1);
        int x = 7;
        assertThat(w, is(wf));
        assertThat(w, is(w));
       // assertFalse(w.equals(z));
        assertFalse(w.equals(r));
        assertFalse(wf.equals(x));
        assertTrue(w.equals(wf));
        assertTrue(w.name.equals(wf.name));
        //assertTrue(null, false);
        //assertTrue(!w.equals(z));
    }




}

