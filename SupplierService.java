package com.ty.maker;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ty.maker.Supplier.NatureOfBusiness;

@Service
public class SupplierService {
	@Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> findSuppliers(String location, NatureOfBusiness natureOfBusiness, 
                                          Supplier.ManufacturingProcess manufacturingProcess, PageRequest pageable) 
    {
        return supplierRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (location != null) {
                predicates.add(criteriaBuilder.equal(root.get("location"), location));
            }
            if (natureOfBusiness != null) {
                predicates.add(criteriaBuilder.equal(root.get("natureOfBusiness"), natureOfBusiness));
            }
            if (manufacturingProcess != null) {
                predicates.add(criteriaBuilder.isMember(manufacturingProcess, root.get("manufacturingProcesses")));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
