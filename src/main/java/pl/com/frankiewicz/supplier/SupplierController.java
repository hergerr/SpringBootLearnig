package pl.com.frankiewicz.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/suppliers")
public class SupplierController {

        private SupplierService supplierService;

        @Autowired
        public SupplierController(SupplierService supplierService) {
            this.supplierService =  supplierService;
        }

        @GetMapping
        public List<SupplierDTO> findAll(){return supplierService.findAll();}

        @GetMapping("/{id}")
        public SupplierDTO findOne(@PathVariable Long id){return supplierService.findOne(id);}

        @PostMapping("/{name}/{productId}")
        public  SupplierDTO addSuplier(@PathVariable String name, @PathVariable Long productId){
            return supplierService.addSuplier(name, productId);
        }
}
