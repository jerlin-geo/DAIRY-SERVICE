package com.vetri.erp.ds.inventory.model.dto;

import com.vetri.erp.ds.inventory.model.CommonDetail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CrateMasterDto extends CommonDetail {
	
	private Integer id;
	private String crateType;
	private Boolean isReturnable;
	private String qtyUom;
	private String openingBal;
	private Boolean activeFlag;
}
