// Handler
abstract class Support {
    protected Support next;

    public Support setNext(Support next) 
    { this.next = next; return next; }

    public abstract void handle(int level);
}

// ConcreteHandler
class Level1 extends Support {
    public void handle(int level) {
        if (level <= 1) System.out.println("Level1 handled it");
        else if (next != null) next.handle(level); // pass along
    }
}
class Level2 extends Support {
    public void handle(int level) {
        if (level <= 2) System.out.println("Level2 handled it");
        else if (next != null) next.handle(level);
    }
}
class Specialist extends Support {
    public void handle(int level) 
    { System.out.println("Specialist handled it"); }
}

// Client
public class ChainDemo {
    public static void main(String[] args) {
        Support level1 = new Level1();
        Support level2 = level1.setNext(new Level2());
        level2.setNext(new Specialist()); // chain: level1 -> level2 -> specialist

        level1.handle(3); // escalates until Specialist handles it
    }
}
