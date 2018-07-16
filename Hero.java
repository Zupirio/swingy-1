public class Hero extends Character{
    public static final String FILENAME = "heroes.txt";
    private String name = null;
    private String heroClass = null;
    private int level;
    private long experience;
    private int attack;
    private int defence;
    private int hitPoints;
    
    public Hero(String name, String heroClass, int level, long experience, int attack, int defence, int hitPoints){
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
    }

    public String heroStats(){
        String results = null;

        results = "--- Hero Stats ---\n";
        results += String.format("Name: %s\n", this.name);
        results += String.format("Class: %s\n", this.heroClass);
        results += String.format("Level: %s\n", this.level);
        results += String.format("Experience: %s\n", this.experience);
        results += String.format("Attack: %s\n", this.attack);
        results += String.format("Defence: %s\n", this.defence);
        results += String.format("Hit Points: %s\n", this.hitPoints);
        return results;
    }

    public void changePosition(int row, int column){
        this.position.changeRow(row);
        this.position.changeColum(column);
    }

    public String toString(){
        String results = null;

        results = String.format("%s,%s,%s,%d,%d,%d,%d", this.name, this.heroClass, this.level, this.experience, this.attack, this.defence, this.hitPoints);
        return results;
    }
}