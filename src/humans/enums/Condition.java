package humans.enums;

public enum Condition {
    GOOD(1.5),
    UNSERTAIN(1.0),
    CONFIDENCE(0.0);
    private final double receptivity;

    Condition(double receptivity) {
        this.receptivity = receptivity;
    }

    public double getReceptivity() {
        return receptivity;
    }
}




