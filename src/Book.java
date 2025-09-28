public class Book {
    private Title title;
    private Author author;
    private YearPublished yearPublished;
    private Price price;
    private BookType type;

    public Book(Title title, Author author, YearPublished yearPublished, Price price, BookType type) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
        this.type = type;
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