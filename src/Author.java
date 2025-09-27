public class Author {
    private final String name;

    public Author(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Author requires name");
        }
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}