// Product
interface Transport {
    void deliver();
}

// ConcreteProduct
class Truck implements Transport {
    public void deliver() 
    { System.out.println("Delivering by road in a truck"); }
}
class Ship implements Transport {
    public void deliver() 
    { System.out.println("Delivering by sea in a ship"); }
}

// Creator
abstract class Logistics {
    public abstract Transport createTransport(); // factory method

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver(); // shared logic, doesn't know concrete type
    }
}

// ConcreteCreator
class RoadLogistics extends Logistics {
    public Transport createTransport() 
    { return new Truck(); }
}
class SeaLogistics extends Logistics {
    public Transport createTransport() 
    { return new Ship(); }
}

// Client
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Logistics logistics = new SeaLogistics();
        logistics.planDelivery(); // delivers by ship, without client specifying Ship directly
    }
}
