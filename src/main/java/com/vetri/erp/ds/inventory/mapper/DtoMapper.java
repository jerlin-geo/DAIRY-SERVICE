package com.vetri.erp.ds.inventory.mapper;

import java.util.List;

import com.vetri.erp.ds.inventory.dto.ProdSectionDto;
import com.vetri.erp.ds.inventory.entity.CompanyEntity;
import com.vetri.erp.ds.inventory.entity.ProductionSectionEntity;

public class DtoMapper {

	public static ProdSectionDto toDto(ProductionSectionEntity entity) {
		ProdSectionDto dto = new ProdSectionDto();
		dto.setId(entity.getId());
		dto.setSectionName(entity.getSectionName());
		dto.setCreatedBy(entity.getCreatedBy());
		return dto;
	}

	public static List<ProdSectionDto> toDtoList(List<ProductionSectionEntity> entityList) {
		return entityList.stream().map(DtoMapper::toDto).toList();
	}
	
	public static ProductionSectionEntity toEntity(ProdSectionDto dto) {
		ProductionSectionEntity entity = new ProductionSectionEntity();
		entity.setSectionName(dto.getSectionName());
		entity.setId(dto.getId());
		entity.setCompany(new CompanyEntity(1));
		
		// TODO autogenerate sequence
//		dto.setCreatedBy(entity.getCreatedBy());  TODO
		return entity;
	}

	public static ProductionSectionEntity updateEntity(ProdSectionDto dto, ProductionSectionEntity updateEntity) {
		updateEntity.setSectionName(dto.getSectionName());
		updateEntity.setModifiedBy(null);
		updateEntity.setModifiedDate(null);
		return null;
	}
}
