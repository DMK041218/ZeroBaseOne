package testSpells;
import util.ReadSpellsUtil;
import test.*;
import testmonster.*;

public class UsingSpells {
    String[] spellsName = ReadSpellsUtil.getSpellsNameArr();
    public void showSpells(Ability ability,Archetypes player,String prompt){
        System.out.print(prompt + " ");
        //Instantiate The SpellsService
        SpellsService spsv = new SpellsService();
        boolean abilityStatus = spsv.unlockSpellsLevel(ability, player.getLevel());
        if(abilityStatus){
            System.out.print(ability.getSpellsName());
            System.out.print("\t");
            System.out.print("< -" + ability.getRequiredSkill_MP() + " MP"  + spsv.isAbility(ability) + ability.getDamage_HP() + " HP, " + ability.getSpellsDescription() + " >");
            System.out.print("\n");
        }
    }

    public boolean usingAtkSpells(Ability ability,Archetypes player,Monster monster) {
        SpellsService spsv = new SpellsService();
        boolean abilityStatus = spsv.unlockSpellsLevel(ability, player.getLevel());
        if (spsv.isAbility(ability) && abilityStatus && spsv.isMpEnough(ability, player.getManaPoints())) {
            //This Spell Has Already Unlocked
            //And Ended Its Cool Down
            //And User's Mp Is Enough For This Spell
            int curMp = player.getManaPoints();
            player.setManaPoints(curMp - ability.getRequiredSkill_MP());
            int damageHP = ability.getDamage_HP();
            int realDamage = damageHP - monster.getPhysicalDefense() - monster.getMagicalDefense();
            int monsterHP = monster.getHealthPoints();
            monster.setHealthPoints(monsterHP - realDamage);
            System.out.println("You have " + ability.getSpellsName().toUpperCase() + " causing " + realDamage + " damage!");
            return true;
        }
        System.out.println("This Spell Is Invalid.");
        return false;
    }
    public boolean canUseDodgingSPells(Archetypes player){
        SpellsService spsv = new SpellsService();
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[1]);
        boolean abilityStatus = spsv.unlockSpellsLevel(ability, player.getLevel());
        if (spsv.isAbility(ability) && abilityStatus && spsv.isMpEnough(ability, player.getManaPoints())) {
            //This Spell Has Already Unlocked
            //And Ended Its Cooldown
            //And User's Mp Is Enough For This Spell
            int curMp = player.getManaPoints();
            player.setManaPoints(curMp - ability.getRequiredSkill_MP());
            return true;
        }
        else {
            System.out.println("This Spell Is Invalid.");
            return false;
        }
    }
    public boolean usingHealingSpells(Paladin player){
        //for paladin spell Holy Smite
            Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[9]);
            int curHp = player.getHealthPoints();
            if(curHp + ability.getSpellsHealthPoints() >= player.getShowHP()){
                player.setHealthPoints(player.getShowHP());
                System.out.println("Your Health Points Is Full.");
                return true;
            }
            else {
                player.setHealthPoints(curHp + ability.getSpellsHealthPoints());
                return true;
            }

    }





    public void WarriorSpells(Warrior player){
        //Display The Spells List And Spells Status During the Battle
        System.out.println(">> Spells");
        Ability a1 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[0]);
        Ability a2 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[1]);
        Ability a3 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[2]);
        showSpells(a1,player,"[A1]");
        showSpells(a2,player,"[A2]");
        showSpells(a3,player,"[A3]");

    }
    public boolean WarriorS1(Warrior player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[0]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }
    public boolean WarriorS3 (Warrior player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[2]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }

    public boolean MageS1(Mage player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[3]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }
    public boolean MageS3(Mage player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[5]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }

    public boolean RogueS1(Rogue player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[6]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }
    public boolean RogueS3(Rogue player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[8]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }

    public boolean PaladinS1(Paladin player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[9]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }
    public boolean PaladinS3(Paladin player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[11]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }
    public boolean ArcherS1(Archer player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[12]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }
    public boolean ArcherS2(Archer player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[13]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }
    public boolean ArcherS3(Archer player,Monster monster){
        Ability ability = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[14]);
        if(usingAtkSpells(ability,player,monster)){
            return true;
        }
        else
            return false;
    }
    public void MageSpells(Mage player){
        //Display The Spells List And Spells Status During the Battle

        System.out.println(">> Spells");
        Ability a1 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[3]);
        Ability a2 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[4]);
        Ability a3 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[5]);
        showSpells(a1,player,"[A1]");
        showSpells(a2,player,"[A2]");
        showSpells(a3,player,"[A3]");
        }

    public void RogueSpells(Rogue player){
        //Display The Spells List And Spells Status During the Battle

        System.out.println(">> Spells");
        Ability a1 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[6]);
        Ability a2 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[7]);
        Ability a3 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[8]);
        showSpells(a1,player,"[A1]");
        showSpells(a2,player,"[A2]");
        showSpells(a3,player,"[A3]");
    }

    public void PaladinSpells(Paladin player){
        //Display The Spells List And Spells Status During the Battle

        System.out.println(">> Spells");
        Ability a1 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[9]);
        Ability a2 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[10]);
        Ability a3 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[11]);
        showSpells(a1,player,"[A1]");
        showSpells(a2,player,"[A2]");
        showSpells(a3,player,"[A3]");
    }

    public void ArcherSpells(Archer player){
        //Display The Spells List And Spells Status During the Battle

        System.out.println(">> Spells");
        Ability a1 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[12]);
        Ability a2 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[13]);
        Ability a3 = ReadSpellsUtil.getAbilitysBySpellsName(player.getName(), spellsName[14]);
        showSpells(a1,player,"[A1]");
        showSpells(a2,player,"[A2]");
        showSpells(a3,player,"[A3]");
    }

}

