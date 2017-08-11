package com.nguyentuan.api.common;

/**
 * Created by ADMIN on 6/15/2017.
 */
public class FLConstant {
	public static final String UPDATE_CUSTOMER = "updatecustomer";
	public static final String DELETE_CUSTOMER = "delete customer";
	public static final String MES_VALIDATION_NOT_DATA = "300";
	public static final String MES_VALIDATION_OKE = "200";
	public static final String MES_VALIDATION_ERROR = "400";
	public static final String MES_VALIDATION_DELETE = "333";
	public static final String MES_VALIDATION_NOT_OKE = " 該当データが存在しません。";
	/** String date format */
	public static final String DATE_FORMAT_YYYYMMDD = "yyyy/MM/dd";
	/** String empty */
	public static final String STRING_EMPTY = "";
	// HTTP STATUS
	public interface status {
		public static final String NORMAL = "000";
		public static final String STATUS = "111";
		public static final String ERROR = "333";
		public static final String VADILATION = "";
		public static final String SYSTEM_ERROR = "999";

	}

}
