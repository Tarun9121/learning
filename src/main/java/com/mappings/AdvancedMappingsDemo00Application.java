package com.mappings;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mappings.dao.InstructorRepository;
import com.mappings.entity.Instructor;
import com.mappings.entity.InstructorDetails;

@SpringBootApplication
public class AdvancedMappingsDemo00Application {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingsDemo00Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(InstructorRepository service) {
		return runner -> {
			findInstructor(3, service);
		};
	}
	
	public boolean deleteById(int id, InstructorRepository service) {
		Optional<Instructor> data = service.findById(id);
		if(data.isPresent()) {
			service.delete(data.get());
			System.out.println("deleted data: " + data);
		}
		else {
			System.out.println("there is no data with the given id: " + id);
		}
			
		return true;
	}
	
	public void createInstructor(InstructorRepository service) {
		Instructor tempInstructor = new Instructor("tarun", "swaroop");
		InstructorDetails tempInstructorDetail = new InstructorDetails("channel1", "youtube");
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		service.save(tempInstructor);
		System.out.println("saved details: " + tempInstructor + " : " + tempInstructorDetail);
	}
	
	public void findInstructor(int id, InstructorRepository service) {
		Optional<Instructor> data = service.findById(id);
		if(data.isPresent())
			System.out.println("the instructor with the id: " + id + " is: " + data.get());
		else 
			System.out.println("there is no data for the given id");
	}

}