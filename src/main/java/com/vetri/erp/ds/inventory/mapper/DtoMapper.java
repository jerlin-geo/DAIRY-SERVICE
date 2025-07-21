package com.vetri.erp.ds.inventory.mapper;

import java.util.List;

import com.vetri.erp.ds.inventory.dto.ProdSectionDto;
import com.vetri.erp.ds.inventory.dto.prodGroupDto;
import com.vetri.erp.ds.inventory.entity.CompanyEntity;
import com.vetri.erp.ds.inventory.entity.ProductGroupEntity;
import com.vetri.erp.ds.inventory.entity.ProductionSectionEntity;

public class DtoMapper {

	public static ProdSectionDto toDto(ProductionSectionEntity entity) {
		ProdSectionDto dto = new ProdSectionDto();
		dto.setId(entity.getId());
		dto.setSectionName(entity.getSectionName());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreateDate(entity.getCreatedDate());
		dto.setUpdatedBy(entity.getModifiedBy());
		dto.setUpdatedDate(entity.getModifiedDate());
		return dto;
	}

	public static List<ProdSectionDto> toProdSecDtoList(List<ProductionSectionEntity> entityList) {
		return entityList.stream().map(DtoMapper::toDto).toList();
	}
	
	public static ProductionSectionEntity toEntity(ProdSectionDto dto) {
		ProductionSectionEntity entity = new ProductionSectionEntity();
		entity.setSectionName(dto.getSectionName());
		entity.setId(dto.getId());
		entity.setCompany(new CompanyEntity(1)); //TODO
		entity.setCreatedBy("jgeoo_created");
		return entity;
	}

	public static ProductionSectionEntity updateEntity(ProdSectionDto dto, ProductionSectionEntity updateEntity) {
		updateEntity.setSectionName(dto.getSectionName());
		updateEntity.setModifiedBy("jgeo_modified");
		return updateEntity;
	}

	public static prodGroupDto toDto(ProductGroupEntity entity) {
		prodGroupDto dto = new prodGroupDto();
		dto.setId(entity.getId());
		dto.setProductGroupName(entity.getProductGroupName());
		dto.setProductionSection(new ProdSectionDto(entity.getProductionSection().getId(), entity.getProductionSection().getSectionName()));
		dto.setUseForMb(entity.getUseForMb());
		dto.setSortOrder(entity.getSortOrder());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
	
	public static List<prodGroupDto> toProdGroupDtoList(List<ProductGroupEntity> entityList) {
		return entityList.stream().map(DtoMapper::toDto).toList();
	}

	public static ProductGroupEntity toEntity(prodGroupDto dto) {
		ProductGroupEntity entity = new ProductGroupEntity();
		entity.setCompany(new CompanyEntity(1)); //TODO
		entity.setId(dto.getId());
		entity.setProductGroupName(dto.getProductGroupName());
		entity.setProductionSection(toEntity(dto.getProductionSection()));
		entity.setCreatedBy("jgeoo");
		entity.setUseForMb(dto.getUseForMb());
		entity.setSortOrder(dto.getSortOrder());
		return entity;
	}

	public static ProductGroupEntity updateEntity(prodGroupDto dto, ProductGroupEntity updateEntity) {
		updateEntity.setProductGroupName(dto.getProductGroupName());
		updateEntity.setProductionSection(toEntity(dto.getProductionSection()));
		updateEntity.setSortOrder(dto.getSortOrder());
		updateEntity.setUseForMb(dto.getUseForMb());
		updateEntity.setModifiedBy("jgeo_modified");
		return updateEntity;
	}
}
