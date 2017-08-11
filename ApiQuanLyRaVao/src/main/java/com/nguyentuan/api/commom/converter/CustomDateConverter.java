package com.nguyentuan.api.commom.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;

import com.nguyentuan.api.common.FLConstant;
import com.nguyentuan.api.entity.DepartmentEntity;





/**
 * Conversion to Date type
 */
public final class CustomDateConverter implements Converter {

	@SuppressWarnings("rawtypes")
	public Object convert( Class type, Object value) {
		if (value == null) {
			return null;
		} else if (value instanceof String) {
			if (StringUtils.isNotBlank(value.toString())) {
				SimpleDateFormat sdf = new SimpleDateFormat(FLConstant.DATE_FORMAT_YYYYMMDD);
				try {
					return sdf.parse(value.toString());
				} catch (ParseException e) {
					e.printStackTrace();
					return value.toString();
				}
			} else {
				return null;
			}
		} else {
			return value;
		}
	}
	
	

}
