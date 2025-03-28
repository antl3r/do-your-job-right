package menu;

import abstracts.Menu;
import classes.BurhanPedia;

public class CourierMenu extends Menu {
    private final BurhanPedia burhanPedia;

    public CourierMenu(BurhanPedia burhanPedia) {
        super(); // Call the appropriate constructor of the Menu class
        this.burhanPedia = burhanPedia;
    }
}
