package com.magang_ITS.magang_ITS_new_java.services;

import java.io.IOException;

import com.magang_ITS.magang_ITS_new_java.message.DataPegawaiRequest;
import com.magang_ITS.magang_ITS_new_java.message.DataPegawaiResponse;

public interface OlahDataServices {

	public String simpan(DataPegawaiRequest request);

	public Object data(DataPegawaiRequest dataPegawaiRequest) throws IOException;

}
