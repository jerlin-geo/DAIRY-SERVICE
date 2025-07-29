package com.vetri.erp.ds.inventory.model.dto;

import com.vetri.erp.ds.inventory.model.CommonDetail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UomDto extends CommonDetail{

	private Integer id;
	private String uomName;
	private Integer uomShortName;
	private String tallyUom;
	private String alternateUomId;
	private Boolean alternateUomQty;
}
