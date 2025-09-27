public class BookDetails {
    public String bookDetails(Book book) {
        return "Title: " + book.getTitle() + "\n" + "Author: " + book.getAuthor() + "\n" + "Year Published: " + book.getYearPublished() + "\n" + "Price: $" + book.getPrice() + "\n";
    }
}