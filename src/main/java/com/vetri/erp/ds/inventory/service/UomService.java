package com.vetri.erp.ds.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetri.erp.ds.inventory.dao.UomDao;
import com.vetri.erp.ds.inventory.entity.UomEntity;
import com.vetri.erp.ds.inventory.exception.InventoryException;
import com.vetri.erp.ds.inventory.mapper.DtoMapper;
import com.vetri.erp.ds.inventory.model.dto.UomDto;

@Service
public class UomService {
	
	@Autowired
	UomDao uomDao;

	public List<UomDto> getAll(Integer orgId) {
		return DtoMapper.toUomDtoList(uomDao.getAll(orgId));
	}

	public UomDto getbyId(Integer orgId, Integer id) throws InventoryException {
		return DtoMapper.toDto(uomDao.getById(orgId, id));
	}

	public UomDto update(Integer orgId, UomDto dto) throws InventoryException {
		UomEntity entity = uomDao.getById(orgId, dto.getId());
		UomEntity updatedEntity =  DtoMapper.updateEntity(dto, entity);
		return DtoMapper.toDto(uomDao.update(updatedEntity));
	}

	public UomDto save(UomDto dto) {
		return DtoMapper.toDto(uomDao.save(DtoMapper.toEntity(dto)));
	}

	public void delete(Integer orgId, Integer id) {
		uomDao.delete(orgId, id);
	}

}
