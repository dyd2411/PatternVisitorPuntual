package visitor;

import composite.OrderComponent;

public class BrazilianOrder extends OrderComponent implements Order {

    private double orderAmount;
    private String name = "Brazil";

    public BrazilianOrder(double inp_orderAmount) {
        orderAmount = inp_orderAmount;
    }

    @Override
    public void accept(OrderVisitor v) {
        v.visit(this);
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "\n " + name + " Order \n Amount: " + orderAmount + "\n Total:"
                + getTotal();
    }
}
