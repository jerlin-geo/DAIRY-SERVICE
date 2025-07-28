package com.vetri.erp.ds.inventory.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Company_Master")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CompanyEntity {
	
	public CompanyEntity(String id) {
		super();
		this.id = id;
	}

	@Id
	@Column(name = "company_id")
	private String id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "created_By", updatable = false)
	private String createdBy;
	
	@Column(name = "modified_By")
	private String modifiedBy;
	
	@Column(name = "created_Date", updatable = false)
	private LocalDateTime createdDate;
	
	@Column(name = "modified_Date")
	private LocalDateTime modifiedDate;
	
	@Lob
	@Column(name = "Custom_Data")
	private String customData;
	
}
