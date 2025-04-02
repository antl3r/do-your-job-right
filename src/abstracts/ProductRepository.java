package abstracts;

import java.util.UUID;

public abstract class ProductRepository<T extends Product> extends Repository<T> {
    public void subtractAmount(UUID id, int amount) {
        T product = this.findById(id);
        if (product != null) {
            product.setAmount(product.getAmount() - amount);
        }
    }

    public void addAmount(UUID id, int amount) {
        T product = findById(id);
        if (product != null) {
            product.setAmount(product.getAmount() + amount);
        }
    }

    public void setAmount(UUID id, int amount) {
        T product = findById(id);
        if (product != null) {
            product.setAmount(amount);
        }
    }
}
