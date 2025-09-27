public class PostalAddress {
    private final String line1;
    private final String line2;
    private final String city;
    private final String state;
    private final String zip;
    private final String country;

    public PostalAddress(String line1, String line2, String city, String state, String zip, String country) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String line1()   { return line1; }
    public String line2()   { return line2; }
    public String city()    { return city; }
    public String state()   { return state; }
    public String zip()     { return zip; }
    public String country() { return country; }

    // Bean-style getters
    public String getLine1(){ return line1; }
    public String getLine2(){ return line2; }
    public String getCity(){ return city; }
    public String getState(){ return state; }
    public String getZip(){ return zip; }
    public String getCountry(){ return country; }
}