public class Title {
    private final String title;

    public Title(String title) {
        if (!validateTitle(title)) {
            throw new IllegalArgumentException("Book requires title");
        }
        this.title = title;
    }

    private boolean validateTitle(String title) {
        return !(title == null || title.isEmpty());
    }

    public String getValue() {
        return title;
    }
}