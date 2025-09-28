public class EBook extends MediaItem {

    public EBook(EBookDetails details) {
        super(details);
    }

    @Override
    public String getMediaType() {
        return "E-Book";
    }
}
