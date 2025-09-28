
public class AudioBook extends MediaItem {
    private AudioBookDetails audioBookDetails;

    public AudioBook(AudioBookDetails details, AudioBookValidator validator) {
        super(details, validator);
        this.audioBookDetails = details;
    }

    public void apply(AudioBookDetails newDetails) {
        this.audioBookDetails = newDetails;
    }

    @Override
    public AudioBookDetails getDetails() {
        return audioBookDetails;
    }

    @Override
    public String getMediaType() {
        return "Audiobook";
    }

}