package repos;

import abstracts.ProductRepository;
import classes.StoreProduct;

public class StoreProductRepo extends ProductRepository<StoreProduct> {
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public StoreProduct findByProductName(String productName) {
        for (StoreProduct product : entities) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}