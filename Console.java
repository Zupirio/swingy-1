import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console implements ViewMode {
    private final String name = "Console";
    private Hero hero = null;

    public Console(){
        System.out.printf("%s MODE\n", this.name);
    }

    public void init(Scanner sc){
        int input = -1;

        try {
            System.out.println("\nYOU");
            sc = new Scanner(System.in);
            System.out.print("Press 1 to create hero OR Press 2 to select hero: ");
            if (!sc.hasNextInt())
                throw new Exception();
            input = sc.nextInt();
            sc.nextLine(); // Moving Line
            if ((input < 1) || (2 < input))
                throw new Exception();
        } catch (Exception e){
            System.out.println("\nERROR\nInput should be 1 or 2.");
            if (sc != null)
                sc.close();
            System.exit(1);
        } finally {
            if (input == 1)
                this.createHero(sc);
            else if (input == 2)
                this.selectHero(sc);
        }
    }

    public void createHero(Scanner sc){
        String name = null;
        String heroClass = null;
        int level;
        long experience;
        int attack;
        int defence;
        int hitPoints;

        System.out.println("\nGAME\nLets create a hero");
        System.out.println("\nYOU");

        try {
            System.out.print("Enter Name (String): ");
            name = sc.nextLine();
            
            System.out.print("Enter Class (String): ");
            heroClass = sc.nextLine();
            
            System.out.print("Enter Level (Integer between 1 - 5): ");
            level = sc.nextInt();
            if ((level < 1) || (5 < level))
                throw new Exception();
            sc.nextLine(); // Moving Line
            
            System.out.print("Enter Experience (Integer): ");
            experience = sc.nextLong();
            sc.nextLine(); // Moving Line
            
            System.out.print("Enter Attack (Integer): ");
            attack = sc.nextInt();
            sc.nextLine(); // Moving Line
            
            System.out.print("Enter Defence (Integer): ");
            defence = sc.nextInt();
            sc.nextLine(); // Moving Line
            
            System.out.print("Enter Hit Points (Integer): ");
            hitPoints = sc.nextInt();

            this.hero = new Hero(name, heroClass, level, experience, attack, defence, hitPoints);
        } catch (NoSuchElementException e){
            System.out.println("\n\nERROR\nWrong input data type");
            if (sc != null)
                sc.close();
            System.exit(1);
        } catch (Exception e){
            System.out.println("\n\nERROR\nInput should be between 1 - 5");
            if (sc != null)
                sc.close();
            System.exit(1);
        } finally {
            System.out.println("\nGAME:\nHero created.");
            System.out.println(this.hero.toString());
        }
    }

    public void selectHero(Scanner sc){

    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        this.init(sc);
    }
}