package classes;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import abstracts.Entity;

public class Transaction extends Entity{
    private final UUID transactionId;
    private String sellerName;
    private String buyerName;
    private String courierName;
    private List<TransactionStatus> transactionStatusHistory;

    public Transaction(String sellerName, String buyerName, String courierName) {
        this.transactionId = UUID.randomUUID();
        this.sellerName = sellerName;
        this.buyerName = buyerName;
        this.courierName = courierName;
        this.transactionStatusHistory = new ArrayList<>();
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getCourierName() {
        return courierName;
    }

    public List<TransactionStatus> getTransactionStatusHistory() {
        return transactionStatusHistory;
    }

    public void addTransactionStatus(TransactionStatus status) {
        this.transactionStatusHistory.add(status);
    }

    public void removeTransactionStatus(TransactionStatus status) {
        this.transactionStatusHistory.remove(status);
    }

    public TransactionStatus getCurrentTransactionStatus() {
        if (transactionStatusHistory.isEmpty()) {
            return null;
        }
        return transactionStatusHistory.get(transactionStatusHistory.size() - 1);
    }
}
