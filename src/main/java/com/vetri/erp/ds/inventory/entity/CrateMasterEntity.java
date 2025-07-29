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
@Table(name = "crate_Master")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CrateMasterEntity {
	
	
	@Id
	@Column(name = "crate_ID")
	private Integer id;

	@Column(name = "crate_Type")
	private String crateType;
	
	@Column(name = "isReturnable")
	private Boolean isReturnable;
	
	@Column(name = "qty_UOM")
	private String qtyUom;
	
	@Column(name = "op_Bal")
	private String openingBal;
	
	@Column(name = "active_Flag")
	private Boolean activeFlag;
	
	@ManyToOne
	@JoinColumn(name = "company_id", updatable = false)
	private CompanyEntity company;
	
	@Column(name = "created_By", updatable = false)
	private String createdBy;
	
	@Column(name = "modified_By")
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
