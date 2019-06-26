package com.magang_ITS.magang_ITS_new_java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "jpaasset")
public class Asset {
	
	@Id
	private String id;
	
	@NotNull
	private String kendaraan;

	private String warnaKendaraan;
	
	
	public Asset(){
		
	}
	
	
	public Asset(String kendaraan){
		
		this.kendaraan = kendaraan;
	}
	
	@Id
	@GenericGenerator(strategy = "uuid", name = "system-uuid")
	@GeneratedValue(generator = "system-uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getWarnaKendaraan() {
		return warnaKendaraan;
	}


	public void setWarnaKendaraan(String warnaKendaraan) {
		this.warnaKendaraan = warnaKendaraan;
	}


	public String getKendaraan() {
		return kendaraan;
	}

	public void setKendaraan(String kendaraan) {
		this.kendaraan = kendaraan;
	}
	
	

}
