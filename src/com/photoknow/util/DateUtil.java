package com.photoknow.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	//转规定时间 样式（sdf_str）,return string
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
