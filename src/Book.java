
public class Book extends MediaItem {

    private BookType type;

    public Book(Title t, Author a, YearPublished y, Price p, BookType type) {
        super(t, a, y, p);
        this.type = type;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public void apply(BookUpdate u) {
        setTitle(u.title());
        setAuthor(u.author());
        setYearPublished(u.yearPublished());
        setPrice(u.price());
        setType(u.type());
    }

}
