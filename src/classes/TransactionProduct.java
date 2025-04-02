package classes;

import abstracts.DerivativeProduct;

public class TransactionProduct extends DerivativeProduct {
    public TransactionProduct(StoreProduct storeProduct) {
        super(storeProduct);
    }

    public TransactionProduct(StoreProduct storeProduct, int amount) {
        super(storeProduct, amount);
    }
}
