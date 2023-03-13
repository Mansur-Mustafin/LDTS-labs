package pt.up.fe.ldts.example3;

public class SimpleOrder {
    private Discount discount;
    private final double price;

    public SimpleOrder(double price) {
        this.price = price;
        discount = new noDiscount();
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return discount.applyDiscount(price);
    }
}
