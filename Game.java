public class Game {
    private final String FILENAME = "heroes.txt";
    private String gameMode = null;
    private ViewMode view = null;

    public Game(String gameMode){
        if (gameMode.equals("console")){
            this.gameMode = "CONSOLE";
            this.view = new Console();
        }
        else if (gameMode.equals("gui")){
            this.gameMode = "GUI";
            this.view = new GUI();
        }
        else{
            String report = String.format("ERROR: Wrong mode.\nUSAGE:\n%sjava -jar swing.jar console\n %sOR\n%sjava -jar swing.jar gui", padLeft(" ", 7), padLeft(" ", 19), padLeft(" ", 7));
            System.out.println(report);
            System.exit(0);
        }
    }

    private static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);  
    }

    public void run(){

    }
}