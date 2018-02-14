package pl.com.frankiewicz.supplier;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface SupplierService {
    SupplierDTO addSuplier(String name, Long productId);
    List<SupplierDTO> findAll();
    SupplierDTO findOne(Long id);
}
