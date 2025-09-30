public class DVD extends MediaItem {

    private DVDDetails dvdDetails;

    public DVD(DVDDetails details, DVDValidator validator) {
        super(details, validator);
        this.dvdDetails = details;
    }

    @Override
    public String getMediaType() {
        return "DVD";
    }

    @Override
    public DVDDetails getDetails() {
        return dvdDetails;
    }

    public void apply(DVDDetails newDetails) {
        this.dvdDetails = newDetails;
    }
}
