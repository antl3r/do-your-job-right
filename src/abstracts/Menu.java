package abstracts;

import java.util.Scanner;

import classes.Router;
import classes.RouterItem;

public abstract class Menu {
    protected Router router = new Router();
    
    public Menu(RouterItem... items) {
        this.router.addRouterItems(items);
    }

    public void display(Scanner scanner) {
        router.printAndPrompt(scanner);
    };
}
