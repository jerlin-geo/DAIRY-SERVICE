package com.vetri.erp.ds.inventory.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ProdSectionDto {
	
	public ProdSectionDto(int id, String sectionName) {
		super();
		this.id = id;
		this.sectionName = sectionName;
	}
	private int id;
	private String sectionName;
	
	private LocalDateTime createDate;
	private LocalDateTime updatedDate;
	private String createdBy;
	private String updatedBy;
	
}
