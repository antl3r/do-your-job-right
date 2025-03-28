package classes;

import java.util.Date;

import abstracts.Discount;

public class Promo extends Discount {
    public Promo(String discountCode, Date validUntil) {
        super(discountCode, validUntil);
    }
}
