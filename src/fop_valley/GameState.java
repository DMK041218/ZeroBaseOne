package fop_valley;
import java.io.*;
import test.*;
public class GameState implements Serializable {
    protected String name;
    protected String playerName;
    protected int level;
    protected int xp;
    protected int healthPoints;
    protected int manaPoints;
    protected int physicalDefense;
    protected int magicalDefense;
    protected int physicalAttack;
    protected int magicalAttack;

    public GameState(){

    }
    @Override
    public String toString(){
        return  "Your Most Recent Game Save:" +
                "Player Name: " + playerName + "\n" +
                "Character Name: " + name + "\n" +
                "HP: " + healthPoints + "\n" +
                "Magical Defense: " + magicalDefense + "\n" +
                "Physical Defense: " + physicalDefense + "\n" + "ManaPoints: " + manaPoints + "\n" + "Physical Attack: " +
                physicalAttack + "\n" + "Magical Attack: " + magicalAttack + "\n";
    }
    public void saveData(Archetypes player){
        this.name = player.getName();
        this.playerName = player.getPlayerName();
        this.healthPoints = player.getHealthPoints();
        this.manaPoints = player.getManaPoints();
        this.level = player.getLevel();
        this.xp = player.getXp();
        this.magicalDefense = player.getMagicalDefense();
        this.physicalDefense = player.getPhysicalDefense();
        this.magicalAttack = player.getMagicalAttack();
        this.physicalAttack = player.getPhysicalAttack();
    }

    public void saveGame(GameState gameState){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/fop_valley/saveGame.dat"))) {
            out.writeObject(gameState);
        } catch (IOException e) {
            System.out.println("Problems Occurred When Saving Data.");
            e.printStackTrace();
        }
    }

    public void loadGame() {
        GameState gameState = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/fop_valley/saveGame.dat"))) {
            gameState = (GameState) in.readObject();
        } catch (IOException e) {
            System.out.println("Problems Occurred When Reading Data.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("You haven't Saved Any Data Yet.");
            e.printStackTrace();
        }
        //Please Add Your LoadFunction Here
    }

}
