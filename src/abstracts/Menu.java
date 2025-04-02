package abstracts;

import java.util.Scanner;

import classes.BurhanPedia;
import classes.Router;
import classes.SharedScanner;

public abstract class Menu {
    protected BurhanPedia burhanPedia = BurhanPedia.getInstance();
    protected Scanner sharedScanner = SharedScanner.getInstance();
    protected Router router = new Router();

    public void display() {
        router.printAndPrompt(SharedScanner.getInstance());
    };
}
