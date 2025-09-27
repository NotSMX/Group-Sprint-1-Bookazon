public class YearPublished {
    private final int year;

    public YearPublished(int year) {
        if (year <= 0 && year >= 2026) {
            throw new IllegalArgumentException("Year must be valid");
        }
        this.year = year;
    }

    public int getValue() {
        return year;
    }
}