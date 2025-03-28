package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Router {
    private List<RouterItem> routerItems;

    public Router(RouterItem... items) {
        this.routerItems = new ArrayList<>();
        for (RouterItem item : items) {
            this.routerItems.add(item);
        }
    }

    public Router() {
        this.routerItems = new ArrayList<>();
    }

    public List<RouterItem> getRouterItems() {
        return routerItems;
    }

    public void addRouterItem(RouterItem item) {
        this.routerItems.add(item);
    }

    public void addRouterItems(RouterItem... items) {
        for (RouterItem item : items) {
            this.routerItems.add(item);
        }
    }

    public void printAndPrompt(Scanner scanner) {
        // Append "Kembali" menu item
        RouterItem kembaliItem = new RouterItem("Kembali", () -> {System.out.println("Exiting..."); return true;});
        routerItems.add(kembaliItem);

        while (true) {
            // Print all router items
            for (int i = 0; i < routerItems.size(); i++) {
                System.out.println((i + 1) + ". " + routerItems.get(i).getTitle());
            }

            // Prompt user for selection
            System.out.print("\nPlease select a number: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);

                // Validate choice and handle options
                if (choice > 0 && choice <= routerItems.size()) {
                    RouterItem selectedItem = routerItems.get(choice - 1);

                    if (selectedItem.getCallback().execute()) {
                        break;
                    } else {
                        continue;
                    }
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Remove "Kembali" menu item after exiting
        routerItems.remove(kembaliItem);
    }
}
