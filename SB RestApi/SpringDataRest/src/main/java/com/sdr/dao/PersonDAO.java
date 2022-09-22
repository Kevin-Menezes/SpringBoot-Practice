package com.sdr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sdr.entities.Person;

@RepositoryRestResource(collectionResourceRel="persons",path="persons")
public interface PersonDAO extends JpaRepository<Person, Integer>{
	
}
