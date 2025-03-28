package classes;

import abstracts.Product;

public class StoreProduct extends Product {
    private String name;
    private long price;

    public StoreProduct(String name, long price, int amount) {
        super(amount);
        this.name = name;
        this.price = price;
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

    public void setPrice(long price) {
        this.price = price;
    }

    public long calculateTotalValue() {
        return price * amount;
    }
}
