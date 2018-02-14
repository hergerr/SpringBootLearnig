//pozwala na komunikacje z bazą danych
package pl.com.frankiewicz.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

//wrzuca i wyrzuca produkty
//Long to ID
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
