package grasp.deleon.app.entity;

// GRASP: Polymorphism - CashPayment is one implementation of the Payment interface
// GRASP: Low Coupling - OrderService depends on Payment interface, not CashPayment directly
public class CashPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("Processing CASH payment of $" + amount);
    }

    @Override
    public String getMethodName() {
        return "CASH";
    }
}
