package testmonster;

public  class Orc extends Monster {
    public Orc(){
        super("Orc",70,0,15,0,9,4);
        this.showHP = healthPoints;
        this.showMP = manaPoints;
        //Description: Orcs are hulking, brutish creatures known for their raw strength. They have no unique abilities.
    }

}