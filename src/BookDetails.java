public class BookDetails extends MediaDetails {

    private BookType type;

    public BookDetails(Title title, Author author, YearPublished yearPublished, Price price, BookType type) {
        super(title, author, yearPublished, price);
        this.type = type;
    }

    public void setType(BookType type) {
        this.type = type;
    }
    public BookType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle().getValue() + "\n" +
               "Author: " + getAuthor().getValue() + "\n" +
               "Year Published: " + getYearPublished().getValue() + "\n" +
               "Price: $" + getPrice().getValue() + "\n" +
               "Type: " + type;  // show Paperback/Hardcover
    }
}
