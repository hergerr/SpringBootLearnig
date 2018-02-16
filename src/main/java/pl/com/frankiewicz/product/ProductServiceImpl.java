package pl.com.frankiewicz.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static pl.com.frankiewicz.product.ProductMapper.toProductDTO;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        return toProductDTO(productRepository.findAll());
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        return toProductDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.delete(productId);
    }

    @Override
    public ProductDTO updatePrice(Long id, BigDecimal price) {
        Product product = productRepository.findOne(id);
        product.setPrice(price);
        return toProductDTO(productRepository.save(product));
    }

    @Override
    public Set<ProductNameAndPrice> findAllInterface(){
        return productRepository.findAllByPriceGreaterThan(BigDecimal.ZERO);
    }

}
