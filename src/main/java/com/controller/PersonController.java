package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.exception.CustomException;
import com.model.Person;
import com.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value ="/listPersons", method = RequestMethod.GET)
	public @ResponseBody Map listPersons() {
		Map<String, Object> map = new HashMap();
		map.put("personList", personService.listPersons());
		return map;
	}

	@RequestMapping(value = "/get/{personId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map getPerson(@PathVariable int personId) throws CustomException {
		Map<String, Object> map = new HashMap();
		Person person = personService.getPerson(personId);
		if (person == null) {
			throw new CustomException("the entity with id " +personId +" is not found !"); 
		} else {
			map.put("person", person);
			return map;
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Map savePerson(@RequestBody Person person) {
		Map<String, Object> map = new HashMap();
		personService.savePerson(person);
		map.put("created", "success");
		return map;
	}
	/*
	 * @POST
		@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public Response createDog(JAXBElement<Dog> jaxbDog) {
    	Dog dog = jaxbDog.getValue();
   		dogDao.save(dog);
    	return Response.status(Response.Status.OK).build();
		}
	 */

	@RequestMapping("/delete/{personId}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void deletePerson(@PathVariable("personId") int personId) throws CustomException {
		Person person = personService.getPerson(personId);
		if (person == null) {
			throw new CustomException("the entity with id " +personId +" is not found !"); 
		}
		personService.deletePerson(personId);
	}

	@RequestMapping("/update/person/{personId}")
	@ResponseStatus(HttpStatus.OK)
	private @ResponseBody Map updatePerson (@RequestBody Person person, @PathVariable("personId") int id){
		return null; //TODO add update person
	}

	@RequestMapping("/getinfo/{personName}/{personFirstname}")
	@ResponseStatus(HttpStatus.OK)
	private @ResponseBody Map infoPersonByNameAndFirstname (@PathVariable("personName") String name,
			@PathVariable("personFirstname") String firstname) throws CustomException {
		Map<String, Object> map = new HashMap();  
		Person person = personService.getInfoPerson(name, firstname);
		if (person == null) {
			throw new CustomException("the entity with firstName " + firstname +" and name"+ name +" is not found !"); 
		}
		map.put("person", person);
		return map;
	}

}
