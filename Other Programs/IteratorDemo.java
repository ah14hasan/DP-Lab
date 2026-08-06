import java.util.*;

// Aggregate
class ChannelList {
    private final List<String> channels;

    public ChannelList(List<String> channels) 
    { this.channels = channels; }

    public Iterator<String> createIterator() 
    { return channels.iterator(); } // hides the List internals
}

// Client
public class IteratorDemo {
    public static void main(String[] args) {
        ChannelList channels = new ChannelList(Arrays.asList("News", "Sports", "Movies"));
        Iterator<String> iterator = channels.createIterator();

        while (iterator.hasNext()) {
            System.out.println("Flipping to: " + iterator.next()); // client only calls hasNext()/next()
        }
    }
}
