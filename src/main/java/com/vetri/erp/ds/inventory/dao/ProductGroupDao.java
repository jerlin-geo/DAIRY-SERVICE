package com.vetri.erp.ds.inventory.dao;

import org.springframework.stereotype.Repository;

import com.vetri.erp.ds.inventory.entity.ProdGroupNameEntity;

@Repository
public class ProductGroupDao extends CommonDaoImpl<ProdGroupNameEntity, Integer> {

	public ProductGroupDao() {
		super(ProdGroupNameEntity.class);
	}

}
