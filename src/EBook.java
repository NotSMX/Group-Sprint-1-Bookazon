public class EBook extends MediaItem {

    private EBookDetails ebookDetails;

    public EBook(EBookDetails details, EBookValidator validator) {
        super(details, validator);
        this.ebookDetails = details;
    }

    @Override
    public String getMediaType() {
        return "E-Book";
    }

    @Override
    public EBookDetails getDetails() {
        return ebookDetails;
    }

    public void apply(EBookDetails newDetails) {
        this.ebookDetails = newDetails;
    }
}
