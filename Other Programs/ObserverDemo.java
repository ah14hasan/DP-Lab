import java.util.*;

// Observer
interface Subscriber {
    void notify(String video);
}

// Subject
class Channel {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber s) 
    { subscribers.add(s); }

    public void upload(String video) {
        for (Subscriber s : subscribers) s.notify(video); // broadcast to all
    }
}

// Client
public class ObserverDemo {
    public static void main(String[] args) {
        Channel channel = new Channel();

        channel.subscribe(video -> System.out.println("Ali notified: " + video));
        channel.subscribe(video -> System.out.println("Sam notified: " + video));

        channel.upload("Design Patterns Explained"); // both notified automatically
    }
}
