package pl.com.frankiewicz.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.frankiewicz.product.Product;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
