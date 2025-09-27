public class CustomerUser extends User {
    public CustomerUser(String name, String subscription) {
        super(name, subscription);
    }

    @Override
    protected void onOrderPlaced(Order order) {
        System.out.println("Thank you for your order, " + getName() + "!");
        System.out.println("Order Details:");
        order.printOrderDetails();
        System.out.println("A confirmation email has been sent to your registered email address.\n");
    }
}
