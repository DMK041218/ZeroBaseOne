package fop_valley;
import java.util.Scanner;
import testmonster.*;
import Map.MapDesign;
import test.*;
import util.*;



public class Game {
        Scanner scanner = new Scanner(System.in);
        Archetypes player = null;
        String playerSetName = "";
        boolean printChap2 = false;
        boolean characterSet = false;
    void begin(){
        BasicFunctions.clearScreen();
        //TODO Set Colour and Add ASCII Art Here
        //TODO Add Save Game and Load Game Here
        BasicFunctions.printHeading("Adventurer,welcome to FOP Valley.");
        System.out.println("Made by Group ZEROBASEONE");
        BasicFunctions.continueGame();
        BasicFunctions bfc = new BasicFunctions();
        if(bfc.printBeginningMenu() != null){
            //Successfully read save
            characterSet = true;
        }
        player = bfc.printBeginningMenu();

    }
        void startGame() {
            //print the story intro
            storyLine.printIntro();
            //Set Character
            do {
                BasicFunctions.printHeading("Choose your Character: ");
                System.out.println("[1] Warrior");
                System.out.println(new Warrior());
                System.out.println(ReadSpellsUtil.getAbilitysByArchetypesName("Warrior"));
                BasicFunctions.lineSeperator();
                System.out.println("[2] Mage");
                System.out.println(new Mage());

                BasicFunctions.lineSeperator();
                System.out.println("[3] Rogue");
                System.out.println(new Rogue());

                BasicFunctions.lineSeperator();
                System.out.println("[4] Paladin");
                System.out.println(new Paladin());

                BasicFunctions.lineSeperator();
                System.out.println("[5] Archer");
                System.out.println(new Archer());

                int choice = BasicFunctions.readChoice("Your character is --->", 5);
                switch (choice) {
                    case 1:
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
                BasicFunctions.printHeading("Is your character " + player.getName() + " ?");
                System.out.println("[1] Yes!");
                System.out.println("[2] No I wanna change my character.");
                int input = BasicFunctions.readChoice("---> ", 2);
                if (input == 1)
                    characterSet = true;
            } while (!characterSet);

            //Set Name
            boolean nameSet = false;
            do {
                BasicFunctions.clearScreen();
                BasicFunctions.printHeading("Tell me your name: ");
                playerSetName = scanner.next();
                BasicFunctions.printHeading("Is your name " + playerSetName + " ?");
                System.out.println("[1] Yes!");
                System.out.println("[2] No I wanna change my name.");
                int input = BasicFunctions.readChoice("---> ", 2);
                if (input == 1) {
                    player.setPlayerName(playerSetName);
                    nameSet = true;
                }
            } while (!nameSet);
            BasicFunctions.continueGame();
            //game starts
            MapDesign map = new MapDesign();
            while(player.getLevel() < 35){
                map.generateMap();
                map.bringPlayer();
                map.bringMonster();
                map.generateMonster();
                do {
                    System.out.println("Press \" M \" to open in game menu");
                    char isOpen = scanner.next().toUpperCase().charAt(0);
                    if (isOpen == 'M')
                        BasicFunctions.printInGameMenu(player);
                    char m = map.movePlayer();
                    if (checkWhichMonster(m) == null) {
                        map.printMap();
                        continue;
                    }
                    else{
                        RoundBasedBattle rbb = new RoundBasedBattle();
                        rbb.battle(player, checkWhichMonster(m));
                        map.setOccupied();
                    }

                    if (player.getLevel() == 15 && !printChap2) {
                        printChap2 = true;
                        storyLine.PrintChap2();
                    }
                    map.printMap();
                }while (!map.curMapFinish());
            }
            storyLine.finalChap();
            System.out.println("Press Any Button to Quit.");
            BasicFunctions.continueGame();
            System.exit(0);
        }

    public testmonster.Monster checkWhichMonster(char m){
        switch (m){
            case 'W':
                return new testmonster.Witch();
            case 'G':
                return new testmonster.Goblin();
            case 'H':
                return new testmonster.Harpy();
            case 'O':
                return new testmonster.Orc();
            case 'S':
                return new testmonster.Skeleton();
        }
        return null;
    }

}
