package pl.com.frankiewicz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.com.frankiewicz.model.Product;
import pl.com.frankiewicz.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> FindAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.delete(id);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestParam BigDecimal price){
        Product one = productRepository.findOne(id);
        one.setPrice(price);
        productRepository.save(one);
    }
}
