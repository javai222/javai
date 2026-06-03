package grasp.deleon.app.entity;

// GRASP: Polymorphism - CardPayment is a second implementation of the Payment interface
// GRASP: Protected Variations - new payment types can be added without changing OrderService
public class CardPayment implements Payment {

    private final String cardLastFour;

    public CardPayment(String cardLastFour) {
        this.cardLastFour = cardLastFour;
    }

    @Override
    public void process(double amount) {
        System.out.println("Processing CARD payment of $" + amount
                + " with card ending in " + cardLastFour);
    }

    @Override
    public String getMethodName() {
        return "CARD";
    }
}
