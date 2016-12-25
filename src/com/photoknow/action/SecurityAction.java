package com.photoknow.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.photoknow.entity.DataObject;
import com.photoknow.entity.User;
import com.photoknow.entity.UserData;
import com.photoknow.entity.UserInfo;
import com.photoknow.service.UserService;
import com.photoknow.util.JsonUtil;

@Controller("securityAction")
@Scope("prototype")
public class SecurityAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	@Resource
	private UserService userService;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public void login(){
		String userDataStr = request.getParameter("userData");
		Gson gson = new Gson();
		UserData userData = gson.fromJson(userDataStr, UserData.class);
		try {
			userService.saveUserData(userData);
			JsonUtil.print(response, "success");
		} catch (Exception e) {
			e.printStackTrace();
			JsonUtil.print(response, "fail");
		}
		
	}
	
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}