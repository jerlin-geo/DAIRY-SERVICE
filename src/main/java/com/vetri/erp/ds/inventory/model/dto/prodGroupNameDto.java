package com.vetri.erp.ds.inventory.model.dto;

import com.vetri.erp.ds.inventory.model.CommonDetail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class prodGroupNameDto extends CommonDetail {

	private Integer id;
	private String prodGroupName;
	private Integer sortNo;
	
}
