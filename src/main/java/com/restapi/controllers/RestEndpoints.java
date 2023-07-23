package com.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entities.Person;
import com.restapi.services.PeopleService;
import com.restapi.utilities.HttpMessages;
import com.restapi.utilities.RecordAlreadyExistsException;

@RestController
@RequestMapping("/api")
public class RestEndpoints {
	@Autowired
	PeopleService ps;
   @RequestMapping("/greet")
	  public String greet() {
		  return "Hi! Spring boot is working";
	  }
   
   @RequestMapping("/people")
	  public ResponseEntity<List<Person>> getPeople() {
		  try {
			return  new ResponseEntity<List<Person>>(ps.getPeople(),HttpStatus.OK);  
		  }
		  catch(Exception e) {
			  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
   
   
   @PostMapping("/people")
	  public ResponseEntity<HttpMessages> addPeople(@RequestBody Person person) {
		  try {
			 System.out.println(person.getSno()+" "+person.getName());
			 ps.addPerson(person);
			 
			return  new ResponseEntity<HttpMessages>(new HttpMessages("Person added"),HttpStatus.CREATED);  
		  }
		  catch(RecordAlreadyExistsException e) {
			  return new ResponseEntity<HttpMessages>(new HttpMessages(e.toString()),HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
	 
	 
}
