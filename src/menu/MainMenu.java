package menu;

import abstracts.Menu;
import abstracts.User;
import classes.Buyer;
import classes.Courier;
import classes.Router;
import classes.RouterItem;
import classes.Seller;
import repos.StoreProductRepo;
import utils.Util;

public class MainMenu extends Menu {
    public MainMenu() {
        this.router.addRouterItems(
                new RouterItem("Login", () -> {
                    this.handleLogin();
                    return false;
                }),
                new RouterItem("Register", () -> {
                    this.handleRegister();
                    return false;
                }),
                new RouterItem("Hari Selanjutnya", () -> {
                    this.handleLogin();
                    return false;
                }));

        this.router.printAndPrompt(sharedScanner);
    }

    /**
     * Prompts the user to input their username.
     * 
     * @return The entered username as a string.
     */
    private String promptUsername() {
        System.out.print("\nMasukkan username: ");
        return sharedScanner.nextLine();
    }

    /**
     * Prompts the user to input their password.
     * 
     * @return The entered password as a string.
     */
    private String promptPassword() {
        System.out.print("\nMasukkan password: ");
        return sharedScanner.nextLine();
    }

    private boolean handleRegisterNewSeller(String username, String password) {
        if (burhanPedia.sellerRepo.findByUsername(username) != null) {
            System.out.println("Role sudah ada. Silahkan pilih role lain!");
            return false;
        } else {
            StoreProductRepo newStore = new StoreProductRepo(
                    Util.promptString("Masukkan nama toko: ", sharedScanner));

            burhanPedia.sellerRepo.add(
                    new Seller(
                            username,
                            password,
                            0,
                            newStore));

            burhanPedia.storeRepo.add(newStore);
            System.out.println("Registrasi akun penjual berhasil!");
            return true;
        }
    }

    private boolean handleRegisterNewBuyer(String username, String password) {
        if (burhanPedia.buyerRepo.findByUsername(username) != null) {
            System.out.println("Role sudah ada. Silahkan pilih role lain!");
            return false;
        } else {
            burhanPedia.buyerRepo.add(new Buyer(username, password, 0));
            System.out.println("Registrasi akun pembeli berhasil!");
            return true;
        }
    }

    private boolean handleRegisterNewCourier(String username, String password) {
        if (burhanPedia.courierRepo.findByUsername(username) != null) {
            System.out.println("Role sudah ada. Silahkan pilih role lain!");
            return false;
        } else {
            burhanPedia.courierRepo.add(new Courier(username, password, 0));
            System.out.println("Registrasi akun pengirim berhasil!");
            return true;
        }
    }

    private void handleLogin() {
        System.out.println("===== LOGIN =====");
        String username = promptUsername();
        String password = promptPassword();

        Buyer buyer = burhanPedia.buyerRepo.findByUsername(username);
        Seller seller = burhanPedia.sellerRepo.findByUsername(username);
        Courier courier = burhanPedia.courierRepo.findByUsername(username);

        if (buyer == null && seller == null && courier == null) {
            System.out.println("User tidak ditemukan.");
            return;
        }

        User validUser = null;
        if (buyer != null && buyer.getPassword().equals(password))
            validUser = buyer;
        if (seller != null && seller.getPassword().equals(password))
            validUser = seller;
        if (courier != null && courier.getPassword().equals(password))
            validUser = courier;

        if (validUser == null) {
            System.out.println("Password salah.");
            return;
        }

        Router loginRouter = new Router();
        if (seller != null) {
            loginRouter.addRouterItem(new RouterItem("Penjual", () -> {
                System.out.println("Login berhasil! Selamat datang, " + seller.getUsername() + "!");
                new SellerMenu(seller).display();
                return true;
            }));
        }
        if (buyer != null) {
            loginRouter.addRouterItem(new RouterItem("Pembeli", () -> {
                System.out.println("Login berhasil! Selamat datang, " + buyer.getUsername() + "!");
                new BuyerMenu(buyer).display();
                return true;
            }));
        }
        if (courier != null) {
            loginRouter.addRouterItem(new RouterItem("Pengirim", () -> {
                System.out.println("Login berhasil! Selamat datang, " + courier.getUsername() + "!");
                new CourierMenu(courier).display();
                return true;
            }));
        }
        loginRouter.addRouterItem(new RouterItem("Cek Saldo Antar Role", () -> {
            System.out.println("\nRole      | Saldo");
            System.out.println("======================");
            if (buyer != null)
                System.out.println("Pembeli   | " + ((Buyer) buyer).getBalance());
            if (seller != null)
                System.out.println("Penjual   | " + ((Seller) seller).getBalance());
            if (courier != null)
                System.out.println("Pengirim  | " + ((Courier) courier).getBalance());
            System.out.println("======================");
            return false;
        }));

        loginRouter.printAndPrompt(sharedScanner);
    }

    private void handleRegister() {
        System.out.println("===== REGISTRASI =====");
        String username = promptUsername();

        User existingUser = burhanPedia.buyerRepo.findByUsername(username);

        if (existingUser != null) {
            System.out.println("\nUsername sudah ada! Silahkan konfirmasi password untuk menambahkan role lain.");
        }

        String password = promptPassword();

        if (existingUser != null) {
            if (existingUser.getPassword().equals(password)) {
                System.out.println("Password salah. Registrasi dibatalkan.");
                return;
            }
            ;
        }

        Router roleMenu = new Router();
        roleMenu.addRouterItems(
                new RouterItem("Penjual", () -> handleRegisterNewSeller(username, password)),
                new RouterItem("Pembeli", () -> handleRegisterNewBuyer(username, password)),
                new RouterItem("Pengirim", () -> handleRegisterNewCourier(username, password)));

        roleMenu.printAndPrompt(sharedScanner);
    }
}
