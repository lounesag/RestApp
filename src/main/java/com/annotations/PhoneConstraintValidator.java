package com.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

	public void initialize(Phone phone) { }

	public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
		boolean result;
		if(phoneField == null) {
			return false;
		}
		result = phoneField.matches("[0-9()-\\.]*");
		return result;
	}
}