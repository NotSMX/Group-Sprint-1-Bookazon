import java.util.List;

public interface PricingPolicy {
    PricingResult price(List<CartItem> items, Subscription subscription);

    final class PricingResult {
        public final double subtotal;
        public final double discountRate;  
        public final double discountAmount;
        public final double total;

        public PricingResult(double subtotal, double discountRate) {
            this.subtotal = subtotal;
            this.discountRate = discountRate;
            this.discountAmount = subtotal * discountRate;
            this.total = subtotal - discountAmount;
        }
    }
}
