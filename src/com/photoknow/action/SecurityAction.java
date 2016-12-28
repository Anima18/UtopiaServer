package com.photoknow.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.photoknow.entity.ResultData;
import com.photoknow.entity.User;
import com.photoknow.entity.UserData;
import com.photoknow.service.UserService;
import com.photoknow.util.JsonUtil;

@Controller("securityAction")
@Scope("prototype")
public class SecurityAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	@Resource
	private UserService userService;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public void register() {
		ResultData result = new ResultData();
		Gson gson = new Gson();
		try {
			String userStr = request.getParameter("user");
			User user = gson.fromJson(userStr, User.class);
			boolean flag = userService.register(user);
		
			if(flag) {
				result.setCode(1);
				result.setInfo("注册成功");
			}else {
				result.setCode(0);
				result.setInfo("该用户已存在!");
			}
		} catch(Exception e) {
			e.printStackTrace();
			result.setCode(0);
			result.setInfo(e.getMessage());
		} finally {
			JsonUtil.print(response, gson.toJson(result));
		}
		
	}
	
	public void login() {
		ResultData result = new ResultData();
		Gson gson = new Gson();
		try {
			String userStr = request.getParameter("user");
			User user = gson.fromJson(userStr, User.class);
			boolean flag = userService.login(user);
		
			if(flag) {
				result.setCode(1);
				result.setInfo("登录成功");
			}else {
				result.setCode(0);
				result.setInfo("用户名或密码出错");
			}
		} catch(Exception e) {
			e.printStackTrace();
			result.setCode(0);
			result.setInfo(e.getMessage());
		} finally {
			JsonUtil.print(response, gson.toJson(result));
		}
	}
	
	
	public void syncData(){
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
