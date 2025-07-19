package com.vetri.erp.ds.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetri.erp.ds.inventory.dao.ProductionSectionDao;
import com.vetri.erp.ds.inventory.dto.ProdSectionDto;
import com.vetri.erp.ds.inventory.entity.ProductionSectionEntity;
import com.vetri.erp.ds.inventory.mapper.DtoMapper;

@Service
public class InventoryService {

	@Autowired
	ProductionSectionDao productionSectionDao;
	
	public List<ProdSectionDto> getAllProductionSection() {
		return DtoMapper.toDtoList(productionSectionDao.getAll(1));
	}

	public ProdSectionDto getbyIdProductionSection(Integer id) {
		return DtoMapper.toDto(productionSectionDao.getById(id, 1));
	}

	public ProdSectionDto updateProductionSection(ProdSectionDto dto) {
		ProductionSectionEntity entity = productionSectionDao.getById(dto.getId(), 1);
		ProductionSectionEntity updatedEntity =  DtoMapper.updateEntity(dto, entity);
		return DtoMapper.toDto(productionSectionDao.update(updatedEntity));
	}

	public ProdSectionDto saveProductionSection(ProdSectionDto dto) {
		return  DtoMapper.toDto(productionSectionDao.save(DtoMapper.toEntity(dto)));
	}

}
