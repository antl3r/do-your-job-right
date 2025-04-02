package repos;

import abstracts.Repository;

public class StoreRepo extends Repository<StoreProductRepo> {
    public StoreProductRepo findByStoreName(String storeName) {
        for (StoreProductRepo store : entities) {
            if (store.getStoreName().equals(storeName)) {
                return store;
            }
        }
        return null;
    }
}
