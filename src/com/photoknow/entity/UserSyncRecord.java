package com.photoknow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_sync_record")
public class UserSyncRecord {
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private Integer userId;
	@Column(length=100)
	private String deviceId;
	@Column(length=40)
	private String syncDate;
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
	public String getSyncDate() {
		return syncDate;
	}
	public void setSyncDate(String syncDate) {
		this.syncDate = syncDate;
	}
}
