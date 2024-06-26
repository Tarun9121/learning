package com.mappings.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mappings.entity.Instructor;

@Repository
public interface Instructors {
	void save(Instructor theInstructor);
	Optional<Instructor> findById(Integer id);
	boolean delete(Instructor data);
}
