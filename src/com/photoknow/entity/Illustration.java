package com.photoknow.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="illustration")
@NamedQueries({
	@NamedQuery(name="Illustration.findLikeName",
			query="select i from Illustration i where i.name like :name"),
	@NamedQuery(name="Illustration.findAll",
			query="select i from Illustration i"
			),
	@NamedQuery(name="Illustration.findById",
			query="select i from Illustration i where i.id =:id"
			)
})
public class Illustration {
	@Id
	@Column(length=40)
	private String id;
	
	@Column(length=100)
	private String artworkpath;
	
	@Column(length=100)
	private String thumbnailpath;
	
	@Column(length=50)
	private String name;
	
	@Column(length=200)
	private String description;
	
	@Column(length=50)
	private String createBy;
	
	private Date createAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArtworkpath() {
		return artworkpath;
	}

	public void setArtworkpath(String artworkpath) {
		this.artworkpath = artworkpath;
	}

	public String getThumbnailpath() {
		return thumbnailpath;
	}

	public void setThumbnailpath(String thumbnailpath) {
		this.thumbnailpath = thumbnailpath;
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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
}
