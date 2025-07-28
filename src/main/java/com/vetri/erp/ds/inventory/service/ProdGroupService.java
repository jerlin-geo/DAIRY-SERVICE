package com.vetri.erp.ds.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetri.erp.ds.inventory.dao.ProductGroupDao;
import com.vetri.erp.ds.inventory.entity.ProductGroupEntity;
import com.vetri.erp.ds.inventory.exception.InventoryException;
import com.vetri.erp.ds.inventory.mapper.DtoMapper;
import com.vetri.erp.ds.inventory.model.dto.prodGroupDto;

@Service
public class ProdGroupService {
	
	@Autowired
	ProductGroupDao productGroupDao;

	public List<prodGroupDto> getAll(String orgId) {
		return DtoMapper.toProdGroupDtoList(productGroupDao.getAll(orgId));
	}

	public prodGroupDto getbyId(String orgId, Integer id) throws InventoryException {
		return DtoMapper.toDto(productGroupDao.getById(orgId, id));
	}

	public prodGroupDto update(String orgId, prodGroupDto dto) throws InventoryException {
		ProductGroupEntity entity = productGroupDao.getById(orgId, dto.getId());
		ProductGroupEntity updatedEntity =  DtoMapper.updateEntity(dto, entity);
		return DtoMapper.toDto(productGroupDao.update(updatedEntity));
	}

	public prodGroupDto save(prodGroupDto dto) {
		return DtoMapper.toDto(productGroupDao.save(DtoMapper.toEntity(dto)));
	}

	public void delete(String orgId, Integer id) {
		productGroupDao.delete(orgId, id);
	}

}
