package abstracts;

public abstract class UserMenu<T extends User> extends Menu {
    protected T user;

    public UserMenu(T user) {
        this.user = user;
    }
}
