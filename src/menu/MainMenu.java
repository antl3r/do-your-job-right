package menu;

import java.util.Scanner;

import abstracts.Menu;
import abstracts.User;
import classes.BurhanPedia;
import classes.RouterItem;
import classes.Buyer;
import classes.Seller;
import classes.Courier;
import classes.Router;
import classes.SharedScanner;

public class MainMenu extends Menu {
    private final BurhanPedia burhanPedia; // Variable to store BurhanPedia instance
    private User loggedInUser; // Variable to store the logged-in user

    public MainMenu(BurhanPedia burhanPedia) {
        super();
        this.burhanPedia = burhanPedia;
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
            }),
            new RouterItem("Keluar", () -> {
                System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                return false;
            })
        );
    }

    /**
     * Prompts the user to input their username.
     * 
     * @return The entered username as a string.
     */
    private String promptUsername() {
        System.out.print("\nMasukkan username: ");
        return SharedScanner.getInstance().nextLine();
    }

    /**
     * Prompts the user to input their password.
     * 
     * @return The entered password as a string.
     */
    private String promptPassword() {
        System.out.print("\nMasukkan password: ");
        return SharedScanner.getInstance().nextLine();
    }

    private void handleLogin() {
        System.out.println("===== LOGIN =====");
        String username = promptUsername();
        String password = promptPassword();

        User buyer = burhanPedia.buyerRepo.findByUsername(username);
        User seller = burhanPedia.sellerRepo.findByUsername(username);
        User courier = burhanPedia.courierRepo.findByUsername(username);

        if (buyer == null && seller == null && courier == null) {
            System.out.println("User tidak ditemukan.");
            return;
        }

        User validUser = null;
        if (buyer != null && buyer.getPassword().equals(password)) validUser = buyer;
        if (seller != null && seller.getPassword().equals(password)) validUser = seller;
        if (courier != null && courier.getPassword().equals(password)) validUser = courier;

        if (validUser == null) {
            System.out.println("Password salah.");
            return;
        }

        Router loginRouter = new Router();
        if (seller != null) {
            loginRouter.addRouterItem(new RouterItem("Penjual", () -> {
                loggedInUser = seller;
                System.out.println("Login berhasil! Selamat datang, " + loggedInUser.getUsername() + "!");
                // Call seller menu here
                return true;
            }));
        }
        if (buyer != null) {
            loginRouter.addRouterItem(new RouterItem("Pembeli", () -> {
                loggedInUser = buyer;
                System.out.println("Login berhasil! Selamat datang, " + loggedInUser.getUsername() + "!");
                // Call buyer menu here
                return true;
            }));
        }
        if (courier != null) {
            loginRouter.addRouterItem(new RouterItem("Pengirim", () -> {
                loggedInUser = courier;
                System.out.println("Login berhasil! Selamat datang, " + loggedInUser.getUsername() + "!");
                // Call courier menu here
                return true;
            }));
        }
        loginRouter.addRouterItem(new RouterItem("Cek Saldo Antar Role", () -> {
            System.out.println("\nRole      | Saldo");
            System.out.println("======================");
            if (buyer != null) System.out.println("Pembeli   | " + ((Buyer) buyer).getBalance());
            if (seller != null) System.out.println("Penjual   | " + ((Seller) seller).getBalance());
            if (courier != null) System.out.println("Pengirim  | " + ((Courier) courier).getBalance());
            System.out.println("======================");
            return false;
        }));

        loginRouter.printAndPrompt(SharedScanner.getInstance());
    }

    private void handleRegister() {
        System.out.println("===== REGISTRASI =====");
        String username = promptUsername();

        User existingUser = burhanPedia.buyerRepo.findByUsername(username);

        if (existingUser != null) {
            System.out.println("\nUsername sudah ada! Silahkan konfirmasi password untuk menambahkan role lain.");
            String password = promptPassword();

            if (!existingUser.getPassword().equals(password)) {
                System.out.println("Password salah. Registrasi dibatalkan.");
                return;
            }

            Router roleMenu = new Router();
            roleMenu.addRouterItems(
                new RouterItem("Penjual", () -> {
                    if (burhanPedia.sellerRepo.findByUsername(username) != null) {
                        System.out.println("Role sudah ada. Silahkan pilih role lain!");
                        return false;
                    } else {
                        burhanPedia.sellerRepo.add(new Seller(username, password, 0));
                        System.out.println("Registrasi akun penjual berhasil!");
                        return true;
                    }
                }),
                new RouterItem("Pembeli", () -> {
                    if (burhanPedia.buyerRepo.findByUsername(username) != null) {
                        System.out.println("Role sudah ada. Silahkan pilih role lain!");
                        return false;
                    } else {
                        burhanPedia.buyerRepo.add(new Buyer(username, password, 0));
                        System.out.println("Registrasi akun pembeli berhasil!");
                        return true;
                    }
                }),
                new RouterItem("Pengirim", () -> {
                    if (burhanPedia.courierRepo.findByUsername(username) != null) {
                        System.out.println("Role sudah ada. Silahkan pilih role lain!");
                        return false;
                    } else {
                        burhanPedia.courierRepo.add(new Courier(username, password, 0));
                        System.out.println("Registrasi akun pengirim berhasil!");
                        return true;
                    }
                })
            );

            roleMenu.printAndPrompt(SharedScanner.getInstance());
        } else {
            String password = promptPassword();
            Router roleMenu = new Router();
            roleMenu.addRouterItems(
                new RouterItem("Penjual", () -> {
                    System.out.println("Akun penjual berhasil didaftarkan.");
                    return burhanPedia.sellerRepo.add(new Seller(username, password, 0));
                }),
                new RouterItem("Pembeli", () -> {
                    System.out.println("Akun pembeli berhasil didaftarkan.");
                    return burhanPedia.buyerRepo.add(new Buyer(username, password, 0));
                }),
                new RouterItem("Pengirim", () -> {
                    System.out.println("Akun pengirim berhasil didaftarkan.");
                    return burhanPedia.courierRepo.add(new Courier(username, password, 0));
                })
            );

            roleMenu.printAndPrompt(SharedScanner.getInstance());
        }
    }
}
