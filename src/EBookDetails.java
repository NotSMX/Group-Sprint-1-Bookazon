public class EBookDetails extends MediaDetails {

    private String format;  // PDF, EPUB, MOBI, etc.

    public EBookDetails(Title title, Author author, YearPublished yearPublished, Price price, String format) {
        super(title, author, yearPublished, price);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle().getValue() + "\n" +
               "Author: " + getAuthor().getValue() + "\n" +
               "Year Published: " + getYearPublished().getValue() + "\n" +
               "Price: $" + getPrice().getValue() + "\n" +
               "Format: " + format;
    }
}
