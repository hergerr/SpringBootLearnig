package pl.com.frankiewicz.order;

import pl.com.frankiewicz.product.Product;
import pl.com.frankiewicz.product.ProductRepository;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    //jeden produkt moze byc w wielu zamowieniach
    @ManyToMany
    private List<Product> products;
    private BigDecimal total;



    public Long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
