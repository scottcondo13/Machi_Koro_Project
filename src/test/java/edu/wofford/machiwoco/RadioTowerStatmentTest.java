package edu.wofford.machiwoco;

import org.junit.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.io.*;

import java.util.*;
public class RadioTowerStatmentTest {
    List<Player> playerList;
    Player currPlayer;
    int Turn;
    LandMark RadioTower = new LandMark("Radio Tower");
    RadioTowerStatement radioTowerStatement;
    Scanner scanner;

    @Before

    public void initialize(){
        playerList = new ArrayList<>();
        RadioTower.setBuilt();
        Player player1 = new Player("1");
        player1.addLandmark(RadioTower);
        Player player2 = new Player("2");
        player2.addLandmark(RadioTower);
        Turn = 1;
        playerList.add(player1);
        playerList.add(player2);
        scanner = new Scanner("y");
        radioTowerStatement = new RadioTowerStatement(playerList, Turn);
    }

    @Test

    public void radioPromptTest(){
        String radioPrompt  = "like to reroll";
        assertThat("Radio prompt is the same", radioTowerStatement.rerollPrompt(), is(radioPrompt));
    }

    @Test

    public void radioReroll1Yes(){
        List<String> s = new ArrayList<>();
        s.add("like to reroll");
        s.add("y");
        assertEquals("String lists are the same", radioTowerStatement.radioTowerYesorNoResponse1Die(scanner), s);
    }

@Test

    public void radioReroll1No(){
        Scanner scanner1 = new Scanner("n");
        List<String> s = new ArrayList<>();
        s.add("like to reroll");
        s.add("n");
        assertEquals("String lists are the same", radioTowerStatement.radioTowerYesorNoResponse1Die(scanner1), s);
    }

@Test

    public void radioReroll2No(){
        
        //File file = new File("/Users/scottcondo/Desktop/New Project/project-fall2020-team-gambit/src/test/java/edu/wofford/machiwoco/input.txt");
        Scanner scanner1 = new Scanner("n");
        List<String> s = new ArrayList<>();
        s.add("like to reroll");
        s.add("n");
        assertEquals("String lists are the same", radioTowerStatement.radioTowerYesorNoResponse2Dice(scanner1), s);
            
        
        //Scanner scanner1 = new Scanner("n");
        
    }


@Test

    public void radioReroll2Yes(){
        //Scanner scanner1 = new Scanner("n");
        List<String> s = new ArrayList<>();
        s.add("like to reroll");
        s.add("y");
        assertEquals("String lists are the same", radioTowerStatement.radioTowerYesorNoResponse2Dice(scanner), s);
    }

/*
@Test 

void wrongInputRadioReroll1(){
    try{
        File file = new File("input.txt");
        Scanner scanner1 = new Scanner(file);
        
    }catch(FileNotFoundException e){
        e.printStackTrace();
    }
    

    

}
*/
}
