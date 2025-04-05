package classes;

import java.util.Scanner;

public class SharedScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getInstance() {
        return scanner;
    }
}
