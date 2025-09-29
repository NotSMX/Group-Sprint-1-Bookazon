import java.util.ArrayList;

public abstract class PricingPolicy {

    public ArrayList<CartItem> orderItems;
    public Subscription subscription;

    public PricingPolicy(ArrayList<CartItem> orderItems, Subscription subscription) {
        this.orderItems = orderItems;
        this.subscription = subscription;
    }
    public double calculateTotal() {
        double subtotal = 0.0;
        for (CartItem item : orderItems) {
            subtotal += item.getTotalPrice();
        }
        return subtotal * (1 - subscription.discount());
    }
}
