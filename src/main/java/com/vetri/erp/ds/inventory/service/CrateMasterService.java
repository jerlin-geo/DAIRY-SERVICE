package com.vetri.erp.ds.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetri.erp.ds.inventory.dao.CrateMasterDao;
import com.vetri.erp.ds.inventory.entity.CrateMasterEntity;
import com.vetri.erp.ds.inventory.exception.InventoryException;
import com.vetri.erp.ds.inventory.mapper.DtoMapper;
import com.vetri.erp.ds.inventory.model.dto.CrateMasterDto;

@Service
public class CrateMasterService {

	@Autowired
	CrateMasterDao crateMasterDao;

	public List<CrateMasterDto> getAll(Integer orgId) {
		return DtoMapper.toCrateMasterDtoList(crateMasterDao.getAll(orgId));
	}

	public CrateMasterDto getbyId(Integer orgId, Integer id) throws InventoryException {
		return DtoMapper.toDto(crateMasterDao.getById(orgId, id));
	}

	public CrateMasterDto update(Integer orgId, CrateMasterDto dto) throws InventoryException {
		CrateMasterEntity entity = crateMasterDao.getById(orgId, dto.getId());
		CrateMasterEntity updatedEntity =  DtoMapper.updateEntity(dto, entity);
		return DtoMapper.toDto(crateMasterDao.update(updatedEntity));
	}

	public CrateMasterDto save(CrateMasterDto dto) {
		return DtoMapper.toDto(crateMasterDao.save(DtoMapper.toEntity(dto)));
	}

	public void delete(Integer orgId, Integer id) {
		crateMasterDao.delete(orgId, id);
	}

}
