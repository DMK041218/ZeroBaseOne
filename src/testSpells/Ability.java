package testSpells;

public class Ability {
    private String spellsName;
    //At what level can you unlock this spell?
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

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public String getSpellsName() {
        return spellsName;
    }

    public void setSpellsName(String spellsName) {
        this.spellsName = spellsName;
    }

    public int getUnlockSpellsLevel() {
        return unlockSpellsLevel;
    }

    public void setUnlockSpellsLevel(int unlockSpellsLevel) {
        this.unlockSpellsLevel = unlockSpellsLevel;
    }

    public int getRequiredSkill_MP() {
        return requiredSkill_MP;
    }

    public void setRequiredSkill_MP(int requiredSkill_MP) {
        this.requiredSkill_MP = requiredSkill_MP;
    }

    public int getDamage_HP() {
        return damage_HP;
    }

    public void setDamage_HP(int damage_HP) {
        this.damage_HP = damage_HP;
    }

    public int getSpellsHealthPoints() {
        return spellsHealthPoints;
    }

    public void setSpellsHealthPoints(int spellsHealthPoints) {
        this.spellsHealthPoints = spellsHealthPoints;
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

    public void setSpellsDescription(String spellsDescription) {
        this.spellsDescription = spellsDescription;
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
