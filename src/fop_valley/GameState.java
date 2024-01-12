package fop_valley;

import test.*;
import java.io.*;
import java.util.Scanner;
public class GameState extends Archetypes implements Serializable {
    public GameState(){
    //constructor
    }
    @Override
    public String toString(){
        return
                this.level+
                "\n"+this.xp+
                "\n"+this.healthPoints+
                "\n"+this.manaPoints+
                "\n"+this.physicalDefense+
                "\n"+this.magicalDefense+
                "\n"+this.physicalAttack+
                "\n"+this.magicalAttack;

    }
    public void saveGame(Archetypes player){
        try{ PrintWriter writer = new PrintWriter("saveGame.txt");
            writer.println(player.getName());
            writer.println(player.getPlayerName());
            writer.println(player.getHealthPoints());
            writer.println(player.getManaPoints());
            writer.println(player.getLevel());
            writer.println(player.getXp());
            writer.println((player.getMagicalAttack()));
            writer.println(player.getPhysicalAttack());
            writer.println(player.getMagicalDefense());
            writer.println(player.getPhysicalDefense());
            System.out.println("Saved Successfully");
            writer.close();
         }  catch (IOException e) {
            System.out.println("Problems Occurred When Saving Current Game.");
        }
    }


    public Archetypes loadGame(){
        try{
            Scanner sc = new Scanner(new File("saveGame.txt"));
            String name = sc.nextLine();
            String PlayerName = sc.nextLine();
            int healthPoints = sc.nextInt();
            int manaPoints = sc.nextInt();
            int level = sc.nextInt();
            int xp = sc.nextInt();
            int magicalAttack = sc.nextInt();
            int physicalAttack = sc.nextInt();
            int magicalDefense = sc.nextInt();
            int physicalDefense = sc.nextInt();
            return new Archetypes(name,PlayerName,healthPoints,manaPoints,level,xp,magicalAttack,physicalAttack,magicalDefense,physicalDefense);
        } catch (IOException e) {
            System.out.println("Problems Occurred When Reading Data.");
        }
        return null;
    }
}
    






