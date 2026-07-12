// Prototype
interface Enemy extends Cloneable {
    Enemy clone();
}

// ConcretePrototype
class Goblin implements Enemy {
    private final String weapon;
    private int health;

    public Goblin(String weapon, int health) {
        this.weapon = weapon;
        this.health = health;
    }

    public Enemy clone() 
    { return new Goblin(weapon, health); } // copies instead of rebuilding

    public void describe() {
        System.out.println("Goblin with " + weapon + ", health: " + health);
    }
}

// Client
public class PrototypeDemo {
    public static void main(String[] args) {
        Goblin prototype = new Goblin("Rusty Dagger", 30); // expensive/complex base setup

        Goblin goblin1 = (Goblin) prototype.clone();
        Goblin goblin2 = (Goblin) prototype.clone();

        goblin1.describe();
        goblin2.describe(); // both spawned quickly from the same prototype
    }
}
