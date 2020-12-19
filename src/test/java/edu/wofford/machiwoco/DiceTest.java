package edu.wofford.machiwoco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.Test;

import io.cucumber.java.Before;
import io.cucumber.java.lu.dann;

public class DiceTest {

    Dice d;

    @Before public void initialize() {
        d = new Dice();
     }

    @Test
    public void getMaxRollTest(){
        d = new Dice();
        int max = 6;
        assertEquals(d.getMaxRoll(), max);
    }

    

    @Test

    public void rollTest(){
        d = new Dice();
        int rollNum;
        int highestRoll = -10000;
        int lowestRoll = 10000;
        for (int i = 0; i < 100000; i++){
            rollNum = d.roll();
            if (rollNum < 0){
                fail("Roll out of bounds lower than expected");
            }

            if (rollNum > d.getMaxRoll()){
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

        if (highestRoll != d.getMaxRoll()){
            fail("The highest roll is " + highestRoll + " and it should be 6.");
        }
        
        if (lowestRoll != 1){
            fail("The lowest pin is " + lowestRoll + " and it should be 1.");
        }

    }

    
    
}
