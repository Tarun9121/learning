package com.mappings.daogeneric;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

@Repository
public class MyJPARepository<T, ID> implements MyGenericRepository<T, ID> {
	private EntityManager entityManager;
	private Class<T> entityType;
	
	@Autowired
	public MyJPARepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public void save(T data) {
		entityManager.persist(data);
	}
	
	public boolean update(T data) {
		try {
			entityManager.merge(data);
		}
		catch(PersistenceException pe) {
			pe.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Optional<T> findById(ID id) {
		T data = entityManager.find(entityType, id);
		return Optional.ofNullable(data);
	}
}