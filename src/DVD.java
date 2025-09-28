public class DVD extends MediaItem {

    public DVD(DVDDetails details) {
        super(details);
    }

    @Override
    public String getMediaType() {
        return "DVD";
    }
}
