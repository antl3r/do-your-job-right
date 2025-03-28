package abstracts;

public abstract class Product extends Entity {
    protected int amount;

    public Product(int amount) {
        super();
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
