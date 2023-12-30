package testSpells;

import util.Constants;

public class SpellsService {


    //When calling a skill, the number of cooling rounds determines whether the skill can be used.
    public boolean isAbility(Ability ability) {
        int coolDown = ability.getCoolDown();
        int totalCount = ability.getTotalCount();
        //totalCount, determine how many rounds the skill has been called,
        //Assume that the set coolDown is 4 rounds,
        //First call (cooling): coolDown= 4, totalCount = 1 totalCount%coolDown
        //Second call (cooling): coolDown= 4, totalCount = 2
        //Third call (cooling): coolDown= 4, totalCount = 3
        //Fourth call (cooling): coolDown= 4, totalCount = 4
        //The fifth call (available) coolDown= 4, totalCount = 5 totalCount%(coolDown+1) = 0
        //Sixth call (cooling) coolDown= 4, totalCount = 6 totalCount%(coolDown+1) = 1
        //.......
        ability.setTotalCount(++totalCount);
        if (totalCount <= coolDown) {
            System.out.println("The spell is cooling down" + "\t" + totalCount + " / " + coolDown + "  C/D");
            return false;
        }
        int count = totalCount % (coolDown + 1);
        if (count != 0) {
            System.out.println("The spell is cooling down" + "\t" + count + " / " + coolDown + "  C/D");
            return false;
        } else {
            System.out.println("Skills available");
            return true;
        }
    }


    //Determine whether the current level spell can be used
    public boolean unlockSpellsLevel(Ability ability, int level) {
        if (ability.isLevelLocked()) {
            return true;
        }
        if (ability.getUnlockSpellsLevel() <= level) {
            ability.setLevelLocked(true);
            return true;
        }
        System.out.println("<Locked - " + ability.getUnlockSpellsLevel() + " >");
        return false;
    }



    public int protectedDanageRounds(Ability ability, int level) {
        if (unlockSpellsLevel(ability, level)) {
            switch (ability.getSpellsName()) {
                case Constants.shieldWall:
                    System.out.println("The Warrior creates an impenetrable barrier with their shield, reducing incoming damage for 3 rounds");
                    return 3;
                case Constants.frostNova:
                    System.out.println(" The Mage releases a burst of frost, freezing nearby enemies in place for 2 rounds");
                    return 2;
                case Constants.shadowstep:
                    System.out.println(" The Rogue can evade the next spell or attack from the enemies");
                    return 1;
                case Constants.divineShield:
                    System.out.println("Creates a protective barrier around the Paladin, rendering them immune to damage for 2 rounds");
                    return 2;
            }
        }
        return 0;
    }


    public int getRequiredSkill_MP(Ability ability, int level) {
        if (unlockSpellsLevel(ability, level)) {
            return ability.getRequiredSkill_MP();
        }
        return 0;
    }



    public int getDamage_HP(Ability ability, int level) {
        if (unlockSpellsLevel(ability, level)) {
            return ability.getDamage_HP();
        }
        return 0;
    }

    public int getSpellsHealthPoints(Ability ability, int level) {
        if (unlockSpellsLevel(ability, level)) {
            return ability.getSpellsHealthPoints();
        }
        return 0;
    }




}
