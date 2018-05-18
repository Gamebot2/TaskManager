package com.ansh.test.repository;

import java.util.List;

import javax.persistence.metamodel.ListAttribute;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>{
	
	List<Task> findByTaskArchived(@Param("archivedfalse") int taskArchivedFalse);
	List<Task> findByTaskClass(@Param("class") String taskClass);
}
