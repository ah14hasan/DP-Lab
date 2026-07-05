// Strategy
interface RouteStrategy {
    void buildRoute(String from, String to);
}

// ConcreteStrategy
class DrivingStrategy implements RouteStrategy {
    public void buildRoute(String from, String to) {
        System.out.println("Driving route from " + from + " to " + to);
    }
}
class WalkingStrategy implements RouteStrategy {
    public void buildRoute(String from, String to) {
        System.out.println("Walking route from " + from + " to " + to);
    }
}

// Context
class Navigator {
    private RouteStrategy strategy;

    public void setStrategy(RouteStrategy strategy) 
    { this.strategy = strategy; }

    public void navigate(String from, String to) 
    {strategy.buildRoute(from, to);} // delegates without knowing the algorithm details
}
// Client
public class StrategyDemo {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();

        navigator.setStrategy(new DrivingStrategy());
        navigator.navigate("Home", "Office"); // driving route

        navigator.setStrategy(new WalkingStrategy());
        navigator.navigate("Home", "Office"); // walking route, same navigator
    }
}
