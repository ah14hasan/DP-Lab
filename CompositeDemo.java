import java.util.ArrayList;
import java.util.List;

// ===== Component (common interface for both leaves and composites) =====
interface FileSystemItem {
    void show(String indent);
}

// ===== Leaf (has no children) =====
class Document implements FileSystemItem {
    private final String name;
    public Document(String name) { this.name = name; }
    public void show(String indent) {
        System.out.println(indent + "- " + name);
    }
}

// ===== Composite (can contain other Components — including other Composites) =====
class Folder implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) { this.name = name; }

    public void add(FileSystemItem item) { children.add(item); }

    public void show(String indent) {
        System.out.println(indent + "+ " + name);
        for (FileSystemItem child : children) {
            child.show(indent + "   ");
        }
    }
}

// ===== Main =====
public class CompositeDemo {
    public static void main(String[] args) {
        // Build a tree:
        //   root
        //   ├── docs
        //   │    ├── resume.pdf
        //   │    └── notes.txt
        //   ├── pics
        //   │    └── vacation.jpg
        //   └── readme.md

        Folder root = new Folder("root");
        Folder docs = new Folder("docs");
        Folder pics = new Folder("pics");

        docs.add(new Document("resume.pdf"));
        docs.add(new Document("notes.txt"));

        pics.add(new Document("vacation.jpg"));

        root.add(docs);
        root.add(pics);
        root.add(new Document("readme.md"));

        // Treat the entire tree the same way you'd treat a single document.
        root.show("");
    }
}
