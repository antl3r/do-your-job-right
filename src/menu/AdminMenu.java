package menu;

import abstracts.Menu;
import classes.BurhanPedia;
import classes.RouterItem;
import classes.SharedScanner;

public class AdminMenu extends Menu {
    private final BurhanPedia burhanPedia;

    public AdminMenu(BurhanPedia burhanPedia) {
        super(
            new RouterItem("Generate Voucher", () -> {return false;}),
            new RouterItem("Generate Promo", () -> {return false;}),
            new RouterItem("Lihat Voucher", () -> {return false;}),
            new RouterItem("Lihat Promo", () -> {return false;}),
            new RouterItem("Kembali ke Menu Utama", () -> {return false;})
        );
        this.burhanPedia = burhanPedia;
        // Use SharedScanner.getInstance() wherever a Scanner is needed
    }
}
