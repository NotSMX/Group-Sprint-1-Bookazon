public class BookValidator {
    public boolean isPriceValid(Book book) {
        return book.getPrice() > 0;
    }

    public boolean isTitleValid(Book book) {
        return book.getTitle() != null && !book.getTitle().isEmpty();
    }

    public boolean isAuthorValid(Book book) {
        return book.getAuthor() != null && !book.getAuthor().isEmpty();
    }

    public boolean isYearPublishedValid(Book book) {
        return book.getYearPublished() > 0;
    }
}