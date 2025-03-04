package decoratorpattern;


class PepperoniDecorator extends ToppingDecorator {
    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.50; // Adding pepperoni costs $2.50
    }
}