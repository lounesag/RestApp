package com.dao;

import java.util.List;

import com.model.Person;

public interface PersonDao {

    public void savePerson(Person person); // create and update

    public List<Person> listPersons(); //list of persons

    public Person getPerson(int id); 

    public void deletePerson(int id);

    public Person getPersonByName(String name, String firstname);

}
