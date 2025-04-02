package menu;

import abstracts.Menu;
import classes.BurhanPedia;
import classes.RouterItem;

public class BuyerMenu extends Menu {
    public BuyerMenu(BurhanPedia burhanPedia) {
        System.out.println("===== MENU PEMBELI =====");
        this.router.addRouterItems(
            new RouterItem("Cek Saldo", () -> false),
            new RouterItem("Top Up Saldo", () -> false),
            new RouterItem("Cek Daftar Barang", () -> false),
            new RouterItem("Tambah Barang ke Keranjang", () -> false),
            new RouterItem("Checkout Keranjang", () -> false),
            new RouterItem("Lacak Barang", () -> false),
            new RouterItem("Lihat Laporan Pengeluaran", () -> false),
            new RouterItem("Lihat Riwayat Transaksi", () -> false)
        );
    }
}
