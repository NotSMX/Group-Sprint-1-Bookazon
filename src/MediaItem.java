public abstract class MediaItem {
    private MediaDetails details;
    private final MediaValidator validator;

    public MediaItem(MediaDetails details, MediaValidator validator) {
        this.details = details;
        this.validator = validator;
    }

    public MediaDetails getDetails() {
        return details;
    }

    public void apply(MediaDetails details) {
        this.details = details;

    }

    public MediaValidator getValidator() {
        return this.validator;
    }

    public boolean isValid() {
        return validator.isValid(details);
    }

    @Override
    public String toString() {
        return "Media Type: " + getMediaType() + "\n" + details.toString();
    }

    public abstract String getMediaType();
}
