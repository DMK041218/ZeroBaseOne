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


}
