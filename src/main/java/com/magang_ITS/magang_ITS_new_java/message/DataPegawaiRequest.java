package com.magang_ITS.magang_ITS_new_java.message;

public class DataPegawaiRequest {
	private String kendaraan;
	private String name;
	private String email;

	public DataPegawaiRequest(String kendaraan, String name, String email) {
		this.kendaraan = kendaraan;
		this.name = name;
		this.email = email;
	}

	public String getKendaraan() {
		return kendaraan;
	}

	public void setKendaraan(String kendaraan) {
		this.kendaraan = kendaraan;
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
