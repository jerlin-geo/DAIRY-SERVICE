package com.vetri.erp.ds.inventory.dao;

import org.springframework.stereotype.Repository;

import com.vetri.erp.ds.inventory.entity.ProductMasterEntity;

@Repository
public class ProductMasterDao extends CommonDaoImpl<ProductMasterEntity, Integer> {

	public ProductMasterDao() {
		super(ProductMasterEntity.class);
	}

}
