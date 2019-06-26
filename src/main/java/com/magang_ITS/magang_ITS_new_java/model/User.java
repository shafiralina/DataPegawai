package com.magang_ITS.magang_ITS_new_java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "jpauser")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String name;
	

	@NotNull
	private String email;
	
	@ManyToOne
	protected Asset asset;

	

	public User() {
		
	}
	
	public User(Asset asset, String name, String email) {
		this.asset = asset;
		this.name = name;
		this.email = email;
	}
	
	@JoinColumn(name = "asset_id")
	@ManyToOne
	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	
	
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
