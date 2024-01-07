package fop_valley;
import test.*;
import testmonster.*;
import testSpells.*;

public class RoundBasedBattle {
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
                            if(usp.canUseDodgingSPells(player)){
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
                        default:
                            isPlayerTurnEnd = false;

                    }
                }
            }while(!isPlayerTurnEnd);
            if(monster.getHealthPoints() <= 0){
                System.out.println("You Defeated the" + monster.getName() + " ,Congratulations.");
                int curXP = player.getXp();
                player.setXp(curXP + 5);
                break;
            }
            //monster's turn
            showMonsterStatus(monster);
            if(!isPlayerDodging && !isPlayerDefending){
                MonsterAttack(player,monster);
            }
            else if(isPlayerDodging){
                leftDodgeRound--;
                if(leftDodgeRound <= 0){
                    isPlayerDodging = false;
                }
            }
            else if(isPlayerDefending){
                defendStatus(player,monster);
            }
            if(player.getHealthPoints() <= 0){
                System.out.println("You DIED and GAME OVER");
                System.out.println("Press Any Button to Quit.");
                BasicFunctions.continueGame();
                System.exit(0);
            }
        } while (player.getHealthPoints() > 0 && monster.getHealthPoints() > 0);
    }

    public void battle(Archer player,Monster monster){
        player.expCheck();
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
            if(monster.getHealthPoints() <= 0){
                System.out.println("You Defeated the" + monster.getName() + " ,Congratulations.");
                int curXP = player.getXp();
                player.setXp(curXP + 5);
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
                System.out.println("You DIED and GAME OVER");
                System.out.println("Press Any Button to Quit.");
                BasicFunctions.continueGame();
                System.exit(0);
            }
        } while (player.getHealthPoints() > 0 && monster.getHealthPoints() > 0);
    }
    public void battle(Mage player,Monster monster){
        player.expCheck();
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
                            if(usp.canUseDodgingSPells(player)){
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
            if(monster.getHealthPoints() <= 0){
                System.out.println("You Defeated the" + monster.getName() + " ,Congratulations.");
                int curXP = player.getXp();
                player.setXp(curXP + 5);
                break;
            }
            //monster's turn
            showMonsterStatus(monster);
            if(!isPlayerDodging && !isPlayerDefending){
                MonsterAttack(player,monster);
            }
            else if(isPlayerDodging){
                leftDodgeRound--;
                if(leftDodgeRound <= 0){
                    isPlayerDodging = false;
                }
            }
            else if(isPlayerDefending){
                defendStatus(player,monster);
            }
            if(player.getHealthPoints() <= 0){
                System.out.println("You DIED and GAME OVER");
                System.out.println("Press Any Button to Quit.");
                BasicFunctions.continueGame();
                System.exit(0);
            }
        } while (player.getHealthPoints() > 0 && monster.getHealthPoints() > 0);
    }
    public void battle(Paladin player,Monster monster){
        player.expCheck();
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
                            if(usp.canUseDodgingSPells(player)){
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
            if(monster.getHealthPoints() <= 0){
                System.out.println("You Defeated the" + monster.getName() + " ,Congratulations.");
                int curXP = player.getXp();
                player.setXp(curXP + 5);
                break;
            }
            //monster's turn
            showMonsterStatus(monster);
            if(!isPlayerDodging && !isPlayerDefending){
                MonsterAttack(player,monster);
            }
            else if(isPlayerDodging){
                leftDodgeRound--;
                if(leftDodgeRound <= 0){
                    isPlayerDodging = false;
                }
            }
            else if(isPlayerDefending){
                defendStatus(player,monster);
            }
            if(player.getHealthPoints() <= 0){
                System.out.println("You DIED and GAME OVER");
                System.out.println("Press Any Button to Quit.");
                BasicFunctions.continueGame();
                System.exit(0);
            }
        } while (player.getHealthPoints() > 0 && monster.getHealthPoints() > 0);
    }
    public void battle(Rogue player,Monster monster){
        player.expCheck();
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
                            if(usp.canUseDodgingSPells(player)){
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
            if(monster.getHealthPoints() <= 0){
                System.out.println("You Defeated the" + monster.getName() + " ,Congratulations.");
                int curXP = player.getXp();
                player.setXp(curXP + 5);
                break;
            }
            //monster's turn
            showMonsterStatus(monster);
            if(!isPlayerDodging && !isPlayerDefending){
                MonsterAttack(player,monster);
            }
            else if(isPlayerDodging){
                leftDodgeRound--;
                if(leftDodgeRound <= 0){
                    isPlayerDodging = false;
                }
            }
            else if(isPlayerDefending){
                defendStatus(player,monster);
            }
            if(player.getHealthPoints() <= 0){
                System.out.println("You DIED and GAME OVER");
                System.out.println("Press Any Button to Quit.");
                BasicFunctions.continueGame();
                System.exit(0);
            }
        } while (player.getHealthPoints() > 0 && monster.getHealthPoints() > 0);
    }


    //Monster Damaged By Player's Attack
    public void PlayerAttack(Archetypes player, Monster monster){
        int playerAtk = player.getPhysicalAttack() + player.getMagicalAttack();
        int monsterDfs = monster.getMagicalDefense() + monster.getPhysicalDefense();
        int monsterDmg = playerAtk - monsterDfs;
        System.out.println("You have HIT the " + monster.getName() + " ,causing " + monsterDmg + " damage!");
        monster.setHealthPoints(monster.getHealthPoints() - monsterDmg);
}
    //Player Damaged By Monster's Attack
    public void MonsterAttack(Archetypes player, Monster monster){
        int monsterAtk = monster.getPhysicalAttack() + monster.getMagicalAttack();
        int playerDfs = player.getMagicalDefense() + player.getPhysicalDefense();
        int playerDmg = monsterAtk - playerDfs;
        System.out.println("> CRITICAL! " + monster.getName() + " has SLASHED you for " + playerDmg + " damage!");
        player.setHealthPoints(player.getHealthPoints() - playerDmg);
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
        BasicFunctions.lineSeperator();
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
    }
    public void defendStatus(Archetypes player,Monster monster){
            int monsterAtk = monster.getPhysicalAttack() + monster.getMagicalAttack();
            int playerDfs = player.getMagicalDefense() + player.getPhysicalDefense();
            int playerDmg = monsterAtk - playerDfs;
            player.setHealthPoints((int)(player.getHealthPoints() - playerDmg * 0.8 ));
            System.out.println("> " + monster.getName() + " has SLASHED you ONLY for " + (int)(playerDmg * 0.8 )+ " damage because you are on denfense.");
    }

    public void battleMenu(){
        System.out.println(">> Starter");
        System.out.println("[S1] Attack");
        System.out.println("[S2] Defend");
        System.out.println("[S3] Heal");
        }
    }

