import java.util.ArrayList;

public class Cart {
    private final ArrayList<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(MediaItem media, int quantity) {
        if (!validateItem(media, quantity)) {
            throw new IllegalArgumentException("Check your object!");
        }
        items.add(new CartItem(media, quantity));
    }

    public boolean validateItem(MediaItem media, int quantity) {
        if (media == null || quantity < 0) {
            return false;
        }
        return true;
    }

    public void removeItem(CartItem item) {
        if (!validateRemove(item)) {
            throw new IllegalArgumentException("The item is empty or does not exist!!");
        }
        items.remove(item);
    }

    private boolean validateRemove(CartItem item) {
        if (item == null) {
            return false;
        } return true;
    }

    public void updateQuantity(CartItem item, int quantity) {
        for (CartItem cartItem : items) {
            if (cartItem.equals(item)) {
                cartItem.setQuantity(quantity);
                break;
            }
        }
    }

    /** Encapsulated remover to avoid mutating the list via getItems() while iterating */
    public void removeByProductName(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
                return;
            }
        }
    }

    public void viewCartDetails() {
        System.out.println("Cart Details:");
        for (CartItem item : items) {
            System.out.println(item.getName() + " - Quantity: " + item.getQuantity());
        }
        System.out.println("\n");
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }
}
