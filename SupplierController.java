package com.ty.maker;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
	@Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
    		@RequestParam(required = false) String location,
            @RequestParam(required = false) Supplier.NatureOfBusiness natureOfBusiness,
            @RequestParam(required = false) Supplier.ManufacturingProcess manufacturingProcess, 
            @RequestParam(defaultValue="0") int page, 
            @RequestParam(defaultValue="10") int size) {

    	PageRequest pageable = PageRequest.of(page, size);
        Page<Supplier> suppliers = supplierService.findSuppliers(location, natureOfBusiness, 
        		manufacturingProcess, pageable);
                return ResponseEntity.ok(suppliers);
    }
}
