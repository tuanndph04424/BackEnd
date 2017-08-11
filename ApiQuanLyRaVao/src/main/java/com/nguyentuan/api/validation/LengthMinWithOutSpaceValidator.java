/*******************************************************************************
 * •Copyright 2017 Panasonic Healthcare Co., Ltd. All rights reserved.
 ******************************************************************************/
package com.nguyentuan.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

public class LengthMinWithOutSpaceValidator implements ConstraintValidator<LengthMinWithOutSpace, String> {
	private int min;

	public void initialize(LengthMinWithOutSpace parameters) {
		min = parameters.min();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}
		int length = value.trim().length();
		return length >= min;
	}

	private void validateParameters() {
		if (min < 0) {
			throw new IllegalArgumentException("The min parameter cannot be negative.");
		}

	}

}
