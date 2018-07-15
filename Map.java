import java.util.HashMap;
import java.util.Random;

public class Map {
    private int level;
    private int gridSize;
    private int[][] grid;
    private HashMap<Integer, Character> characters;
    private static int numberOfCharacters = 0;
    //List of villains
    //Current hero position

    public Map(int level, Character hero) {
        this.level = level;
        this.gridSize = this.calculateGridSize(this.level);
        this.grid = new int[this.gridSize][this.gridSize];
        this.characters = new HashMap<Integer, Character>();
        this.createCharacters(hero);
    }

    private int calculateGridSize(int level){
        return ((level - 1) * 5 + 10 - (level % 2));
    }

    private void addHero(Character hero){
        int intialPosition = this.gridSize / 2;
        hero.setPosition(intialPosition, intialPosition);
        this.characters.put(++Map.numberOfCharacters, hero);
        this.grid[intialPosition][intialPosition] = 1;
    }

    private void addVillains(){
        Random random = new Random();
        int numberOfVillains = this.level * 5;
        int totalCharacters = 1 + numberOfVillains;
        for (int i = 2; i <= totalCharacters; i++){
            Character villain = new Villain();
            while (true){
                int x = random.nextInt(this.gridSize);
                int y = random.nextInt(this.gridSize);
                if (this.grid[x][y] == 0){
                    villain.setPosition(x, y);
                    this.grid[x][y] = ++Map.numberOfCharacters;
                    break;
                }
            }
            this.characters.put(Map.numberOfCharacters, villain);
            
        }
    }

    private void createCharacters(Character hero){
        this.addHero(hero);
        this.addVillains();
    }

    public String move(String direction){
        String status = null;
        Hero hero = (Hero)this.characters.get(1);

        if (direction.equals("N")){
            if (hero.getY() == 0){
                status = "END";
            } else {
                this.grid[hero.getX()][hero.getY()] = 0;
                hero.changePosition(0, -1);
                this.grid[hero.getX()][hero.getY()] = 1;
                status = "CONTINUE";
            }
        } else if (direction.equals("E")){
            if (hero.getX() == this.gridSize){
                status = "END";
            } else {
                this.grid[hero.getX()][hero.getY()] = 0;
                hero.changePosition(1, 0);
                this.grid[hero.getX()][hero.getY()] = 1;
                status = "CONTINUE";
            }
        } else if (direction.equals("W")){
            if (hero.getX() == 0){
                status = "END";
            } else {
                this.grid[hero.getX()][hero.getY()] = 0;
                hero.changePosition(-1, 0);
                this.grid[hero.getX()][hero.getY()] = 1;
                status = "CONTINUE";
            }
        } else if (direction.equals("S")){
            if (hero.getY() == this.gridSize){
                status = "END";
            } else {
                this.grid[hero.getX()][hero.getY()] = 0;
                hero.changePosition(0, 1);
                this.grid[hero.getX()][hero.getY()] = 1;
                status = "CONTINUE";
            }
        }

        return status;
    }

    public String toString(){
        String map = "";

        for (int i = 0; i < gridSize; i++){
            map += "|";
            for (int j = 0; j < gridSize; j++){
                map += String.format("%2d|", this.grid[i][j]);
            }
            map += "\n";
        }
        return map;
    }
}