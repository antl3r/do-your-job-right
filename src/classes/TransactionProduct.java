package classes;

import abstracts.Product;
import java.util.UUID;

public class TransactionProduct extends Product {
    /**
     * Constructs a TransactionProduct with the specified amount and a random UUID.
     * 
     * @param amount The amount of the product.
     */
    public TransactionProduct(int amount) {
        super(amount);
    }

    /**
     * Constructs a TransactionProduct with the specified amount and a custom UUID.
     * 
     * @param amount The amount of the product.
     * @param id     The custom UUID for the product.
     */
    public TransactionProduct(int amount, UUID id) {
        super(amount, id);
    }
}
