package menu;

import abstracts.Menu;

public class SellerMenu extends Menu {
    private final BurhanPedia burhanPedia;

    public SellerMenu(BurhanPedia burhanPedia) {
        super(
            new RouterItem("Choice1", () -> {return false;}),
            new RouterItem("Choice2", () -> {return false;}),
            new RouterItem("Choice3", () -> {return false;})
        );
        this.burhanPedia = burhanPedia;
        // Use SharedScanner.getInstance() wherever a Scanner is needed
    }
}
