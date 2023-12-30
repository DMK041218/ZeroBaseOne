package test;

import java.io.*;


public class Mage extends Archetypes {
    public Mage(){
        try(BufferedReader reader = new BufferedReader(new FileReader("src/test/archetypes.txt"))){

            String line;
            int L = 0;

            while ((line = reader.readLine()) != null) {
                L++;
                String[] parts = line.split(",");
                if (parts.length == 7&&L==2) {
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
        } catch(FileNotFoundException e){
            System.out.println("Archetypes.txt was not found");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading from Archetypes.txt");
        }
    }
    public Mage(String name, int healthPoints, int manaPoints, int physicalDefense, int magicalDefense,
                   int physicalAttack, int magicalAttack) {
        super(name, healthPoints, manaPoints, physicalDefense, magicalDefense, physicalAttack, magicalAttack);
        try(BufferedReader reader = new BufferedReader(new FileReader("src/test/archetypes.txt"))){

            String line;
            int L = 0;

            while ((line = reader.readLine()) != null) {
                L++;
                String[] parts = line.split(",");
                if (parts.length == 7&&L==2) {
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
        }
        catch(FileNotFoundException e){
            System.out.println("Archetypes.txt was not found");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading from Archetypes.txt");
        }

    }

    //The rate of attribute increase upon leveling up will vary based on the character's archetype
    @Override
    public void levelUp() {
        super.levelUp();
        magicalAttack += 15;
        manaPoints += 100;
    }

}
    

