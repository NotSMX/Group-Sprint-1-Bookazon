public class DVDValidator extends MediaValidator {

    public boolean isRuntimeValid(DVDDetails details) {
        return details.getRuntimeMinutes() > 0;
    }

    public boolean isRegionValid(DVDDetails details) {
        return details.getRegionCode() != null && !details.getRegionCode().isEmpty();
    }

    public boolean isValid(DVDDetails details) {
        return super.isValid(details) &&
               isRuntimeValid(details) &&
               isRegionValid(details);
    }

    public String toString(DVDDetails details) {
        return super.toString(details) + ",\n Runtime: " + isRuntimeValid(details) + ",\n Region: " + isRegionValid(details);
    }
}
