package com.photoknow.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;


public class JsonUtil {
	public static void printJson(Object o, String[] filters,HttpServletResponse httpServletResponse){
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);   
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); 
		config.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor("yy-MM-dd hh:mm:ss")); //date processor register
		config.setExcludes(filters);	
		JSONArray  jsonObject = JSONArray.fromObject(o,config); 
		
		httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = httpServletResponse.getWriter();			
			System.out.println(jsonObject.toString());
			out.print(jsonObject.toString());	
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void print(HttpServletResponse httpServletResponse,Object o){
		
		httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = httpServletResponse.getWriter();			
			System.out.println(o.toString());
			out.print(o.toString());	
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void printJsonObject(HttpServletResponse response, String callback, JSONObject jsonObject){
		try {
			response.setCharacterEncoding("UTF-8");	
			response.getWriter().print(callback + "(" +jsonObject.toString() + ")");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
