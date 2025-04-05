package menu;

import abstracts.UserMenu;
import classes.Buyer;
import classes.CartProduct;
import classes.RouterItem;
import classes.Seller;
import classes.StoreProduct;
import java.util.ArrayList;
import repos.SellerRepo;
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
                new RouterItem("Cek Daftar Barang", () -> {
                    this.handleCekDaftarBarang();
                    return false;}),
                new RouterItem("Tambah Barang ke Keranjang", () -> {
                    this.tambahBarangKeKeranjang();
                    return false;
                }),
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
        user.setBalance(user.getBalance()+newBalance);
        System.out.println("Saldo saat ini: " + user.getBalance()); // new balanse :)
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

    private void tambahBarangKeKeranjang() {
        boolean productsExist = false;
        String sellerName = Util.promptString("Masukkan nama penjual: ", sharedScanner);
        ArrayList<Seller> sellerList = SellerRepo.getSellerList();
        Seller matchingSeller = null;

        //check if any product exists to display
        for (Seller seller : sellerList){
            if (!seller.getStore().getAll().isEmpty()) {
                productsExist = true;
                break;
            }
            if (seller.getUsername().equals(sellerName)){
                matchingSeller = seller;
            }
        }

        //prints if there's no product to display
        if (!productsExist){
            System.out.println("No products available to display!");
            return;
        }

        //prompts product name to user
        String productName = Util.promptString("Masukkan nama barang: ", sharedScanner);
        boolean productFound = false;
        StoreProduct matchingProduct = null;

        //checks if product exists in the store
        for (StoreProduct product : matchingSeller.getStore().getAll()){
            if (product.getName().equals(productName)){
                productFound = true;
                matchingProduct = product;
            }
        }

        //handles the product
        if (!productFound){
            System.out.println("Barang tidak ditemukan!");
        } else if (productFound){
            int amount = Integer.parseInt(Util.promptString("Masukkan jumlah barang: ", sharedScanner));
            if (amount > matchingProduct.getAmount()) {
                System.out.println("Jumlah barang melebihi stok yang ada!");
            } else if (amount <= 0) {  
                System.out.println("Jumlah barang tidak valid!");
            } else {
                // add to cart
                CartProduct cartProduct = new CartProduct(matchingProduct);
                user.getCartProductRepo().add(cartProduct);
                System.out.println("Barang berhasil ditambahkan ke keranjang!");
            }
        }
        
        
}}
