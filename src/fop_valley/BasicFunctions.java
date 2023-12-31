package fop_valley;
import java.util.Scanner;
import java.lang.*;
import test.*;
import testmonster.Monster;
import util.ReadSpellsUtil;

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
                System.out.println("Please Enter a Number Within the GivenRange as Choice and Nothing Else.");
            }
        }while(input > playerChoice || input < 1);
        return input;
    }

    public static void clearScreen(){
        for(int i = 0; i < 100; i++){
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
    public static void printInGameMenu(Archetypes player){
        clearScreen();
        printHeading("MENU");
        System.out.println("Choose an action:");
        System.out.println("[1] Continue Journey");
        System.out.println("[2] Current Status Of Your Character");
        System.out.println("[3] Save Data And Exit Game?");
        switch (readChoice("-->",3)){
            case 1:
                break;
            case 2:
                player.toString();
                break;
            case 3:
                //Add GameState Here
                break;
        }

    }
    public Archetypes startGame(){
        Archetypes player = new Archetypes();
        String playerSetName;
        boolean nameSet = false;
        clearScreen();
        //TODO Set Colour and Add ASCII Art Here
        printHeading("Adventurer,welcome to FOP Valley.");
        System.out.println("Made by Group ZEROBASEONE");
        continueGame();
        do{
            clearScreen();
            printHeading("Tell me your name: ");
            playerSetName = scanner.next();
            printHeading("Is your name " + playerSetName + " ?");
            System.out.println("[1] Yes!");
            System.out.println("[2] No I wanna change my name.");
            int input = readChoice("---> ",2);
            if(input == 1){
                player.setPlayerName(playerSetName);
                nameSet = true;
            }
        }while(!nameSet);
        continueGame();

        //print the story intro
        storyLine.printIntro();
        boolean characterSet = false;
        do{
            clearScreen();
            printHeading("Choose your Character: ");
            System.out.println("[1] Warrior");
            System.out.println(new Warrior());
            System.out.println(ReadSpellsUtil.getAbilitysByArchetypesName("Warrior"));
            lineSeperator();
            System.out.println("[2] Mage");
            System.out.println(new Mage());
            System.out.println(ReadSpellsUtil.getAbilitysByArchetypesName("Mage"));
            lineSeperator();
            System.out.println("[3] Rogue");
            System.out.println(new Rogue());
            System.out.println(ReadSpellsUtil.getAbilitysByArchetypesName("Rogue"));
            lineSeperator();
            System.out.println("[4] Paladin");
            System.out.println(new Paladin());
            System.out.println(ReadSpellsUtil.getAbilitysByArchetypesName("Paladin"));
            lineSeperator();
            System.out.println("[5] Archer");
            System.out.println(new Archer());
            System.out.println(ReadSpellsUtil.getAbilitysByArchetypesName("Archer"));
            int choice = readChoice("Your character is --->",5);
            switch (choice){
                case 1 :
                    player = new Warrior();
                    break;
                case 2:
                    player = new Mage();
                    break;
                case 3:
                    player = new Rogue();
                    break;
                case 4:
                    player = new Paladin();
                    break;
                case 5:
                    player = new Archer();
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
            printHeading("Is your character " + player.getName() + " ?");
            System.out.println("[1] Yes!");
            System.out.println("[2] No I wanna change my character.");
            int input = readChoice("---> ",2);
            if(input == 1)
                characterSet = true;
        }while(!characterSet);
        return player;
    }


}
