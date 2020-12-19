package edu.wofford.machiwoco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.management.relation.Role;
import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.DefaultCaret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.Writer;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.parsers.FactoryConfigurationError;

import org.apache.logging.log4j.core.net.ssl.SslConfiguration;

//import javafx.scene.paint.Color;

import java.awt.*;
//import javax.swing.;

// import javafx.geometry.Dimension2D;
// import javafx.scene.control.Label;
// import javafx.scene.effect.Light.Point;
// // import javafx.scene.paint.Color;
// //import javafx.scene.paint.Color;
// import javafx.scene.layout.GridPaneBuilder;
// import javafx.scene.paint.Color;
// import javafx.stage.Window;

/**
 * This public class is the implementation of activation listeners for the GUI of the game.
 */
public class GameGui implements ActionListener {

    List<Card> phaseCards;
    List<LandMark> landmarks;

    private Card wheatField = new Card("Wheat Field", "W", "B", 1, 1, 1);
    private Card Ranch = new Card("Ranch", "C", "B", 1, 2, 1);
    private Card Forest = new Card("Forest", "G", "B", 3, 5, 1);
    private Card Bakery = new Card("Bakery", "B", "G", 1, 2, 3, 1);
    private Card ConvenienceStore = new Card("Convenience Store", "B", "G", 2, 4, 3);
    private Card Mine = new Card("Mine", "G", "B", 6, 9, 5);
    private Card FamilyRestaurant = new Card("Family Restaurant", "U", "R", 3, 9, 10, 2); 
    private Card AppleOrchard = new Card("Apple Orchard", "W", "B", 3, 10, 3);
    private Card CheeseFactory = new Card("Cheese Factory", "F", "G", 5, 7, 3);
    private Card FurnitureFactory = new Card("Furniture Factory", "F", "G", 3, 8, 3);
    private Card FarmersMarket = new Card("Farmers Market", "O", "G", 2, 11, 12, 2);
    private Card Cafe = new Card("Cafe", "U", "R", 2, 3, 1);
    private Card Stadium = new Card("Stadium", "T", "P", 6, 6, 2);   
    private Card TvStation = new Card("TV Station", "T", "P", 7, 6, 5);
    private Card BusinessComplex = new Card("Business Complex", "T", "P", 8, 6, 0);

    private static JFrame window;
    private int turn;
    private static JLabel turnLabel;
    private static Game game;
    private static Market market;
    private static JTextArea gameLog;
    private static JPanel marketPanel;
    private static JPanel cardsOnDisplay;
    private static JPanel playerMarketOptions;
    private static JPanel playerInfoPanel;
    private static boolean playerHasPurchased;
    private static JPanel otherPlayerInfoPanel;

    private static PrintWriter writer;
    private static Scanner scanner;
    private static GameMenu gameMenu;
    private static GameNotifications notifications;

    public GameGui() {
        gameMenu = new GameMenu();
        notifications = new GameNotifications();

        phaseCards = new ArrayList<>();
        phaseCards.add(wheatField);
        phaseCards.add(Ranch);
        phaseCards.add(Forest);
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
        phaseCards.add(TvStation);
        phaseCards.add(BusinessComplex);


        LandMark trainStation = new LandMark("Train Station");
        LandMark shoppingMall = new LandMark("Shopping Mall");
        LandMark amusementPark = new LandMark("Amusement Park");
        LandMark radioTower = new LandMark("Radio Tower");

        trainStation.setCost(4);
        shoppingMall.setCost(10);
        amusementPark.setCost(16);
        radioTower.setCost(22);

        landmarks = new ArrayList<>();
        // landmarks.add(new LandMark("City Hall"));
        landmarks.add(trainStation);
        landmarks.add(shoppingMall);
        landmarks.add(amusementPark);
        landmarks.add(radioTower);

        //scanner = new Scanner(System.in);
        game = new Game("phase6", 2, "", phaseCards, landmarks);
        //scanner = game.getGameScanner();
        //game.setGameScanner(scanner);
        market = game.getMarket();

        window = new JFrame();

        playerInfoPanel = new JPanel();
        // panel.setBackground(Color.rgb(red, green, blue));
        playerInfoPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        playerInfoPanel.setLayout(new GridLayout(0, 1));
        playerInfoPanel.setBackground(Color.RED);

        turnLabel = new JLabel("Turn Number: ");

        JButton button = new JButton();
        button.addActionListener(this);
        button.setBounds(50, 50, 10, 10);
        button.setPreferredSize(new Dimension(10, 10));
        // button.setLayout(new BorderLayout());

        playerInfoPanel.add(turnLabel);
        playerInfoPanel.add(button, BorderLayout.NORTH);

        marketPanel = new JPanel();
        marketPanel.setBackground(Color.lightGray);
        // marketPanel.setLayout(new FlowLayout());
        GridLayout gridLayout = new GridLayout(2, 0); // 2,12
        marketPanel.setLayout(gridLayout);
        // marketPanel.setLayout(new GridBagLayout());
        // GroupLayout gLayout = new GroupLayout(marketPanel);
        // marketPanel.setLayout(gLayout);
        // gLayout.setAutoCreateGaps(true);
        // marketPanel.setLayout(new BoxLayout(marketPanel, BoxLayout.LINE_AXIS));
        // marketPanel.setLayout(new BorderLayout());
        cardsOnDisplay = new JPanel();
        JLabel lb = new JLabel("Cards in the market:");
        cardsOnDisplay.add(lb);
        cardsOnDisplay.setBackground(Color.CYAN);
        // j.setLayout(new BorderLayout());
        // j.add(lb, BorderLayout.CENTER);

        // j.setLayout(new BorderLayout());
        marketPanel.add(cardsOnDisplay, BorderLayout.PAGE_START);
        JTabbedPane selection = new JTabbedPane();
        selection.setSize(100, 50);
        Component component;
        JPanel p = new JPanel();
        selection.addTab("tab1", p);
        // marketPanel.add(selection);
        JPanel k = new JPanel();
        k.setBackground(Color.magenta);
        // marketPanel.add(k, BorderLayout.PAGE_END);
        cardsOnDisplay.setMinimumSize(new Dimension(200, 200));
        cardsOnDisplay.setPreferredSize(new Dimension(300, 300));
        // j.setAlignmentX(alignmentX);
        JScrollPane marketDisplay = new JScrollPane();
        playerMarketOptions = new JPanel();
        playerMarketOptions.add(new JLabel("Cards Available To Buy:"));
        // marketDisplay.add(new JButton("Card"));
        // marketDisplay.add(new JButton("Card"));
        // container.add(new JButton("Card"));
        marketDisplay.setMaximumSize(new Dimension(100, 100));
        marketDisplay.setPreferredSize(new Dimension(50, 50));
        marketDisplay.setBackground(Color.green);
        // marketDisplay.add(new Label("Cards Available To Purchase:"));
        // marketDisplay.add(container);
        // marketPanel.add(marketDisplay);
        marketPanel.add(playerMarketOptions);
        // marketPanel.setLayout(new FlowLayout());
        cardsOnDisplay.setLayout(new FlowLayout());

        market = game.getMarket();
        List<Card> cardsInMarket = market.getCardTypes();
        List<JButton> displayButtons = new ArrayList<>();
        Map<String, Integer> stock = market.getMarketStock();
        JButton b;
        System.out.println(cardsInMarket.size());
        for (Card card : cardsInMarket) {
            b = new JButton();
            String name = card.getName();
            String numAvailable = String.format(" Number Available To Buy: %d", stock.get(name));
            String info = "<html>" + name + "<br>" + numAvailable + "<html>";
            String lbl = "<html>" + "This label" + "<br>" + "is in two lines" + "</html>";

            b.setText(info);
            // b.setActionCommand("a");
            b.setBackground(Color.CYAN);

            // b.setPreferredSize(new Dimension(150, 170));

            // b.setMinimumSize(new Dimension(50,80));

            // marketPanel.add(b, BorderLayout.CENTER);
            // marketPanel.add(b);
            // gLayout.addLayoutComponent(b, gLayout.createParallelGroup());

            // marketPanel.add(b, GridBagConstraints.CENTER);
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.LAST_LINE_END;
            JLabel l = new JLabel(name);
            // j.add(l);
            cardsOnDisplay.add(b);
            // marketDisplay.add(b);
            // marketPanel.add(l, GridBagConstraints.anchor);

            // container.add(b);

            // marketDisplay.add(b);
            // marketPanel.add(b);
            // marketDisplay.setHorizontalScrollBar(new JScrollBar());

        }
        for (int i = 0; i < cardsInMarket.size(); i++) {
            JButton btn = new JButton("jaljdf");
            // Card card = cardsInMarket.get(i);
            // String name = card.getName();
            // btn.setText(name);
            // j.add(btn);
            marketDisplay.add(btn);
            marketDisplay.setName("CArds to buy");
        }
        // marketPanel.add(marketDisplay);

        // j.add(new JButton("Button"));
        gridLayout.setVgap(15); // Market panel distance setting
        // gridLayout.setRows(rows);

        JPanel logPanel = new JPanel();
        logPanel.setBackground(Color.YELLOW);

        otherPlayerInfoPanel = new JPanel();
        otherPlayerInfoPanel.setBackground(Color.orange);
        otherPlayerInfoPanel.setSize(100, 300);
        otherPlayerInfoPanel.setMinimumSize(new Dimension(100, 500));
        JLabel l = new JLabel("Other Players");
        l.setSize(200, 400);
        otherPlayerInfoPanel.add(l);

        JPanel leftPane = new JPanel();
        leftPane.setBackground(Color.GREEN);

        JScrollPane log = new JScrollPane();
        log.setPreferredSize(new Dimension(200, 300));
        log.setAutoscrolls(true);

        gameLog = new JTextArea();
        gameLog.append("This is the Game Log\n");
        DefaultCaret caret = (DefaultCaret)gameLog.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        log.setViewportView(gameLog);

        logPanel.add(log);
        

        window.add(playerInfoPanel, BorderLayout.PAGE_END);
        // window.add(panel, BorderLayout.BEFORE_FIRST_LINE);
        window.add(marketPanel, BorderLayout.CENTER);
        window.add(logPanel, BorderLayout.LINE_END);
        window.add(otherPlayerInfoPanel, BorderLayout.PAGE_START);
        window.add(leftPane, BorderLayout.LINE_START);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Machi Woco");
        window.pack();
        window.setVisible(true);
        window.setSize(800, 800);

        // window.setLocation();
        playerHasPurchased = false;

        JScrollPane scrollPane = new JScrollPane();
        otherPlayerInfoPanel.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(150, 300));
        JButton btn = new JButton("bkfakld");
        btn.setPreferredSize(new Dimension(45, 90));
        scrollPane.add(btn);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.add(new JLabel("kljflkajkldjalkjf"));
        JPanel jp = new JPanel();
        jp.setBackground(Color.BLUE);
        scrollPane.add(jp);
        scrollPane.setViewportView(jp);
        scrollPane.setOpaque(true);
        scrollPane.add(new JButton("b"));
        // JViewport v = new JViewport();
        // scrollPane.add(comp, constraints);
        jp.setLayout(new GridLayout(3, 0));
        jp.add(btn);
        jp.add(new JButton());

        // zero, one more, one less

        writer = new PrintWriter(System.out, true);
    }

    public static void main(String[] args) {
        new GameGui();
        // PrintWriter writer = new PrintWriter(System.out);

        // old code
        // while (game.isOver() == false) {
        //     turnLabel.setText("The Turn is: " + game.getTurn());
        //     playerHasPurchased = false;

        //     // List<Card> cardsInMarket = market.getCardTypes();

        //     game.preRoll();
        //     // game.rollCheck();

        //     Player curPlayer = game.getCurrentPlayer();
        //     // if (curPlayer.hasBuilt("Train Station") == true && curPlayer.isAi() == false) {
        //     //     // diceRoll(curPlayer);
        //     //     System.out.println("The ai player shouldn't be in here");
        //     //     // game.rollCheck();
        //     // } else {
        //     //     game.rollCheck();
        //     //     System.out.println("The ai player has their cards checked");
        //     //     writer.write("The printwriter works here");
        //     //     //writer.flush();
        //     // }

        //     game.rollCheck();
            
        //     // game.rollCheck(game.scanner, game.getCurrentPlayer(), game.getTurn());

        //     if (game.getPlayer(game.getTurn()).getWallet() > 0) {
        //         game.buyPrompt();
        //         // game.viewMenu();
        //         // game.purchaseEstablishmentLandmark();

        //         //Player curPlayer = game.getCurrentPlayer();
        //         if (curPlayer.getNum() == 1) { // curPlayer.isAi();
        //             updatePlayerMarketOptions(curPlayer);
                    
        //             // window.wait();
        //             game.purchaseEstablishmentLandmark();

        //         } else {
        //             System.out.println("Player 2's buy prompt and purchase");
        //             game.purchaseEstablishmentLandmark();
        //         }

        //     }

        //     if (game.isOver() == true) {
        //         break;
        //     }

        //     // n.endOfTurn(currentPlayerNum);
        //     // game.nextTurn();

        //     //Player curPlayer = game.getCurrentPlayer();
        //     if (curPlayer.isAi() == true) {
        //         updateOtherPlayersInfo();
        //         game.endTurn();

        //     }

        //     if (curPlayer.getNum() == 1) {
        //         updatePlayerInfo(curPlayer);
        //         // ActionListener
        //         updateMarket();
        //         game.endTurn();

        //     }
        // }
        // game.gameWinner();
        //old code with while loop


        //     // while (curPlayer.isAi() == false && playerHasPurchased == false) {
        //     //     // System.out.println(5);
        //     //     try {
        //     //         window.wait();
        //     //         ;
        //     //     } catch (InterruptedException e) {
        //     //         // TODO Auto-generated catch block
        //     //         e.printStackTrace();
        //     //     }
        //     // }

        // }

        
        // New code, need to uncomment
        Player curPlayer = game.getPlayer(1);
       // game.preRoll();
        //game.rollCheck();
        GameNotifications notifications = new GameNotifications();
        notifications.GameStartNotification(game.getTurn());

        if(game.getCurrentPlayer().isAi() == true){
            game.preRoll();
            //text.append(output);
            //text.append("");
            gameLog.append(notifications.GameStartNotification(game.getTurn()) + "\n");
            List<String> output = game.rollCheck(new Scanner(System.in));
            for(String s : output){
                gameLog.append(s + "\n");
            }

            game.purchaseEstablishmentLandmark();
            game.endTurn();
        }
        // New code


        //Player curPlayer = game.getPlayer(1);
        updateMarket();
        updatePlayerMarketOptions(curPlayer);
        updatePlayerInfo(curPlayer);
        updateOtherPlayersInfo();
        
      
        // while(game.isOver() == false){
        //     if(game.isOver() == true){
        //         game.gameWinner();
        //         int turn = game.getTurn();
        //         curPlayer = game.getCurrentPlayer();
        //         String winner = String.format("Player %d won the game!", curPlayer.getNum());
        //         JOptionPane.showMessageDialog(window, winner);
        //         break;
        //     }
        // }

        // game = new Game(phase, numPlayers, aiPlayers, phaseCards, phaseLandMark)
        // JFrame window =new JFrame();//creating instance of JFrame

        // JButton b=new JButton("click");//creating instance of JButton
        // b.setBounds(130,100,100, 40);//x axis, y axis, width, height

        // window.add(b);//adding button in JFrame

        // window.setSize(400,500);//400 width and 500 height
        // window.setLayout(null);//using no layout managers
        // window.setVisible(true);//making the frame visible
        // window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        turn = game.getTurn();
        // game.preRoll();
        // game.rollCheck();
        // if(game.getPlayer(turn).isAi() == true){

        // }
        System.out.println(turn);
        turnLabel.setText("Turn Number: " + turn);

    }

    public static void setButtonColorToCardColor(JButton button, Card card){
        
        if(card.getColor() == "B"){
            button.setBackground(Color.cyan);
        }else if(card.getColor() == "G"){
            button.setBackground(Color.GREEN);
        }else if(card.getColor() == "R"){
            button.setBackground(Color.red);
        }else if(card.getColor() == "P"){
            button.setBackground(Color.magenta); //138,43,226
        }

    }

    public static void updateOtherPlayersInfo(){
        List<Player> playerList = game.getPlayers();
        JScrollPane playerInfo;
        JPanel playerProperties;
        JButton button;
        JLabel nameAndMoney;
        otherPlayerInfoPanel.removeAll();

        for(Player player : playerList){
            if(player.isAi() == true){
                List<Card> cards = player.getTableau().getCardTypes();
                gameMenu.sortByActNum(cards);

                List<LandMark> landmarks = player.getTableau().getLandmarks();

                playerInfo = new JScrollPane();
                playerInfo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                playerInfo.setMaximumSize(new Dimension(150,200));
                playerInfo.setPreferredSize(new Dimension(175,200));

                playerProperties = new JPanel();
                GridLayout gridLayout = new GridLayout(cards.size() + 5, 0);
                playerProperties.setLayout(gridLayout);

                String name = "Player " + player.getName();
                String coins = " Coins: " + player.getWallet();
                nameAndMoney = new JLabel(name + coins);
                playerProperties.add(nameAndMoney);
                playerProperties.setMaximumSize(new Dimension(100,200));

                button = new JButton();


                for(Card card : cards){
                    String cardName = card.getName();
                    int cardNumber = player.getTableau().getNumberOfSpecifiedCards(cardName);
                    String numInHand = String.format("Number in tableau: %d", cardNumber);
                    String info = "<html>" + cardName + "<br>" + numInHand + "<html>";

                    button = new JButton(info);
                    setButtonColorToCardColor(button, card);
                    playerProperties.add(button);
                    //playerInfo.add(button);
                }

                for(LandMark lm : landmarks){
                    name = lm.getName();

                    button = new JButton(name);
                    if(lm.isBuilt() == true){
                        button.setText(name + ": Constructed");
                    }

                    button.setBackground(Color.ORANGE);
                    
                    //LandMarkButtonClicked al = new LandMarkButtonClicked(window, player, name);
                    //button.addActionListener(al);

                    playerProperties.add(button);
                }

                playerInfo.setViewportView(playerProperties);
                //playerInfo.setViewportView(playerInfo);
                otherPlayerInfoPanel.add(playerInfo);
            }
        }
        //
    }

    public static void updateMarket() {
        List<Card> cardsInMarket = market.getCardTypes();
        Map<String, Integer> stock = market.getMarketStock();
        cardsOnDisplay = new JPanel();
        cardsOnDisplay.add(new JLabel("Cards Available In The Market:"));

        for (Card card : cardsInMarket) {
            JButton b = new JButton();
            String name = card.getName();
            String numAvailable = String.format(" Number Available To Buy: %d", stock.get(name));
            String info = "<html>" + "<br>" + name + "<br>" + numAvailable + "<html>";

            b.setText(info);
            // b.setActionCommand("a");
            b.setBackground(Color.CYAN);
            b.setPreferredSize(new Dimension(150, 170));
            // b.setMinimumSize(new Dimension(50,80));
            MarketButtonClicked c = new MarketButtonClicked(market, card);
            b.addActionListener(c);
            setButtonColorToCardColor(b, card);
            //b.setAction(a);

            if (stock.containsKey(name)) { // stock.get(name) > 0 && 
                cardsOnDisplay.add(b);
            }

        }
        marketPanel.remove(0);
        marketPanel.add(cardsOnDisplay, 0);
        marketPanel.repaint();
        marketPanel.revalidate();

    }

    public static void updatePlayerMarketOptions(Player curPlayer) {
        List<Card> cardsInMarket = market.getCardTypes();
        Map<String, Integer> stock = market.getMarketStock();
        playerMarketOptions = new JPanel();
        PurchaseButtonClicked al;
        JLabel label = new JLabel("Card Available To Buy:");
        playerMarketOptions.add(label);

        for(Card card : cardsInMarket){
            String name = card.getName();
            int cost = card.getCost();
            al = new PurchaseButtonClicked(game, market, curPlayer, card, writer, gameLog);

            if(curPlayer.getWallet() >= cost && stock.containsKey(name)){ // stock.get(name) > 0
                JButton button = new JButton();

                button.setText(name);
                button.addActionListener(al);
                setButtonColorToCardColor(button, card);

                if(card.getColor() != "P"){
                    playerMarketOptions.add(button);
                }else if(!curPlayer.hasCard(card)){
                    playerMarketOptions.add(button);
                }
            }
                
        }


        marketPanel.remove(1);
        marketPanel.add(playerMarketOptions, 1);
        marketPanel.repaint();
        marketPanel.revalidate();

    }

    public static void updatePlayerInfo(Player player){
        window.remove(playerInfoPanel);

        List<Card> playerCards = player.getTableau().getCardTypes();
        playerCards = gameMenu.sortByActNum(playerCards);

        List<LandMark> landmarks = player.getLandmarks();
        playerInfoPanel = new JPanel();
        playerInfoPanel.setBackground(Color.red);
        //playerInfoPanel.setPreferredSize(new Dimension(200, 400));

        playerInfoPanel.setMinimumSize(new Dimension(200,200));

        //playerInfoPanel.removeAll();
        playerInfoPanel.setLayout(new GridLayout(3,3));

        JPanel playerNameAndMoney = new JPanel();
        GridLayout layout = new GridLayout(0, 1);
        layout.setHgap(5);
        playerNameAndMoney.setLayout(layout);

        JLabel playerName = new JLabel("Player " + player.getNum() + " Coins: " + player.getWallet());
        //JLabel moneyAmount = new JLabel("Coins: " + player.getWallet());
        JButton doNothing = new JButton("Skip Turn");

        doNothing.addActionListener(new SkipButtonClicked(game, player, gameLog));

        playerNameAndMoney.add(playerName);
        //playerNameAndMoney.add(moneyAmount);
        playerNameAndMoney.add(doNothing);

        playerInfoPanel.add(playerNameAndMoney);

        JPanel playerTableauInfo = new JPanel();
        for(Card card : playerCards){
            String name = card.getName();
            String numInHand = String.format("Number In Tableau: %d", player.getNumEstablishment(name));
            String info = "<html>" + name + "<br>" + numInHand + "<html>";

            JButton button = new JButton();
            button.setText(info);
            setButtonColorToCardColor(button, card);

            //playerInfoPanel.add(button);
            playerTableauInfo.add(button);

        }
        playerInfoPanel.add(playerTableauInfo);

        JPanel landmarkInfo = new JPanel(new GridLayout(1,4));

        for(LandMark lm : landmarks){
            String name = lm.getName();

            JButton button = new JButton();

            if(player.hasBuilt(name) == true){
                button.setText(name + ": Constructed");
            }else{
                button.setText(name);
            }

            button.setBackground(Color.YELLOW);

            
            button.addActionListener(new LandMarkButtonClicked(window, player, name, gameLog));

            //playerInfoPanel.add(button);
            landmarkInfo.add(button);

        }
        playerInfoPanel.add(landmarkInfo);

        //window.remove(playerInfoPanel);
        playerInfoPanel.repaint();
        playerInfoPanel.revalidate();
        window.add(playerInfoPanel, BorderLayout.PAGE_END);

        //window.remove(index);


    }

    public static void tvStationActivationCheck(Player curPlayer, int diceTotal){
        System.out.println("Goes into the tv station function");
         List<Card> activatedCards = curPlayer.checkCards(diceTotal, game.getTurn());
        List<Player> players = game.getPlayers();
        //List<String> options = new ArrayList<>();
        String[] options = new String[players.size()];

        for(int i = 0; i < players.size(); i++){
            Player player = players.get(i);
            if(player.getWallet() > 0 && player != curPlayer){
                String s = "Player " + player.getNum();
                options[i] = s;
            }
        }
        
        System.out.println("After the for loop for the function");

        int choice = JOptionPane.showOptionDialog(window, "Chose a player to target", "TV Station Menu", JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE, null, options, null);
        writer.println(choice + 1);
        String c = String.valueOf(choice + 1);
        System.out.println("This is the player's choice: " + c);
        game.setGameScanner(new Scanner(c));
        updateOtherPlayersInfo();

        System.out.println("After the window pop up");
        
        // for(Card card : activatedCards){
        //     String cardName = card.getName();
        //     if(cardName.equals("TV Station")){
        //         int choice = JOptionPane.showOptionDialog(window, "Chose a player to target", "TV Station Menu", JOptionPane.YES_NO_OPTION, 
        //             JOptionPane.QUESTION_MESSAGE, null, options, null);
        //         writer.println(choice + 1);
        //         String c = String.valueOf(choice + 1);
        //         System.out.println("This is the player's choice: " + c);
        //         game.setGameScanner(new Scanner(c));
        //         updateOtherPlayersInfo();

        //     }else if(cardName.equals("Business Complex")){

        //     }
        // }

    }

    public static void diceRoll(Player curPlayer) {
        Dice dice = new Dice();
        PrintWriter writer = new PrintWriter(System.out);
        Object[] options = { "1 die", "2 dice" };
        Object howManyDiceToRollMessage = "Do you want to roll 1 or 2 dice";
        int diceTotal = 0;
        int roll1 = 0;
        int roll2 = 0;

        game.preRoll();
        System.out.println("Yes, it does go into the dice roll function");

        if (curPlayer.hasBuilt("Train Station")) {
                
                
                int choice = JOptionPane.showOptionDialog(window, howManyDiceToRollMessage, "Dice Roll Menu",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                System.out.println(choice);
                
                //game.buyPrompt();
                // If the player wants to roll one die
                if (choice == 0) {
                    //diceTotal = dice.roll();
                    roll1 = dice.roll();
                    //writer.write("1");

                // If the player wants to roll two dice
                } else {
                    //diceTotal = dice.roll() + dice.roll();
                    roll1 = dice.roll();
                    roll2 = dice.roll();
                    //writer.write("2");
                    ///writer.println(2);
                    //writer.flush();
            }
            //game.rollCheck();

        } else {
            //game.preRoll();
            //diceTotal = dice.roll();
            roll1 = dice.roll();
            //game.rollCheck();
            //game.buyPrompt();
        }

        if(curPlayer.hasBuilt("Radio Tower")){

            if(curPlayer.hasBuilt("Train Station")){
                int choice = JOptionPane.showConfirmDialog(window, "Do you want to re roll the dice?", "Radio Tower Menu", 
                    JOptionPane.YES_NO_OPTION);
                if(choice == 0){
                    choice = JOptionPane.showOptionDialog(window, howManyDiceToRollMessage, "Dice Roll Menu",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                    
                    // If the player wants to roll 1 die
                    if(choice == 0){
                        //diceTotal = dice.roll();
                        roll1 = dice.roll();
                    }else{
                        //diceTotal = dice.roll() + dice.roll();
                        roll1 = dice.roll();
                        roll2 = dice.roll();
                    }
                
                }
            // If the player has built the Radio Tower, but not the Train station
            }else{
                int choice = JOptionPane.showConfirmDialog(window, "Do you want to re roll the dice?", "Radio Tower Menu", 
                    JOptionPane.YES_NO_OPTION);

                if(choice == 0){
                    //diceTotal = dice.roll();
                    roll1 = dice.roll();
                }

            }
        }

        String output;
        if(roll2 == 0){
            output = notifications.rollNotification(curPlayer.getNum(), roll1);
        }else{
            output = notifications.rollNotification(curPlayer.getNum(), roll1, roll2);
        }
        
        gameLog.append(output + "\n");

        game.setExtraTurn(false);
        diceTotal = roll1 + roll2;
        if(roll1 == roll2){
            game.setExtraTurn(true);
            output = "The Amusement Park was activated for Player " + curPlayer.getNum();
            gameLog.append(output + "\n");
        }

        System.out.println("The player rolled " + diceTotal);

        // List<Card> activatedCards = curPlayer.checkCards(diceTotal, game.getTurn());
        
        
        // for(Card card : activatedCards){
        //     String cardName = card.getName();
        //     if(cardName.equals("TV Station")){
        //         int choice = JOptionPane.showOptionDialog(window, "Chose a player to target", "TV Station Menu", JOptionPane.YES_NO_OPTION, 
        //             JOptionPane.QUESTION_MESSAGE, null, options, null);
        //         writer.println(choice + 1);
        //         String c = String.valueOf(choice + 1);
        //         System.out.println("This is the player's choice: " + c);
        //         game.setGameScanner(new Scanner(c));
        //         updateOtherPlayersInfo();

        //     }else if(cardName.equals("Business Complex")){

        //     }
        // }
        List<Player> players = game.getPlayers();
        //List<String> options = new ArrayList<>();
        String[] playerChoiceOptions = new String[players.size()];

        for(int i = 0; i < players.size(); i++){
            Player player = players.get(i);
            if(player.getWallet() > 0 && player != curPlayer){
                String s = "Player " + player.getNum();
                playerChoiceOptions[i] = s;
            }
        }

        List<String> cardActivationNotifications = game.checkPlayerCards(diceTotal, game.getTurn());
        for(String str : cardActivationNotifications){
            gameLog.append(str + "\n");
        }

         List<Card> activatedCards = curPlayer.checkCards(diceTotal, game.getTurn());
        String[] arr = {"1", "2", "3"};
        for(Card card : activatedCards){
            String cardName = card.getName();
            String logOutput = String.format("The %s was activated for Player %d", cardName, curPlayer.getNum());
            //gameLog.append(logOutput + "\n");
            if(cardName.equals("TV Station")){
               
                JMenu menu;
                JPopupMenu m = new JPopupMenu();
                m.show(window, 10, 100);
                int choice = JOptionPane.showOptionDialog(window, "Chose a player to target", "TV Station Menu", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, arr, null);
                writer.println(choice + 1);
                String c = String.valueOf(choice + 1);
                System.out.println("This is the player's choice: " + c);
                game.setGameScanner(new Scanner(c));
                updateOtherPlayersInfo();

                //tvStationActivationCheck(curPlayer, diceTotal);

            }else if(cardName.equals("Business Complex")){

            }
        }


        game.buyPrompt();
        updatePlayerInfo(curPlayer);
        updateOtherPlayersInfo();
        //
    }

    public static void updateGame() {
        //game.endTurn();
        List<Player> aiPlayers  = new ArrayList<>();
        for(Player player : game.getPlayers()){
            if(player.isAi() == true){
                aiPlayers.add(player);
            }
        }
        System.out.println("The number of ai players is " + aiPlayers.size());
        for(Player player : aiPlayers){
            System.out.println("Player " + player.getNum() + "is in the ai list");
        }

        while(game.getCurrentPlayer().isAi() == true){
            Player player = game.getCurrentPlayer();
            
            System.out.println("The current Player is " + game.getCurrentPlayer().getNum());
            if(player.isAi() == true){
                System.out.println("And the player is an ai");
            }else{
                System.out.println("and the player isn't an ai. isAi value: " + player.isAi());
            }

            if(player.isAi() == true && game.getTurn() == player.getNum()){
                String s = game.preRoll();
                List<String> st = game.rollCheck(new Scanner(System.in));
                game.buyPrompt();

                //gameLog.append(s + "\n");
                for(String str : st){
                    System.out.println("This the stuff from the roll check: " + str );
                    gameLog.append(str + "\n");
                }

                if(player.getWallet() > 0 && player.isAi() == true){
                    System.out.println("The player is player " + player.getNum());
                    String purchaseChoice = game.purchaseEstablishmentLandmark();
                    gameLog.append("This is where the ai player purchase notification should go" + "\n");
                    gameLog.append(purchaseChoice + "\n");
                }

                if(game.isOver() == true){
                    JOptionPane.showMessageDialog(window, "Player " + game.getCurrentPlayer().getName() + " won the game!");
                }

                updateOtherPlayersInfo();
                gameLog.append("The turn ended for Player " + player.getNum() + "\n");
                game.endTurn();
                

            }
        }


        // System.out.println("The current Player is " + game.getCurrentPlayer().getNum());
        // game.nextTurn();
        // game.preRoll();
        // game.rollCheck();
        // game.buyPrompt();
        // Player curPlayer = game.getCurrentPlayer();
        // System.out.println("The current Player is " + game.getCurrentPlayer().getNum());
        // if (game.getCurrentPlayer().isAi() == true && curPlayer.getWallet() > 0) {
        //     game.purchaseEstablishmentLandmark();
        // }

        // if (game.isOver() == true) {
        //     JOptionPane.showMessageDialog(window, "Player " + game.getCurrentPlayer().getName() + " won the game!");
        // }

        // updateOtherPlayersInfo();
        // game.endTurn();


        Player curPlayer = game.getCurrentPlayer();
        System.out.println("The current Player is " + game.getCurrentPlayer().getNum());
        System.out.println("This is past the ai player for loop");
        diceRoll(curPlayer);
        if (curPlayer.getWallet() == 0) {
            game.endTurn();
        } else if(curPlayer.isAi() == false){
            //diceRoll(curPlayer);
        }

        //updatePlayerMarketOptions(curPlayer);



    }

/**
 * This class is embedded is the GameGui class.
* It handles the entirity of the market when the button is clicked.
 */

    public static class MarketButtonClicked implements ActionListener{
        private Market market;
        private Card card;
        private Player player;

        public MarketButtonClicked(Market market, Card card){
            this.market = market;
            this.player = player;
            this.card = card;

        }


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            JOptionPane.showMessageDialog(window, card.getName() + " was clicked");
            //JOptionPane.showInputDialog(window, "Click here ");

        }
        
    }
/**
 * This class is embedded is the GameGui class.
 * It handles the purchasing of the establishments when the button is clicked.
 */
    public static class PurchaseButtonClicked implements ActionListener{
        private Market market;
        private Card card;
        private Player player;
        private Game game;
        PrintWriter writer;
        private JTextArea gameLog;

        public PurchaseButtonClicked(Game game, Market market, Player player, Card card, PrintWriter writer, JTextArea gameLog){
            this.game = game;
            this.market = market;
            this.player = player;
            this.card = card;
            this.writer = writer;
            this.gameLog = gameLog;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String name = card.getName();

            market.purchase(name);
            player.purchase(card);
            String output = String.format("Player %d purchased the %s", player.getNum(), name);
            System.out.println(output);

            updatePlayerInfo(player);
            updatePlayerMarketOptions(player);
            updateMarket();

            playerHasPurchased = true;

            //System.out.println(game.getTurn());
            //game.nextTurn();
            //System.out.println(game.getTurn());
            //window.notify();

            // game.preRoll();
            // game.rollCheck();

            gameLog.append(output + "\n");
            game.endTurn();
            updateGame();
            //writer.print(1);
            // writer.write(1);
            // writer.flush();

            //game.endTurn();

        }


    }
    /**
     * This class is embedded is the GameGui class.
    * It handles the skipping of a turn when the button is clicked.
     */
    
    public static class SkipButtonClicked implements ActionListener{
        private Game game;
        private Player player;
        private JTextArea gameLog;


        public SkipButtonClicked(Game game, Player player, JTextArea gameLog){
            this.game = game;
            this.player = player;
            this.gameLog = gameLog;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String output = String.format("Player %d skipped their turn", player.getNum());
            gameLog.append(output + "\n");
            game.endTurn();
            updateGame();
            //game.nextTurn();
            updateMarket();
            updatePlayerInfo(player);
            updatePlayerMarketOptions(player);

        }



    }
    /**
     * This class is embedded is the GameGui class.
    * It handles the LandMarks when the button is clicked.
     */

    public static class LandMarkButtonClicked implements ActionListener{
        private Player player;
        private String landmarkName;
        private JFrame window;
        private LandMark landMark;
        private JTextArea gameLog;

        public LandMarkButtonClicked(JFrame window, Player player, String landmarkName, JTextArea gameLog){
            this.window = window;
            this.player = player;
            this.landmarkName = landmarkName;
            landMark = player.getTableau().getSpecifiedLandmark(landmarkName);
            this.gameLog = gameLog;

        }


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            //if(pl)
            //JOptionPane.YES_NO_OPTION;
            //JOptionPane.showInputDialog(window, JOptionPane.YES_NO_OPTION);
            

            if(player.getWallet() >= landMark.getCost()){
                int choice = JOptionPane.showConfirmDialog(window, "Do you want to build the " + landmarkName, "Construction Window",
                    JOptionPane.YES_NO_OPTION);
                    System.out.println(choice);

                if(choice == 0){
                    player.construct(landmarkName);
                    String winnerMessage = String.format("Player %d won the game!", player.getNum());

                    if(game.isOver()){
                        JOptionPane.showMessageDialog(window, winnerMessage);
                    }else{
                        String output = String.format("Player %d constructed the %s", player.getNum(), landMark.getName());
                        gameLog.append(output);
                        updateGame();
                        updatePlayerInfo(player);
                        updateMarket();
                        updatePlayerMarketOptions(player);
                    }
                }

            }else{
                JOptionPane.showMessageDialog(window, "Insufficient funds to purchse this landmark");
            }
            

        }

    }



    //
    
}
