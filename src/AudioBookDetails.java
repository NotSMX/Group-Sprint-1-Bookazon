public class AudioBookDetails extends MediaDetails {

    private int durationMinutes; // specific to audiobooks

    public AudioBookDetails(Title title, Author author, YearPublished yearPublished, Price price, int durationMinutes) {
        super(title, author, yearPublished, price);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle().getValue() + "\n" +
               "Author: " + getAuthor().getValue() + "\n" +
               "Year Published: " + getYearPublished().getValue() + "\n" +
               "Price: $" + getPrice().getValue() + "\n" +
               "Duration: " + durationMinutes + " mins";
    }
}
