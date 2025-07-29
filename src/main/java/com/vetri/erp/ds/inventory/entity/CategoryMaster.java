package com.vetri.erp.ds.inventory.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "category_Master")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryMaster {

	@Id
	@Column(name = "category_ID")
	private Integer id;

	@Column(name = "category_Name")
	private String categoryName;
	
	@ManyToOne
	@JoinColumn(name = "company_id", updatable = false)
	private CompanyEntity company;
	
	@Column(name = "created_By", updatable = false)
	private String createdBy;
	
	@Column(name = "modifyed_By")
	private String modifiedBy;
	
	@Column(name = "created_Date", updatable = false)
	private LocalDateTime createdDate;
	
	@Column(name = "modified_Date")
	private LocalDateTime modifiedDate;
	
	@PreUpdate
    public void preUpdate() {
        this.modifiedDate = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
    }
}
