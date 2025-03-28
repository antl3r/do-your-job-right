package classes;

import abstracts.Product;
import java.util.UUID;

public class CartProduct extends Product {
    /**
     * Constructs a CartProduct with the specified amount and a custom UUID.
     * 
     * @param amount The amount of the product.
     * @param id     The custom UUID for the product.
     */
    public CartProduct(int amount, UUID id) {
        super(amount, id);
    }
}
