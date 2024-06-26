package com.mappings.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mappings.entity.Instructor;

import jakarta.persistence.EntityManager;

@Component
public class InstructorRepository implements Instructors {
	
	private EntityManager entityManager;
	
	@Autowired
	public InstructorRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * What is a Transaction ?
	 * A transaction in the context of database is a sequence of operations performed on a single logical unit of work.
	 * A Transaction has a four important properties referred as ACID properties.
	 * 
	 * 1. Automicity: All operation within a transaction are completed successfully or none of them are applied. it's all or nothing
	 * 
	 * 2. Consistency: A Transaction ensures that the database moves from one consistent state to another consistent state.
	 * 
	 * 3. Isolation: Transactions are isolated from each other. Changes made in Transaction are not visible to another
	 *  Transactions until the transaction is committed.
	 *  
	 * 4. Durability: Once a Transaction is comitted, the changes are perminent, even if a event of a system failure.
	 * 
	 * 
	 * Transactional Layer in Spring: Springs transactional layer helps manage transactions within your application.
	 * it provides two main ways to handle transactions.
	 * 1. Declarative	2. Programmatically
	 * 
	 * 1. Declarative: you declare a transaction bounderies using annotations or configuration, and spring take care of the rest.
	 * - simply put the @Transactional annotation on the method or class where you want to manage the transaction.
	 * - when the method is called, Spring starts a transaction before executing the method, and commits it after completion of 
	 * method. if an exception occurs, Spring roll back the transaction.
	 * 
	 * 2. Programatically: you have to use the PlatformTransactionManager interface, so refer it.
	 * 
	 */
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}
	
	@Override
	public Optional<Instructor> findById(Integer id) {
		Instructor data = entityManager.find(Instructor.class, id);
		return Optional.ofNullable(data);
	}

	@Override
	public boolean delete(Instructor data) {
		entityManager.remove(data);
		return false;
	}
	
	

}
