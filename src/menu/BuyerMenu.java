package menu;

import abstracts.UserMenu;
import classes.Buyer;
import classes.RouterItem;
import classes.Seller;
import classes.StoreProduct;
import repos.SellerRepo;
import utils.Util;

public class BuyerMenu extends UserMenu<Buyer> {
    public BuyerMenu(Buyer user) {
        super(user);
        System.out.println("===== MENU PEMBELI =====");
        this.router.addRouterItems(
                new RouterItem("Cek Saldo", () -> {
                    this.handleBalanceCheck();
                    return false;
                }),
                new RouterItem("Top Up Saldo", () -> {
                    this.handleTopUpSaldo();
                    return false;
                }),
                new RouterItem("Cek Daftar Barang", () -> false),
                new RouterItem("Tambah Barang ke Keranjang", () -> false),
                new RouterItem("Checkout Keranjang", () -> false),
                new RouterItem("Lacak Barang", () -> false),
                new RouterItem("Lihat Laporan Pengeluaran", () -> false),
                new RouterItem("Lihat Riwayat Transaksi", () -> false));

        this.router.printAndPrompt(sharedScanner);
    }

    private long promptBalance() {
        return Long.parseLong(Util.promptString("Masukkan jumlah saldo yang ingin ditambah: ", sharedScanner));
    }

    private void handleTopUpSaldo() {
        long newBalance = promptBalance(); // prompt balanse :)
        System.out.println("Saldo saat ini: " + newBalance); // new balanse :)
    }

    private void handleCekDaftarBarang() {
        for (Seller seller : SellerRepo.getSellerList()) {
            System.out.println(seller.getUsername());
            for (StoreProduct product : seller.getStore().getAll()) {
                System.out.println(product.getName());
                System.out.printf("%-10s %10d.00 %10d\n", product.getName(), product.getPrice(), product.getAmount());
            }
        }
        System.out.println("======================");
    }
}
