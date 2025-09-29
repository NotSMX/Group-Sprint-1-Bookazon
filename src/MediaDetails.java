public abstract class MediaDetails {
    private final Title title;
    private final Author author;
    private final YearPublished yearPublished;
    private final Price price;

    public MediaDetails(Title title, Author author, YearPublished yearPublished, Price price) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public Title getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public YearPublished getYearPublished() {
        return yearPublished;
    }

    public Price getPrice() {
        return price;
    }
}
