package com.vetri.erp.ds.inventory.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vetri.erp.ds.inventory.entity.ProductionSectionEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
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
	public T getById(Integer orgId, ID id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(entityClass);
		Root<T> root = query.from(entityClass);

		Predicate idPredicate = cb.equal(root.get("id"), id);
		Predicate orgPredicate = cb.equal(root.get("company").get("id"), orgId);
//		Predicate notDeleted = cb.equal(root.get("isDeleted"), false);

		query.select(root).where(cb.and(idPredicate, orgPredicate));
		List<T> resultList = entityManager.createQuery(query).getResultList();
		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public List<T> getAll(Integer orgId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = cb.createQuery(entityClass);
		Root<T> root = query.from(entityClass);

		Predicate orgPredicate = cb.equal(root.get("company").get("id"), orgId);
//		Predicate notDeleted = cb.equal(root.get("isDeleted"), false);

		query.select(root).where(cb.and(orgPredicate));
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
	public int delete(Integer orgId, ID id) {
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaDelete<ProductionSectionEntity> delete = cb.createCriteriaDelete(ProductionSectionEntity.class);
	    Root<ProductionSectionEntity> root = delete.from(ProductionSectionEntity.class);
	    Predicate orgPredicate = cb.equal(root.get("company").get("id"), orgId);
	    Predicate idPredicate = cb.equal(root.get("id"), id);
	    delete.where(orgPredicate, idPredicate); // TODO soft delete or hard delete
	    entityManager.createQuery(delete).executeUpdate();
		return 0;
	}

}
