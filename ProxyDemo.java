// ===== Subject (common interface for both Real and Proxy) =====
interface Image {
    void display();
}

// ===== Real Subject (the expensive object we want to defer creating) =====
class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();   // simulate an expensive operation
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename + " from disk... (expensive!)");
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// ===== Proxy (stand-in that controls access to RealImage) =====
class ImageProxy implements Image {
    private final String filename;
    private RealImage realImage;   // created lazily

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);   // load on first use
        }
        realImage.display();
    }
}

// ===== Main =====
public class ProxyDemo {
    public static void main(String[] args) {
        // Only proxies are created here — no disk access yet, cheap and fast.
        Image img1 = new ImageProxy("photo1.jpg");
        Image img2 = new ImageProxy("photo2.jpg");

        System.out.println("Proxies created. No images loaded yet.\n");

        // First display() triggers the expensive load
        img1.display();
        System.out.println();

        // Second display() reuses the already-loaded image (no reload)
        img1.display();
        System.out.println();

        // img2 was never displayed, so it was never loaded from disk at all
        img2.display();
    }
}
