package pl.com.frankiewicz.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO updatePrice(Long id, BigDecimal price);
    void deleteProduct(Long id);
}
