public class BookValidator {
        public boolean isPriceValid(BookDetails details) {
        return details.getPrice().getValue() > 0;
    }

    public boolean isTitleValid(BookDetails details) {
        return details.getTitle().getValue() != null && !details.getTitle().getValue().isEmpty();
    }

    public boolean isAuthorValid(BookDetails details) {
        return details.getAuthor().getValue() != null && !details.getAuthor().getValue().isEmpty();
    }

    public boolean isYearPublishedValid(BookDetails details) {
        return details.getYearPublished().getValue() > 0;
    }

    public boolean isTypeValid(BookDetails details) {
        return details.getType() != null;
    }

    public boolean isValid(BookDetails details) {
        return isPriceValid(details) &&
               isTitleValid(details) &&
               isAuthorValid(details) &&
               isYearPublishedValid(details) &&
               isTypeValid(details);
    }
}