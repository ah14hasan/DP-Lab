// ===== Implementor (the "implementation" side of the bridge) =====
interface Color {
    String fill();
}

// ===== Concrete Implementors =====
class RedColor implements Color {
    public String fill() { return "red"; }
}

class BlueColor implements Color {
    public String fill() { return "blue"; }
}

// ===== Abstraction (holds a reference to an Implementor — this IS the bridge) =====
abstract class Shape {
    protected Color color;   // the "bridge" link to the implementation

    protected Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

// ===== Refined Abstractions =====
class Circle extends Shape {
    public Circle(Color color) { super(color); }
    public void draw() {
        System.out.println("Drawing a " + color.fill() + " circle.");
    }
}

class Square extends Shape {
    public Square(Color color) { super(color); }
    public void draw() {
        System.out.println("Drawing a " + color.fill() + " square.");
    }
}

// ===== Main =====
public class BridgeDemo {
    public static void main(String[] args) {
        // Mix and match shapes with colors freely — no need for
        // RedCircle, BlueCircle, RedSquare, BlueSquare classes.
        Shape redCircle  = new Circle(new RedColor());
        Shape blueCircle = new Circle(new BlueColor());
        Shape blueSquare = new Square(new BlueColor());

        redCircle.draw();
        blueCircle.draw();
        blueSquare.draw();
    }
}
