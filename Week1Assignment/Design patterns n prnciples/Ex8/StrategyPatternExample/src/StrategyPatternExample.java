// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy: CreditCardPayment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

// Concrete Strategy: PayPalPayment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}

// Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Test Class
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432");
        PaymentStrategy payPalPayment = new PayPalPayment("user@example.com");

        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(250.75);

        context.setPaymentStrategy(payPalPayment);
        context.executePayment(150.50);
    }
}
