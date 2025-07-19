package com.vetri.erp.ds.inventory.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "production_Section")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductionSectionEntity {

	@Id
	@Column(name = "section_ID")
	private Integer id;
	
	@Column(name = "section_Name")
	private String sectionName;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private CompanyEntity company;
	
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
