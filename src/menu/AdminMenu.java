package menu;

import abstracts.UserMenu;
import classes.Admin;
import classes.RouterItem;


public class AdminMenu extends UserMenu<Admin> {
    public AdminMenu(Admin user) {
        super(user);
        System.out.println("===== MENU ADMIN =====");
        this.router.addRouterItems(
            new RouterItem("Generate Voucher", () -> {return false;}),
            new RouterItem("Generate Promo", () -> {return false;}),
            new RouterItem("Lihat Voucher", () -> {return false;}),
            new RouterItem("Lihat Promo", () -> {return false;}),
            new RouterItem("Kembali ke Menu Utama", () -> {return false;})
        );
        // Use SharedScanner.getInstance() wherever a Scanner is needed
    }
}
