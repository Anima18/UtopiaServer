package com.photoknow.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plan")
public class Plan implements Serializable {
	@Id
	@GeneratedValue
    private Integer id;
	@Column
	private Integer roleId;
	@Column(length=40)
	private String name;
	@Column(length=1000)
	private String description;
	@Column(length=40)
	private String progress;
	@Column
	private Integer userId;
	@Column
	private Integer thingClassesId;
	@Column(length=40)
	private String thingQuadrant;
	@Column(length=40)
	private String beginDate;
	@Column(length=40)
	private String endDate;
	@Column(length=40)
	private String createBy;
	@Column(length=40)
	private String createAt;
	@Column(length=40)
	private String updateBy;
	@Column(length=40)
	private String updateAt;
	@Column(length=40)
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getThingClassesId() {
		return thingClassesId;
	}
	public void setThingClassesId(Integer thingClassesId) {
		this.thingClassesId = thingClassesId;
	}
	public String getThingQuadrant() {
		return thingQuadrant;
	}
	public void setThingQuadrant(String thingQuadrant) {
		this.thingQuadrant = thingQuadrant;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
