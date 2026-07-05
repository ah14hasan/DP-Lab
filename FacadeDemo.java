// Subsystem classes
class FuelInjector {
    public void inject()
    { System.out.println("Injecting fuel"); }
}
class Ignition {
    public void fire() 
    { System.out.println("Firing ignition"); }
}
class Starter {
    public void engage() 
    { System.out.println("Engaging starter motor"); }
}

// Facade
class CarStartFacade {
    private final FuelInjector fuelInjector = new FuelInjector();
    private final Ignition ignition = new Ignition();
    private final Starter starter = new Starter();

    public void startCar() {
        fuelInjector.inject();
        ignition.fire();
        starter.engage(); // client doesn't need to know or call these individually
    }
}

// Client
public class FacadeDemo {
    public static void main(String[] args) {
        CarStartFacade car = new CarStartFacade();
        car.startCar(); // one call instead of managing three subsystems
    }
}
