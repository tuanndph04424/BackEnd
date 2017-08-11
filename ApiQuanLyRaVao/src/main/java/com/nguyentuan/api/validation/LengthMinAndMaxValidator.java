/*******************************************************************************
 * •Copyright 2017 Panasonic Healthcare Co., Ltd. All rights reserved.
 ******************************************************************************/
package com.nguyentuan.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

public class LengthMinAndMaxValidator implements ConstraintValidator<LengthMinAndMax, String> {
	private int min;
	private int max;

	public void initialize(LengthMinAndMax parameters) {
		min = parameters.min();
		max = parameters.max();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}

		int length = value.length();

		if (min <= length && length <= max) {
			return true;
		}
		return false;
	}

	private void validateParameters() {

	}

}
