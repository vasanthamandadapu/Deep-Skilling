import java.util.Scanner;

public class AdapterTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Payment Gateway:");
        System.out.println("1. PayPal");
        System.out.println("2. Stripe");

        int choice = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        PaymentProcessor paymentProcessor;

        switch (choice) {

            case 1:
                paymentProcessor =
                        new PayPalAdapter(new PayPalGateway());
                paymentProcessor.processPayment(amount);
                break;

            case 2:
                paymentProcessor =
                        new StripeAdapter(new StripeGateway());
                paymentProcessor.processPayment(amount);
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}