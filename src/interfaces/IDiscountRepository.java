package interfaces;

import abstracts.Discount;

public interface IDiscountRepository<T extends Discount> extends IRepository<T> {
    T findByCode(String code);
}
