package Map;

import java.util.Random;
import java.util.Scanner;

import fop_valley.BasicFunctions;
import util.ColorText;
public class MapDesign {
    private static final int MONSTER_TYPES = 7;
    char[][] map = new char[40][40];
    boolean[][] isOccupied = new boolean[40][40];
    private int x, y, cur_x, cur_y;
    private int monX, monY;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    //initialise the map
    public void generateMap() {
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if (i == 0 || i == 39 || j == 0 || j == 39)
                    map[i][j] = '#';
                else
                    map[i][j] = ' ';
            }
        }
    }

    //player born at a random position


    public void bringPlayer() {
        x = random.nextInt(38) + 1;
        y = random.nextInt(38) + 1;
        map[x][y] = '@';
        isOccupied[x][y] = true;
    }
    //7 monsters are generated at random position

    public void bringMonster() {
        while (true) {
            monX = random.nextInt(38) + 1;
            monY = random.nextInt(38) + 1;
            if (!isOccupied[monX][monY]) {
                isOccupied[monX][monY] = true;
                break;
            }
        }
    }

    public void generateMonster() {
        for (int i = 0; i < MONSTER_TYPES; i++) {
            int monsterType = random.nextInt(MONSTER_TYPES);
            switch (monsterType) {
                case 0:
                    bringMonster();
                    map[monX][monY] = 'W';
                    //generate a monster Witch
                    break;
                case 1:
                    bringMonster();
                    //generate a monster Goblin
                    map[monX][monY] = 'G';
                    break;
                case 2:
                    bringMonster();
                    //generate a monster Harpy
                    map[monX][monY] = 'H';
                    break;
                case 3:
                    bringMonster();
                    //generate a monster Orc
                    map[monX][monY] = 'O';
                    break;
                case 4:
                    bringMonster();
                    //generate a monster Skeleton
                    map[monX][monY] = 'S';
                    break;
                case 5:
                    bringMonster();
                    map[monX][monY] = 'W';
                    //generate a monster Witch
                    break;
                case 6:
                    bringMonster();
                    //generate a monster Goblin
                    map[monX][monY] = 'G';
                    break;
            }
        }
    }

    public void printMap() {
        for (char[] row : map) {
            for (char column : row)
                System.out.print(column + "   ");
            System.out.println();
        }
    }

    //change coordinate and update the map
    public char movePlayer() {
        cur_x = x;
        cur_y = y;
        boolean isMovementSuccessful = false;
        do{
            System.out.println("What's your next step?");
            System.out.print("-->");
            char dir = scanner.next().toUpperCase().charAt(0);
            switch (dir) {
                case 'W':
                    //actually the coordinate cannot be changed when encounter the boundary
                    cur_x = Math.max((x - 1), 1);
                    isMovementSuccessful = true;
                    break;
                case 'S':
                    cur_x = Math.min(x + 1, 38);
                    isMovementSuccessful = true;
                    break;
                case 'A':
                    cur_y = Math.max(y - 1, 1);
                    isMovementSuccessful = true;
                    break;
                case 'D':
                    cur_y = Math.min(y + 1, 38);
                    isMovementSuccessful = true;
                    break;
                default:
                    System.out.println("Adventurer, you have gone too far.\n");
            }
        }while(!isMovementSuccessful);
        //check encounter
        if (map[cur_x][cur_y] != '#' && !isOccupied[cur_x][cur_y]) {
            //last position turn back to empty
            //update the map
            map[x][y] = ' ';
            isOccupied[x][y] = false;
            isOccupied[cur_x][cur_y] = true;
            //change the current coordinate
            x = cur_x;
            y = cur_y;
            //set the current position as '@'
            map[x][y] = '@';
            return ' ';
        }
        else if (map[cur_x][cur_y] != '#' && isOccupied[cur_x][cur_y]) {
            switch(map[cur_x][cur_y]) {
                //encounter witch
                case 'W':
                    //last position turn back to empty
                    //update the map
                    map[x][y] = ' ';
                    isOccupied[x][y] = false;
                    isOccupied[cur_x][cur_y] = true;
                    //change the current coordinate
                    x = cur_x;
                    y = cur_y;
                    //set the current position as '@'
                    System.out.println(ColorText.colorText("You startled the Witch!",ColorText.RED));
                    map[x][y] = '@';
                    return 'W';
                //encounter goblin
                case 'G':
                    //last position turn back to empty
                    //update the map
                    map[x][y] = ' ';
                    isOccupied[x][y] = false;
                    isOccupied[cur_x][cur_y] = true;
                    //change the current coordinate
                    x = cur_x;
                    y = cur_y;
                    //set the current position as '@'
                    System.out.println(ColorText.colorText("A sleeping goblin was awakened by you...",ColorText.RED));
                    BasicFunctions.printASCII("Goblin");
                    map[x][y] = '@';
                    return 'G';
                //encounter Orc
                case 'O':
                    //last position turn back to empty
                    //update the map
                    map[x][y] = ' ';
                    isOccupied[x][y] = false;
                    isOccupied[cur_x][cur_y] = true;
                    //change the current coordinate
                    x = cur_x;
                    y = cur_y;
                    //set the current position as '@'
                    System.out.println(ColorText.colorText("An orc roars and charges towards you!",ColorText.RED));
                    BasicFunctions.printASCII("Orc");
                    map[x][y] = '@';
                    return 'O';
                //encounter Skeleton
                case 'S':
                    //last position turn back to empty
                    //update the map
                    map[x][y] = ' ';
                    isOccupied[x][y] = false;
                    isOccupied[cur_x][cur_y] = true;
                    //change the current coordinate
                    x = cur_x;
                    y = cur_y;
                    //set the current position as '@'
                    System.out.println(ColorText.colorText("Brace yourself,the skeleton has you in its sight...",ColorText.RED));
                    BasicFunctions.printASCII("Skeleton");
                    map[x][y] = '@';
                    return 'S';
                //encounter Harpy
                case 'H':
                    //last position turn back to empty
                    //update the map
                    map[x][y] = ' ';
                    isOccupied[x][y] = false;
                    isOccupied[cur_x][cur_y] = true;
                    //change the current coordinate
                    x = cur_x;
                    y = cur_y;
                    //set the current position as '@'
                    System.out.println(ColorText.colorText("You have strayed into harpy's territory...",ColorText.RED));
                    BasicFunctions.printASCII("Harpy");
                    map[x][y] = '@';
                    return 'H';
                default:
                    //last position turn back to empty
                    //update the map
                    map[x][y] = ' ';
                    isOccupied[x][y] = false;
                    isOccupied[cur_x][cur_y] = true;
                    //change the current coordinate
                    x = cur_x;
                    y = cur_y;
                    //set the current position as '@'
                    map[x][y] = '@';
                    return ' ';
            }
        }
        else
            return ' ';

    }
        public void setOccupied(){
            isOccupied[x][y] = false;
        }
        public boolean curMapFinish() {
        int cnt = 0;
            for(int i = 1;i < 39;i++){
                for(int j =1;j < 39;j++){
                    if(isOccupied[i][j] == true)
                        cnt++;
                }
            }
            if(cnt == 1){
                return true;
            }
            else
                return false;
        }
    }

