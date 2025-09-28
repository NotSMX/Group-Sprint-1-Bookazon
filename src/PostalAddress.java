public class PostalAddress {
    private final String addressLine1;
    private final String addressLine2;
    private final String city;
    private final String stateProvince;
    private final String postalCode;
    private final String country;

    public PostalAddress(String addressLine1,
                         String addressLine2,
                         String city,
                         String stateProvince,
                         String postalCode,
                         String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.stateProvince = stateProvince;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getAddressLine1() { return addressLine1; }
    public String getAddressLine2() { return addressLine2; }
    public String getCity() { return city; }
    public String getStateProvince() { return stateProvince; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }

    public String getLine1() { return addressLine1; }
    public String getLine2() { return addressLine2; }
    public String getState() { return stateProvince; }
    public String getZip() { return postalCode; }

    public String line1() { return addressLine1; }
    public String line2() { return addressLine2; }
    public String city() { return city; }
    public String state() { return stateProvince; }
    public String zip() { return postalCode; }
    public String country() { return country; }

    public String toSingleLine() {
        StringBuilder sb = new StringBuilder();
        appendSegment(sb, addressLine1);
        appendSegment(sb, addressLine2);
        appendSegment(sb, city);
        appendSegment(sb, stateProvince);
        appendSegment(sb, postalCode);
        appendSegment(sb, country);
        return sb.toString();
    }

    private static void appendSegment(StringBuilder sb, String segment) {
        if (segment == null) return;
        String s = segment.trim();
        if (s.isEmpty()) return;
        if (sb.length() > 0) sb.append(", ");
        sb.append(s);
    }

    @Override
    public String toString() {
        return toSingleLine();
    }
}
