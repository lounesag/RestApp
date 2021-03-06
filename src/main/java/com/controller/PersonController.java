package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.model.Person;
import com.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value ="/listPersons", method = RequestMethod.GET)
	public @ResponseBody Map listPersons() {
		Map<String, Object> map = new HashMap<>();
		map.put("personList", personService.listPersons());
		return map;
	}

	 @RequestMapping(value = "/get/{personId}", method = RequestMethod.GET)
     public @ResponseBody Map getPerson(@PathVariable int personId) {
		 	Map<String, Object> map = new HashMap<>();
            Person person = personService.getPerson(personId);
            map.put("person", person);
            return map;
     }

     @RequestMapping(value = "/save", method = RequestMethod.POST)
     public @ResponseBody Map savePerson(@RequestBody Person person) {
    	 Map<String, Object> map = new HashMap<>();
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
     public @ResponseBody Map deletePerson(@PathVariable("personId") int id) {
         Map<String, Object> map = new HashMap<>();   
    	 personService.deletePerson(id);
    	 map.put("delete", "success");
         map.put("person", id);
         return map;
     }
}
