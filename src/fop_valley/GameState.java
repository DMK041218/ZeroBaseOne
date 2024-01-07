package fop_valley;

import test.*;
import java.io.*;
public class GameState extends Archetypes implements Serializable {
    public GameState(){
    //constructor
    }
    public void saveData(Archetypes player){
        this.healthPoints = player.getHealthPoints();
        this.manaPoints = player.getManaPoints();
        this.level = player.getLevel();
        this.xp = player.getXp();
        this.magicalDefense = player.getMagicalDefense();
        this.physicalDefense = player.getPhysicalDefense();
        this.magicalAttack = player.getMagicalAttack();
        this.physicalAttack = player.getPhysicalAttack();
    }
    @Override
    public String toString(){
        return ""+this.level+
                "\n"+this.xp+
                "\n"+this.healthPoints+
                "\n"+this.manaPoints+
                "\n"+this.physicalDefense+
                "\n"+this.magicalDefense+
                "\n"+this.physicalAttack+
                "\n"+this.magicalAttack;

    }
    public void saveGame(GameState gameState){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/fop_valley/saveGame.dat"))) {
            out.writeObject(gameState);
        } catch (IOException e) {
            System.out.println("Problems Occurred When Saving Current Game.");
        }
    }


    public void loadGame(){
        GameState gameState = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/fop_valley/saveGame.dat"))) {
            gameState = (GameState) in.readObject();
        } catch (IOException e) {
            System.out.println("Problems Occurred When Reading Data.");
        } catch (ClassNotFoundException e) {
            System.out.println("You Dont Have Any Previous Save Yet.");
        }

    }
}





