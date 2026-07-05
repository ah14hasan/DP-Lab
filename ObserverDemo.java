import java.util.ArrayList;
import java.util.List;

// Observer
interface Subscriber {
    void notify(String videoTitle);
}

// ConcreteObserver
class User implements Subscriber {
    private final String name;

    public User(String name) 
    { this.name = name; }

    public void notify(String videoTitle) 
    {System.out.println(name + " notified: new video \"" + videoTitle + "\" uploaded");}
}

// Subject
class YouTubeChannel {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) { subscribers.add(subscriber); }

    public void uploadVideo(String title) {
        for (Subscriber subscriber : subscribers) {
            subscriber.notify(title); // subject doesn't know/care who's listening
        }
    }
}

// Client
public class ObserverDemo {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();
        channel.subscribe(new User("Ali"));
        channel.subscribe(new User("Sam"));

        channel.uploadVideo("Design Patterns Explained"); // both users notified automatically
    }
}
