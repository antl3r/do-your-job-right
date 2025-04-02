package classes;

import abstracts.Product;
import repos.StoreProductRepo;

public class StoreProduct extends Product {
    private String name;
    private long price;
    private StoreProductRepo store;

    public StoreProduct(String name, long price, int amount, StoreProductRepo store) {
        super(amount);
        this.name = name;
        this.price = price;
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public StoreProductRepo getStore() {
        return store;
    }

    public void setStore(StoreProductRepo store) {
        this.store = store;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long calculateTotalValue() {
        return price * amount;
    }
}
