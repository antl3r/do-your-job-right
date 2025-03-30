package menu;

import abstracts.Menu;
import classes.BurhanPedia;
import classes.RouterItem;

public class SellerMenu extends Menu {
    private final BurhanPedia burhanPedia;

    public SellerMenu(BurhanPedia burhanPedia) {
        super(
            new RouterItem("Cek Produk", () -> {return false;}),
            new RouterItem("Tambah Produk", () -> {return false;}),
            new RouterItem("Tambah Stok", () -> {return false;}),
            new RouterItem("Ubah Harga Barang", () -> {return false;}),
            new RouterItem("Kirim Barang", () -> {return false;}),
            new RouterItem("Lihat Laporan Pendapatan", () -> {return false;}),
            new RouterItem("Cek Saldo", () -> {return false;}),
            new RouterItem("Lihat Riwayat Transaksi", () -> {return false;}),
            new RouterItem("Kembali ke Menu Utama", () -> {return false;})
        );
        this.burhanPedia = burhanPedia;
    }
}
