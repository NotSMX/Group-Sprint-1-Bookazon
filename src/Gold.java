public class Gold extends Subscription {
    private final double discount = 0.10;
    private final String level = "Gold";

    @Override
    public String level() {
        return level;
    }

    @Override
    public double discount() {
        return discount;
    }

}
