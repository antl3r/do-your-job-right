package menu;

import abstracts.UserMenu;
import classes.Buyer;
import classes.RouterItem;
import utils.Util;

public class BuyerMenu extends UserMenu<Buyer> {
    public BuyerMenu(Buyer user) {
        super(user);
        System.out.println("===== MENU PEMBELI =====");
        this.router.addRouterItems(
                new RouterItem("Cek Saldo", () -> {
                    this.handleCekSaldo();
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

    private void handleCekSaldo() {
        System.out.println("Saldo saat ini: " + user.getBalance());
    }

    private long promptBalance() {
        return Integer.parseInt(Util.promptString("Masukkan jumlah saldo yang ingin ditambah: ", sharedScanner));
    }

    private void handleTopUpSaldo() {
        long newBalance = promptBalance(); // prompt balanse :)
        System.out.println("Saldo saat ini: " + newBalance); // new balanse :)
    }

    private void handleCekDaftarBarang() {
        System.out.println("======================");
    }
}
