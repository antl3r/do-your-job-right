package menu;

import abstracts.UserMenu;
import classes.RouterItem;
import classes.Seller;

public class SellerMenu extends UserMenu<Seller> {
    public SellerMenu(Seller user) {
        super(user);
        System.out.println("===== MENU PENJUAL =====");
        this.router.addRouterItems(
                new RouterItem("Cek Produk", () -> {
                    return false;
                }),
                new RouterItem("Tambah Produk", () -> {
                    return false;
                }),
                new RouterItem("Tambah Stok", () -> {
                    return false;
                }),
                new RouterItem("Ubah Harga Barang", () -> {
                    return false;
                }),
                new RouterItem("Kirim Barang", () -> {
                    return false;
                }),
                new RouterItem("Lihat Laporan Pendapatan", () -> {
                    return false;
                }),
                new RouterItem("Cek Saldo", () -> {
                    return false;
                }),
                new RouterItem("Lihat Riwayat Transaksi", () -> {
                    return false;
                }),
                new RouterItem("Kembali ke Menu Utama", () -> {
                    return false;
                }));
    }
}
