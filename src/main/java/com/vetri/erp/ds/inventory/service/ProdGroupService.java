package com.vetri.erp.ds.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetri.erp.ds.inventory.dao.ProductGroupDao;
import com.vetri.erp.ds.inventory.entity.ProdGroupNameEntity;
import com.vetri.erp.ds.inventory.exception.InventoryException;
import com.vetri.erp.ds.inventory.mapper.DtoMapper;
import com.vetri.erp.ds.inventory.model.dto.prodGroupNameDto;

@Service
public class ProdGroupService {
	
	@Autowired
	ProductGroupDao productGroupDao;

	public List<prodGroupNameDto> getAll(Integer orgId) {
		return DtoMapper.toProdGroupDtoList(productGroupDao.getAll(orgId));
	}

	public prodGroupNameDto getbyId(Integer orgId, Integer id) throws InventoryException {
		return DtoMapper.toDto(productGroupDao.getById(orgId, id));
	}

	public prodGroupNameDto update(Integer orgId, prodGroupNameDto dto) throws InventoryException {
		ProdGroupNameEntity entity = productGroupDao.getById(orgId, dto.getId());
		ProdGroupNameEntity updatedEntity =  DtoMapper.updateEntity(dto, entity);
		return DtoMapper.toDto(productGroupDao.update(updatedEntity));
	}

	public prodGroupNameDto save(prodGroupNameDto dto) {
		return DtoMapper.toDto(productGroupDao.save(DtoMapper.toEntity(dto)));
	}

	public void delete(Integer orgId, Integer id) {
		productGroupDao.delete(orgId, id);
	}

}
