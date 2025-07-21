package com.vetri.erp.ds.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetri.erp.ds.inventory.dao.ProductGroupDao;
import com.vetri.erp.ds.inventory.dto.prodGroupDto;
import com.vetri.erp.ds.inventory.entity.ProductGroupEntity;
import com.vetri.erp.ds.inventory.mapper.DtoMapper;

@Service
public class ProdGroupService {
	
	@Autowired
	ProductGroupDao productGroupDao;

	public List<prodGroupDto> getAll(Integer orgId) {
		return DtoMapper.toProdGroupDtoList(productGroupDao.getAll(orgId));
	}

	public prodGroupDto getbyId(Integer orgId, Integer id) {
		return DtoMapper.toDto(productGroupDao.getById(orgId, id));
	}

	public prodGroupDto update(Integer orgId, prodGroupDto dto) {
		ProductGroupEntity existingEntity = productGroupDao.getById(orgId, dto.getId());
		ProductGroupEntity updatedEntity =  DtoMapper.updateEntity(dto, existingEntity);
		return DtoMapper.toDto(productGroupDao.update(updatedEntity));
	}

	public prodGroupDto save(prodGroupDto dto) {
		return DtoMapper.toDto(productGroupDao.save(DtoMapper.toEntity(dto)));
	}

	public void delete(Integer orgId, Integer id) {
		productGroupDao.delete(orgId, id);
	}

}
