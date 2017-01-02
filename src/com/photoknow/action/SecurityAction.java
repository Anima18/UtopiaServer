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
import com.photoknow.entity.UserSyncRecord;
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
	
	public void checkDataVersion() {
		Gson gson = new Gson();
		String userId = request.getParameter("userId");
		String deviceId = request.getParameter("deviceId");
		String lastSyncTime = request.getParameter("lastSyncTime");
		UserSyncRecord record = new UserSyncRecord(userId, deviceId, lastSyncTime);
		
		try {
			boolean flag = userService.findSyncRecord(record);
			ResultData result = new ResultData();
			if(flag) {
				result.setCode(1);
				result.setInfo("数据是最新的");
				//return version is new
			}else {
				//get data of sync to local
				UserData userData = userService.getUserData(userId);
				result.setCode(0);
				result.setInfo("数据有更新");
				result.setUserData(userData);
			}
			JsonUtil.print(response, gson.toJson(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void syncData(){
		Gson gson = new Gson();
		ResultData result = new ResultData();
		try {
			String userDataStr = request.getParameter("userData");
			UserData userData = gson.fromJson(userDataStr, UserData.class);
			
			userService.saveUserData(userData);
			userService.saveSyncRecord(userData.getRecord());
			
			result.setCode(1);
			result.setInfo("同步成功！");
			JsonUtil.print(response, gson.toJson(result));
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(0);
			result.setInfo("同步失败！");
			JsonUtil.print(response, gson.toJson(result));
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
