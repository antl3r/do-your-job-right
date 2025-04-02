import classes.BurhanPedia;
import classes.SharedScanner;
import menu.MainMenu;

public class App {
    private static BurhanPedia burhanPedia = new BurhanPedia();

    public static void main(String[] args) throws Exception {
        SharedScanner.getInstance(); // Ensure SharedScanner is initialized if needed
        new MainMenu(burhanPedia).display();
    }
}

