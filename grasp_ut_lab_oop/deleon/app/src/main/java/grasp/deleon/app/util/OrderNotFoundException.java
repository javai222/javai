package grasp.deleon.app.util;

// GRASP: Protected Variations - custom exception shields the controller
//        from knowing HOW the service detects a missing order
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Order not found with id: " + id);
    }
}
