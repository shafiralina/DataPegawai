package com.magang_ITS.magang_ITS_new_java.services.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.magang_ITS.magang_ITS_new_java.message.BaseResponse;
import com.magang_ITS.magang_ITS_new_java.message.DataPegawaiRequest;
import com.magang_ITS.magang_ITS_new_java.message.SendAllRequest;
import com.magang_ITS.magang_ITS_new_java.model.Asset;
import com.magang_ITS.magang_ITS_new_java.model.User;
import com.magang_ITS.magang_ITS_new_java.repository.AssetPegawaiRepository;
import com.magang_ITS.magang_ITS_new_java.repository.DataPegawaiRepository;
import com.magang_ITS.magang_ITS_new_java.services.OlahDataServices;

@Service("OlahDataService")
public class OlahDataServiceImpl implements OlahDataServices {

	@Autowired
	private DataPegawaiRepository dataPegawaiRepository;

	@Autowired
	private AssetPegawaiRepository assetPegawaiRepository;


	@Override
	public String simpan(DataPegawaiRequest request) {

		Asset asset = new Asset(request.getKendaraan());
		asset = assetPegawaiRepository.save(asset);

		User user = new User(asset, request.getName(), request.getEmail());
		user = dataPegawaiRepository.save(user);
		return "ok";
	}

	@Override
	public Object sendAll(SendAllRequest request) throws IOException {
		BaseResponse response = new BaseResponse();
		response.setMessage("HTTP 200");
		response.setStatus("Berhasil");
		return response;
	}

	@Override
	public Object sendOne(String request) {
		BaseResponse response = new BaseResponse();
		response.setStatus("Berhasil");
		return response;
		
	}

}
