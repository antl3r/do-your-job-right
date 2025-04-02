package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Router class manages a list of RouterItem objects and provides
 * functionality to display and interact with them in a menu-like interface.
 */
public class Router {
    private List<RouterItem> routerItems;

    /**
     * Constructs a Router with the specified RouterItem objects.
     * 
     * @param items The RouterItem objects to initialize the Router with.
     */
    public Router(RouterItem... items) {
        this.routerItems = new ArrayList<>();
        for (RouterItem item : items) {
            this.routerItems.add(item);
        }
    }

    /**
     * Constructs an empty Router.
     */
    public Router() {
        this.routerItems = new ArrayList<>();
    }

    /**
     * Gets the list of RouterItem objects managed by this Router.
     * 
     * @return A list of RouterItem objects.
     */
    public List<RouterItem> getRouterItems() {
        return routerItems;
    }

    /**
     * Adds a single RouterItem to the Router.
     * 
     * @param item The RouterItem to add.
     */
    public void addRouterItem(RouterItem item) {
        this.routerItems.add(item);
    }

    /**
     * Adds multiple RouterItem objects to the Router.
     * 
     * @param items The RouterItem objects to add.
     */
    public void addRouterItems(RouterItem... items) {
        for (RouterItem item : items) {
            this.routerItems.add(item);
        }
    }

    /**
     * Displays the menu of RouterItem objects, prompts the user for input,
     * and executes the corresponding callback for the selected item.
     * 
     * @param scanner A Scanner object for reading user input.
     */
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

                    // Execute the callback associated with the selected menu item
                    if (selectedItem.getCallback().execute()) {
                        // If the callback returns true, exit the menu loop
                        break;
                    } else {
                        // If the callback returns false, continue displaying the menu
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
