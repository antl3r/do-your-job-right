package abstracts;

import java.util.Scanner;

import classes.Router;
import classes.RouterItem;
import classes.SharedScanner;

public abstract class Menu {
    protected Router router = new Router();
    
    public Menu(RouterItem... items) {
        this.router.addRouterItems(items);
    }

    public void display() {
        router.printAndPrompt(SharedScanner.getInstance());
    };
}
