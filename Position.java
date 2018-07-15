public class Position {
    private int x;
    private int y;
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public void changeX(int value){
        this.x += value;
    }

    public int getY(){
        return this.y;
    }

    public void changeY(int value){
        this.y += value;
    }
}