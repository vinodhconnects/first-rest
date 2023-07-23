package com.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entities.Person;

public interface PeopleRepository extends JpaRepository<Person, Long>{
   public Person findBySno(Integer sno);
}
