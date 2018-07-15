import java.util.List;

public class Map {
    private int level;
    private int gridSize;
    private int[][] grid;
    //List of villains
    //Current hero position

    public Map(int level) {
        this.level = level;
        this.gridSize = this.calculateGridSize(this.level);
        this.grid = new int[this.gridSize][this.gridSize];
    }

    private int calculateGridSize(int level){
        return ((level - 1) * 5 + 10 - (level % 2));
    }

    public String toString(){
        String map = "";

        for (int i = 0; i < gridSize; i++){
            map += "|";
            for (int j = 0; j < gridSize; j++){
                map += String.format("%d|", this.grid[i][j]);
            }
            map += "\n";
        }
        return map;
    }
}