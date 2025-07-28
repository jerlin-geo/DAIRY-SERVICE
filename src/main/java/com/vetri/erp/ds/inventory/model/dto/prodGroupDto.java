package com.vetri.erp.ds.inventory.model.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class prodGroupDto {


	private Integer id;
	
	private String companyId;

	private String productGroupName;
	
	private Integer sortOrder;
	
	private ProdSectionDto productionSection;
	
	private Boolean useForMb;
	
	private String createdBy;
	
	private String modifiedBy;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime modifiedDate;
	
}
