package com.vetri.erp.ds.inventory.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vetri.erp.ds.inventory.exception.InventoryException;
import com.vetri.erp.ds.inventory.util.Constants;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CommonDaoImpl<T, ID> implements CommonDao<T, ID> {
	
	@PersistenceContext
	protected EntityManager entityManager;

	private final Class<T> entityClass;

	public CommonDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T getById(Integer orgId, ID id) throws InventoryException {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(entityClass);
		Root<T> root = query.from(entityClass);

		Predicate idPredicate = cb.equal(root.get("id"), id);
		Predicate orgPredicate = cb.equal(root.get("company").get("id"), orgId);
		Predicate orgIsNullPredicate = cb.isNull(root.get("company").get("id"));
//		Predicate notDeleted = cb.equal(root.get("isDeleted"), false);
		
		query.select(root).where(idPredicate, cb.or(orgIsNullPredicate, orgPredicate));
	    try {
	    	return entityManager.createQuery(query).getSingleResult();
	    } catch (NoResultException e) {
	        throw new InventoryException(Constants.ITEM_NOT_FOUND);
	    }
	}

	@Override
	public List<T> getAll(Integer orgId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(entityClass);
		Root<T> root = query.from(entityClass);

		Predicate orgPredicate = cb.equal(root.get("company").get("id"), orgId);
		Predicate orgIsNullPredicate = cb.isNull(root.get("company").get("id"));
//		Predicate notDeleted = cb.equal(root.get("isDeleted"), false);

		query.select(root).where(cb.or(orgIsNullPredicate, orgPredicate));
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	@Transactional
	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	@Transactional
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	@Transactional
	public int delete(Integer orgId, ID id) {
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaDelete<T> delete = cb.createCriteriaDelete(entityClass);
	    Root<T> root = delete.from(entityClass);
	    Predicate orgPredicate = cb.equal(root.get("company").get("id"), orgId);
	    Predicate idPredicate = cb.equal(root.get("id"), id);
	    Predicate orgIsNullPredicate = cb.isNull(root.get("company").get("id"));
	    delete.where(cb.or(orgIsNullPredicate, orgPredicate), idPredicate); 
	    return entityManager.createQuery(delete).executeUpdate();
	}
	
	@Override
	@Transactional
	public int softDelete(Integer orgId, ID id) {
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaUpdate<T> update = cb.createCriteriaUpdate(entityClass);
	    Root<T> root = update.from(entityClass);
	    Predicate orgPredicate = cb.equal(root.get("company").get("id"), orgId);
	    Predicate idPredicate = cb.equal(root.get("id"), id);
	    Predicate orgIsNullPredicate = cb.isNull(root.get("company").get("id"));
	    update.set(root.get("isDeleted"), true);
	    update.where(cb.or(orgIsNullPredicate, orgPredicate), idPredicate); 
	    return entityManager.createQuery(update).executeUpdate();
	}

}
