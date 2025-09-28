public class ConsoleOrderPrinter implements OrderPrinter {
    @Override
    public void print(Order order) {
        order.printOrderDetails();
    }
}
