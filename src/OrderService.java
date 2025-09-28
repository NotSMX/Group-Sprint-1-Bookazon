import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderService {
    private static final DateTimeFormatter ISO_DATE = DateTimeFormatter.ISO_DATE;

    public Order createOrder(User user) {
        if (user == null) throw new IllegalArgumentException("user cannot be null");
        if (user.getCart() == null) throw new IllegalStateException("user cart cannot be null");
        if (user.getSubscription() == null) throw new IllegalStateException("user subscription cannot be null");
        Order order = new Order(user.getCart(), user.getSubscription().level());
        PostalAddress ship = user.getShippingAddress();
        if (ship != null) {
            order.setShippingAddress(ship);
        }

        PostalAddress bill = user.getBillingAddress();
        if (bill != null) {
            order.setBillingAddress(bill);
        }

        // Set order metadata
        order.setOrderStatus("Order Placed");
        order.setDateCreated(LocalDate.now().format(ISO_DATE));
        order.setUserName(user.getName());

        return order;
    }
}
