package decoratorpattern;

class BasePizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 5.00; // Base price of pizza
    }
}

