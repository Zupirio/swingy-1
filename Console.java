import java.util.InputMismatchException;
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
            sc.nextLine(); // Moving Cursor
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
            sc.nextLine(); // Moving Cursor
            
            System.out.print("Enter Experience (Integer): ");
            experience = sc.nextLong();
            sc.nextLine(); // Moving Cursor
            
            System.out.print("Enter Attack (Integer): ");
            attack = sc.nextInt();
            sc.nextLine(); // Moving Cursor
            
            System.out.print("Enter Defence (Integer): ");
            defence = sc.nextInt();
            sc.nextLine(); // Moving Cursor
            
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
            System.out.println(this.hero.heroStats());
        }
    }

    public void selectHero(Scanner sc){
        String heroes = null;
        int heroNumber = -1;
        String heroChosen = null;
        
        System.out.println("\nGAME\nLets select a hero");
        heroes = Tools.getSavedHeroes(Hero.FILENAME, sc);
        System.out.println(heroes);
        try {
            System.out.println("\nYOU");
            System.out.print("Press hero number you want to select: ");
            heroNumber = sc.nextInt();
            sc.nextLine(); // Moving Cursor

            heroChosen = heroes.split("\n")[heroNumber - 1];
            heroChosen = heroChosen.replaceFirst("[0-9]* - ", "");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nERROR\nHero number chosen doesn't exit.");
            System.exit(0);
        } catch (InputMismatchException e) {
            System.out.println("\nERROR\nWe only accept numbers.");
            System.exit(0);
        }

        try {
            String data[] = heroChosen.split(",");
            String name = data[0];
            String heroClass = data[1];
            int level = Integer.parseInt(data[2]);
            long experience = Long.parseLong(data[3]);
            int attack = Integer.parseInt(data[4]);
            int defence = Integer.parseInt(data[5]);
            int hitPoints = Integer.parseInt(data[6]);
            this.hero = new Hero(name, heroClass, level, experience, attack, defence, hitPoints);

            System.out.println("\nGAME\nHero Selected");
            System.out.println(this.hero.heroStats());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nERROR\nDatafile corrupt.");
            System.exit(0);
        }
        
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        this.init(sc);
        Map map = new Map(2, this.hero);
        String move = null;
        
        System.out.println(map.toString());

        while (true){
            System.out.print("YOU\nEnter your move: ");
            move = map.move(sc.nextLine());
            if (move.equals("END"))
                break;
            System.out.println("\nGAME");
            System.out.println(map.toString());
        }
    }
}