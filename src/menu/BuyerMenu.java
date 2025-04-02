package menu;

import abstracts.UserMenu;
import classes.Buyer;
import classes.RouterItem;
import classes.Seller;
import classes.StoreProduct;
import repos.SellerRepo;

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
    private void handleCekSaldo(){
        System.out.println("Saldo saat ini: " + user.getBalance());
    }
    private long promptBalance(){
        System.out.println("Masukkan jumlah saldo yang ingin ditambah: ");
        return sharedScanner.nextInt();
    }
    private void handleTopUpSaldo(){
        long newBalance = promptBalance();
        System.out.println("Saldo saat ini: "+ newBalance);
    }
    private void handleCekDaftarBarang(){
        for (Seller seller : SellerRepo.getSellerList()){
            System.out.println(seller.getUsername());
            for (StoreProduct product : seller.getStore().getAll()){
                System.out.println(product.getName());
                System.out.printf("%-10s %10d.00 %10d\n", product.getName(), product.getPrice(), product.getAmount());
            }
        }
        System.out.println("======================");

    }
}
