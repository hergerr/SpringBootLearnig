package pl.com.frankiewicz.supplier;

import pl.com.frankiewicz.product.Product;

import javax.persistence.ManyToOne;

public class SupplierDTO {
    private Long id;
    private String name;
    private String  productName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
