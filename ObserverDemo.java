import java.util.ArrayList;
import java.util.List;

// ===== Observer interface (what subscribers must implement) =====
interface Subscriber {
    void update(String videoTitle);
}

// ===== Subject interface (what subscribers can be attached to) =====
interface Channel {
    void subscribe(Subscriber s);
    void unsubscribe(Subscriber s);
    void notifySubscribers();
}

// ===== Concrete Subject =====
class YouTubeChannel implements Channel {
    private final List<Subscriber> subscribers = new ArrayList<>();
    private String latestVideo;

    public void subscribe(Subscriber s)   { subscribers.add(s); }
    public void unsubscribe(Subscriber s) { subscribers.remove(s); }

    public void notifySubscribers() {
        for (Subscriber s : subscribers) {
            s.update(latestVideo);
        }
    }

    // The "state change" that triggers notification.
    public void uploadVideo(String title) {
        this.latestVideo = title;
        System.out.println("Channel uploaded: \"" + title + "\"");
        notifySubscribers();
    }
}

// ===== Concrete Observer =====
class User implements Subscriber {
    private final String name;
    public User(String name) { this.name = name; }
    public void update(String videoTitle) {
        System.out.println("   -> " + name + " got notified about: \"" + videoTitle + "\"");
    }
}

// ===== Main =====
public class ObserverDemo {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Subscriber alice = new User("Alice");
        Subscriber bob   = new User("Bob");
        Subscriber carol = new User("Carol");

        channel.subscribe(alice);
        channel.subscribe(bob);
        channel.subscribe(carol);

        channel.uploadVideo("Observer Pattern in 5 mins");

        // Bob unsubscribes — he won't be notified anymore.
        channel.unsubscribe(bob);

        channel.uploadVideo("Java Tips & Tricks");
    }
}
