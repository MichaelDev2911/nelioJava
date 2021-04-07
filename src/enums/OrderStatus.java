package enums;

public enum OrderStatus {
    PENDING_PAYMENT(0),
    PROCESSING(1),
    SHIPPED(2),
    DELIVERED(3);

    int id;

    OrderStatus(int i) {
        this.id= i;
    }

    public int getId() {
        return id;
    }
}
