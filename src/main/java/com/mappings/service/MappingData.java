package com.mappings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mappings.dao.Instructors;
import com.mappings.entity.Instructor;

@Component
public class MappingData implements MappingService {
	
	private Instructors instRepo;
	
	@Autowired
	public MappingData(Instructors instRepo) {
		this.instRepo = instRepo;
	}

	@Override
	public void save(Instructor theInstructor) {
		instRepo.save(theInstructor);
	}

}
