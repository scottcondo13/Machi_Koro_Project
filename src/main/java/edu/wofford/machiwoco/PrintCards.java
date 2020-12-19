package edu.wofford.machiwoco;

/**
 * This class will display all of the card information.
 */
public class PrintCards {
/**
 * This String method is a full display of the cards.
 * @param cardName The name of the cards. 
 */
    public static String getFullDisplay(String cardName) {
        if (cardName.equals("Wheat Field")) {
            return "" +
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
        } else if(cardName.equals("Ranch")) {
            return "" +
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

        } else if(cardName.equals("Bakery")) {
            return "" +
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

        } else if(cardName.equals("Cafe")) {
            return "" +
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

        } else if(cardName.equals("Convenience Store")) {
            return "" +
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
        } else if(cardName.equals("Forest")) {
            return "" +
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

        } else if(cardName.equals("Stadium")) {
            return "" +
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

        } else if(cardName.equals("TV Station")) {
            return "" +
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

        } else if(cardName.equals("Business Complex")) {
            return "" +
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

        } else if(cardName.equals("Cheese Factory")) {
            return "" +
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

        } else if(cardName.equals("Furniture Factory")) {
            return "" +
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

        }  else if(cardName.equals("Mine")) {
            return "" +
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

        } else if(cardName.equals("Family Restaurant")) {
                    return "" +
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

        } else if(cardName.equals("Apple Orchard")) {
                    return "" +
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

        } else if(cardName.equals("Farmers Market")) {
                    return "" +
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

        } else if(cardName.equals("Train Station")) {
                    return "" +
            ".-----------------------." + "\n" +
            "| <N>   LANDMARK    {T} |" + "\n" +
            "|     Train Station     |" + "\n" +
            "|                       |" + "\n" +
            "|  You may roll 1 or 2  |" + "\n" +
            "|         dice.         |" + "\n" +
            "|                       |" + "\n" +
            "| (4)               [ ] |" + "\n" +
            "|_______________________|" + "\n";

        } else if(cardName.equals("Shopping Mall")) {
                    return "" +
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

        } else if(cardName.equals("Amusement Park")) {
                    return "" +
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

        } else if(cardName.equals("Radio Tower")) {
                    return "" +
            ".-----------------------." + "\n" +
            "| <N>   LANDMARK    {T} |" + "\n" +
            "|      Radio Tower      |" + "\n" +
            "|                       |" + "\n" +
            "|  Once per turn, you   |" + "\n" +
            "| may reroll the dice.  |" + "\n" +
            "|                       |" + "\n" +
            "| (22)              [ ] |" + "\n" +
            "|_______________________|" + "\n";
        } else {
            return "";
        }

    }
    
}