package com.vetri.erp.ds.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetri.erp.ds.inventory.dao.ProductionSectionDao;
import com.vetri.erp.ds.inventory.entity.ProductionSectionEntity;
import com.vetri.erp.ds.inventory.exception.InventoryException;
import com.vetri.erp.ds.inventory.mapper.DtoMapper;
import com.vetri.erp.ds.inventory.model.dto.ProdSectionDto;

@Service
public class ProdSectionService {

	@Autowired
	ProductionSectionDao productionSectionDao;
	
	public List<ProdSectionDto> getAll(Integer orgId) {
		return DtoMapper.toProdSecDtoList(productionSectionDao.getAll(orgId));
	}

	public ProdSectionDto getbyId(Integer orgId, Integer id) throws InventoryException {
		return DtoMapper.toDto(productionSectionDao.getById(orgId, id));
	}

	public ProdSectionDto update(Integer orgId, ProdSectionDto dto) throws InventoryException {
		ProductionSectionEntity entity = productionSectionDao.getById(orgId, dto.getId());
		ProductionSectionEntity updatedEntity =  DtoMapper.updateEntity(dto, entity);
		return DtoMapper.toDto(productionSectionDao.update(updatedEntity));
	}

	public ProdSectionDto save(ProdSectionDto dto) {
		return  DtoMapper.toDto(productionSectionDao.save(DtoMapper.toEntity(dto)));
	}

	public void delete(Integer orgId, Integer id) {
		productionSectionDao.delete(orgId, id);
	}

}
