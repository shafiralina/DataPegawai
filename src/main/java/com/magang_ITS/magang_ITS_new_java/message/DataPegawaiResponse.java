package com.magang_ITS.magang_ITS_new_java.message;

import java.io.Serializable;

public class DataPegawaiResponse implements Serializable {

	/**
	 * @author shafira
	 */
	private static final long serialVersionUID = -8403137745358477142L;
	private String status;
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
