package util;

import com.alibaba.fastjson.JSONArray;
import testSpells.Ability;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//ability
public class ReadSpellsUtil {

    private static Map<String, List<Ability>> nameAbilities = readSpells();


    //Read spells.txt, text, and convert the data into Map
    private static Map<String, List<Ability>> readSpells() {
        String str = "";
        try {
            File filename = new File(Constants.spellsPath);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                str += line;
            }
            reader.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, List<Ability>> nameAbilities = new HashMap<>();
        String[] split = str.split(Constants.semicolon);
        for (String s : split) {
            String key = s.substring(0, s.indexOf(Constants.colon));
            try {
                String substring = s.substring(s.indexOf(Constants.colon) + 1, s.length());
                List<Ability> jsonList = JSONArray.parseArray(substring, Ability.class);
                nameAbilities.put(key, jsonList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nameAbilities;
    }


    //Enter the character name to get the character skill list
    public static List<Ability> getAbilitysByArchetypesName(String name) {
        return nameAbilities.get(name);
    }

    //Get skill beans based on character name and skill name
    public static Ability getAbilitysBySpellsName(String name, String spellsName) {
        List<Ability> abilities = nameAbilities.get(name);
        for (Ability ability: abilities) {
            if(ability.getSpellsName().equals(spellsName)){
                return ability;
            }
        }
        return null;
    }



}
