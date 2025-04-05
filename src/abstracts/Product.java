package abstracts;

import java.util.UUID;

public abstract class Product extends Entity {
    protected int amount;

    /**
     * Constructs a Product with only 1 amount and a random UUID.
     * 
     * @param amount The amount of the product.
     */
    public Product() {
        super();
        this.amount = 1;
    }

    /**
     * Constructs a Product with only 1 amount and a custom UUID.
     * 
     * @param amount The amount of the product.
     */
    public Product(UUID id) {
        super(id);
        this.amount = 1;
    }

    /**
     * Constructs a Product with the specified amount and a random UUID.
     * 
     * @param amount The amount of the product.
     */
    public Product(int amount) {
        super();
        this.amount = amount;
    }

    /**
     * Constructs a Product with the specified amount and a custom UUID.
     * 
     * @param amount The amount of the product.
     * @param id     The custom UUID for the product.
     */
    public Product(int amount, UUID id) {
        super(id);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public void subtractAmount(int amount) {
        if (amount <= this.amount) {
            this.amount -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient amount");
        }
    }
}
