// AbstractClass
abstract class Beverage {
    public final void prepare() { // template method: fixed skeleton
        System.out.println("Boiling water");
        brew();
        System.out.println("Pouring into cup");
    }

    protected abstract void brew(); // step subclasses customize
}

// ConcreteClass
class Tea extends Beverage {
    protected void brew() 
    { System.out.println("Steeping tea bag"); }
}
class Coffee extends Beverage {
    protected void brew() 
    { System.out.println("Brewing coffee grounds"); }
}

// Client
public class TemplateMethodDemo {
    public static void main(String[] args) {
        new Tea().prepare();    // same steps, different brew
        new Coffee().prepare();
    }
}
