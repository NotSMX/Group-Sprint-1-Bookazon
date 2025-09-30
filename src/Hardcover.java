public class Hardcover extends BookType {
    @Override
    public String getType() {
        return toString();
    }

    @Override
    public String toString() {
        return "Hardcover";
    }
}