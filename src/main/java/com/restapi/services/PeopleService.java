package com.restapi.services;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entities.Person;
import com.restapi.repositories.PeopleRepository;
import com.restapi.utilities.RecordAlreadyExistsException;

@Service
public class PeopleService implements InitializingBean{

	@Autowired
	PeopleRepository prepo;
	
	public List<Person> getPeople() {
		return prepo.findAll();
	}
	
	public void addPerson(Person p) throws RecordAlreadyExistsException {
		try {
			Person person=prepo.findBySno(p.getSno());
			if(person!=null) {
				throw new RecordAlreadyExistsException(p.getSno());
			}
			prepo.save(p);
		}
		catch(RecordAlreadyExistsException e) {
			throw e;
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(prepo.getClass()+"  is the class name  ############");
	}
	
}

/*
  Controller
  Service - service
  Component - normal classes
  Repository - database repository
*/