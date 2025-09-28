public class AudioBook extends MediaItem {
    private int lengthInMinutes;

    public AudioBook(AudioBookDetails details, int lengthInMinutes) {
        super(details);
        this.lengthInMinutes = lengthInMinutes;
    }

    @Override
    public String getMediaType() {
        return "Audiobook";
    }

    public void setLengthInMinutes(int len) {
        this.lengthInMinutes = len;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }
}