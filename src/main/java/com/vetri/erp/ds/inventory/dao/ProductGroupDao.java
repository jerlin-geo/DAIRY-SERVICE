package com.vetri.erp.ds.inventory.dao;

import org.springframework.stereotype.Repository;

import com.vetri.erp.ds.inventory.entity.ProductGroupEntity;

@Repository
public class ProductGroupDao extends CommonDaoImpl<ProductGroupEntity, Integer> {

	public ProductGroupDao() {
		super(ProductGroupEntity.class);
	}

}
