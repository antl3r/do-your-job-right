package menu;

import abstracts.Menu;
import classes.BurhanPedia;
import classes.RouterItem;
import classes.SharedScanner;

public class AdminMenu extends Menu {
    private final BurhanPedia burhanPedia;

    public AdminMenu(BurhanPedia burhanPedia) {
        super(
            new RouterItem("Choice1", () -> {return false;}),
            new RouterItem("Choice2", () -> {return false;}),
            new RouterItem("Choice3", () -> {return false;})
        );
        this.burhanPedia = burhanPedia;
        // Use SharedScanner.getInstance() wherever a Scanner is needed
    }
}
