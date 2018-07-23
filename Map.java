import java.util.HashMap;
import java.util.Random;

public class Map {
    private int level;
    private int gridSize;
    private int[][] grid;
    private HashMap<Integer, Character> characters; // HERO & VILLAINS
    private static int numberOfCharacters = 0;
    private int heroSymbol;
    private final String[] meetOutcomes = {"RUN", "FIGHT"};

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

    public String getMetVillainsPositionString(){
        String results = null;
        String villainsPositions[] = this.getMetVillainsPosition();

        for (int i = 0; i < villainsPositions.length; i++){
            String[] position = villainsPositions[i].split(",");
            if (results == null)
                results = String.format("\tVillain at [%s:%s]\n", position[0], position[1]);
            else
                results += String.format("\tVillain at [%s:%s]\n", position[0], position[1]);
        }

        return results;
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

    public String meetOutcomes(){
        String results = null;
        Hero hero = (Hero)this.characters.get(this.heroSymbol);
        int row = hero.getRow();
        int column = hero.getColumn();
        int prow = -1;
        int pcolumn = -1;
        
        if (hero.getPreviousPosition() == null){
            results = "FIGHT";
        } else {
            results = this.meetOutcomes[new Random().nextInt(2)];
            if (results.equals("RUN")){
                prow = hero.getPreviousPosition().getRow();
                pcolumn = hero.getPreviousPosition().getColumn();
                
                this.grid[row][column] = 0;
                hero.setPosition(prow, pcolumn);
                hero.makePreviousPositionNull();
                this.grid[prow][pcolumn] = 1;
            }
        }

        return results;
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