// Implementor
interface Device {
    void turnOn();
}

// ConcreteImplementor
class TV implements Device {
    public void turnOn() 
    { System.out.println("TV is turning on"); }
}
class Radio implements Device {
    public void turnOn() 
    { System.out.println("Radio is turning on"); }
}

// Abstraction
class RemoteControl {
    private final Device device; // the "bridge" to the implementation

    public RemoteControl(Device device) 
    { this.device = device; }

    public void power() 
    { device.turnOn(); }
}

// Client
public class BridgeDemo {
    public static void main(String[] args) {
        new RemoteControl(new TV()).power();    // same remote class, different device
        new RemoteControl(new Radio()).power();
    }
}
