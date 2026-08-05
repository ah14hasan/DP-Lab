// Component
interface Coffee {
    String describe();
}

// ConcreteComponent
class PlainCoffee implements Coffee {
    public String describe() 
    { return "Coffee"; }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected final Coffee coffee; // wraps another Coffee

    public CoffeeDecorator(Coffee coffee) 
    { this.coffee = coffee; }
}

// ConcreteDecorator
class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) 
    { super(coffee); }
    public String describe() 
    { return coffee.describe() + " + Milk"; }
}
class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) 
    { super(coffee); }
    public String describe() 
    { return coffee.describe() + " + Sugar"; }
}

// Client
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee order = new Sugar(new Milk(new PlainCoffee())); // stack decorators freely

        System.out.println(order.describe()); // Coffee + Milk + Sugar
    }
}
