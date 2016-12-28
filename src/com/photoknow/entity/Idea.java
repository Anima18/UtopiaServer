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
	@GeneratedValue
    private Integer id;
	@Column(length=40)
    private String name;
	@Column(length=1000)
    private String description;
	@Column
    private Integer userId;
	@Column
    private Integer thingClassesId;
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

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
