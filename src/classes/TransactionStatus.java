package classes;

public enum TransactionStatus {
    SEDANG_DIKEMAS("Sedang Dikemas"),
    MENUNGGU_PENGIRIM("Menunggu Pengirim"),
    SEDANG_DIKIRIM("Sedang Dikirim"),
    PESANAN_SELESAI("Pesanan Selesai"),
    DIKEMBALIKAN("Dikembalikan");

    private final String text;

    TransactionStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
