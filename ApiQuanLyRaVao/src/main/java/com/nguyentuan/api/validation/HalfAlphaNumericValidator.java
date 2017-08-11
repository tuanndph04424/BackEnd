package com.nguyentuan.api.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

/**
 * Integer check
 *
 */
public class HalfAlphaNumericValidator implements ConstraintValidator<HalfAlphaNumeric, String> {

	public void initialize(HalfAlphaNumeric parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}

		String regex = "^[a-zA-Z0-9]+$";
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
