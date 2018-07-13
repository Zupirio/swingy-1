import java.util.Scanner;

public interface ViewMode {
    public void init(Scanner sc);
    public void createHero(Scanner sc);
    public void selectHero(Scanner sc);
    public void run();
    // public void createMap();
    // public void initialPosition();
    // public void randomVillains();
    // public void heroFight();
    // public void heroWinLose();
    // public void heroRun();
}