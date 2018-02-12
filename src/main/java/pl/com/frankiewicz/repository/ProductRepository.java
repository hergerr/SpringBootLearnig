package pl.com.frankiewicz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.frankiewicz.model.Product;

//wrzuca i wyrzuca produkty
//Long to ID
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
