public class DefaultPricingPolicy extends PricingPolicy {

    public DefaultPricingPolicy(Cart cart, Subscription subscription) {
        super(cart.getItems(), subscription);
    }

    @Override
    public double calculateTotal() {
        double subtotal = 0.0;
        for (CartItem item : orderItems) {
            subtotal += item.getTotalPrice();
        }
        return subtotal * (1 - subscription.discount());
    }
}
