package test;

import java.io.*;

public class Mage extends Archetypes {
    public Mage() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/archetypes.txt"))) {

            String line;
            int L = 0;

            while ((line = reader.readLine()) != null) {
                L++;
                String[] parts = line.split(",");
                if (parts.length == 7 && L == 2) {
                    name = parts[0];
                    healthPoints = Integer.parseInt(parts[1]);
                    manaPoints = Integer.parseInt(parts[2]);
                    this.showMP = manaPoints;
                    this.showHP = healthPoints;
                    physicalDefense = Integer.parseInt(parts[3]);
                    magicalDefense = Integer.parseInt(parts[4]);
                    physicalAttack = Integer.parseInt(parts[5]);
                    magicalAttack = Integer.parseInt(parts[6]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archetypes.txt was not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading from Archetypes.txt");
        }
    }

    public Mage(String name, String playerName, int healthPoints, int manaPoints, int physicalDefense,
            int magicalDefense,
            int physicalAttack, int magicalAttack) {
        super(name, playerName, healthPoints, manaPoints, physicalDefense, magicalDefense, physicalAttack,
                magicalAttack);
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/archetypes.txt"))) {

            String line;
            int L = 0;

            while ((line = reader.readLine()) != null) {
                L++;
                String[] parts = line.split(",");
                if (parts.length == 7 && L == 2) {
                    name = parts[0];
                    healthPoints = Integer.parseInt(parts[1]);
                    manaPoints = Integer.parseInt(parts[2]);
                    this.showMP = manaPoints;
                    this.showHP = healthPoints;
                    physicalDefense = Integer.parseInt(parts[3]);
                    magicalDefense = Integer.parseInt(parts[4]);
                    physicalAttack = Integer.parseInt(parts[5]);
                    magicalAttack = Integer.parseInt(parts[6]);

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archetypes.txt was not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading from Archetypes.txt");
        }

    }

    // The rate of attribute increase upon leveling up will vary based on the
    // character's archetype
    @Override
    public void levelUp() {
        super.levelUp();
        magicalAttack += 10;
        showMP += 30;
        manaPoints += 30;
    }

    public Mage(String name, String playerName, int healthPoints, int manaPoints, int level, int xp, int magicalAttack,
            int physicalAttack, int magicalDefense, int physicalDefense) {
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
        this.level = level;
        ;
        this.xp = xp;
    }

}
