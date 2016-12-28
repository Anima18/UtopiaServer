package com.photoknow.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
  	public static String toFormatString(Date date,String format){
  		final SimpleDateFormat sdf = new SimpleDateFormat(format);
  		try {
  			return sdf.format(date);
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			return null;
  		}
  	}
}
