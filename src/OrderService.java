public class OrderService {
    public Order createOrder(User user) {
        // Create order with cart and subscription level
        Order order = new Order(user.getCart(), user.getSubscription().level());

        // Get addresses with proper typing
        PostalAddress shippingAddress = user.getShippingAddress();
        PostalAddress billingAddress = user.getBillingAddress();

        // Set shipping address if available
        if (shippingAddress != null) {
            order.setShippingAddress(
                shippingAddress.getLine1(), 
                shippingAddress.getLine2(), 
                shippingAddress.getCity(),
                shippingAddress.getState(), 
                shippingAddress.getZip(), 
                shippingAddress.getCountry()
            );
        }
        
        // Set billing address if available
        if (billingAddress != null) {
            order.setBillingAddress(
                billingAddress.getLine1(), 
                billingAddress.getLine2(), 
                billingAddress.getCity(),
                billingAddress.getState(), 
                billingAddress.getZip(), 
                billingAddress.getCountry()
            );
        }

        // Set order metadata
        order.setOrderStatus("Order Placed");
        order.setDateCreated(java.time.LocalDate.now().toString()); // Use current date
        order.setUserName(user.getName());
        
        return order;
    }
}