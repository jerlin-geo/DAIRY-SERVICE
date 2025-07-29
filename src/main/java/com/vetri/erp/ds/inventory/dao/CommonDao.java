package com.vetri.erp.ds.inventory.dao;

import java.util.List;

import com.vetri.erp.ds.inventory.exception.InventoryException;

public interface CommonDao<T, ID> {

	T  getById(Integer orgId, ID id) throws InventoryException;

	List<T> getAll(Integer orgId);

	T save(T entity);

	T update(T entity);
	
	int delete(Integer orgId, ID id);

	int softDelete(Integer orgId, ID id);

}
