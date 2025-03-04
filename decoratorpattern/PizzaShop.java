package decoratorpattern;

public class PizzaShop {
    public static void main(String[] args) {
        // Order a plain pizza
        Pizza pizza = new BasePizza();
        System.out.println(pizza.getDescription() + " -> Cost: $" + pizza.getCost());

        // Add cheese topping
        pizza = new CheeseDecorator(pizza);
        System.out.println(pizza.getDescription() + " -> Cost: $" + pizza.getCost());

        // Add olives topping
        pizza = new OlivesDecorator(pizza);
        System.out.println(pizza.getDescription() + " -> Cost: $" + pizza.getCost());

        // Add pepperoni topping
        pizza = new PepperoniDecorator(pizza);
        System.out.println(pizza.getDescription() + " -> Cost: $" + pizza.getCost());
    }
}
