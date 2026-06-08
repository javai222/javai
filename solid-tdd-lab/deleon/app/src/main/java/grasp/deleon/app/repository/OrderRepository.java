package grasp.deleon.app.repository;

import grasp.deleon.app.entity.Order;
import grasp.deleon.app.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// GRASP: Indirection - OrderRepository sits BETWEEN the service and the database
//        The service never touches SQL directly
// GRASP: Low Coupling - service depends on this interface, not on a concrete DB class
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Spring Data JPA auto-generates the SQL for this method from the method name
    List<Order> findByStatus(OrderStatus status);

    List<Order> findByCustomerName(String customerName);
}
