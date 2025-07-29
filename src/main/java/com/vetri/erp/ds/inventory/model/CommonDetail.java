package com.vetri.erp.ds.inventory.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommonDetail {

	private String createdBy;
	private String modifiedBy;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private Integer companyId;
}
