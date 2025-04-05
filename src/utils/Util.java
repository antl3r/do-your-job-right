package utils;

import java.util.Scanner;

public class Util {
    public final static String promptString(String text, Scanner scanner) {
        System.out.print(text);
        return scanner.nextLine();
    }
}
