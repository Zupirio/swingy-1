import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console implements ViewMode {
    private final String name = "Console";
    private Hero hero = null;

    public Console(){
        System.out.printf("%s MODE\n", this.name);
    }

    public void init(){
        Scanner sc = null;
        int input = -1;

        try {
            System.out.println("\nYOU");
            sc = new Scanner(System.in);
            System.out.print("Press 1 to create hero OR Press 2 to select hero: ");
            if (!sc.hasNextInt())
                throw new InputMismatchException();
            input = sc.nextInt();
            if ((input < 1) || (2 < input))
                throw new InputMismatchException();
        } catch (InputMismatchException e){
            System.out.println("\nERROR\nInput should be 1 or 2.");
            if (sc != null)
                sc.close();
            System.exit(1);
        } finally {
            if (sc != null)
                sc.close();
            System.out.println("");
        }

        if (input == 1)
            this.createHero();
        else if (input == 2)
            this.selectHero();
    }

    public void createHero(){
        Scanner sc = null;
        String name = null;
        String heroClass = null;
        int level;
        long experience;
        int attack;
        int defence;
        int hitPoints;

        try {
            System.out.println("GAME\nLets create a hero");
            System.out.println("\nYOU");

            sc = new Scanner(System.in);

            System.out.print("Enter Name (String): ");
            name = sc.nextLine();

            System.out.print("\nEnter Class (String): ");
            heroClass = sc.nextLine();
            
            System.out.print("\nEnter Level (Integer between 1 - 5): ");
            level = sc.nextInt();
            
            System.out.print("\nEnter Experience (Integer): ");
            experience = sc.nextLong();
            
            System.out.print("\nEnter Attack (Integer): ");
            attack = sc.nextInt();
            
            System.out.print("\nEnter Defence (Integer): ");
            defence = sc.nextInt();
            
            System.out.print("\nEnter Hit Points (Integer): ");
            hitPoints = sc.nextInt();

            this.hero = new Hero(name, heroClass, level, experience, attack, defence, hitPoints);
        } catch (NoSuchElementException e){
            System.out.println("\n\nERROR\nWrong input data type");
            if (sc != null)
                sc.close();
            System.exit(1);
        } finally {
            System.out.println("\nGAME:\nHero created.");
            if (sc != null)
                sc.close();
        }
    }

    public void selectHero(){

    }

    public void run(){
        this.init();
    }
}