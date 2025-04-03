package classes;

import abstracts.User;
import repos.StoreProductRepo;

public class Seller extends User {
    private StoreProductRepo store;

    public Seller(String username, String password, double balance, StoreProductRepo store) {
        super(username, password, balance);
        this.store = store;
    }

    public StoreProductRepo getStore(){
        return this.store;
    }
}
