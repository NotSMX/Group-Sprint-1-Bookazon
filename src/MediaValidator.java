public abstract class MediaValidator {
    public boolean isPriceValid(MediaDetails details) {
        return details.getPrice().getValue() > 0;
    }

    public boolean isTitleValid(MediaDetails details) {
        return details.getTitle().getValue() != null && !details.getTitle().getValue().isEmpty();
    }

    public boolean isAuthorValid(MediaDetails details) {
        return details.getAuthor().getValue() != null && !details.getAuthor().getValue().isEmpty();
    }

    public boolean isYearPublishedValid(MediaDetails details) {
        return details.getYearPublished().getValue() > 0;
    }

    public boolean isValid(MediaDetails details) {
        return isPriceValid(details) &&
                isTitleValid(details) &&
                isAuthorValid(details) &&
                isYearPublishedValid(details);
    }

    public String toString(MediaDetails details) {
        return details.getTitle()
                + ":\nPrice: " + isPriceValid(details)
                + ",\nTitle: " + isTitleValid(details)
                + ",\nAuthor: " + isAuthorValid(details)
                + ",\nYear: " + isYearPublishedValid(details);
    }
}
