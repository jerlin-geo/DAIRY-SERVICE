package com.vetri.erp.ds.inventory.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product_Group")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductGroupEntity {
	
	@Id
	@Column(name = "product_Group_ID")
	private Integer id;

	@Column(name = "product_Group_Name")
	private String productGroupName;
	
	@Column(name = "sort_Order")
	private Integer sortOrder;
	
	@ManyToOne
	@JoinColumn(name = "production_Section")
	private ProductionSectionEntity productionSection;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private CompanyEntity company;
	
	@Column(name = "use_For_MB")
	private Boolean useForMb;
	
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
	
	@PreUpdate
    public void preUpdate() {
        this.modifiedDate = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
    }
}
