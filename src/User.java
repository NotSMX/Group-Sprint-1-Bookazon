
import java.util.ArrayList;

public abstract class User {

    private String name;
    private Subscription subscription;
    private final Cart cart;
    private final ArrayList<Order> orders;

    private PostalAddress shippingAddress;
    private PostalAddress billingAddress;

    protected User(String name, String subscription) {
        this.name = name;
        this.subscription = Subscription.of(subscription);
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(String level) {
        this.subscription = Subscription.of(level);
    }

    public PostalAddress getShippingAddress() {
        return shippingAddress;
    }

    public PostalAddress getBillingAddress() {
        return billingAddress;
    }

    public void setShippingAddress(PostalAddress addr) {
        this.shippingAddress = addr;
    }

    public void setBillingAddress(PostalAddress addr) {
        this.billingAddress = addr;
    }

    public void setShippingAddress(String l1, String l2, String city, String state, String zip, String country) {
        setShippingAddress(new PostalAddress(l1, l2, city, state, zip, country));
    }

    public void setBillingAddress(String l1, String l2, String city, String state, String zip, String country) {
        setBillingAddress(new PostalAddress(l1, l2, city, state, zip, country));
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(MediaItem item, int quantity) {
        if (item != null && quantity > 0) {
            cart.addItem(new CartItem(item.getDetails().getTitle().getValue(), item.getDetails().getPrice().getValue(), quantity));
        }
    }

    public void removeFromCart(MediaItem item) {
        if (item != null) {
            cart.removeByProductName(item.getDetails().getTitle().getValue());
        }
    }

    public void viewCart() {
        cart.viewCartDetails();
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        for (Order order : orders) {
            order.printOrderDetails();
        }
    }

    public final void checkout() {
        OrderService service = new OrderService();
        Order order = service.createOrder(this);
        orders.add(order);
        onOrderPlaced(order);
    }

    protected void onOrderPlaced(Order order) {
    }

    public void updateSubscription(String role) {
        setSubscription(role);
    }

}
