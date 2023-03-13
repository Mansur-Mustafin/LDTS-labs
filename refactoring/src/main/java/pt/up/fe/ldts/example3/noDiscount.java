package pt.up.fe.ldts.example3;

public class noDiscount extends Discount{
    public noDiscount(){}

    @Override
    public double applyDiscount(double price) {
         return price;
    }
}
