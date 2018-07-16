public class Character {
    protected Position position;

    public int getRow(){
        return this.position.getRow();
    }

    public int getColumn(){
        return this.position.getColumn();
    }

    public void setPosition(int row, int column){
        this.position = new Position(row, column);
    }
}