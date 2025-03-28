import classes.BurhanPedia;
import menu.MainMenu;

public class App {
    private static BurhanPedia burhanPedia = new BurhanPedia();
    public static void main(String[] args) throws Exception {
        new MainMenu(burhanPedia).display(burhanPedia.scanner);
    }
}

