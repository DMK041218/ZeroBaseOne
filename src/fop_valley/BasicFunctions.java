package fop_valley;
import java.util.Scanner;
import java.lang.*;
import test.*;

public class BasicFunctions {

    static Scanner scanner = new Scanner(System.in);

    //Game Structure Functions
    public static int readChoice(String prompt,int playerChoice){
        int input;
        do{
            System.out.print(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch (Exception e){
                //abnormal input handling
                input = -1;
                System.out.println("Please Enter a Number Within the Given Range as Choice and Nothing Else.");
            }
        }while(input > playerChoice || input < 1);
        return input;
    }
    public static String readChoice(String prompt,String[] playerChoice){
        String input;
        boolean rightChoice = false;
        do{
            System.out.print(prompt);
            try{
                input = scanner.next();
                for(String choice : playerChoice){
                    if(input.equalsIgnoreCase(choice))
                        rightChoice = true;
                }
            }catch (Exception e){
                //abnormal input handling
                input = null;
                System.out.println("Please Enter Your Choice Within the Given Range and Nothing Else.");
            }
        }while(!rightChoice);
        return input;
    }

    public static void clearScreen(){
        for(int i = 0; i < 20; i++){
            System.out.println();
        }
    }

    public static void lineSeperator(){
        System.out.print("+");
        for(int i = 0; i < 30; i++){
            System.out.print("-");
        }
        System.out.print("+\n");
    }

    public static void continueGame(){
        System.out.println("Press any key to continue... ");
        scanner.next();
    }

    public static void printHeading(String str){
        lineSeperator();
        System.out.println(str);
        lineSeperator();
    }
    //Game Content Functions
    public GameState printBeginningMenu(){
        printHeading("MENU");
        System.out.println("[1]Start a new Journey");
        System.out.println("[2]Load Game");
        System.out.println("[3]Exit");
        switch(readChoice("-->",3)){
            case 1:
                Game game = new Game();
                game.startGame();
                return null;
            case 2 :
                GameState gamestate = new GameState();
                gamestate.loadGame();
                return gamestate;
            case 3 :
                System.exit(0);
            default:
                return null;
        }
    }
    public static void printInGameMenu(Archetypes player){
        clearScreen();
        printHeading("MENU");
        System.out.println("Choose an action:");
        System.out.println("[1] Continue Journey");
        System.out.println("[2] Current Status Of Your Character");
        System.out.println("[3] Save Data And Exit Game");
        switch (readChoice("-->",3)){
            case 1:
                return;
            case 2:
                System.out.println(player);
                continueGame();
                return;
           case 3:
                GameState saveGameState = new GameState();
                saveGameState.saveData(player);
                saveGameState.saveGame(saveGameState);
                System.exit(0);
        }

    }


}