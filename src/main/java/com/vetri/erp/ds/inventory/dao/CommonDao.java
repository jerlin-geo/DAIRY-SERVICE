package com.vetri.erp.ds.inventory.dao;

import java.util.List;

import com.vetri.erp.ds.inventory.exception.InventoryException;

public interface CommonDao<T, ID> {

	T  getById(String orgId, ID id) throws InventoryException;

	List<T> getAll(String orgId);

	T save(T entity);

	T update(T entity);
	
	int delete(String orgId, ID id);

	int softDelete(String orgId, ID id);

}
