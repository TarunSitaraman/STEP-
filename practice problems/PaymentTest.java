interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}

class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid via Credit Card: ₹" + amount);
    }
    @Override
    public void refund(double amount) {
        System.out.println("Refund to Credit Card: ₹" + amount);
    }
}

class UPIPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid via UPI: ₹" + amount);
    }
    @Override
    public void refund(double amount) {
        System.out.println("Refund to UPI: ₹" + amount);
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        PaymentGateway payment = new CreditCardPayment();
        payment.pay(1500);
        payment.refund(500);

        System.out.println("---");

        payment = new UPIPayment();
        payment.pay(2000);
        payment.refund(750);
    }
}
