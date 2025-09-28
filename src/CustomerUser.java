public class CustomerUser extends User {
    public CustomerUser(String name, String subscription) {
        super(name, subscription);
    }

    @Override
    protected void onOrderPlaced(Order order) {
    }
}
