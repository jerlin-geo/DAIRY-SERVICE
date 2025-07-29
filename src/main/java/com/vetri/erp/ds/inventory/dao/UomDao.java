package com.vetri.erp.ds.inventory.dao;

import org.springframework.stereotype.Repository;

import com.vetri.erp.ds.inventory.entity.UomEntity;

@Repository
public class UomDao extends CommonDaoImpl<UomEntity, Integer> {

	public UomDao() {
		super(UomEntity.class);
	}

}
