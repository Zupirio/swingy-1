import java.util.InputMismatchException;
import java.util.Scanner;

public class Console implements ViewMode {
    private final String name = "Console";

    public Console(){
        System.out.printf("Hi, I'm %s!!!\n", this.name);
    }

    public void init(){
        Scanner sc = null;
        int input;

        try {
            sc = new Scanner(System.in);
            System.out.println("Press 1 to create hero OR Press 2 to select hero:");
            if (!sc.hasNextInt())
                throw new InputMismatchException();
            input = sc.nextInt();
            if ((input < 1) || (2 < input))
                throw new InputMismatchException();
        } catch (InputMismatchException e){
            System.out.println("ERROR: Input should be 1 or 2.");
            if (sc != null)
                sc.close();
            System.exit(1);
        } finally {
            System.out.println("finally");
            if (sc != null)
                sc.close();
        }
        
        
    }

    public void run(){
        this.init();
    }
}