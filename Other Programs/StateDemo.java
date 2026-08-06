// State
interface State {
    State next(); // each state knows what comes after it
    void show();
}

// ConcreteState
class Red implements State {
    public State next() 
    { return new Green(); }
    public void show() 
    { System.out.println("Red: Stop"); }
}
class Green implements State {
    public State next() 
    { return new Yellow(); }
    public void show() 
    { System.out.println("Green: Go"); }
}
class Yellow implements State {
    public State next() 
    { return new Red(); }
    public void show() 
    { System.out.println("Yellow: Slow down"); }
}

// Context
class TrafficLight {
    private State state = new Red();

    public void change() {
        state = state.next(); // delegates transition to the current state
        state.show();
    }
}

// Client
public class StateDemo {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.change(); // Green
        light.change(); // Yellow
        light.change(); // Red
    }
}
