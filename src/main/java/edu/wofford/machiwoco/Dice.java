package edu.wofford.machiwoco;
import java.util.*;

/**
 * This class establishes a random dice roll for players.
 * It contains a random die, two rolls, a max role, and a max double roll.
 */
public class Dice {
    private Random die;
    private int roll;
    private int maxRoll = 6;
    /**
     * This constructor intializes a new random object called dice.
     */
    public Dice(){
        die = new Random();
    }
    /**
     * This method returns an Integer that represents the max possible roll on a die.
     * @return vairable maxRoll as an integer.
     */
    public int getMaxRoll(){
        return maxRoll;
    }

    /**
     * This method returns an Integer that represents the roll of the die.
     * @return variable roll as an integer.
     */
    public int roll(){
        roll = die.nextInt(maxRoll) + 1;
        return roll;
    }

}
