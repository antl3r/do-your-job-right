package classes;

import repos.AdminRepo;
import repos.BuyerRepo;
import repos.CourierRepo;
import repos.PromoRepo;
import repos.SellerRepo;
import repos.TransactionRepo;
import repos.VoucherRepo;

public class BurhanPedia {
    private static BurhanPedia INSTANCE = new BurhanPedia();

    public final AdminRepo adminRepo = new AdminRepo();
    public final BuyerRepo buyerRepo = new BuyerRepo();
    public final CourierRepo courierRepo = new CourierRepo();
    public final PromoRepo promoRepo = new PromoRepo();
    public final SellerRepo sellerRepo = new SellerRepo();
    public final TransactionRepo transactionRepo = new TransactionRepo();
    public final VoucherRepo voucherRepo = new VoucherRepo();

    private BurhanPedia() {};

    public static BurhanPedia getInstance() {
        return INSTANCE;
    }
}
