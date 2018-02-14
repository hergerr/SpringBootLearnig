package pl.com.frankiewicz.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(productDTO.getPrice());

        return productDTO;
    }

    public static List<ProductDTO> toProductDTO(Collection<Product> products){
        List<ProductDTO> result = new ArrayList<ProductDTO>();
        for(Product product:products){
            result.add(toProductDTO(product));
        }
        return result;
    }
}
