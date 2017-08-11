package com.nguyentuan.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class FloatValidator implements ConstraintValidator<FloatFormat, String> {

	public void initialize(FloatFormat parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isEmpty(value)) {
			return true;
		}

		try {
			Float.parseFloat(value);
		} catch (Exception e) {
			return true;
		}
		return false;

	}

	private void validateParameters() {
	}
}
