package com.ty.maker;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ty.maker.Supplier.NatureOfBusiness;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>,JpaSpecificationExecutor <Supplier> {

	Page<Supplier> findAll(
			String location,
	        NatureOfBusiness natureOfBusiness,
	        Supplier.ManufacturingProcess manufacturingProcesses,Pageable pageable);

//	Page<Supplier> findAll(Object example, Pageable pageable);
}
