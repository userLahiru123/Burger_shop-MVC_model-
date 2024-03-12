package Model;

public class Burger {

    final public static double BURGERPRICE = 500;

    private String orderId;
    private String customerId;
    private String customerName;
    private int orderStatus;
    private int orderQTY;
    private double orderValue;

    // Order status
    public final static int CANCEL = 0;
    public final static int PREPARING = 1;
    public final static int DELIVERED = 2;

    // set methods........
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderQTY(int orderQTY) {
        this.orderQTY = orderQTY;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    // get methods...........
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public int getOrderQTY() {
        return orderQTY;
    }

    public double getOrderValue() {
        return orderValue;
    }
}
