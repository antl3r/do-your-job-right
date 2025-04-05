package abstracts;

import classes.StoreProduct;

public abstract class DerivativeProduct extends Product {
    private StoreProduct storeProduct;

    public DerivativeProduct(StoreProduct storeProduct) {
        super();
        this.storeProduct = storeProduct;
    }

    public DerivativeProduct(StoreProduct storeProduct, int amount) {
        super(amount);
        this.storeProduct = storeProduct;
    }

    public StoreProduct getStoreProduct() {
        return storeProduct;
    }
}
