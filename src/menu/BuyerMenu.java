package menu;

import abstracts.Menu;
import classes.BurhanPedia;
import classes.RouterItem;

public class BuyerMenu extends Menu {
    private final BurhanPedia burhanPedia;

    public BuyerMenu(BurhanPedia burhanPedia) {
        super(
            new RouterItem("Choice1", () -> {return false;}),
            new RouterItem("Choice2", () -> {return false;}),
            new RouterItem("Choice3", () -> {return false;})
        );
        this.burhanPedia = burhanPedia;
    }
}
