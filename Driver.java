public class Driver {
    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);  
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);  
    }

    public static void main(String[] args) {
        String report = null;
        if (args.length != 1){
            report = String.format("ERROR: 1 argument required.\nUSAGE: java -jar swing.jar [VIEW MODE]");
            System.out.println(report);
            System.exit(0);
        }

        if (args[0].equals("console"))
            System.out.println("Hi, I'm CONSOLE!!!");
        else if (args[0].equals("gui"))
            System.out.println("Hi, I'm GUI!!!");
        else{
            report = String.format("ERROR: Wrong mode.\nUSAGE:\n%sjava -jar swing.jar console\n %sOR\n%sjava -jar swing.jar gui", padLeft(" ", 7), padLeft(" ", 19), padLeft(" ", 7));
            System.out.println(report);
            System.exit(0);
        }
    }
}