// Receiver
class Chef {
    public void cookDish(String dish) 
    { System.out.println("Chef is cooking: " + dish); }
}

// Command
interface Order {
    void execute();
}

// Invoker
class Waiter {
    private Order order;

    public void takeOrder(Order order) 
    { this.order = order; }

    public void placeOrder() 
    { order.execute(); }
}

// Client
public class CommandDemo {
    public static void main(String[] args) {
        Chef chef = new Chef();
        Order foodOrder = () -> chef.cookDish("Pasta"); // lambda replaces DishOrder class
        Waiter waiter = new Waiter();
        waiter.takeOrder(foodOrder);
        waiter.placeOrder();
    }
}
