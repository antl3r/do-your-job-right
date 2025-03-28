package interfaces;

import abstracts.Discount;

public interface IDiscountRepository<T extends Discount> {
    T findByCode(String code);
}
