package pl.com.frankiewicz.supplier;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SupplierMapper {
    public static SupplierDTO toSupplierDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setId(supplier.getId());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setProductName(supplier.getProduct().getName());

        return supplierDTO;
    }

    public static List<SupplierDTO> toSupplierDTO(Collection<Supplier> suppliers) {
        List<SupplierDTO> result = new ArrayList<SupplierDTO>();
        for (Supplier supplier : suppliers) {
            result.add(toSupplierDTO(supplier));
        }
        return result;
    }

//    public static Set<SupplierDTO> toSupplierDTO(Collection<Supplier> suppliers) {
//        Set<SupplierDTO> result = new Set<SupplierDTO>();
//        for (Supplier supplier : suppliers) {
//            result.add(toSupplierDTO(supplier));
//        }
//        return result;
//    }
}
