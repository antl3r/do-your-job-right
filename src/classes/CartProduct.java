package classes;

import abstracts.DerivativeProduct;

public class CartProduct extends DerivativeProduct {
    public CartProduct(StoreProduct storeProduct) {
        super(storeProduct);
    }

    public CartProduct(StoreProduct storeProduct, int amount) {
        super(storeProduct, amount);
    }
}
