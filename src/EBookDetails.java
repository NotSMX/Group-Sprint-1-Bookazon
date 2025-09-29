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
        return super.toString() + "\n" +
               "Format: " + format;
    }
}
