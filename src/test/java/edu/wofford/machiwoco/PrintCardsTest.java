package edu.wofford.machiwoco;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class PrintCardsTest {
    @Test
    public void testWheatField() {
        String string = PrintCards.getFullDisplay("Wheat Field");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <B>      [1]      {W} |" + "\n" +
        "|      Wheat Field      |" + "\n" +
        "|                       |" + "\n" +
        "|  Get 1 coin from the  |" + "\n" +
        "|         bank.         |" + "\n" +
        "|    (anyone's turn)    |" + "\n" +
        "|                       |" + "\n" +
        "| (1)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1);
    }
    @Test
    public void testRanch() {
        String string = PrintCards.getFullDisplay("Ranch");
        String string1 = "" +
            ".-----------------------." + "\n" +
            "| <B>      [2]      {C} |" + "\n" +
            "|         Ranch         |" + "\n" +
            "|                       |" + "\n" +
            "|  Get 1 coin from the  |" + "\n" +
            "|         bank.         |" + "\n" +
            "|    (anyone's turn)    |" + "\n" +
            "|                       |" + "\n" +
            "| (1)                   |" + "\n" +
            "|_______________________|" + "\n";
        assertSame(string, string1);
    }

    @Test
    public void testBakery() {
        String string = PrintCards.getFullDisplay("Bakery");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <G>     [2-3]     {B} |" + "\n" +
        "|        Bakery         |" + "\n" +
        "|                       |" + "\n" +
        "|  Get 1 coin from the  |" + "\n" +
        "|         bank.         |" + "\n" +
        "|   (your turn only)    |" + "\n" +
        "|                       |" + "\n" +
        "| (1)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1);    
    }

    @Test
    public void testCafe() {
        String string= PrintCards.getFullDisplay("Cafe");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <R>      [3]      {U} |" + "\n" +
        "|         Cafe          |" + "\n" +
        "|                       |" + "\n" +
        "| Take 1 coin from the  |" + "\n" +
        "|    active player.     |" + "\n" +
        "|   (opponent's turn)   |" + "\n" +
        "|                       |" + "\n" +
        "| (2)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1);    
    }

    
    @Test
    public void testConvenienceStore() {
        String string = PrintCards.getFullDisplay("Convenience Store");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <G>      [4]      {B} |" + "\n" +
        "|   Convenience Store   |" + "\n" +
        "|                       |" + "\n" +
        "|  Get 3 coin from the  |" + "\n" +
        "|         bank.         |" + "\n" +
        "|    (your turn only)   |" + "\n" +
        "|                       |" + "\n" +
        "| (2)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1);    
    }

    @Test
    public void testForest() { 
        String string = PrintCards.getFullDisplay("Forest");
        String string1 = "" +
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
        assertSame(string, string1);    
    }

    @Test
    public void testStadium() {
        String string = PrintCards.getFullDisplay("Stadium");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <P>      [6]      {T} |" + "\n" +
        "|        Stadium        |" + "\n" +
        "|                       |" + "\n" +
        "|   Take 2 coins from   |" + "\n" +
        "|    each opponent.     |" + "\n" +
        "|   (your turn only)    |" + "\n" +
        "|                       |" + "\n" +
        "| (6)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1);    
    }

    @Test
    public void testTVStation() {
        String string = PrintCards.getFullDisplay("TV Station");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <P>      [6]      {T} |" + "\n" +
        "|      TV Station       |" + "\n" +
        "|                       |" + "\n" +
        "| Take 5 coins from an  |" + "\n" +
        "|       opponent.       |" + "\n" +
        "|    (your turn only)   |" + "\n" +
        "|                       |" + "\n" +
        "| (7)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1);    
    }

    @Test
    public void testBusinessComplex() {
        String string = PrintCards.getFullDisplay("Business Complex");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <P>      [6]      {T} |" + "\n" +
        "|   Business Complex    |" + "\n" +
        "|                       |" + "\n" +
        "| Exchange one of your  |" + "\n" +
        "|       non-tower       |" + "\n" +
        "| establishments for 1  |" + "\n" +
        "|    an opponent owns.  |" + "\n" +
        "|    (your turn only)   |" + "\n" +
        "|                       |" + "\n" +
        "| (8)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1);    
    }

    @Test
    public void testCheeseFactory() {
        String string = PrintCards.getFullDisplay("Cheese Factory");
        String string1 = "" +
            ".-----------------------." + "\n" +
            "| <G>      [7]      {F} |" + "\n" +
            "|   Cheese Factory      |" + "\n" +
            "|                       |" + "\n" +
            "| Get 3 coins from the  |" + "\n" +
            "|   bank for each {C}   |" + "\n" +
            "|   establishments you  |" + "\n" +
            "|         own.          |" + "\n" +
            "|    (your turn only)   |" + "\n" +
            "|                       |" + "\n" +
            "| (5)                   |" + "\n" +
            "|_______________________|" + "\n";
        assertSame(string, string1);    
    }
    
    @Test
    public void testFurnitureFactory() {
        String string = PrintCards.getFullDisplay("Furniture Factory");
        String string1 = "" +
            ".-----------------------." + "\n" +
            "| <G>      [8]      {F} |" + "\n" +
            "|   Furniture Factory   |" + "\n" +
            "|                       |" + "\n" +
            "| Get 3 coins from the  |" + "\n" +
            "|   bank for each {G}   |" + "\n" +
            "|   establishments you  |" + "\n" +
            "|         own.          |" + "\n" +
            "|    (your turn only)   |" + "\n" +
            "|                       |" + "\n" +
            "| (3)                   |" + "\n" +
            "|_______________________|" + "\n";
        assertSame(string, string1);    
    }

    @Test
    public void testMine() {
        String string = PrintCards.getFullDisplay("Mine");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <B>      [9]      {G} |" + "\n" +
        "|         Mine          |" + "\n" +
        "|                       |" + "\n" +
        "| Get 5 coins from the  |" + "\n" +
        "|         bank.         |" + "\n" +
        "|    (anyone's turn)    |" + "\n" +
        "|                       |" + "\n" +
        "| (6)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1);    
    }

    @Test
    public void testFamilyRestaurant() {
        String string = PrintCards.getFullDisplay("Family Restaurant");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <R>    [9-10]     {U} |" + "\n" +
        "|   Family Restaurant   |" + "\n" +
        "|                       |" + "\n" +
        "| Take 2 coins from the |" + "\n" +
        "|    active player.     |" + "\n" +
        "|   (opponent's turn)   |" + "\n" +
        "|                       |" + "\n" +
        "| (3)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1);    
    }

    @Test
    public void testAppleOrchard() {
        String string = PrintCards.getFullDisplay("Apple Orchard");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <B>     [10]      {W} |" + "\n" +
        "|     Apple Orchard     |" + "\n" +
        "|                       |" + "\n" +
        "| Get 3 coins from the  |" + "\n" +
        "|         bank.         |" + "\n" +
        "|    (anyone's turn)    |" + "\n" +
        "|                       |" + "\n" +
        "| (3)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1); 
    }
    @Test
    public void testFarmersMarket() {
        String string = PrintCards.getFullDisplay("Farmers Market");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <G>    [11-12]    {O} |" + "\n" +
        "|    Farmers Market     |" + "\n" +
        "|                       |" + "\n" +
        "| Get 2 coins from the  |" + "\n" +
        "|   bank for each {W}   |" + "\n" +
        "|   establishment you   |" + "\n" +
        "|         own.          |" + "\n" +
        "|   (your turn only)    |" + "\n" +
        "|                       |" + "\n" +
        "| (2)                   |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1); 
    }

    @Test
    public void testTrainStation() {
        String string = PrintCards.getFullDisplay("Train Station");
        String string1 = "" +
            ".-----------------------." + "\n" +
            "| <N>   LANDMARK    {T} |" + "\n" +
            "|     Train Station     |" + "\n" +
            "|                       |" + "\n" +
            "|  You may roll 1 or 2  |" + "\n" +
            "|         dice.         |" + "\n" +
            "|                       |" + "\n" +
            "| (4)               [ ] |" + "\n" +
            "|_______________________|" + "\n";
        assertSame(string, string1); 
    }

    @Test
    public void testShoppingMall() {
        String string = PrintCards.getFullDisplay("Shopping Mall");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <N>   LANDMARK    {T} |" + "\n" +
        "|     Shopping Mall     |" + "\n" +
        "|                       |" + "\n" +
        "|   Your {U} and {B}    |" + "\n" +
        "|  establishments earn  |" + "\n" +
        "|     +1 coin when      |" + "\n" +
        "|      activated.       |" + "\n" +
        "|                       |" + "\n" +
        "| (10)              [ ] |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1); 
    }

    @Test
    public void testAmusementPark() {
        String string = PrintCards.getFullDisplay("Amusement Park");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <N>   LANDMARK    {T} |" + "\n" +
        "|    Amusement Park     |" + "\n" +
        "|                       |" + "\n" +
        "| If you roll doubles,  |" + "\n" +
        "|   take another turn   |" + "\n" +
        "|    after this one.    |" + "\n" +
        "|                       |" + "\n" +
        "| (16)              [ ] |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1); 
    }

    @Test
    public void testRadioTower() {
        String string = PrintCards.getFullDisplay("Radio Tower");
        String string1 = "" +
        ".-----------------------." + "\n" +
        "| <N>   LANDMARK    {T} |" + "\n" +
        "|      Radio Tower      |" + "\n" +
        "|                       |" + "\n" +
        "|  Once per turn, you   |" + "\n" +
        "| may reroll the dice.  |" + "\n" +
        "|                       |" + "\n" +
        "| (22)              [ ] |" + "\n" +
        "|_______________________|" + "\n";
        assertSame(string, string1); 
    }



}