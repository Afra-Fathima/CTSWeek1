
interface PaymentProcessor {
    void processPayment(double amount);
}


class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via PayPal.");
    }
}

class Stripe {
    public void charge(double amount) {
        System.out.println("Charging $" + amount + " through Stripe.");
    }
}


class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.charge(amount);
    }
}


public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());

        payPalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(150.0);
    }
}
