package testSpells;

public class Ability {
    private String spellsName;
    //At what level can you unlock this spell
    private int unlockSpellsLevel;
    //The mana value required to release the skill
    private int requiredSkill_MP;
    private int damage_HP;
    //Heal HealthPoints
    private int spellsHealthPoints;
    //CD
    private int coolDown;
    //How many times the skill has been called
    private int totalCount;
    private boolean levelLocked;
    private String spellsDescription;


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCoolDown() {
        return coolDown;
    }


    public String getSpellsName() {
        return spellsName;
    }


    public int getUnlockSpellsLevel() {
        return unlockSpellsLevel;
    }


    public int getRequiredSkill_MP() {
        return requiredSkill_MP;
    }


    public int getDamage_HP() {
        return damage_HP;
    }


    public int getSpellsHealthPoints() {
        return spellsHealthPoints;
    }


    public boolean isLevelLocked() {
        return levelLocked;
    }

    public void setLevelLocked(boolean levelLocked) {
        this.levelLocked = levelLocked;
    }

    public String getSpellsDescription() {
        return spellsDescription;
    }



    @Override
    public String toString() {
        return "Ability{" +
                "spellsName='" + spellsName + '\'' +
                ", unlockSpellsLevel=" + unlockSpellsLevel +
                ", requiredSkill_MP=" + requiredSkill_MP +
                ", damage_HP=" + damage_HP +
                ", spellsHealthPoints=" + spellsHealthPoints +
                ", coolDown=" + coolDown +
                 ", totalCount=" + totalCount +
                ", levelLocked=" + levelLocked +
                ", spellsDescription='" + spellsDescription + '\'' +
                '}';
    }
}
