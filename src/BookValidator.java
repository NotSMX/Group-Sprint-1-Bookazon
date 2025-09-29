public class BookValidator extends MediaValidator{
    public boolean isTypeValid(BookDetails details) {
        return details.getType() != null;
    }

    public boolean isValid(BookDetails details) {
        return super.isValid(details) && isTypeValid(details);
    }

    public String toString(BookDetails details) {
        return super.toString(details) + ",\n Cover Type: " + isTypeValid(details);
    }
}