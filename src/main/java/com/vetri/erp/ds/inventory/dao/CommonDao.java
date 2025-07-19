package com.vetri.erp.ds.inventory.dao;

import java.util.List;

public interface CommonDao<T, ID> {

	T getById(ID id, Integer orgId);

	List<T> getAll(Integer orgId);

	T save(T entity);

	T update(T entity);
}
