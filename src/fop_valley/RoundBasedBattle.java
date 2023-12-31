package fop_valley;
import test.*;
import testmonster.*;

public class RoundBasedBattle {
    Archetypes player;
    Monster monster;
    //Monster Damaged By Player's Attack
    public void PlayerAttack(Monster monster){
        int playerAtk = player.getPhysicalAttack() + player.getMagicalAttack();
        int monsterDfs = monster.getMagicalDefense() + monster.getPhysicalDefense();
        int monsterDmg = playerAtk - monsterDfs;
        monster.setHealthPoints(monster.getHealthPoints() - monsterDmg);
}
    //Player Damaged By Monster's Attack
    public void MonsterAttack(Archetypes player){
        int monsterAtk = monster.getPhysicalAttack() + monster.getMagicalAttack();
        int playerDfs = player.getMagicalDefense() + player.getPhysicalDefense();
        int playerDmg = monsterAtk - playerDfs;
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
        BasicFunctions.lineSeperator();
    }

    public void defendStatus(Archetypes player,boolean isDefend){
        if(isDefend){
            int monsterAtk = monster.getPhysicalAttack() + monster.getMagicalAttack();
            int playerDfs = player.getMagicalDefense() + player.getPhysicalDefense();
            int playerDmg = monsterAtk - playerDfs;
            player.setHealthPoints((int)(player.getHealthPoints() - playerDmg * 0.8 ));
        }
    }

}
