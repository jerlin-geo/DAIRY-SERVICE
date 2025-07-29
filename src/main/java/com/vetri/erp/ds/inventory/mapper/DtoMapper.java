package com.vetri.erp.ds.inventory.mapper;

import java.util.List;

import com.vetri.erp.ds.inventory.entity.CompanyEntity;
import com.vetri.erp.ds.inventory.entity.CrateMasterEntity;
import com.vetri.erp.ds.inventory.entity.ProdGroupNameEntity;
import com.vetri.erp.ds.inventory.entity.ProductionSectionEntity;
import com.vetri.erp.ds.inventory.entity.UomEntity;
import com.vetri.erp.ds.inventory.model.dto.CrateMasterDto;
import com.vetri.erp.ds.inventory.model.dto.ProdSectionDto;
import com.vetri.erp.ds.inventory.model.dto.UomDto;
import com.vetri.erp.ds.inventory.model.dto.prodGroupNameDto;

public class DtoMapper {

	public static ProdSectionDto toDto(ProductionSectionEntity entity) {
		ProdSectionDto dto = new ProdSectionDto();
		dto.setId(entity.getId());
		dto.setSectionName(entity.getSectionName());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}

	public static List<ProdSectionDto> toProdSecDtoList(List<ProductionSectionEntity> entityList) {
		return entityList.stream().map(DtoMapper::toDto).toList();
	}
	
	public static ProductionSectionEntity toEntity(ProdSectionDto dto) {
		ProductionSectionEntity entity = new ProductionSectionEntity();
		entity.setSectionName(dto.getSectionName());
		entity.setId(dto.getId());
		entity.setCompany(new CompanyEntity(dto.getCompanyId()));
		entity.setCreatedBy("jgeoo_created");
		return entity;
	}

	public static ProductionSectionEntity updateEntity(ProdSectionDto dto, ProductionSectionEntity updateEntity) {
		updateEntity.setSectionName(dto.getSectionName());
		updateEntity.setModifiedBy("jgeo_modified");
		return updateEntity;
	}

	public static prodGroupNameDto toDto(ProdGroupNameEntity entity) {
		prodGroupNameDto dto = new prodGroupNameDto();
		dto.setId(entity.getId());
		dto.setProdGroupName(entity.getProdGroupName());
		dto.setSortNo(entity.getSortNo());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
	
	public static List<prodGroupNameDto> toProdGroupDtoList(List<ProdGroupNameEntity> entityList) {
		return entityList.stream().map(DtoMapper::toDto).toList();
	}

	public static ProdGroupNameEntity toEntity(prodGroupNameDto dto) {
		ProdGroupNameEntity entity = new ProdGroupNameEntity();
		entity.setId(dto.getId());
		entity.setProdGroupName(dto.getProdGroupName());
		entity.setSortNo(dto.getSortNo());
		entity.setCompany(new CompanyEntity(dto.getCompanyId()));
		entity.setCreatedBy("jgeoo");
		return entity;
	}

	public static ProdGroupNameEntity updateEntity(prodGroupNameDto dto, ProdGroupNameEntity updateEntity) {
		updateEntity.setProdGroupName(dto.getProdGroupName());
		updateEntity.setSortNo(dto.getSortNo());
		updateEntity.setModifiedBy("jgeo_modified");
		return updateEntity;
	}

	public static CrateMasterDto toDto(CrateMasterEntity entity) {
		CrateMasterDto dto = new CrateMasterDto();
		dto.setId(entity.getId());
		dto.setActiveFlag(entity.getActiveFlag());
		dto.setCrateType(entity.getCrateType());
		dto.setIsReturnable(entity.getIsReturnable());
		dto.setOpeningBal(entity.getOpeningBal());
		dto.setQtyUom(entity.getQtyUom());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}

	public static List<CrateMasterDto> toCrateMasterDtoList(List<CrateMasterEntity> entityList) {
		return entityList.stream().map(DtoMapper::toDto).toList();
	}

	public static CrateMasterEntity updateEntity(CrateMasterDto dto, CrateMasterEntity entity) {
		entity.setActiveFlag(dto.getActiveFlag());
		entity.setCrateType(dto.getCrateType());
		entity.setIsReturnable(dto.getIsReturnable());
		entity.setOpeningBal(dto.getOpeningBal());
		entity.setQtyUom(dto.getQtyUom());
		entity.setModifiedBy("jgeo_modified");
		return entity;
	}

	public static CrateMasterEntity toEntity(CrateMasterDto dto) {
		CrateMasterEntity entity = new CrateMasterEntity();
		entity.setId(dto.getId());
		entity.setActiveFlag(dto.getActiveFlag());
		entity.setCrateType(dto.getCrateType());
		entity.setIsReturnable(dto.getIsReturnable());
		entity.setOpeningBal(dto.getOpeningBal());
		entity.setQtyUom(dto.getQtyUom());
		entity.setCreatedBy("jgeoo");
		entity.setCompany(new CompanyEntity(dto.getCompanyId()));
		return entity;
	}

	public static List<UomDto> toUomDtoList(List<UomEntity> entityList) {
		return entityList.stream().map(DtoMapper::toDto).toList();
	}

	public static UomDto toDto(UomEntity entity) {
		UomDto dto = new UomDto();
		dto.setId(entity.getId());
		dto.setAlternateUomId(entity.getAlternateUomId());
		dto.setAlternateUomQty(entity.getAlternateUomQty());
		dto.setTallyUom(entity.getTallyUom());
		dto.setUomName(entity.getUomName());
		dto.setUomShortName(entity.getUomShortName());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}

	public static UomEntity updateEntity(UomDto dto, UomEntity entity) {
		entity.setAlternateUomId(dto.getAlternateUomId());
		entity.setAlternateUomQty(dto.getAlternateUomQty());
		entity.setTallyUom(dto.getTallyUom());
		entity.setUomName(dto.getUomName());
		entity.setUomShortName(dto.getUomShortName());
		entity.setModifiedBy("jgeo_modified");
		return entity;
	}

	public static UomEntity toEntity(UomDto dto) {
		UomEntity entity = new UomEntity();
		entity.setId(dto.getId());
		entity.setAlternateUomId(dto.getAlternateUomId());
		entity.setAlternateUomQty(dto.getAlternateUomQty());
		entity.setTallyUom(dto.getTallyUom());
		entity.setUomName(dto.getUomName());
		entity.setUomShortName(dto.getUomShortName());
		entity.setCreatedBy("jgeoo");
		entity.setCompany(new CompanyEntity(dto.getCompanyId()));
		return entity;
	}
}
