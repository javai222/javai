package grasp.deleon.app.entity;

// GRASP: Polymorphism - Payment is an interface so multiple payment types can exist
// GRASP: Protected Variations - if payment logic changes, only implementations change
//        The service depends on this interface, not concrete classes
public interface Payment {

    // Each implementation decides how to process payment
    void process(double amount);

    // Returns the payment method name
    String getMethodName();
}
