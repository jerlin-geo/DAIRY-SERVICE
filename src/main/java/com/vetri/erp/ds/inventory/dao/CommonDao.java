package com.vetri.erp.ds.inventory.dao;

import java.util.List;

public interface CommonDao<T, ID> {

	T getById(Integer orgId, ID id);

	List<T> getAll(Integer orgId);

	T save(T entity);

	T update(T entity);
	
	int delete(Integer orgId, ID id);
}
