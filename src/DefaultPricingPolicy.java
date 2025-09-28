import java.util.List;

public class DefaultPricingPolicy implements PricingPolicy {

    @Override
    public PricingResult price(List<CartItem> items, Subscription subscription) {
        double subtotal = 0.0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }

        double discountRate = 0.0;
        if (subscription != null) {
            discountRate = subscription.discount();
        }

        return new PricingResult(subtotal, discountRate);
    }
}
