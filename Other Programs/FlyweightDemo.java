import java.util.*;

// Flyweight
class TreeType {
    private final String name; // shared/intrinsic state

    public TreeType(String name) 
    { this.name = name; }

    public void render(int x, int y) { // extrinsic state passed in
        System.out.println("Rendering " + name + " tree at (" + x + ", " + y + ")");
    }
}

// FlyweightFactory
class TreeFactory {
    private static final Map<String, TreeType> types = new HashMap<>();

    public static TreeType getTreeType(String name) {
        types.putIfAbsent(name, new TreeType(name)); // reuse if already created
        return types.get(name);
    }
}

// Client
public class FlyweightDemo {
    public static void main(String[] args) {
        TreeType oak = TreeFactory.getTreeType("Oak");
        oak.render(10, 20);
        oak.render(15, 25); // same Oak object reused, different position

        System.out.println(oak == TreeFactory.getTreeType("Oak")); // true — shared instance
    }
}
