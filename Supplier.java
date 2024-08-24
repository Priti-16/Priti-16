package com.ty.maker;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Supplier {

    public enum NatureOfBusiness {
    	SMALL_SCALE,
        MEDIUM_SCALE,
        LARGE_SCALE
	}
	public enum ManufacturingProcess {
		MOULDING,
		THREE_D_PRINTING,
		CASTING,
		COATING
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    private String companyName;
    private String website;
    private String location;
    
    @Enumerated(EnumType.STRING)
    private NatureOfBusiness natureOfBusiness;

    @ElementCollection(targetClass = ManufacturingProcess.class)
    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "supplier_processes", joinColumns = @JoinColumn(name = "supplier_id"))
//    @Column(name="process")
    private Set<ManufacturingProcess> manufacturingProcesses;
    
    public Long getSupplierId() {
    	return supplierId; 
    }
    public void setSupplierId() {
    	this.supplierId=supplierId;
    }
    public String getCompanyName() {
    	return companyName;
    }
    public void setCompanyName() {
    	this.companyName=companyName;
    }
    public String getWebsite() {
    	return website;
    }
    public void setWebsite() {
    	this.website=website;
    }
    public String getLocation() {
    	return location;
    }
    public void setLocation() {
    	this.location=location;
    }
}
