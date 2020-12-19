package edu.wofford.machiwoco;
import java.util.*;
import java.util.regex.Pattern;


/**
 * This public class is where the main method set up. 
 */

public class MachiWoCo {
    
    public static void main(String[] args) {
        //comment

         
        //minesweepPractice m = new minesweepPractice(10, 4);
        String input = String.join(" ",args);
        Card WheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
        Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
        Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
        Card Bakery = new Card("Bakery", "B", "G", 1, 2, 3, 1);
        Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
        Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
        Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
        Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
        Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
        Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 12, 2);
        Card Cafe = new Card("Cafe", "U", "R", 2, 3, 1);
        Card FamilyRestaurant = new Card("Family Restaurant", "U", "R", 3, 9, 10, 2);
        Card Stadium = new Card("Stadium", "T", "P", 6, 6, 2);
        Card TVStation = new Card("TV Station", "T", "P", 7, 6, 5);
        Card BusinessCenter = new Card("Business Complex", "T", "P", 8, 6, 0);
        LandMark AmusementPark = new LandMark("Amusement Park");
        AmusementPark.setCost(16);
        LandMark CityHall = new LandMark("City Hall");
        CityHall.setCost(7);
        LandMark TrainStation = new LandMark("Train Station");
        TrainStation.setCost(4);
        LandMark ShoppingMall = new LandMark("Shopping Mall");
        ShoppingMall.setCost(10);
        LandMark RadioTower = new LandMark("Radio Tower");
        RadioTower.setCost(22);
        List<Card> phaseCards = new ArrayList<>();
        List<LandMark> phaseLandMarks = new ArrayList<>();
        Game game;
        int numPlayers = 0;
        String aiPlayers = "-ai";
        String phase = args[0];
        phaseCards = new ArrayList<>();
        phaseCards.add(WheatField);
        phaseCards.add(Ranch);
        phaseCards.add(Forest);

        if (args.length == 1 && phase.contains("phase1")){
            numPlayers = 2;
            aiPlayers = "";
            //System.out.println("p1 2p");
        }
        
        if (args.length == 2){
            if(args[1].equals("--ai")){
                numPlayers = 2;
            }else{
                numPlayers = Integer.parseInt(args[1]);
            }
            
        }

        /*
        if(args.length > 2){
           aiPlayers = args[2];
        }
        */
        
        
        if(phase.contains("phase0")){
            game = new Game(phase);
        }else if(phase.contains("phase1")){
            phaseLandMarks.add(CityHall);
        } else if (phase.contains("phase2")){
            phaseCards.add(Bakery);
            phaseCards.add(ConvenienceStore);
            phaseCards.add(Mine);
            phaseCards.add(AppleOrchard);
            phaseLandMarks.add(TrainStation);
            phaseLandMarks.add(CityHall);
        } else if (phase.contains("phase3")){
            phaseCards.add(Bakery);
            phaseCards.add(ConvenienceStore);
            phaseCards.add(Mine);
            phaseCards.add(AppleOrchard);
            phaseCards.add(CheeseFactory);
            phaseCards.add(FurnitureFactory);
            phaseCards.add(FarmersMarket);
            phaseLandMarks.add(TrainStation);
            phaseLandMarks.add(CityHall);
            phaseLandMarks.add(ShoppingMall);
        }
        else if(phase.contains("phase4")){
            phaseCards.add(Bakery);
            phaseCards.add(ConvenienceStore);
            phaseCards.add(Mine);
            phaseCards.add(FamilyRestaurant);
            phaseCards.add(AppleOrchard);
            phaseCards.add(CheeseFactory);
            phaseCards.add(FurnitureFactory);
            phaseCards.add(FarmersMarket);
            phaseCards.add(Cafe);
            phaseLandMarks.add(TrainStation);
            phaseLandMarks.add(ShoppingMall);
            phaseLandMarks.add(AmusementPark);
        }
        else if(phase.contains("phase5") || phase.contains("phase6")){
            phaseCards.add(Bakery);
            phaseCards.add(ConvenienceStore);
            phaseCards.add(Mine);
            phaseCards.add(FamilyRestaurant);
            phaseCards.add(AppleOrchard);
            phaseCards.add(CheeseFactory);
            phaseCards.add(FurnitureFactory);
            phaseCards.add(FarmersMarket);
            phaseCards.add(Cafe);
            phaseCards.add(Stadium);
            phaseCards.add(TVStation);
            phaseCards.add(BusinessCenter);
            phaseLandMarks.add(TrainStation);
            phaseLandMarks.add(ShoppingMall);
            phaseLandMarks.add(AmusementPark);
            phaseLandMarks.add(RadioTower);
        }
        /*
        if(args.length == 3 && args[2].contains("gui")){
            GameGui.main(args);
    
            

        }*///else{
            game = new Game(phase, numPlayers, aiPlayers, phaseCards, phaseLandMarks);
            GameNotifications notifications = new GameNotifications();
            notifications.GameStartNotification(game.getTurn());

            while(game.isOver() == false){
                //List<Card> cardsInMarket = market.getCardTypes();

                game.preRoll();
                game.rollCheck(game.scanner);
                //game.rollCheck();
                // game.rollCheck(game.scanner, game.getCurrentPlayer(), game.getTurn());
            
                

                if(game.getPlayer(game.getTurn()).getWallet() > 0){
                    game.buyPrompt();
                    //game.viewMenu();
                    game.purchaseEstablishmentLandmark();

                }


               
                if(game.isOver() == true){
                    break;
                }

                //n.endOfTurn(currentPlayerNum);
                //game.nextTurn();
                game.endTurn();
            }
            //String winner = String.format("Player %s is th winner!", game.getPlayer(game.getTurn()).getName());
            //System.out.println(winner);
            //s.close();
            game.gameWinner();
        
        }
   // }
            
           
    
}
