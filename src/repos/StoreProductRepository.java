package repos;

import abstracts.ProductRepository;
import classes.StoreProduct;

public class StoreProductRepository extends ProductRepository<StoreProduct> {
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}