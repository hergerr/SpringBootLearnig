package pl.com.frankiewicz.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.frankiewicz.product.ProductRepository;

import java.util.List;
import java.util.Set;

import static pl.com.frankiewicz.supplier.SupplierMapper.toSupplierDTO;
@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;
    private ProductRepository productRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ProductRepository productRepository) {
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<SupplierDTO> findAll() {
        return toSupplierDTO(supplierRepository.findAll());
    }

    @Override
    public SupplierDTO addSuplier(String name, Long productId) {
        Supplier supplier = new Supplier();
        supplier.setName(name);
        supplier.setProduct(productRepository.findOne(productId));
        return SupplierMapper.toSupplierDTO(supplierRepository.save(supplier));
    }

    @Override
    public SupplierDTO findOne(Long id) {
        return toSupplierDTO(supplierRepository.findOne(id));
    }

    @Override
    public Set<SupplierDTO> findSuppliersByProduct(String name) {
        return null;//SupplierMapper.toSupplierDTO()supplierRepository.findAllByProductName(name);
    }
}
