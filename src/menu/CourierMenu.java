package menu;

import abstracts.UserMenu;
import classes.Courier;
import classes.RouterItem;

public class CourierMenu extends UserMenu<Courier> {
    public CourierMenu(Courier user) {
        super(user); // Call the appropriate constructor of the Menu class
        // Use SharedScanner.getInstance() wherever a Scanner is needed
        System.out.println("===== MENU KURIR =====");
        this.router.addRouterItems(
            new RouterItem("Find Job", () -> {return false;}),
            new RouterItem("Take Job", () -> {return false;}),
            new RouterItem("Confirm Job", () -> {return false;}),
            new RouterItem("Lihat Riwayat Transaksi", () -> {return false;}),
            new RouterItem("Kembali ke Menu Utama", () -> {return false;})
        );
    }

}
