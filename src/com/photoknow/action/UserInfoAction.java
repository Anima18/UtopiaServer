package com.photoknow.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.photoknow.entity.DataObject;
import com.photoknow.entity.UserInfo;
import com.photoknow.util.JsonUtil;

@Controller("userInfoAction")
/*@Scope("prototype")*/
public class UserInfoAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private Gson gson = new Gson();

	private UserInfo userInfo;
	private List<UserInfo> userInfoList = new ArrayList<>();
	

	public void saveUserInfo(){
		String flag = "fail";
		if(userInfo != null){
			userInfoList.add(0,userInfo);
			userInfo = null;
			flag = "success";
		}
		
		DataObject dataObject = new DataObject();
		dataObject.info = "";
		dataObject.result = "1";
		String value = gson.toJson(dataObject);
		JsonUtil.print(response, value);
	}
	
	public void getAllUserInfoLayer() {
		if(userInfoList.size() == 0) {
			for(int i = 0; i < 50; i++) {
				userInfoList.add(new UserInfo(i+"", i, i+""));
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("=======getAllUserInfoLayer=======");
		DataObject<UserInfo> dataObject = new DataObject<>();
		dataObject.data = new DataObject.DataBean<>();
		dataObject.data.rows = userInfoList;
		dataObject.data.total = userInfoList.size();
		dataObject.info = "";
		dataObject.result = "1";
		String value = gson.toJson(dataObject);
		JsonUtil.print(response, value);
	}
	
	public void getAllUserInfo() {
		if(userInfoList.size() == 0) {
			for(int i = 0; i < 50; i++) {
				userInfoList.add(new UserInfo(i+"", i, i+""));
			}
		}
		System.out.println("=======getAllUserInfo=======");
		DataObject<UserInfo> dataObject = new DataObject<>();
		dataObject.data = new DataObject.DataBean<>();
		dataObject.data.rows = userInfoList;
		dataObject.data.total = userInfoList.size();
		dataObject.info = "";
		dataObject.result = "1";
		String value = gson.toJson(dataObject);
		JsonUtil.print(response, value);
	}
	
	public void getWeatherToday() {
		
	}
	
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

}
