package com.photoknow.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="plan")
@NamedQueries({
	@NamedQuery(name="Plan.getPlanByUserId",
			query="select i from Plan i where i.userId = :userId")
})
public class Plan implements Serializable {
	@Id
    private String id;
	@Column
	private String roleId;
	@Column(length=40)
	private String name;
	@Column(length=1000)
	private String description;
	@Column(length=40)
	private String progress;
	@Column
	private String userId;
	@Column
	private String thingClassesId;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getThingClassesId() {
		return thingClassesId;
	}
	public void setThingClassesId(String thingClassesId) {
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
