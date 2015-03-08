package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Required;

import com.annotations.Phone;


@Entity
@Table(name = "Person")
public class Person {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@NotEmpty
	@Size(max=50)
	private String firstname;

	@NotBlank
	@NotEmpty
	@Size(max=50)
	private String name;

	private String country;

	@NotBlank
	@NotEmpty
	@Size(max=1024)
	private String adressString;

	// TODO add annotations min and max
//	@Min(value=18)
//	@Max(value=99)
	private int age;

	// TODO annotation phone @Phone
	private String telephoneNumber; 

	private Date created_at;

	private String fixTelephoneNumber;

	public Person () {
		this.created_at = new Date();
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAdressString() {
		return adressString;
	}
	public void setAdressString(String adressString) {
		this.adressString = adressString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getFixTelephoneNumber() {
		return fixTelephoneNumber;
	}

	public void setFixTelephoneNumber(String fixTelephoneNumber) {
		this.fixTelephoneNumber = fixTelephoneNumber;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", name="
				+ name + ", country=" + country + ", adressString="
				+ adressString + ", age=" + age + ", telephoneNumber="
				+ telephoneNumber + ", created_at=" + created_at
				+ ", fixTelephoneNumber=" + fixTelephoneNumber + "]";
	}

}
