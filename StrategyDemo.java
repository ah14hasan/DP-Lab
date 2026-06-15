// ===== Strategy interface (defines the family of algorithms) =====
interface PaymentStrategy {
    void pay(double amount);
}

// ===== Concrete Strategies (each is one interchangeable algorithm) =====
class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;
    public CreditCardPayment(String cardNumber) { this.cardNumber = cardNumber; }
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with credit card " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private final String email;
    public PayPalPayment(String email) { this.email = email; }
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal account " + email);
    }
}

class CryptoPayment implements PaymentStrategy {
    private final String walletAddress;
    public CryptoPayment(String walletAddress) { this.walletAddress = walletAddress; }
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " in crypto from wallet " + walletAddress);
    }
}

// ===== Context (uses a Strategy without knowing which concrete one it is) =====
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}

// ===== Main =====
public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Swap algorithms at runtime — no if/else, no instanceof.
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012"));
        cart.checkout(99.99);

        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(45.50);

        cart.setPaymentStrategy(new CryptoPayment("0xABC123..."));
        cart.checkout(120.00);
    }
}
