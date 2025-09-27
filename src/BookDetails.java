public class BookDetails {
    public String bookDetails(Book book) {
        return "Title: " + book.getTitle().getValue() + "\n" + "Author: " + book.getAuthor().getValue() + "\n" + "Year Published: " + book.getYearPublished().getValue() + "\n" + "Price: $" + book.getPrice().getValue() + "\n";
    }
}