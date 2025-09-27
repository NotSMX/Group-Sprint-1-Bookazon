public class OrderService {
    public Order createOrder(User user) {
        Order order = new Order(user.getCart(), user.getSubscription().level());

        PostalAddress shippingAddress = user.getShippingAddress();
        PostalAddress billingAddress = user.getBillingAddress();

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
        order.setDateCreated(java.time.LocalDate.now().toString());
        order.setUserName(user.getName());
        
        return order;
    }
}