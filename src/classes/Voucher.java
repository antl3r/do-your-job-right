package classes;

import java.util.Date;

import abstracts.Discount;

public class Voucher extends Discount {
    private int usesLeft;

    public Voucher(String discountCode, Date validUntil, int usesLeft) {
        super(discountCode, validUntil);
        this.usesLeft = usesLeft;
    }

    public int getUsesLeft() {
        return usesLeft;
    }

    public void setUsesLeft(int usesLeft) {
        this.usesLeft = usesLeft;
    }

    public boolean canBeUsed() {
        return usesLeft > 0 && !isExpired();
    }

    public void use() {
        if (canBeUsed()) {
            usesLeft--;
        } else {
            throw new IllegalStateException("Voucher cannot be used.");
        }
    }
}
