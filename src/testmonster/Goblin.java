package testmonster;

public class Goblin extends Monster{
    public Goblin(){
        super("Goblin",130,0,55,0,20,30);
        this.showHP = healthPoints;
        this.showMP = manaPoints;
        //Description: Goblins are small, pesky creatures that rely on sheer numbers to overpower their foes. They have no special abilities.
    }

}