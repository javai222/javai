package grasp.deleon.app.entity;

// SOLID: OCP  - GCashPayment is a NEW payment type added WITHOUT modifying any existing class.
//               OrderService, OrderController, and Payment interface are all UNCHANGED.
// SOLID: LSP  - GCashPayment fully implements Payment. It can replace CashPayment or CardPayment
//               anywhere Payment is used without breaking the program.
// SOLID: DIP  - OrderService depends on the Payment interface, so it automatically
//               supports GCashPayment without knowing it exists.
// GRASP: Polymorphism - process() behaves differently here than in Cash or Card.
// GRASP: Protected Variations - adding GCash required zero changes to existing code.
public class GCashPayment implements Payment {

    // The GCash mobile number to charge
    private final String mobileNumber;

    public GCashPayment(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void process(double amount) {
        // KISS: Simple, direct implementation. No unnecessary complexity.
        System.out.println("Processing GCASH payment of $" + amount
                + " to GCash number: " + mobileNumber);
    }

    @Override
    public String getMethodName() {
        return "GCASH";
    }
}
