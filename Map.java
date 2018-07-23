import java.util.HashMap;
import java.util.Random;

public class Map {
    private int level;
    private int gridSize;
    private int[][] grid;
    private HashMap<Integer, Character> characters; // HERO & VILLAINS
    private static int numberOfCharacters = 0;
    private int heroSymbol;

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
        this.heroSymbol = Map.numberOfCharacters;
        this.grid[intialPosition][intialPosition] = 1;
    }

    private void addVillains(){
        Random random = new Random();
        int numberOfVillains = this.level * 5;
        int totalCharacters = 1 + numberOfVillains;
        for (int i = 2; i <= totalCharacters; i++){
            Character villain = new Villain();
            while (true){
                int row = random.nextInt(this.gridSize);
                int column = random.nextInt(this.gridSize);
                if (this.grid[row][column] == 0){
                    villain.setPosition(row, column);
                    this.grid[row][column] = ++Map.numberOfCharacters;
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

    public String[] getMetVillainsPosition(){
        String villainsPositions = null;
        Hero hero = (Hero)this.characters.get(this.heroSymbol);
        int row = hero.getRow();
        int column = hero.getColumn();

        if (this.grid[row - 1][column] > 0){
            if (villainsPositions == null)
                villainsPositions = row + "," + column;
            else
                villainsPositions += row + "," + column;
        } else if (this.grid[row][column + 1] > 0){
            if (villainsPositions == null)
                villainsPositions = row + "," + column;
            else
                villainsPositions += "\n" + row + "," + column;
        }
        else if (this.grid[row][column - 1] > 0){
            if (villainsPositions == null)
                villainsPositions = row + "," + column;
            else
                villainsPositions += "\n" + row + "," + column;
        }
        else if (this.grid[row + 1][column] > 0){
            if (villainsPositions == null)
                villainsPositions = row + "," + column;
            else
                villainsPositions += "\n" + row + "," + column;
        }
        return villainsPositions.split("\n");
    }

    public Boolean metVillain(){
        Boolean status = false;
        Hero hero = (Hero)this.characters.get(this.heroSymbol);
        int row = hero.getRow();
        int column = hero.getColumn();
        
        // North
        if (this.grid[row - 1][column] > 0)
            status = true;

        // East
        else if (this.grid[row][column + 1] > 0)
            status = true;

        // West
        else if (this.grid[row][column - 1] > 0)
            status = true;

        // South
        else if (this.grid[row + 1][column] > 0)
            status = true;

        return status;
    }

    private String navigation(String direction){
        String status = null;
        Hero hero = (Hero)this.characters.get(this.heroSymbol);
        int row = hero.getRow();
        int column = hero.getColumn();

        if (direction.equals("N")){
            if (row == 0){
                status = "END";
            } else {
                this.grid[row][column] = 0;
                hero.changePosition(-1, 0);
                this.grid[hero.getRow()][hero.getColumn()] = 1;
                status = "CONTINUE";
            }
        } else if (direction.equals("E")){
            if (hero.getColumn() == (this.gridSize - 1)){
                status = "END";
            } else {
                this.grid[hero.getRow()][hero.getColumn()] = 0;
                hero.changePosition(0, 1);
                this.grid[hero.getRow()][hero.getColumn()] = 1;
                status = "CONTINUE";
            }
        } else if (direction.equals("W")){
            if (hero.getColumn() == 0){
                status = "END";
            } else {
                this.grid[hero.getRow()][hero.getColumn()] = 0;
                hero.changePosition(0, -1);
                this.grid[hero.getRow()][hero.getColumn()] = 1;
                status = "CONTINUE";
            }
        } else if (direction.equals("S")){
            if (hero.getRow() == (this.gridSize - 1)){
                status = "END";
            } else {
                this.grid[hero.getRow()][hero.getColumn()] = 0;
                hero.changePosition(1, 0);
                this.grid[hero.getRow()][hero.getColumn()] = 1;
                status = "CONTINUE";
            }
        }

        return status;
    }

    public String move(String direction){
        return this.navigation(direction);
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