/*******************************************************************************
 * •Copyright 2017 Panasonic Healthcare Co., Ltd. All rights reserved.
 ******************************************************************************/
package com.nguyentuan.api.commom.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

import com.nguyentuan.api.common.FLConstant;




/**
 * Conversion to String type
 */
public final class CustomStringConverter implements Converter {

    @SuppressWarnings("rawtypes")
    public Object convert(Class type, Object value) {

        if (value == null) {
            return null;
        } else if (value instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat(FLConstant.DATE_FORMAT_YYYYMMDD);
            return sdf.format(value);
        } else {
            return value.toString();
        }
    }

}
