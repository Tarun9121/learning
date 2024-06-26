package com.mappings.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * In spring boot, the entity lifecycle refers to the various stages an entity goes through from its
 * creation to its removal in the context of a persistence framework like JPA (Java Persistence API).
 * Understanding the lifecycle of an entity is crucial for managing database operations effectively.
 * Here are the key stages of the entity lifecycle in Spring Boot using JPA
 * 
 * 1. New (transient):
 * -An entity is created but not yes associated with a persistence context. It is not yet stored in the database
 * 
 * 2. Managed (Persistent):
 * -An entity is associated with a persistence context and is being tracked by the EntityManager.
 *  It corresponds to a row in the database.
 * -When you persist an entity "entityManager.persist(instructor)", it becomes managed
 * 
 * 3. Detached:
 * -An entity that was once managed but is no longer associated with a persistance context.
 *  Changes to the entity are not automatically synchronized to the database.
 * -After closing the EntityManager, the entities it managed become detached.
 * 
 * 4. Removed:
 * -An entity is marked for deletion. it will be deleted from the database when the transaction commits.
 * -entityManager.remove(instructor)
 * 
 * Entity Lifecycle Callbacks:
 * JPA provides lifecycle callback annotations that allow you to execute specifie code at different stages of an entity's lifecycle.
 * These annotations can be used within entity classes:
 * 
 * @PrePresist: invoked before an entity is persisted (added to the database)
 * @PostPersist: invoked after an entity has been persisted
 * @PreUpdate: invoked before an entity is updated
 * @PostUpdate: invoked after an entity has been updated
 * @PreRemove: invoked before an entity is removed
 * @PostRemove: invoked after an entity has been removed
 * @PostLoad: invoked after an entity has been loaded from the database
 */

@Entity
@Table(name = "instructor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
	public Instructor(String firstName, String lastName) {
		this.firstName = firstName; this.lastName = lastName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	
	/**
	 * OneToOne: this annotation is used to define a one-to-one relationship between two entities
	 * in one-to-one relationship, each instance of the source entity (the entity containing this annotation)
	 * is associated with exactly one instance of the target entity and vice versa
	 * 
	 * --------------------------------------------------------------------------------------------------------------
	 * Cascade types:
	 * CascadeType.PERSIST -> use when you want to automatically save child entities when saving a parent entity.
	 * 
	 * CascadeType.MERGE -> use when you want to update child entities automatically when updating a parent entity.
	 * 
	 * CascadeType.REMOVE -> use when you want to delete child entities automatically when deleting a parent entity
	 * 
	 * Cascadetype.REFRESH -> use when you want to reload child entities automatically when reloading a parent entity.
	 * 
	 * CascadeType.DETACH -> use when you want to detach child entities automatically when detaching a parent entity.
	 * 
	 * CascadeType.ALL -> use when you want to apply all of the above cascading operations
	 * 
	 * --------------------------------------------------------------------------------------------------------------
	 * Configure Cascade Types:
	 * @OneToOne(cascade = CascadeType.PERSIST)
	 * 
	 * if you have multiple
	 * @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, ...})
	 * 
	 * --------------------------------------------------------------------------------------------------------------
	 * 
	 * @JoinColumn(name = "instructor_detail_id"): this specifies that the "Instructor" table,
	 * there is a column named "instructor_detail_id" which acts as a foreign key. this foreign key
	 * links each "instructor" to a specific "Instructor_details" by its primary key
	 * 
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetails instructorDetail;
}
