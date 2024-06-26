package com.mappings.daogeneric;

import java.util.Optional;

/**
 * Creating a generic repository like MyJPARepository<T, ID> can be a useful way to reduce code
 * duplication and provide a consistent way to interact with your database entities. 
 * However, there are several considerations in terms of security, maintainability, and 
 * best practices:
 * 
 * 
 * 
 * @param <T>
 * @param <ID>
 */

public interface MyGenericRepository<T, ID> {
	public void save(T data);
	public boolean update(T data);
	public Optional<T> findById(ID id);
}