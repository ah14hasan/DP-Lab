import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystemItem {
    int getSize();
}

// Leaf
class File implements FileSystemItem {
    private final int size;
    public File(int size) { this.size = size; }
    public int getSize() { return size; }
}

// Composite
class Folder implements FileSystemItem {
    private final List<FileSystemItem> items = new ArrayList<>();

    public void add(FileSystemItem item) { items.add(item); }

    public int getSize() {
        return items.stream().mapToInt(FileSystemItem::getSize).sum(); // replaces manual loop
    }
}

// Client
public class CompositeDemo {
    public static void main(String[] args) {
        Folder subFolder = new Folder();
        subFolder.add(new File(50));
        subFolder.add(new File(30));

        Folder root = new Folder();
        root.add(new File(100));
        root.add(subFolder); // folder inside a folder

        System.out.println("Total size: " + root.getSize()); // 180, computed recursively
    }
}
