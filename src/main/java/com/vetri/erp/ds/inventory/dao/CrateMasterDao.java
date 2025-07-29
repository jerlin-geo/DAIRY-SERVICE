package com.vetri.erp.ds.inventory.dao;

import org.springframework.stereotype.Repository;

import com.vetri.erp.ds.inventory.entity.CrateMasterEntity;

@Repository
public class CrateMasterDao extends CommonDaoImpl<CrateMasterEntity, Integer> {

	public CrateMasterDao() {
		super(CrateMasterEntity.class);
	}

}
