public class CustomerUser extends User {
    public CustomerUser(String name, Subscription subscription) {
        super(name, subscription);
    }

    @Override
    protected void onOrderPlaced(Order order) {
    }
}
