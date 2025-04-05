package abstracts;

public abstract class UserMenu<T extends User> extends Menu {
    protected T user;

    protected void handleBalanceCheck() {
        System.out.println("Saldo saat ini: " + user.getBalance());
    }

    public UserMenu(T user) {
        this.user = user;
    }
}
