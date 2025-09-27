public class Price {
    private final double cost;

    public Price(double cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException("Cost must be valid");
        }
        this.cost = cost;
    }

    public double getValue() {
        return cost;
    }
}