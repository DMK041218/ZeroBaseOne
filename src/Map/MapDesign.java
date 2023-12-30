package Map;

import java.util.Random;
import java.util.Scanner;
import testmonster.*;
public class MapDesign {
        private static final int MONSTER_TYPES = 7;
        char[][] map = new char[40][40];
        Monster[] monsters = new Monster[MONSTER_TYPES];
        int x,y,cur_x,cur_y;
        int monX,monY;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        //initialise the map
        public void generateMap(){
            for(int i = 0;i < 40;i++){
                for(int j = 0;j < 40;j++){
                    if(i==0 || i == 39 || j == 0 || j == 39)
                        map[i][j] = '#';
                    else
                        map[i][j] = ' ';
                }
            }
        }
        //player born at a random position
        public void bringPlayer(){
            x = random.nextInt(38) + 1;
            y = random.nextInt(38) + 1;
            map[x][y] = '@';
        }
        //5 monsters are generated at random position
        public void bringMonster(){
            while(true){
                monX = random.nextInt(38) + 1;
                monY = random.nextInt(38) + 1;
                if(monX != x && monY != y)
                    break;
            }
        }
        //TODO set a boolean array for not generating monster in the same place
        public void generateMonster(){
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
        public void printMap(){
            for(char[] row : map){
                for(char column : row)
                    System.out.print(column + "   ");
                System.out.println();
            }
        }

        //change coordinate and update the map
        public void movePlayer(){
            cur_x = x;
            cur_y = y;
            System.out.print("What's your next step?");
            char dir = scanner.next().toUpperCase().charAt(0);
            switch(dir){
                case'W':
                    //actually the coordinate cannot be changed when encounter the boundary
                    cur_x = Math.max((x-1),1);
                    break;
                case'S':
                    cur_x = Math.min(x+1, 38);
                    break;
                case'A':
                    cur_y = Math.max(y-1,1);
                    break;
                case'D':
                    cur_y = Math.min(x+1, 38);
                    break;
                default:
                    System.out.println("Where do you wanna go?");
            }
            if(map[cur_x][cur_y] != '#'){
                //last position turn back to empty
                map[x][y] = ' ';
                //change the current coordinate
                x = cur_x;
                y = cur_y;
                //set the current position as '@'
                map[x][y] = '@';
            }
        }

        public char checkForEncounter(){
            switch(map[x][y]) {
                case 'W':
                    return 'W';
                case 'G':
                    return 'G';
                case 'O':
                    return 'O';
                case 'S':
                    return 'S';
            }
            return ' ';
        }
    }

