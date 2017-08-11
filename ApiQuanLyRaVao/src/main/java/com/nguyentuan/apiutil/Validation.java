package com.nguyentuan.apiutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Validation {

	
	public static Boolean isNumberic(String value) {
		if (!NumberUtils.isNumber(value)) {
			return true;
		}
		return false;
	}

	public static boolean isStringFloat(String number ){
	    try{
	        Float.parseFloat(number);
	    }catch(Exception e ){
	        return true;
	    }
	    return false;
	}
	
	public static Boolean minAndMAx(String value, int min, int max) {

		if (StringUtils.isEmpty(value)) {
			return true;
		}
		if (value.length() < min || value.length() > max) {
			return true;
		}
		return false;
	}

	public static boolean validateDate(String strDate) throws JsonProcessingException {
		if (StringUtils.isEmpty(strDate)) {
			return true;
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(strDate);
			} catch (ParseException pe) {
				return true;
			}
			return false;
		}
	}

	public static boolean compareToDate(String strDate) throws JsonProcessingException {
		if (StringUtils.isEmpty(strDate)) {
			return true;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String dateStr = sdf.format(new Date());
			Date date1 = null;
			Date date2 = null;
			try {
				date1 = sdf.parse(dateStr);
				date2 = sdf.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (date2.compareTo(date1) < 0) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean compareToNextMonth(String strDate) throws JsonProcessingException {
		if (StringUtils.isEmpty(strDate)) {
			return true;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date date2 = null;
			try {
				date2 = sdf.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar calendar = Calendar.getInstance();         
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date nextMonthLastDay = calendar.getTime();
			if(date2.compareTo(nextMonthLastDay) > 0){
				return true;
			}
		}
		return false;
	}
	
}
