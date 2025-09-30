public class Author {
    private final String name;

    public Author(String name) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("Author requires name");
        }
        this.name = name;
    }

    private boolean validateName(String name) {
        return !(name == null || name.isEmpty());
    }

    public String getValue() {
        return name;
    }
}