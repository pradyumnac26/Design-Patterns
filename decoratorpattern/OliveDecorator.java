// Concrete Decorator: Adding Olives
package decoratorpattern;

class OlivesDecorator extends ToppingDecorator {
    public OlivesDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.50; // Adding olives costs $1.50
    }
}