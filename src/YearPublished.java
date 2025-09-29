public class YearPublished {
    private final int year;
    private final int currentYear = 2025;

    public YearPublished(int year) {
        if (!validateYear(year)) {
            throw new IllegalArgumentException("Year must be valid");
        }
        this.year = year;
    }

    private boolean validateYear(int year) {
        return year > 0 && year < (currentYear + 1);
    }

    public int getValue() {
        return year;
    }
}