public class Book extends MediaItem {
    private BookDetails bookDetails;

    public Book(BookDetails details, BookValidator validator) {
        super(details, validator);
        this.bookDetails = details;
    }

    public void apply(BookDetails newDetails) {
        this.bookDetails = newDetails;
    }

    @Override
    public BookDetails getDetails() {
        return bookDetails;
    }

    @Override
    public String getMediaType() {
        return "Book";
    }
}
