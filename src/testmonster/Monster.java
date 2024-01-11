package testmonster;
import test.*;
public class Monster {
    protected String name;
    protected int healthPoints;
    protected int manaPoints;
    protected int physicalAttack;
    protected int magicalAttack;
    protected int physicalDefense;
    protected int magicalDefense;
    protected int showHP;
    protected int showMP;
    public Monster(String name, int healthPoints, int manaPoints, int physicalAttack, int magicalAttack, int physicalDefense, int magicalDefense) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.showHP = healthPoints;
        this.showMP = manaPoints;
        this.manaPoints = manaPoints;
        this.physicalAttack = physicalAttack;
        this.magicalAttack = magicalAttack;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
    }
    public int MonsterLvUp(int playerLevel){
        //Everytime player's level up to 5 levels the attributes of Monster will change
        if(playerLevel >= 5)
            System.out.println("As you get stronger, the monsters get stronger too...");
        while(playerLevel >= 5){
            playerLevel -= 5;
            healthPoints += 70;
            showHP += 70;
            manaPoints += 50;
            showMP += 50;
            physicalDefense += 10;
            magicalDefense += 10;
            physicalAttack += 15;
            magicalAttack += 15;
        }
        return playerLevel;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public int getPhysicalAttack() {
        return physicalAttack;
    }

    public int getMagicalAttack() {
        return magicalAttack;
    }

    public int getPhysicalDefense() {
        return physicalDefense;
    }

    public int getMagicalDefense() {
        return magicalDefense;
    }

    public int getShowHP() {
        return showHP;
    }

    public int getShowMP() {
        return showMP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public void setPhysicalAttack(int physicalAttack) {
        this.physicalAttack = physicalAttack;
    }

    public void setMagicalAttack(int magicalAttack) {
        this.magicalAttack = magicalAttack;
    }

    public void setPhysicalDefense(int physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    public void setMagicalDefense(int magicalDefense) {
        this.magicalDefense = magicalDefense;
    }

    public void setShowHP(int showHP) {
        this.showHP = showHP;
    }

    public void setShowMP(int showMP) {
        this.showMP = showMP;
    }
}