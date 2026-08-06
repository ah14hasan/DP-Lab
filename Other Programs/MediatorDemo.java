import java.util.*;
// Mediator
class ControlTower {
    private final List<String> planes = new ArrayList<>();

    public void request(String plane) {
        System.out.println(plane + " requests to land");
        System.out.println("Tower: cleared, " + planes.size() + " plane(s) ahead of you");
        planes.add(plane); // tower tracks and coordinates, planes don't talk to each other
    }
}

// Client
public class MediatorDemo {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();

        tower.request("Flight A"); // planes only ever talk to the tower
        tower.request("Flight B");
    }
}
