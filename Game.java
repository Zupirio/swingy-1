public class Game {
    private final String FILENAME = "heroes.txt";
    private String gameMode = null;
    private ViewMode view = null;

    public Game(String gameMode){
        if (gameMode.equals("console")){
            this.gameMode = "CONSOLE";
            this.view = new Console();
            this.view.run();
        }
        else if (gameMode.equals("gui")){
            this.gameMode = "GUI";
            //this.view = new GUI();
        }
        else{
            String report = String.format("ERROR: Wrong mode.\nUSAGE:\n%sjava -jar swing.jar console\n %sOR\n%sjava -jar swing.jar gui", Tools.padLeft(" ", 7), Tools.padLeft(" ", 19), Tools.padLeft(" ", 7));
            System.out.println(report);
            System.exit(1);
        }
    }

    public void run(){

    }
}