public class AudioBookValidator extends MediaValidator {

    public boolean isDurationValid(AudioBookDetails details) {
        return details.getDurationMinutes() > 0;
    }

    public boolean isValid(AudioBookDetails details) {
        return super.isValid(details) && isDurationValid(details);
    }

    public String toString(AudioBookDetails details) {
        return super.toString(details) + ",\n Duration: " + isDurationValid(details);
    }
}
