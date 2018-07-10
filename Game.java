public class Game {
    private String gameMode = null;

    public Game(String gameMode){
        if (gameMode.equals("console"))
            this.gameMode = "CONSOLE";
        else if (gameMode.equals("gui"))
            this.gameMode = "GUI";
        else{
            String report = String.format("ERROR: Wrong mode.\nUSAGE:\n%sjava -jar swing.jar console\n %sOR\n%sjava -jar swing.jar gui", padLeft(" ", 7), padLeft(" ", 19), padLeft(" ", 7));
            System.out.println(report);
            System.exit(0);
        } 
        System.out.printf("Hi, I'm %s!!!\n", this.gameMode);
            
    }

    private static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);  
    }

    public void run(){

    }
}