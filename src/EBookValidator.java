public class EBookValidator extends MediaValidator {

    public boolean isFormatValid(EBookDetails details) {
        return details.getFormat() != null && !details.getFormat().isEmpty();
    }

    public boolean isValid(EBookDetails details) {
        return super.isValid(details) && isFormatValid(details);
    }

    public String toString(EBookDetails details) {
        return super.toString(details) + ",\n Format: " + isFormatValid(details);
    }
}
