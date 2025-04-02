package classes;

import abstracts.User;
import repos.CartProductRepo;
import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {
    private CartProductRepo cartProductRepo;
    private List<Transaction> transactionHistory;

    public Buyer(String username, String password, double balance) {
        super(username, password, balance);
        this.cartProductRepo = new CartProductRepo();
        this.transactionHistory = new ArrayList<>();
    }

    public CartProductRepo getCartProductRepo() {
        return cartProductRepo;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionHistory.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        this.transactionHistory.remove(transaction);
    }
}
