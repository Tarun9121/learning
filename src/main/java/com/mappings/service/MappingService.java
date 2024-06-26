package com.mappings.service;

import org.springframework.stereotype.Service;

import com.mappings.entity.Instructor;

@Service
public interface MappingService {
	public void save(Instructor theInstructor);
}
