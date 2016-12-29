package com.photoknow.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Chris on 2016/1/17.
 */
@Entity
@Table(name="idea")
public class Idea implements Serializable {
	@Id
    private String id;
	@Column(length=40)
    private String name;
	@Column(length=1000)
    private String description;
	@Column
    private String userId;
	@Column
    private String thingClassesId;
    @Column(length=40)
    private String remindTime;
    @Column(length=40)
    private String background;
    @Column(length=40)
    private String createBy;
    @Column(length=40)
    private String createAt;
    @Column(length=40)
    private String updateBy;
    @Column(length=40)
    private String updateAt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getRemindTime() {
		return remindTime;
	}
	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
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

	

}
