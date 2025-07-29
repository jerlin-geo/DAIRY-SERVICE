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
@Table(name = "uom_Master")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UomEntity {
	
	@Id
	@Column(name = "uom_ID")
	private Integer id;

	@Column(name = "uom_Name")
	private String uomName;
	
	@Column(name = "uom_Short_Name")
	private Integer uomShortName;
	
	@Column(name = "tally_UOM")
	private String tallyUom;
	
	@Column(name = "alternate_UOM_ID")
	private String alternateUomId;
	
	@Column(name = "alternate_UOM_Qty")
	private Boolean alternateUomQty;
	
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
