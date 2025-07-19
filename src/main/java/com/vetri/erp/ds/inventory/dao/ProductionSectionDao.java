package com.vetri.erp.ds.inventory.dao;

import org.springframework.stereotype.Repository;

import com.vetri.erp.ds.inventory.entity.ProductionSectionEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProductionSectionDao extends CommonDaoImpl<ProductionSectionEntity, Integer> {

	public ProductionSectionDao() {
		super(ProductionSectionEntity.class);
	}

	@PersistenceContext
	EntityManager em;
	
	
}
