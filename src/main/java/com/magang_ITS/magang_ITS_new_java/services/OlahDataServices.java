package com.magang_ITS.magang_ITS_new_java.services;

import java.io.IOException;

import com.magang_ITS.magang_ITS_new_java.message.DataPegawaiRequest;
import com.magang_ITS.magang_ITS_new_java.message.SendAllRequest;

public interface OlahDataServices {

	public String simpan(DataPegawaiRequest request);
	
	
	public Object sendAll(SendAllRequest request) throws IOException;
	public Object sendOne(String request);
	
}
