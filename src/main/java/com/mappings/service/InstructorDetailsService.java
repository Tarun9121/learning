package com.mappings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mappings.daogeneric.MyJPARepository;
import com.mappings.entity.InstructorDetails;

@Repository
public class InstructorDetailsService {
	private MyJPARepository<InstructorDetails, Integer> instructorDetailsRepository;
	
	@Autowired
	public InstructorDetailsService(MyJPARepository<InstructorDetails, Integer> instructorDetailsRepository) {
		this.instructorDetailsRepository = instructorDetailsRepository;
	}
	
	public void save(InstructorDetails data) {
		instructorDetailsRepository.save(data);
	}
}