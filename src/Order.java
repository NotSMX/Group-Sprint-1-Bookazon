
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private String dateCreated;
    private String dateShipped;
    private String userName;
    private String orderStatus;
    private PostalAddress shippingAddress;
    private PostalAddress billingAddress;
    private final ArrayList<CartItem> orderItems;
    private Subscription subscription;
    private final DefaultPricingPolicy pricingPolicy;
    private double orderPrice;

     public Order(Cart cart, Subscription subscription) {
        this(cart, subscription, new DefaultPricingPolicy(cart, subscription));
    }

    public Order(Cart cart, Subscription subscription, DefaultPricingPolicy pricingPolicy) {
        this.orderItems = new ArrayList<>(cart.getItems());
        this.pricingPolicy = pricingPolicy;
        this.subscription = subscription;
    }

    public void setShippingAddress(PostalAddress address) {
        this.shippingAddress = address;
    }

    public void setBillingAddress(PostalAddress address) {
        this.billingAddress = address;
    }

    public void setShippingAddress(String line1, String line2, String city, String state, String zip, String country) {
        this.shippingAddress = new PostalAddress(line1, line2, city, state, zip, country);
    }

    public void setBillingAddress(String line1, String line2, String city, String state, String zip, String country) {
        this.billingAddress = new PostalAddress(line1, line2, city, state, zip, country);
    }

    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }

    public void setDateCreated(String date) {
        this.dateCreated = date;
    }

    public void setDateShipped(String date) {
        this.dateShipped = date;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateShipped() {
        return dateShipped;
    }

    public String getUserName() {
        return userName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public PostalAddress getShippingAddress() {
        return shippingAddress;
    }

    public PostalAddress getBillingAddress() {
        return billingAddress;
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(orderItems);
    }

    public double getOrderPrice() {
        return orderPrice;
    }
    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public double calculatePrice() {
        return pricingPolicy.calculateTotal();
    }

    public void printOrderDetails() {
        System.out.println("Order Details:");
        System.out.println("Date Created: " + valueOrNull(dateCreated));
        System.out.println("Date Shipped: " + valueOrNull(dateShipped));
        System.out.println("User Name: " + valueOrNull(userName));
        System.out.println("Order Status: " + valueOrNull(orderStatus));
        System.out.println("Shipping Address: " + joinAddress(shippingAddress));
        System.out.println("Billing Address: " + joinAddress(billingAddress));
        System.out.println("Order Price: $" + String.format("%.2f", orderPrice));
    }

    private static String valueOrNull(String v) {
        return v == null ? "null" : v;
    }

    private static String joinAddress(PostalAddress a) {
        if (a == null) {
            return "null";
        }
        return a.toSingleLine();
    }
}
