public abstract class MediaItem {
    private final MediaDetails details;

    public MediaItem(MediaDetails details) {
        this.details = details;
    }

    public MediaDetails getDetails() {
        return details;
    }

    public abstract String getMediaType();
}
