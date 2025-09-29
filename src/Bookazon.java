
import java.util.ArrayList;

public class Bookazon {

    private final ArrayList<MediaItem> products;
    private final ArrayList<User> users;

    public Bookazon() {
        products = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addItem(MediaItem item) {
        products.add(item);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void viewProducts() {
        for (MediaItem item : products) {
            System.out.println(item.toString() + "\n");
        }
    }

    public void validateProducts() {
        for (MediaItem product : products) {
            System.out.println(product.getValidator().toString());
        }
    }

    public boolean validateBooksSilently() {
        for (MediaItem product : products) {
            MediaDetails details = product.getDetails();
            if (!product.getValidator().isValid(details)) {
                return false; // stop on first invalid product
            }
        }
        return true;
    }

    public java.util.List<String> viewUsers() {
        java.util.List<String> lines = new java.util.ArrayList<>();
        for (User user : users) {
            lines.add(user.getName() + " - Role: " + user.getSubscription().level());
        }
        return lines;
    }

    public void removeProduct(MediaItem item) {
        products.remove(item);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void updateProductDetails(MediaItem item, MediaDetails u) {
        item.apply(u);
    }

    public void updateRole(User user, String role) {
        user.updateSubscription(role);
    }

    public static void main(String[] args) {
        Bookazon bookazon = new Bookazon();

        bookazon.addItem(new Book(
                new BookDetails(
                        new Title("The Great Gatsby"),
                        new Author("F. Scott Fitzgerald"),
                        new YearPublished(1925),
                        new Price(9.99),
                        new Paperback()), new BookValidator()
        ));

        bookazon.addItem(new Book(
                new BookDetails(
                        new Title("To Kill a Mockingbird"),
                        new Author("Harper Lee"),
                        new YearPublished(1960),
                        new Price(7.99),
                        new Hardcover()), new BookValidator()
        ));

        bookazon.addItem(new Book(
                new BookDetails(
                        new Title("1984"),
                        new Author("George Orwell"),
                        new YearPublished(1949),
                        new Price(8.99),
                        new Paperback()), new BookValidator()
        ));

         // --- Add AudioBooks ---
        bookazon.addItem(new AudioBook(
            new AudioBookDetails(
                new Title("Becoming"),
                new Author("Michelle Obama"),
                new YearPublished(2018),
                new Price(14.99),
                1140 // duration in minutes
            ),
            new AudioBookValidator()
        ));

         // --- Add DVDs ---
        bookazon.addItem(new DVD(
            new DVDDetails(
                new Title("Inception"),
                new Author("Christopher Nolan"),
                new YearPublished(2010),
                new Price(12.99),
                120, // duration in seconds
                "Region 1" // region code
            ),
            new DVDValidator()
        ));

        // --- Add E-Books ---
        bookazon.addItem(new EBook(
            new EBookDetails(
                new Title("Clean Code"),
                new Author("Robert C. Martin"),
                new YearPublished(2008),
                new Price(29.99),
                "PDF" // format
            ),
            new EBookValidator()
        ));

        bookazon.viewProducts();

        boolean allValid = bookazon.validateBooksSilently();
        assert allValid : "One or more books are invalid";

        bookazon.addUser(new CustomerUser("Alice", "normal"));
        bookazon.addUser(new CustomerUser("Bob", "gold"));

        bookazon.users.get(0).addToCart(bookazon.products.get(0), 1);
        bookazon.users.get(0).addToCart(bookazon.products.get(1), 2);

        bookazon.users.get(0).viewCart();

        bookazon.users.get(0).setShippingAddress("123 Main St", "", "Springfield", "IL", "62701", "USA");
        bookazon.users.get(0).setBillingAddress("456 Elm St", "", "Springfield", "IL", "62702", "USA");

        bookazon.users.get(0).checkout();
        bookazon.users.get(0).viewOrders();

        for (String line : bookazon.viewUsers()) {
            System.out.println(line);
        }
    }
}
