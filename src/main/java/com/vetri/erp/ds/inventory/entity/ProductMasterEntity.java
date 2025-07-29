package com.vetri.erp.ds.inventory.entity;

import java.math.BigDecimal;
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
import lombok.Setter;

@Entity
@Table(name = "product_Master")
@Getter
@Setter
public class ProductMasterEntity {

    @Id
    @Column(name = "product_ID", nullable = false)
    private Integer productId;

    @Column(name = "product_Code")
    private String productCode;

    @Column(name = "hsn_Code")
    private String hsnCode;

    @Column(name = "product_Desc")
    private String productDesc;

    @Column(name = "product_Type_ID")
    private Integer productTypeId;  // TODO

    @ManyToOne
    @JoinColumn(name = "category_ID")
    private CategoryMaster category;

    @ManyToOne
    @JoinColumn(name = "groupName_Id")
    private ProdGroupNameEntity prodGroupName;

    @ManyToOne
    @JoinColumn(name = "selling_UOM_ID")
    private UomEntity sellingUom;

    @ManyToOne
    @JoinColumn(name = "qty_UOM_ID")
    private UomEntity qtyUom;

    @Column(name = "qty_InUOM", precision = 18, scale = 3)
    private BigDecimal qtyInUom;

    @ManyToOne
    @JoinColumn(name = "crate_Type")
    private CrateMasterEntity crateType;

    @Column(name = "crate_Qty")
    private Integer crateQty;

    @Column(name = "sorting_No")
    private Integer sortingNo;

    @Column(name = "tax_Percent", precision = 18, scale = 2)
    private BigDecimal taxPercent;

    @Column(name = "selling_Rate", precision = 18, scale = 2)
    private BigDecimal sellingRate;

    @Column(name = "active_Flag")
    private Boolean activeFlag;

    @Column(name = "prod_Weight", precision = 18, scale = 3)
    private BigDecimal prodWeight;

    @Column(name = "billSorting_No")
    private Integer billSortingNo;

    @Column(name = "repSorting_No")
    private Integer repSortingNo;

    @Column(name = "rate_Per")
    private String ratePer;

    @Column(name = "is_Leakable")
    private Boolean isLeakable;

    @Column(name = "advanceStock_Unit", precision = 18, scale = 2)
    private BigDecimal advanceStockUnit;

    @Column(name = "advanceStock_Crate", precision = 18, scale = 2)
    private BigDecimal advanceStockCrate;

    @Column(name = "adjustment", precision = 18, scale = 2)
    private BigDecimal adjustment;

    @Column(name = "sale_Acc", precision = 18)
    private BigDecimal saleAcc;

//    @Column(name = "purc_Acc", precision = 18)  TODO Ledger PK for all below items why?
//    private BigDecimal purcAcc;
//
//    @Column(name = "input_CGST", precision = 18)
//    private BigDecimal inputCgst;
//
//    @Column(name = "input_SGST", precision = 18)
//    private BigDecimal inputSgst;
//
//    @Column(name = "input_IGST", precision = 18)
//    private BigDecimal inputIgst;
//
//    @Column(name = "output_CGST", precision = 18)
//    private BigDecimal outputCgst;
//
//    @Column(name = "output_SGST", precision = 18)
//    private BigDecimal outputSgst;
//
//    @Column(name = "output_IGST", precision = 18)
//    private BigDecimal outputIgst;

    @Column(name = "fat", precision = 18, scale = 8)
    private BigDecimal fat;

    @Column(name = "snf", precision = 18, scale = 8)
    private BigDecimal snf;

    @Column(name = "is_Ghee")
    private Boolean isGhee;

    @Column(name = "lr", precision = 18, scale = 2)
    private BigDecimal lr;

    @ManyToOne
    @JoinColumn(name = "company_ID")
    private CompanyEntity company;

    @Column(name = "created_By")
    private Integer createdBy;

    @Column(name = "created_Date")
    private LocalDateTime createdDate;

    @Column(name = "modifyed_By")
    private Integer modifiedBy;

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
