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
    public static void printMenu(){
        clearScreen();
        printHeading("MENU");
        System.out.println("Choose an action:");
        System.out.println("[1] Come on let's continue on our journey!");
        System.out.println("[2] Current status of your character");
        System.out.println("[3] Oh you wanna exit game?");


    }
    public Archetypes startGame(){
        Archetypes player = new Archetypes();
        String playerName;
        boolean nameSet = false;
        clearScreen();
        //TODO Set Colour and Add ASCII Art Here
        printHeading("Adventurer,welcome to FOP Valley.");
        System.out.println("Made by Group ZEROBASEONE");
        continueGame();
        do{
            clearScreen();
            printHeading("Tell me your name: ");
            playerName = scanner.next();
            printHeading("Is your name " + playerName + " ?");
            System.out.println("[1] Yes!");
            System.out.println("[2] No I wanna change my name.");
            int input = readChoice("---> ",2);
            if(input == 1)
                nameSet = true;
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

    public void showPlayerStatus(Archetypes player) {
        System.out.println(player.getName());
        System.out.println("-->" + "HP: [");

        int HPratio = (int) Math.ceil((player.getShowHP() / 30) * (player.getHealthPoints() / player.getShowHP()));
        for (int i = 0; i <(int)Math.floor(player.getShowHP() / 30);i++){
            System.out.print((i <= HPratio ? ":" : " "));
        }
        System.out.print("] " + "( " + player.getHealthPoints() + " / " + player.getShowHP() + " )\n");

        System.out.print("-->" + "MP: [");
        int MPratio = (int) Math.ceil((player.getShowMP() / 10) * (player.getManaPoints() / player.getShowMP()));
        for (int i = 0; i <(int)Math.floor(player.getShowMP() / 10);i++){
            System.out.print((i <= MPratio ? "/" : " "));
        }
        System.out.print("] " + "( " + player.getManaPoints() + " / " + player.getShowMP() + " )\n");
        lineSeperator();
    }

    public void showMonsterStatus(Monster monster) {
        System.out.println(monster.getName());
        System.out.println("-->" + "HP: [");

        int HPratio = (int) Math.ceil((monster.getShowHP() / 30) * (monster.getHealthPoints() / monster.getShowHP()));
        for (int i = 0; i <(int)Math.floor(monster.getShowHP() / 30);i++){
            System.out.print((i <= HPratio ? ":" : " "));
        }
        System.out.print("] " + "( " + monster.getHealthPoints() + " / " + monster.getShowHP() + " )\n");

        System.out.print("-->" + "MP: [");
        int MPratio = (int) Math.ceil((monster.getShowMP() / 10) * (monster.getManaPoints() / monster.getShowMP()));
        for (int i = 0; i <(int)Math.floor(monster.getShowMP() / 10);i++){
            System.out.print((i <= MPratio ? "/" : " "));
        }
        System.out.print("] " + "( " + monster.getManaPoints() + " / " + monster.getShowMP() + " )\n");
        lineSeperator();
    }


}
