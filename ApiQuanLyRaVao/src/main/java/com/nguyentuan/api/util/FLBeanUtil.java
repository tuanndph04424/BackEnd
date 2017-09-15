package com.nguyentuan.api.util;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;

import com.nguyentuan.api.commom.converter.CustomDateConverter;
import com.nguyentuan.api.commom.converter.CustomStringConverter;




public class FLBeanUtil {

	private static BeanUtilsBean bu;

	private static BeanUtilsBean buNative;

	static {
		bu = new BeanUtilsBean(new ConvertUtilsBean(), BeanUtilsBean.getInstance().getPropertyUtils());
		bu.getConvertUtils().register(new CustomDateConverter(), Date.class);
		bu.getConvertUtils().register(new CustomStringConverter(), String.class);
		bu.getConvertUtils().register(new BigDecimalConverter(null), BigDecimal.class);
		buNative = new BeanUtilsBean(new ConvertUtilsBean(), BeanUtilsBean.getInstance().getPropertyUtils());
		buNative.getConvertUtils().register(new CustomDateConverter(), Date.class);
		buNative.getConvertUtils().register(new CustomStringConverter(), String.class);
		buNative.getConvertUtils().register(new LongConverter(null), Long.class);
		buNative.getConvertUtils().register(new IntegerConverter(null), Integer.class);
		buNative.getConvertUtils().register(new ShortConverter(null), Short.class);
		buNative.getConvertUtils().register(new FloatConverter(null), Float.class);
		buNative.getConvertUtils().register(new DoubleConverter(null), Double.class);
	}

	private FLBeanUtil() {

	}

	public static void copyProperties(Object source, Object target) throws Exception {
		bu.copyProperties(target, source);

	}

	@SuppressWarnings("rawtypes")
	public static Object createAndCopyProperties(Object source, Class c) throws Exception {
		Object target = null;
		target = c.newInstance();
		bu.copyProperties(target, source);
		return target;
	}

	public static void copyPropertiesNative(Object source, Object target) throws Exception {
		buNative.copyProperties(target, source);

	}

	@SuppressWarnings("rawtypes")
	public static Object createAndCopyPropertiesNative(Object source, Class c) throws Exception {
		Object target = null;
		target = c.newInstance();
		buNative.copyProperties(target, source);
		return target;
	}

}
