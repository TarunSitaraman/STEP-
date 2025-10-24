public class Payment {
    public void pay() {
        System.out.println("Generic payment");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Processing credit card payment");
    }
}

class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Processing wallet payment");
    }
}

class PaymentGateway {
    public static void main(String[] args) {
        Payment[] payments = new Payment[3];
        payments[0] = new CreditCardPayment();
        payments[1] = new WalletPayment();
        payments[2] = new Payment();
        
        System.out.println("Payment Gateway - Processing Payments:\n");
        
        for (Payment payment : payments) {
            System.out.println("Class: " + payment.getClass().getSimpleName());
            payment.pay();
            System.out.println();
        }
    }
}
