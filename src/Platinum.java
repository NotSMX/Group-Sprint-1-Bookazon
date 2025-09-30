public class Platinum extends Subscription {
    private final double discount = 0.15;
    private final String level = "Platinum";

    @Override
    public String level() {
        return level;
    }

    @Override
    public double discount() {
        return discount;
    }
}
