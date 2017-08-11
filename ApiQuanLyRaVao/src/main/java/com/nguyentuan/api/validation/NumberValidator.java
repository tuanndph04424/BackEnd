package com.nguyentuan.api.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class NumberValidator implements ConstraintValidator<Number, String> {

	public void initialize(Number parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isEmpty(value)) {
			return true;
		}

		String regex = "^(\\d+)$";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(value.trim());

		if (m.find()) {
			return true;
		} else {
			return false;
		}

	}

	private void validateParameters() {
	}
}
