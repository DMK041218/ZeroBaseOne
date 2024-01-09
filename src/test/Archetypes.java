package test;
import util.ColorText;
public class Archetypes {
    protected String name;
    protected String playerName;
    protected int healthPoints;
    protected int showHP;
    protected int manaPoints;
    protected int showMP;
    protected int physicalDefense;
    protected int magicalDefense;
    protected int physicalAttack;
    protected int magicalAttack;
    protected int level;
    protected int xp;

    public Archetypes(String name,String playerName,int healthPoints, int manaPoints, int physicalDefense, int magicalDefense, int physicalAttack, int magicalAttack) {
        this.name = name;
        this.playerName = playerName;
        this.healthPoints = healthPoints;
        this.showHP = healthPoints;
        this.manaPoints = manaPoints;
        this.showMP = manaPoints;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
        this.physicalAttack = physicalAttack;
        this.magicalAttack = magicalAttack;
        this.level = 1;
        this.xp = 0;
    }
    public Archetypes(){
        this.showMP = manaPoints;
        this.showHP = healthPoints;
        this.level = 1;
        this.xp = 0;
    }
    public void expCheck(){
        if(this.level <= 10){
            if(this.xp >= 10){
                this.xp -= 10;
                levelUp();
            }
        }
        else if(this.level > 10 && this.level<35){
            this.xp -= 30;
            levelUp();
        }
    }

    public void levelUp() {
        healthPoints += 15;
        showHP += 15;
        manaPoints += 30;
        showMP += 30;
        physicalDefense += 10;
        magicalDefense += 10;
        physicalAttack += 10;
        magicalAttack += 10;
        level++;

    }
    @Override
    public String toString(){
        return  ColorText.colorText("Character Name: " + name + "\n",ColorText.YELLOW) +
                "Player Name: " + playerName + "\n" +
                "HP: " + healthPoints + "\n" +
                "Magical Defense: " + magicalDefense + "\n" +
                "Physical Defense: " + physicalDefense + "\n" + "ManaPoints: " + manaPoints + "\n" + "Physical Attack: " +
                physicalAttack + "\n" + "Magical Attack: " + magicalAttack + "\n";
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

    public int getShowHP() {
        return showHP;
    }

    public int getShowMP() {
        return showMP;
    }

    public int getPhysicalDefense() {
        return physicalDefense;
    }

    public int getMagicalDefense() {
        return magicalDefense;
    }

    public int getPhysicalAttack() {
        return physicalAttack;
    }

    public int getMagicalAttack() {
        return magicalAttack;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setShowHP(int showHP) {
        this.showHP = showHP;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public void setShowMP(int showMP) {
        this.showMP = showMP;
    }

    public void setPhysicalDefense(int physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    public void setMagicalDefense(int magicalDefense) {
        this.magicalDefense = magicalDefense;
    }

    public void setPhysicalAttack(int physicalAttack) {
        this.physicalAttack = physicalAttack;
    }

    public void setMagicalAttack(int magicalAttack) {
        this.magicalAttack = magicalAttack;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
