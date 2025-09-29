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
        return super.toString() + "\n" +
               "Duration: " + durationMinutes + " mins";
    }
}
