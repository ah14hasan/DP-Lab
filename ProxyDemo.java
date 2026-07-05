// Subject
interface Account {
    void pay(int amount);
}

// RealSubject
class BankAccount implements Account {
    public void pay(int amount) 
    { System.out.println("Paid " + amount + " from bank account"); }
}

// Proxy
class CreditCard implements Account {
    private final BankAccount bankAccount = new BankAccount();
    private final int limit = 500;

    public void pay(int amount) 
    {
        if (amount > limit) 
        {
            System.out.println("Transaction declined: exceeds limit"); // access control
        } 
        else 
        {
            bankAccount.pay(amount); // delegates to the real object
        }
    }
}

// Client
public class ProxyDemo {
    public static void main(String[] args) {
        Account card = new CreditCard();
        card.pay(200); // goes through
        card.pay(700); // declined by proxy before reaching the real account
    }
}
