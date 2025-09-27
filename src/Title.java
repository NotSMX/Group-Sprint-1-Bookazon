public class Title {
    private final String title;

    public Title(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Book requires title");
        }
        this.title = title;
    }

    public String getValue() {
        return title;
    }
}