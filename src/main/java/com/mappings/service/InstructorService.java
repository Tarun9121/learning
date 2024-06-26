package com.mappings.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mappings.daogeneric.MyJPARepository;
import com.mappings.entity.Instructor;

@Repository
public class InstructorService {
	private MyJPARepository<Instructor, Integer> instructorRepository;
	
	@Autowired
	public InstructorService(MyJPARepository<Instructor, Integer> instructorRepository) {
		this.instructorRepository = instructorRepository;
	}
	
	public void save(Instructor data) {
		instructorRepository.save(data);
	}
	
	public Instructor findById(int id) {
		Optional<Instructor> optionalData = instructorRepository.findById(id);
		Instructor data = null;
		if(optionalData.isPresent()) {
			data = optionalData.get();
		}
		return data;
	}
}
