public class Console implements ViewMode {
    private final String name = "Console";

    public Console(){
        System.out.printf("Hi, I'm %s!!!\n", this.name);
    }
}