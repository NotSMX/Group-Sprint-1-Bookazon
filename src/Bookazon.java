
import java.util.ArrayList;

public class Bookazon {

    private final ArrayList<Book> books;
    private final ArrayList<User> users;

    public Bookazon() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public java.util.List<String> viewBooks() {
        java.util.List<String> lines = new java.util.ArrayList<>();
        for (Book book : books) {
            lines.add(book.getDetails().toString());
        }
        return lines;
    }

    public void validateBooks() {
        BookValidator validator = new BookValidator();
        for (Book book : books) {
            BookDetails details = book.getDetails();
            boolean priceValid = validator.isPriceValid(details);
            boolean titleValid = validator.isTitleValid(details);
            boolean authorValid = validator.isAuthorValid(details);
            boolean yearValid = validator.isYearPublishedValid(details);
            System.out.println(
                    book.getDetails().getTitle()
                    + ": Price: " + priceValid
                    + ", Title: " + titleValid
                    + ", Author: " + authorValid
                    + ", Year: " + yearValid
            );
        }
    }

    public boolean validateBooksSilently() {
        BookValidator validator = new BookValidator();
        for (Book book : books) {
            BookDetails details = book.getDetails();
            boolean ok = validator.isValid(details);
            if (!ok) {
                return false;
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

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void updateBookDetails(Book book, BookDetails u) {
        book.apply(u);
    }

    public void updateRole(User user, String role) {
        user.updateSubscription(role);
    }

    public static void main(String[] args) {
        Bookazon bookazon = new Bookazon();

        bookazon.addBook(new Book(
                new BookDetails(
                        new Title("The Great Gatsby"),
                        new Author("F. Scott Fitzgerald"),
                        new YearPublished(1925),
                        new Price(9.99),
                        new Paperback())
        ));

        bookazon.addBook(new Book(
                new BookDetails(
                        new Title("To Kill a Mockingbird"),
                        new Author("Harper Lee"),
                        new YearPublished(1960),
                        new Price(7.99),
                        new Hardcover()
                )));

        bookazon.addBook(new Book(
                new BookDetails(
                        new Title("1984"),
                        new Author("George Orwell"),
                        new YearPublished(1949),
                        new Price(8.99),
                        new Paperback()
                )));

        for (String line : bookazon.viewBooks()) {
            System.out.println(line);
        }

        boolean allValid = bookazon.validateBooksSilently();
        assert allValid : "One or more books are invalid";

        bookazon.addUser(new CustomerUser("Alice", "normal"));
        bookazon.addUser(new CustomerUser("Bob", "gold"));

        bookazon.users.get(0).addToCart(bookazon.books.get(0), 1);
        bookazon.users.get(0).addToCart(bookazon.books.get(1), 2);

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
