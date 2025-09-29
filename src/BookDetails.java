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
        return super.toString() + "\n" +
               "Type: " + type;  // show Paperback/Hardcover
    }
}
