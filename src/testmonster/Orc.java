package testmonster;

public  class Orc extends Monster {
    public Orc(){
        super("Orc",180,0,80,0,50,35);
        this.showHP = healthPoints;
        this.showMP = manaPoints;
        //Description: Orcs are hulking, brutish creatures known for their raw strength. They have no unique abilities.
    }

}