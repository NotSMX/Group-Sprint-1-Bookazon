public class CartItem {
    private final String name;
    private final double price;
    private int quantity;

    public CartItem(MediaItem item, int quantity) {
        this.name = item.getMediaType() + " \"" + item.getDetails().getTitle().getValue() + "\"";
        this.price = item.getDetails().getPrice().getValue();
        this.quantity = quantity;
    }

    public String getName() {
        return name;
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
        return quantity >= 0;
    }

    public boolean equals(CartItem item) {
        return this.name.equals(item.getName());
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}
