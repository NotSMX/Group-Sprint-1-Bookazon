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

    private String subscriptionLevel;
    private final PricingPolicy pricingPolicy;
    private double orderPrice;

    public Order(Cart cart, String subscription) {
        this(cart, Subscription.of(subscription), new DefaultPricingPolicy());
    }

    public Order(Cart cart, Subscription subscription) {
        this(cart, subscription, new DefaultPricingPolicy());
    }

    public Order(Cart cart, Subscription subscription, PricingPolicy pricingPolicy) {
        this.orderItems = new ArrayList<>(cart.getItems());
        this.pricingPolicy = pricingPolicy;
        setSubscription(subscription);
        recomputeTotals();
    }

    public void setShippingAddress(PostalAddress address) { this.shippingAddress = address; }
    public void setBillingAddress(PostalAddress address)  { this.billingAddress  = address; }

    public void setShippingAddress(String line1, String line2, String city, String state, String zip, String country) {
        this.shippingAddress = new PostalAddress(line1, line2, city, state, zip, country);
    }
    public void setBillingAddress(String line1, String line2, String city, String state, String zip, String country) {
        this.billingAddress = new PostalAddress(line1, line2, city, state, zip, country);
    }

    public void setOrderStatus(String status) { this.orderStatus = status; }
    public void setDateCreated(String date)   { this.dateCreated = date; }
    public void setDateShipped(String date)   { this.dateShipped = date; }
    public void setUserName(String name)      { this.userName = name; }

    public String getDateCreated() { return dateCreated; }
    public String getDateShipped() { return dateShipped; }
    public String getUserName()    { return userName; }
    public String getOrderStatus() { return orderStatus; }
    public PostalAddress getShippingAddress() { return shippingAddress; }
    public PostalAddress getBillingAddress()  { return billingAddress; }
    public List<CartItem> getItems() { return Collections.unmodifiableList(orderItems); }
    public double getOrderPrice() { return orderPrice; }

    private void setSubscription(Subscription subscription) {
        Subscription effective = (subscription == null) ? Subscription.of("normal") : subscription;
        this.subscriptionLevel = effective.level();
    }

    private void recomputeTotals() {
        PricingPolicy.PricingResult r = pricingPolicy.price(orderItems, Subscription.of(subscriptionLevel));
        this.orderPrice = r.total;
    }

    @Deprecated
    public double calculatePrice(String subscription) {
        PricingPolicy.PricingResult r = pricingPolicy.price(orderItems, Subscription.of(subscription));
        return r.total;
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
        if (a == null) return "null";
        String line1 = a.getLine1() == null ? "" : a.getLine1();
        String line2 = a.getLine2() == null ? "" : a.getLine2();
        String city = a.getCity() == null ? "" : a.getCity();
        String state = a.getState() == null ? "" : a.getState();
        String zip = a.getZip() == null ? "" : a.getZip();
        String country = a.getCountry() == null ? "" : a.getCountry();
        return line1 + ", " + line2 + ", " + city + ", " + state + ", " + zip + ", " + country;
    }
}
