public class Silver extends Subscription {
    private final double discount = 0.05;
    private final String level = "Silver";
    @Override
    public String level()    { return level; }
    @Override
    public double discount() { return discount; }
}
