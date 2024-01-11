package fop_valley;
import test.*;
import testmonster.*;
import testSpells.*;
import util.ColorText;
import util.ReadSpellsUtil;

import java.util.List;

public class RoundBasedBattle {
    public void resetAbilityCalledCnt(Archetypes player){
        for(int i = 0; i < 3;i++){
            List<Ability> abilities = ReadSpellsUtil.getAbilitysByArchetypesName(player.getName());
            abilities.get(i).setIsCalledCnt(0);
        }
    }
    public String readBattleChoice(){
        String[] battleChoice = {"S1","S2","S3","A1","A2","A3"};
        String choice = BasicFunctions.readChoice("-->",battleChoice);
        return choice.toUpperCase();
        }
    public boolean starterHealing(Archetypes player){
        int curMp = player.getManaPoints();
        if(curMp > 20){
            player.setManaPoints(curMp - 20);
            int curHp = player.getHealthPoints();
            if(curHp + 20 >= player.getShowHP()){
                player.setHealthPoints(player.getShowHP());
                System.out.println("Your Health Points Is Full.");
            }
            else {
                System.out.println("You regain 20 health points.");
                player.setHealthPoints(curHp + 20);
            }
            return true;
        }
        else
            return false;
        }
    public boolean useStarter(Archetypes player,Monster monster,String choice){
        switch (choice){
            case "S1" :
                PlayerAttack(player, monster);
                return true;
            case "S2":
                return true;
            case "S3":
                if(starterHealing(player))
                    return true;
                else
                    return false;
            default:
                //player chooses to use spells
                return false;
        }
    }
    public void battle(Archetypes player,Monster monster){
        if(player instanceof Warrior){
            battle((Warrior) player,monster);
        }
        else if(player instanceof Archer){
            battle((Archer) player,monster);
        }
        else if(player instanceof Mage){
            battle((Mage) player,monster);
        }
        else if(player instanceof Paladin){
            battle((Paladin) player,monster);
        }
        else if(player instanceof Rogue){
            battle((Rogue) player,monster);
        }
    }
    public void battle(Warrior player,Monster monster){
        player.expCheck();
        int restLv = monster.MonsterLvUp(player.getLvMonsterLvUp());
        player.setLvMonsterLvUp(restLv);
        boolean isPlayerDodging = false;
        int leftDodgeRound = 0;
        do {
            //player's turn
            showPlayerStatus(player);
            battleMenu();
            UsingSpells usp = new UsingSpells();
            usp.WarriorSpells(player);
            boolean isPlayerTurnEnd;
            boolean isPlayerDefending = false;
            do {
                String choice = readBattleChoice();
                isPlayerTurnEnd = useStarter(player, monster, choice);
                if(choice.equalsIgnoreCase("S2"))
                    isPlayerDefending = true;

                if (!isPlayerTurnEnd) {
                    switch (choice) {
                        case "A1":
                            isPlayerTurnEnd = usp.WarriorS1(player, monster);
                            break;
                        case "A2":
                            if(usp.canUseDodgingSPells(player, ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), UsingSpells.spellsName[1]))){
                                isPlayerDodging = true;
                                leftDodgeRound = 3;
                                isPlayerTurnEnd = true;
                                break;
                            }
                            else
                                break;
                        case "A3":
                            isPlayerTurnEnd = usp.WarriorS3(player,monster);
                            break;

                    }
                }
            }while(!isPlayerTurnEnd);
            resetAbilityCalledCnt(player);

            if(monster.getHealthPoints() <= 0){
                System.out.println(ColorText.colorText("\nYou Defeated the " + monster.getName() + " ,Congratulations.",ColorText.CYAN));
                int curXP = player.getXp();
                player.setXp(curXP + 20);
                break;
            }
            //monster's turn
            showMonsterStatus(monster);
            if(!isPlayerDodging && !isPlayerDefending){
                MonsterAttack(player,monster);
            }
            else if(isPlayerDodging){
                System.out.println(ColorText.colorText("You dodged an attack",ColorText.YELLOW));
                leftDodgeRound--;
                if(leftDodgeRound <= 0){
                    isPlayerDodging = false;
                }
            }
            else if(isPlayerDefending){
                defendStatus(player,monster);
            }
            if(player.getHealthPoints() <= 0){
                System.out.println(ColorText.colorText("You DIED and GAME OVER",ColorText.RED));
                System.out.println(ColorText.colorText("Press Any Button to Quit.",ColorText.RED));
                BasicFunctions.continueGame();
                System.exit(0);
            }
        } while (player.getHealthPoints() > 0 && monster.getHealthPoints() > 0);
    }

    public void battle(Archer player,Monster monster){
        player.expCheck();
        int restLv = monster.MonsterLvUp(player.getLvMonsterLvUp());
        player.setLvMonsterLvUp(restLv);
        do {
            //player's turn
            showPlayerStatus(player);
            battleMenu();
            UsingSpells usp = new UsingSpells();
            usp.ArcherSpells(player);
            boolean isPlayerTurnEnd;
            boolean isPlayerDefending = false;
            do {
                String choice = readBattleChoice();
                isPlayerTurnEnd = useStarter(player, monster, choice);
                if(choice.equalsIgnoreCase("S2"))
                    isPlayerDefending = true;
                if (!isPlayerTurnEnd) {
                    switch (choice) {
                        case "A1":
                            isPlayerTurnEnd = usp.ArcherS1(player, monster);
                            break;
                        case "A2":
                            isPlayerTurnEnd = usp.ArcherS2(player, monster);
                            break;
                        case "A3":
                            isPlayerTurnEnd = usp.ArcherS3(player,monster);
                            break;
                        default:
                            isPlayerTurnEnd = false;
                    }
                }
            }while(!isPlayerTurnEnd);
            resetAbilityCalledCnt(player);
            if(monster.getHealthPoints() <= 0){
                System.out.println(ColorText.colorText("\nYou Defeated the " + monster.getName() + " ,Congratulations.",ColorText.CYAN));
                int curXP = player.getXp();
                player.setXp(curXP + 20);
                break;
            }
            //monster's turn
            showMonsterStatus(monster);
            if(isPlayerDefending){
                defendStatus(player,monster);
            }
            else
                MonsterAttack(player,monster);
            if(player.getHealthPoints() <= 0){
                System.out.println(ColorText.colorText("You DIED and GAME OVER",ColorText.RED));
                System.out.println(ColorText.colorText("Press Any Button to Quit.",ColorText.RED));
                BasicFunctions.continueGame();
                System.exit(0);
            }
        } while (player.getHealthPoints() > 0 && monster.getHealthPoints() > 0);
    }
    public void battle(Mage player,Monster monster){
        player.expCheck();
        int restLv = monster.MonsterLvUp(player.getLvMonsterLvUp());
        player.setLvMonsterLvUp(restLv);
        boolean isPlayerDodging = false;
        int leftDodgeRound = 0;
        do {
            //player's turn
            showPlayerStatus(player);
            battleMenu();
            UsingSpells usp = new UsingSpells();
            usp.MageSpells(player);
            boolean isPlayerTurnEnd;
            boolean isPlayerDefending = false;
            do {
                String choice = readBattleChoice();
                isPlayerTurnEnd = useStarter(player, monster, choice);
                if(choice.equalsIgnoreCase("S2"))
                    isPlayerDefending = true;
                if (!isPlayerTurnEnd) {
                    switch (choice) {
                        case "A1":
                            isPlayerTurnEnd = usp.MageS1(player, monster);
                            break;
                        case "A2":
                            if(usp.canUseDodgingSPells(player, ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), UsingSpells.spellsName[4]))){
                                isPlayerDodging = true;
                                leftDodgeRound = 2;
                                isPlayerTurnEnd = true;
                                break;
                            }
                            else
                                break;
                        case "A3":
                            isPlayerTurnEnd = usp.MageS3(player,monster);
                            break;
                        default:
                            isPlayerTurnEnd = false;
                    }
                }
            }while(!isPlayerTurnEnd);
            resetAbilityCalledCnt(player);
            if(monster.getHealthPoints() <= 0){
                System.out.println(ColorText.colorText("\nYou Defeated the " + monster.getName() + " ,Congratulations.",ColorText.CYAN));
                int curXP = player.getXp();
                player.setXp(curXP + 20);
                break;
            }
            //monster's turn
            showMonsterStatus(monster);
            if(!isPlayerDodging && !isPlayerDefending){
                MonsterAttack(player,monster);
            }
            else if(isPlayerDodging){
                System.out.println(ColorText.colorText("You dodged an attack",ColorText.YELLOW));
                leftDodgeRound--;
                if(leftDodgeRound <= 0){
                    isPlayerDodging = false;
                }
            }
            else if(isPlayerDefending){
                defendStatus(player,monster);
            }
            if(player.getHealthPoints() <= 0){
                System.out.println(ColorText.colorText("You DIED and GAME OVER",ColorText.RED));
                System.out.println(ColorText.colorText("Press Any Button to Quit.",ColorText.RED));
                BasicFunctions.continueGame();
                System.exit(0);
            }
        } while (player.getHealthPoints() > 0 && monster.getHealthPoints() > 0);
    }
    public void battle(Paladin player,Monster monster){
        player.expCheck();
        int restLv = monster.MonsterLvUp(player.getLvMonsterLvUp());
        player.setLvMonsterLvUp(restLv);
        boolean isPlayerDodging = false;
        int leftDodgeRound = 0;
        do {
            //player's turn
            showPlayerStatus(player);
            battleMenu();
            UsingSpells usp = new UsingSpells();
            usp.PaladinSpells(player);
            boolean isPlayerTurnEnd;
            boolean isPlayerDefending = false;
            do {
                String choice = readBattleChoice();
                isPlayerTurnEnd = useStarter(player, monster, choice);
                if(choice.equalsIgnoreCase("S2"))
                    isPlayerDefending = true;
                if (!isPlayerTurnEnd) {
                    switch (choice) {
                        case "A1":
                            isPlayerTurnEnd = usp.PaladinS1(player, monster);
                            usp.usingHealingSpells(player);
                            break;
                        case "A2":
                            if(usp.canUseDodgingSPells(player, ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), UsingSpells.spellsName[10]))){
                                isPlayerDodging = true;
                                leftDodgeRound = 2;
                                isPlayerTurnEnd = true;
                                break;
                            }
                            else
                                break;
                        case "A3":
                            isPlayerTurnEnd = usp.PaladinS3(player,monster);
                            break;
                        default:
                            isPlayerTurnEnd = false;
                    }
                }
            }while(!isPlayerTurnEnd);
            resetAbilityCalledCnt(player);

            if(monster.getHealthPoints() <= 0){
                System.out.println(ColorText.colorText("\nYou Defeated the " + monster.getName() + " ,Congratulations.",ColorText.CYAN));
                int curXP = player.getXp();
                player.setXp(curXP + 20);
                break;
            }
            //monster's turn
            showMonsterStatus(monster);
            if(!isPlayerDodging && !isPlayerDefending){
                MonsterAttack(player,monster);
            }
            else if(isPlayerDodging){
                System.out.println(ColorText.colorText("You dodged an attack",ColorText.YELLOW));
                leftDodgeRound--;
                if(leftDodgeRound <= 0){
                    isPlayerDodging = false;
                }
            }
            else if(isPlayerDefending){
                defendStatus(player,monster);
            }
            if(player.getHealthPoints() <= 0){
                System.out.println(ColorText.colorText("You DIED and GAME OVER",ColorText.RED));
                System.out.println(ColorText.colorText("Press Any Button to Quit.",ColorText.RED));
                BasicFunctions.continueGame();
                System.exit(0);
            }
        } while (player.getHealthPoints() > 0 && monster.getHealthPoints() > 0);
    }
    public void battle(Rogue player,Monster monster){
        player.expCheck();
        int restLv = monster.MonsterLvUp(player.getLvMonsterLvUp());
        player.setLvMonsterLvUp(restLv);
        boolean isPlayerDodging = false;
        int leftDodgeRound = 0;
        do {
            //player's turn
            showPlayerStatus(player);
            battleMenu();
            UsingSpells usp = new UsingSpells();
            usp.RogueSpells(player);
            boolean isPlayerTurnEnd;
            boolean isPlayerDefending = false;
            do {
                String choice = readBattleChoice();
                isPlayerTurnEnd = useStarter(player, monster, choice);
                if(choice.equalsIgnoreCase("S2"))
                    isPlayerDefending = true;
                if (!isPlayerTurnEnd) {
                    switch (choice) {
                        case "A1":
                            isPlayerTurnEnd = usp.RogueS1(player, monster);
                            break;
                        case "A2":
                            if(usp.canUseDodgingSPells(player, ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), UsingSpells.spellsName[7]))){
                                isPlayerDodging = true;
                                leftDodgeRound = 1;
                                isPlayerTurnEnd = true;
                                break;
                            }
                            else
                                break;
                        case "A3":
                            isPlayerTurnEnd = usp.RogueS3(player,monster);
                            break;
                        default:
                            isPlayerTurnEnd = false;
                    }
                }
            }while(!isPlayerTurnEnd);
            resetAbilityCalledCnt(player);
            if(monster.getHealthPoints() <= 0){
                System.out.println(ColorText.colorText("\nYou Defeated the " + monster.getName() + " ,Congratulations.",ColorText.CYAN));
                int curXP = player.getXp();
                player.setXp(curXP + 20);
                break;
            }
            //monster's turn
            showMonsterStatus(monster);
            if(!isPlayerDodging && !isPlayerDefending){
                MonsterAttack(player,monster);
            }
            else if(isPlayerDodging){
                System.out.println(ColorText.colorText("You dodged an attack",ColorText.YELLOW));
                leftDodgeRound--;
                if(leftDodgeRound <= 0){
                    isPlayerDodging = false;
                }
            }
            else if(isPlayerDefending){
                defendStatus(player,monster);
            }
            if(player.getHealthPoints() <= 0){
                System.out.println(ColorText.colorText("You DIED and GAME OVER",ColorText.RED));
                System.out.println(ColorText.colorText("Press Any Button to Quit.",ColorText.RED));
                BasicFunctions.continueGame();
                System.exit(0);
            }
        } while (player.getHealthPoints() > 0 && monster.getHealthPoints() > 0);
    }


    //Monster Damaged By Player's Attack
    public void PlayerAttack(Archetypes player, Monster monster){
        int playerAtk = player.getPhysicalAttack() + player.getMagicalAttack();
        int monsterDfs = monster.getMagicalDefense() + monster.getPhysicalDefense();
        double monsterDmg = playerAtk -0.3 * monsterDfs;
        System.out.println("You have HIT the " + monster.getName() + " ,causing " + (int)monsterDmg + " damage!");
        monster.setHealthPoints(monster.getHealthPoints() - (int)monsterDmg);
}
    //Player Damaged By Monster's Attack
    public void MonsterAttack(Archetypes player, Monster monster){
        int monsterAtk = monster.getPhysicalAttack() + monster.getMagicalAttack();
        int playerDfs = player.getMagicalDefense() + player.getPhysicalDefense();
        double playerDmg = monsterAtk -  0.3 * playerDfs;
        if(playerDmg <= 0){
            player.setHealthPoints(player.getHealthPoints());
            System.out.println("You are strong enough, and the current monsters can no longer harm you.");
        }
        else {
            System.out.println("> CRITICAL! " + monster.getName() + " has SLASHED you for " + (int)playerDmg + " damage!");
            player.setHealthPoints(player.getHealthPoints() - (int) playerDmg);
        }
    }

    public void showPlayerStatus(Archetypes player) {
        System.out.println(player.getName());
        System.out.print("-->" + "HP: [");

        int HPratio = (int)(Math.ceil(player.getHealthPoints())/30);
        for (int i = 0; i < (int) Math.floor(player.getShowHP() / 30); i++) {
            System.out.print((i <= HPratio ? ":" : " "));
        }
        System.out.print("] " + "( " + player.getHealthPoints() + " / " + player.getShowHP() + " )\n");

        System.out.print("-->" + "MP: [");
        int MPratio = (int)(Math.ceil(player.getManaPoints())/10);
        if (player.getManaPoints() != 0) {
            for (int i = 0; i < (int) Math.floor(player.getShowMP() / 10); i++) {
                System.out.print((i <= MPratio ? "/" : " "));
            }

            System.out.print("] " + "( " + player.getManaPoints() + " / " + player.getShowMP() + " )\n");
        }
        else {
            System.out.print("      ]\n");
        }
        BasicFunctions.lineSeperator();
    }

    public void showMonsterStatus(Monster monster) {
        System.out.println(monster.getName());
        System.out.print("-->" + "HP: [");

        int HPratio = (int)(Math.ceil(monster.getHealthPoints())/30);;
        for (int i = 0; i <(int)Math.floor(monster.getShowHP() / 30);i++){
            System.out.print((i <= HPratio ? ":" : " "));
        }
        System.out.print("] " + "( " + monster.getHealthPoints() + " / " + monster.getShowHP() + " )\n");

        System.out.print("-->" + "MP: [");
        if(monster.getManaPoints() != 0){
            int MPratio = (int)(Math.ceil(monster.getManaPoints())/10);;
            for (int i = 0; i <(int)Math.floor(monster.getShowMP() / 10);i++){
                System.out.print((i <= MPratio ? "/" : " "));
            }
            System.out.print("] " + "( " + monster.getManaPoints() + " / " + monster.getShowMP() + " )\n");
        }
        else {
            System.out.print("      ]\n");
        }
        BasicFunctions.lineSeperator();
    }
    public void defendStatus(Archetypes player,Monster monster){
            int monsterAtk = monster.getPhysicalAttack() + monster.getMagicalAttack();
            int playerDfs = player.getMagicalDefense() + player.getPhysicalDefense();
            double playerDmg = monsterAtk - 0.6 * playerDfs;
            if(playerDmg <= 0){
                System.out.println("> " + monster.getName() + " cannot harm you because you are on denfense.");
            }
            else {
                player.setHealthPoints((int) (player.getHealthPoints() - playerDmg));
                System.out.println("> " + monster.getName() + " has SLASHED you ONLY for " + (int) (playerDmg) + " damage because you are on denfense.");
            }
    }

    public void battleMenu(){
        System.out.println(">> Starter");
        System.out.println("[S1] Attack");
        System.out.println("[S2] Defend");
        System.out.println("[S3] Heal");
        }
    }

