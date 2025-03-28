package abstracts;

import java.util.Date;

public abstract class Discount extends Entity {
    private String discountCode;
    private Date validUntil;

    public Discount(String discountCode, Date validUntil) {
        this.discountCode = discountCode;
        this.validUntil = validUntil;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public boolean isExpired() {
        return new Date().after(validUntil);
    }
}
