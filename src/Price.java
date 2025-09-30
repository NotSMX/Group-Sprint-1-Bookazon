public class Price {
    private final double cost;

    public Price(double cost) {
        if (!validateCost(cost)) {
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        this.cost = cost;
    }

    private boolean validateCost(double cost) {
        return cost > 0;
    }

    public double getValue() {
        return cost;
    }
}