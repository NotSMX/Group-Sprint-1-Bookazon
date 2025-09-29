public class DVDDetails extends MediaDetails {

    private int runtimeMinutes;  // DVD-specific
    private String regionCode;   // optional

    public DVDDetails(Title title, Author author, YearPublished yearPublished, Price price, int runtimeMinutes, String regionCode) {
        super(title, author, yearPublished, price);
        this.runtimeMinutes = runtimeMinutes;
        this.regionCode = regionCode;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle().getValue() + "\n" +
               "Author: " + getAuthor().getValue() + "\n" +
               "Year Published: " + getYearPublished().getValue() + "\n" +
               "Price: $" + getPrice().getValue() + "\n" +
               "Runtime: " + runtimeMinutes + " mins\n" +
               "Region: " + regionCode;
    }
}
