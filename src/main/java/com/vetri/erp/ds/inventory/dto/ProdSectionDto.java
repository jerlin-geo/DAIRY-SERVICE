package com.vetri.erp.ds.inventory.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProdSectionDto {

	private int id;
	private String sectionName;
	
	private LocalDateTime createDate;
	private LocalDateTime updatedDate;
	private String createdBy;
	private String updatedBy;
	
}
