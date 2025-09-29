public class Title {
    private final String title;

    public Title(String title) {
        if (!validateTitle(title)) {
            throw new IllegalArgumentException("Book requires title");
        }
        this.title = title;
    }

    private boolean validateTitle(String title) {
        if (title == null || title.isEmpty()) {
            return false;
        }
        return true;
    }

    public String getValue() {
        return title;
    }
}