package fop_valley;

import test.*;
import java.io.*;
import java.util.Scanner;

public class loadGame extends Archetypes implements Serializable {
    private String name;
    protected int showMP;
    protected int showHP;

    public String getName() {
        return name;
    }

    private String PlayerName;

    public String getPlayerName() {
        return PlayerName;
    }

    private int healthPoints;

    public int getHealthPoints() {
        return healthPoints;
    }

    private int manaPoints;

    public int getManaPoints() {
        return manaPoints;
    }

    private int level;

    public int getLevel() {
        return level;
    }

    private int xp;

    public int getXp() {
        return xp;
    }

    private int magicalAttack;

    public int getMagicalAttack() {
        return magicalAttack;
    }

    private int physicalAttack;

    public int getPhysicalAttack() {
        return physicalAttack;
    }

    private int magicalDefense;

    public int getMagicalDefense() {
        return magicalDefense;
    }

    private int physicalDefense;

    public int getPhysicalDefense() {
        return physicalDefense;
    }

    public void loadGameFirst() {
        try (Scanner sc = new Scanner(new File("saveGame.txt"))) {
            this.name = sc.nextLine();
            this.PlayerName = sc.nextLine();
            this.healthPoints = sc.nextInt();
            this.manaPoints = sc.nextInt();
            this.level = sc.nextInt();
            this.xp = sc.nextInt();
            this.magicalAttack = sc.nextInt();
            this.physicalAttack = sc.nextInt();
            this.magicalDefense = sc.nextInt();
            this.physicalDefense = sc.nextInt();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Warrior load1() {
        return new Warrior(name, PlayerName, healthPoints, manaPoints, level, xp, magicalAttack, physicalAttack,
                magicalDefense, physicalDefense);
    }

    public Mage load2() {
        return new Mage(name, PlayerName, healthPoints, manaPoints, level, xp, magicalAttack, physicalAttack,
                magicalDefense, physicalDefense);
    }

    public Archer load3() {
        return new Archer(name, PlayerName, healthPoints, manaPoints, level, xp, magicalAttack, physicalAttack,
                magicalDefense, physicalDefense);
    }

    public Paladin load4() {
        return new Paladin(name, PlayerName, healthPoints, manaPoints, level, xp, magicalAttack, physicalAttack,
                magicalDefense, physicalDefense);
    }

    public Rogue load5() {
        return new Rogue(name, PlayerName, healthPoints, manaPoints, level, xp, magicalAttack, physicalAttack,
                magicalDefense, physicalDefense);
    }

}
