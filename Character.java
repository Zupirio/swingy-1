public class Character {
    protected Position position;

    public int getX(){
        return this.position.getX();
    }

    public int getY(){
        return this.position.getY();
    }

    public void setPosition(int x, int y){
        this.position = new Position(x, y);
    }
}