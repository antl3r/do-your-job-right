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
        return burhanPedia.scanner.nextLine();
    }

    /**
     * Prompts the user to input their password.
     * 
     * @return The entered password as a string.
     */
    private String promptPassword() {
        System.out.print("\nMasukkan password: ");
        return burhanPedia.scanner.nextLine();
    }

    private void handleLogin() {
        System.out.println("===== LOGIN =====");
        String username = promptUsername();
        String password = promptPassword();

        User user = burhanPedia.buyerRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User tidak ditemukan.");
        } else if (!user.getPassword().equals(password)) {
            System.out.println("Password salah.");
        } else {
            loggedInUser = user;
            System.out.println("Login berhasil. Selamat datang, " + loggedInUser.getUsername() + "!");
        }
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

            roleMenu.printAndPrompt(burhanPedia.scanner);
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

            roleMenu.printAndPrompt(burhanPedia.scanner);
        }
    }
}
