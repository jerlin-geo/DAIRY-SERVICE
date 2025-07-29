package com.vetri.erp.ds.inventory.model.dto;

import com.vetri.erp.ds.inventory.model.CommonDetail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ProdSectionDto extends CommonDetail {
	
	public ProdSectionDto(int id, String sectionName) {
		super();
		this.id = id;
		this.sectionName = sectionName;
	}
	private int id;
	private String sectionName;
	
}
