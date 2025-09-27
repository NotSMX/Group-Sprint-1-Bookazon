public class BookValidator {
    public boolean isPriceValid(Book book) {
        return book.getPrice().getValue() > 0;
    }

    public boolean isTitleValid(Book book) {
        return book.getTitle().getValue() != null && !book.getTitle().getValue().isEmpty();
    }

    public boolean isAuthorValid(Book book) {
        return book.getAuthor().getValue() != null && !book.getAuthor().getValue().isEmpty();
    }

    public boolean isYearPublishedValid(Book book) {
        return book.getYearPublished().getValue() > 0;
    }

    public boolean isTypeValid(Book book) {
        return book.getType() != null;
    }
}