//pozwala na komunikacje z bazą danych
package pl.com.frankiewicz.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

//wrzuca i wyrzuca produkty
//Long to ID
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
   @Query("SELECT p FROM Product p where p.name =?1")//Uzywamy zawsze nazwy encji
    Set<Product> findAllByName(String name);

   Set<ProductNameAndPrice> findAllByPriceGreaterThan(BigDecimal price);
}
