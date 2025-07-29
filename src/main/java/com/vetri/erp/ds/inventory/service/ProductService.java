package com.vetri.erp.ds.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetri.erp.ds.inventory.dao.ProductMasterDao;
import com.vetri.erp.ds.inventory.entity.ProductMasterEntity;

@Service
public class ProductService {
	
	@Autowired
	ProductMasterDao productMasterDao;

	public List<ProductMasterEntity> getAll(Integer orgId) {
		return productMasterDao.getAll(orgId);
	}

}
