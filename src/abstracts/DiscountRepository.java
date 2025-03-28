package abstracts;

import interfaces.IDiscountRepository;

public abstract class DiscountRepository<T extends Discount> extends Repository<T> implements IDiscountRepository<T> {
    @Override
    public T findByCode(String code) {
        for (T discount : entities) {
            if (discount.getDiscountCode().equals(code)) {
                return discount;
            }
        }
        return null;
    }
}
