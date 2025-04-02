package menu;

import abstracts.Menu;
import classes.BurhanPedia;
import classes.RouterItem;

public class CourierMenu extends Menu {
    private final BurhanPedia burhanPedia;

    public CourierMenu(BurhanPedia burhanPedia) {
        super(); // Call the appropriate constructor of the Menu class
        this.burhanPedia = burhanPedia;
        // Use SharedScanner.getInstance() wherever a Scanner is needed
        System.out.println("===== MENU PEMBELI =====");
        this.router.addRouterItems(
            
             new RouterItem("Find Job", () -> {return false;}),
            new RouterItem("Take Job", () -> {return false;}),
            new RouterItem("Confirm Job", () -> {return false;}),
            new RouterItem("Lihat Riwayat Transaksi", () -> {return false;}),
            new RouterItem("Kembali ke Menu Utama", () -> {return false;})
        );
    }

}
