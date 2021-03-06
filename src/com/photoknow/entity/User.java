package com.photoknow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
@NamedQueries({
	@NamedQuery(name="User.getUserByEmail",
			query="select u from User u where u.email = :email"),
	@NamedQuery(name="User.getUserById",
			query="select u from User u where u.userId = :userId"),
	@NamedQuery(name="User.login",
			query="select u from User u where u.name = :name and u.password = :password")
})
public class User {
	@Id
	private String userId;
	@Column(length=40)
	private String name;
	@Column(length=40)
	private String email;
	@Column(length=40)
	private String password;
	@Column(length=40)
	private String createBy;
	@Column(length=40)
	private String createAt;
	@Column(length=40)
	private String updateBy;
	@Column(length=40)
	private String updateAt;
	@Column(length=10)
	private String gender;
	@Column(length=100)
	private String introduce;
	@Transient
	private String deviceId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
}
