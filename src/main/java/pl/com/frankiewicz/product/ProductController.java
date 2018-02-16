package pl.com.frankiewicz.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService =  productService;
    }

    @GetMapping
    public List<ProductDTO> findAllProducts() {
        return productService.findAll();
    }

    @PreAuthorize("isAthenticated()")
    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {
        ProductDTO newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestParam BigDecimal price){
        productService.updatePrice(id, price);
    }

    @GetMapping("/interface/all")
    public Set<String> findAllInterface(){
        return productService.findAllInterface()
                .stream()
                .flatMap(p -> Stream.of(p.getName(), p.getPrice().toString()))
                .collect(Collectors.toSet());
    }
}
