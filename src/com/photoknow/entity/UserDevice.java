package com.photoknow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_device")
public class UserDevice {
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private Integer userId;
	@Column(length=100)
	private String deviceId;
	@Column(length=40)
	private String createDate;
	
	public UserDevice() {}
	
	public UserDevice(Integer userId, String deviceId, String createDate) {
		this.userId = userId;
		this.deviceId = deviceId;
		this.createDate = createDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
