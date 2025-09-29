public class CartItem {
    private final String itemName;
    private final double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (!validateQuantity(quantity)) {
            throw new IllegalArgumentException("Quantity cannot be negative!");
        }
        this.quantity = quantity;
    }

    private boolean validateQuantity(int quantity) {
        if (quantity < 0) {
            return false;
        }
        return true;
    }

    public boolean equals(CartItem item) {
        return this.itemName.equals(item.getName());
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}
