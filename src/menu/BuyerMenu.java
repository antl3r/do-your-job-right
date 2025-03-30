package menu;

import abstracts.Menu;
import classes.BurhanPedia;
import classes.RouterItem;

public class BuyerMenu extends Menu {
    private final BurhanPedia burhanPedia;

    public BuyerMenu(BurhanPedia burhanPedia) {
        super(
            new RouterItem("Cek Saldo", () -> {return false;}),
            new RouterItem("Top Up Saldo", () -> {return false;}),
            new RouterItem("Cek Daftar Barang", () -> {return false;}),
            new RouterItem("Tambah Barang ke Keranjang", () -> {return false;}),
            new RouterItem("Checkout Keranjang", () -> {return false;}),
            new RouterItem("Lacak Barang", () -> {return false;}),
            new RouterItem("Lihat Laporan Pengeluaran", () -> {return false;}),
            new RouterItem("Lihat Riwayat Transaksi", () -> {return false;}),
            new RouterItem("Kembali ke Menu Utama", () -> {return false;})
        );
        this.burhanPedia = burhanPedia;
    }
}
