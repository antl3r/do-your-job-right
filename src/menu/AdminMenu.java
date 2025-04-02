package menu;

import abstracts.UserMenu;
import classes.Admin;
import classes.RouterItem;
import java.util.Random;


public class AdminMenu extends UserMenu<Admin> {
    public AdminMenu(Admin user) {
        super(user);
        System.out.println("===== MENU ADMIN =====");
        this.router.addRouterItems(
            new RouterItem("Generate Voucher", () -> {
                this.handleGenerateVoucher();
                return false;
            }),
            new RouterItem("Generate Promo", () -> {return false;}),
            new RouterItem("Lihat Voucher", () -> {return false;}),
            new RouterItem("Lihat Promo", () -> {return false;}),
            new RouterItem("Kembali ke Menu Utama", () -> {return false;})
        );
        // Use SharedScanner.getInstance() wherever a Scanner is needed
    }

    private void handleGenerateVoucher(){
        Random random = new Random();
        StringBuilder id = new StringBuilder();
        StringBuilder convertedId = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            char randomChar = (char) ('A' + random.nextInt(26)); //pilih huruf acak a-z
            id.append(randomChar);

            int charValue = (randomChar - 'A' + 10) * i % 10; //konversi ke angka sesuai formula
            convertedId.append(charValue);
        }

        //TO DO add new generatedvoucher to repository here
        System.out.println("Kode Voucher Terbentuk: " + convertedId.toString());
        return;
    }
}
