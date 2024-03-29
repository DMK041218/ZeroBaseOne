package testSpells;

import util.ColorText;

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
        if (totalCount <= coolDown) {
            System.out.println(ColorText.colorText(totalCount + "/" + coolDown + " CD",ColorText.BLUE));
            return false;
        }
        int count = totalCount % (coolDown + 1);
        if (count != 0) {
            System.out.println(ColorText.colorText(count + "/" + coolDown + " CD",ColorText.BLUE));
            return false;
        } else {
            System.out.println(ColorText.colorText(coolDown + "/" + coolDown + " CD",ColorText.BLUE));
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
        System.out.print(ColorText.colorText("<Locked - " + ability.getUnlockSpellsLevel() + " >",ColorText.RED));
        return false;
    }

    public boolean isMpEnough(Ability ability, int MP){
        if(MP >= ability.getRequiredSkill_MP())
            return true;
        else
            return false;

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
