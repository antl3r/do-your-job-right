package menu;

import java.util.List;

import abstracts.UserMenu;
import classes.RouterItem;
import classes.Seller;
import classes.StoreProduct;
import repos.StoreProductRepo;
import utils.Util;

public class SellerMenu extends UserMenu<Seller> {
    private void handleCheckProduct() {
        StoreProductRepo store = this.user.getStore();
        List<StoreProduct> products = store.getAll();

        if (!products.isEmpty()) {
            for (StoreProduct product : products) {
                System.out.println("===========PRODUK TOKO===========");
                System.out.println("=================================");
                System.out.println("Nama produk: " + product.getName());
                System.out.println("Jumlah produk: " + product.getAmount());
                System.out.println("Harga produk: " + product.getPrice());
                System.out.println("Id produk: " + product.getId());
                System.out.println("=================================");
            }
        } else {
            System.out.println(
                    "=================================\n"
                            + "Toko belum memiliki produk!\n"
                            + "=================================");
        }
    }

    private void handleAddProduct() {
        StoreProductRepo store = this.user.getStore();

        StoreProduct newProduct = new StoreProduct(
                Util.promptString("Nama produk: ", sharedScanner),
                Long.parseLong(Util.promptString("Harga produk: ", sharedScanner)),
                Integer.parseInt(Util.promptString("Jumlah produk: ", sharedScanner)),
                store);

        store.add(newProduct);
    }

    private void handleRestock() {
        StoreProductRepo store = this.user.getStore();
        StoreProduct targetProduct = store
                .findByProductName(Util.promptString("Masukkan nama barang: ", sharedScanner));

        if (targetProduct != null) {
            targetProduct.addAmount(
                    Integer.parseInt(Util.promptString("Masukkan jumlah stok yang ingin ditambah:", sharedScanner)));
        }
    }

    public SellerMenu(Seller user) {
        super(user);
        System.out.println("===== MENU PENJUAL =====");
        this.router.addRouterItems(
                new RouterItem("Cek Produk", () -> {
                    handleCheckProduct();
                    return false;
                }),
                new RouterItem("Tambah Produk", () -> {
                    handleAddProduct();
                    return false;
                }),
                new RouterItem("Tambah Stok", () -> {
                    handleRestock();
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
                }));
    }
}
