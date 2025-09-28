public abstract class MediaItem {
    private Title title;
    private Author author;
    private YearPublished yearPublished;
    private Price price;

    public MediaItem(Title title, Author author, YearPublished yearPublished, Price price) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public YearPublished getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(YearPublished yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
