package classes;

import java.util.Scanner;

import repos.*;

public class BurhanPedia {
    public final AdminRepo adminRepo = new AdminRepo();
    public final BuyerRepo buyerRepo = new BuyerRepo();
    public final CourierRepo courierRepo = new CourierRepo();
    public final PromoRepo promoRepo = new PromoRepo();
    public final SellerRepo sellerRepo = new SellerRepo();
    public final TransactionRepo transactionRepo = new TransactionRepo();
    public final VoucherRepo voucherRepo = new VoucherRepo();

    public final Scanner scanner = new Scanner(System.in);
}
