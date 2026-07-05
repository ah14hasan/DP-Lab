// Target (interface the client expects)
interface USSocket {
    void plugIn();
}

// Adaptee (existing incompatible interface)
class EuropeanSocket {
    public void connect() 
    { System.out.println("Connected to European-style socket"); }
}

// Adapter
class SocketAdapter implements USSocket {
    private final EuropeanSocket europeanSocket;

    public SocketAdapter(EuropeanSocket europeanSocket) {
        this.europeanSocket = europeanSocket;
    }

    public void plugIn() 
    { europeanSocket.connect(); } // translates the call
}

// Client
public class AdapterDemo {
    public static void main(String[] args) {
        EuropeanSocket wallSocket = new EuropeanSocket();
        USSocket adapter = new SocketAdapter(wallSocket);

        adapter.plugIn(); // client only knows USSocket, adapter handles the rest
    }
}
