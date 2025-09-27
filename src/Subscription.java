import java.util.Locale;
import java.util.Map;

public class Subscription {
    private static final Map<String, Double> DISCOUNTS = Map.of(
        "normal",   0.00,
        "silver",   0.05,
        "gold",     0.15,
        "platinum", 0.10
    );

    private final String level;     // normalized lower-case
    private final double discount;

    private Subscription(String level, double discount) {
        this.level = level;
        this.discount = discount;
    }

    public static Subscription of(String raw) {
        String key = (raw == null ? "normal" : raw.toLowerCase(Locale.ROOT).trim());
        if (!DISCOUNTS.containsKey(key)) key = "normal";
        return new Subscription(key, DISCOUNTS.get(key));
    }

    public String level()    { return level; }
    public double discount() { return discount; }
}
