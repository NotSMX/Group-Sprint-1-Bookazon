import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
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
