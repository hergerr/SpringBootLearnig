package pl.com.frankiewicz.product;


import pl.com.frankiewicz.common.BaseEntity;
import pl.com.frankiewicz.order.Order;
import pl.com.frankiewicz.supplier.Supplier;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "product")
public class Product extends BaseEntity implements ProductNameAndPrice {

    @Column(unique = true, nullable = false,length = 60)
    private String name;
    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    @Column(nullable = false)
    private List<Supplier> suppliers;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product(long id,String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Product(){

    }

    public List<Order> getOrders() {
        return orders;
    }
}