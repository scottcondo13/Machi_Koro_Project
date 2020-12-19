package edu.wofford.machiwoco;

import java.util.Scanner;

/**
 * This public class is where cards and players interact in the game per phase
 */
public class PlayerInputHandler {

    public int getPlayerNumberInput(Scanner scanner, int bound, String errorMessage){
        int input = 99;

        while(scanner.hasNextInt() == false){
            System.out.println(errorMessage);
            scanner.nextLine();
            
        }

        if(scanner.hasNextInt()){
            input = scanner.nextInt();
            while(input > bound || input <= 0){
                System.out.println(errorMessage);
                if(input == 99){
                    break;
                }else if(scanner.hasNextInt()){
                    input = scanner.nextInt();
                }else{
                    scanner.nextLine();
                }


            }

        }
        
        return input;
    }



    //
    
}
