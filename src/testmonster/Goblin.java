package testmonster;

public class Goblin extends Monster{
    public Goblin(){
        super("Goblin",40,0,10,0,5,2 );
        this.showHP = healthPoints;
        this.showMP = manaPoints;
        //Description: Goblins are small, pesky creatures that rely on sheer numbers to overpower their foes. They have no special abilities.
    }

}