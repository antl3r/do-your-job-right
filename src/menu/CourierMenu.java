package menu;

import abstracts.Menu;
import classes.BurhanPedia;
import classes.SharedScanner;

public class CourierMenu extends Menu {
    private final BurhanPedia burhanPedia;

    public CourierMenu(BurhanPedia burhanPedia) {
        super(); // Call the appropriate constructor of the Menu class
        this.burhanPedia = burhanPedia;
        // Use SharedScanner.getInstance() wherever a Scanner is needed
    }
}
