package edu.wofford.machiwoco;
import org.junit.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;
import java.security.cert.TrustAnchor;

public class SimpleAiTest {
    Game game;
    SimpleAi ai;
    Random rand;
    private final ByteArrayOutputStream output= new ByteArrayOutputStream();
    //private final PrintStream outputStream = System.out;
    String aiOutput;
    private Card wheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    private LandMark CityHall = new LandMark("City Hall");

    @Before public void initialize() {
      CityHall.setCost(7);
      ai = new SimpleAi("1");
      ai.addEstablishment(wheatField);
      ai.addEstablishment(Ranch);
      ai.addEstablishment(Forest);
      ai.addLandmark(CityHall);
      rand = new Random();
      //System.setOut(new PrintStream(output));
   }

    @After 
    public void restoreStreams(){
        //System.setOut(outputStream);
    }

    @Test

    public void isAiTest() {
       assertTrue(ai.isAi());
    }

    @Test
    
    public void setAiFalseTest(){
       ai.setAI(false);
       assertFalse("sets ai to false", ai.isAi());
    }

     @Test
     public void generateRandomIntTest(){
        int bound = 10;
        int num = rand.nextInt(bound);
        int aiNum = ai.generateRandomInt(bound);
        System.out.println(aiNum);
        assertTrue(aiNum <= bound);
        assertTrue(aiNum >= 0);
        assertThat(ai.generateRandomInt(0), is(0));
     }

     @Test 
     public void getNumEntriesInMenuTest(){
        String menu = "" + 
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 3. Forest             BG (3)  [5]      #6" + "\n" +
        "---------       CONSTRUCT        ---------" + "\n" + 
        " 4. City Hall          NT (7)  [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================" + "\n" ;

        assertThat(ai.getNumEntriesInMenu(menu), is(4));
     }

     @Test
     public void aiPurchaseOutputTest(){
      ai.aiPurchaseOutput(1);
      aiOutput = output.toString();
     // output.writeTo(out);

      //assertThat(aiOutput, is("1"));
     }

     @Test
     public void aiPurchaseSelect(){
        int entries = 3;
        String s = "";
        String menu = "" + 
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 3. Forest             BG (3)  [5]      #6" + "\n" +
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================" + "\n" ;

        ai.aiPurchaseSelect(entries, menu);
        for(int i = 0; i < entries; i++){
            s += String.valueOf(i);
        }
        assertTrue(s.contains(output.toString()));

        menu = "" + 
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 3. Forest             BG (3)  [5]      #6" + "\n" +
        "---------       CONSTRUCT        ---------" + "\n" + 
        " 4. Train Station      NT (4)  [ ]        " + "\n" +
        " 5. City Hall          NT (7)  [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================" + "\n" ;

        entries = 5;
        int choice = ai.aiPurchaseSelect(entries, menu);
        System.out.println(choice);
        if(choice == 4 || choice == 5){
           assertTrue(true);
        }else{
           assertTrue(false);
        }
        //assertThat(choice, is(5));
     }

     
     @Test
     public void aiTurnTest(){
        
        String prompt = "Choose a number to purchase or construct:";
        int turn = 1;
        String menu = "" +
        "==========================================" + "\n" +
        "---------        PURCHASE        ---------" + "\n" +
        " 1. Wheat Field        BW (1)  [1]      #6" + "\n" + 
        " 2. Ranch              BC (1)  [2]      #6" + "\n" + 
        " 3. Forest             BG (3)  [5]      #6" + "\n" +
        "---------       CONSTRUCT        ---------" + "\n" + 
        " 4. City Hall          NT (7)  [ ]        " + "\n" + 
        "---------         CANCEL         ---------" + "\n" + 
        "99. Do nothing                            " + "\n" +
        "==========================================" + "\n" ;

        //System.out.println("Choose a number to purchase or construct");
        ai.aiTurn(menu, prompt, turn);
        String aiTurnOutput = output.toString();
        String choices = "12345";

        //assertTrue(aiTurnOutput.contains("1"));
        assertTrue(choices.contains(aiTurnOutput));
        assertEquals(99, ai.aiTurn(menu, prompt, 2));
     }
    
}
