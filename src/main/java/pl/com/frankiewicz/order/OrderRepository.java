package pl.com.frankiewicz.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //@Query("SELECT o from Order o where ")
}
