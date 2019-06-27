package com.magang_ITS.magang_ITS_new_java.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.magang_ITS.magang_ITS_new_java.message.BaseResponse;
import com.magang_ITS.magang_ITS_new_java.message.DataPegawaiRequest;
import com.magang_ITS.magang_ITS_new_java.message.SaveRequest;
import com.magang_ITS.magang_ITS_new_java.model.Asset;
import com.magang_ITS.magang_ITS_new_java.model.MasterData;
import com.magang_ITS.magang_ITS_new_java.model.User;
import com.magang_ITS.magang_ITS_new_java.repository.AssetPegawaiRepository;
import com.magang_ITS.magang_ITS_new_java.repository.DataPegawaiRepository;
import com.magang_ITS.magang_ITS_new_java.repository.NotifRepository;
import com.magang_ITS.magang_ITS_new_java.services.OlahDataServices;

@Service("OlahDataService")
public class OlahDataServiceImpl implements OlahDataServices {

	@Autowired
	private DataPegawaiRepository dataPegawaiRepository;

	@Autowired
	private AssetPegawaiRepository assetPegawaiRepository;

	@Autowired
	private NotifRepository notifRepository;

	@Override
	public String simpan(DataPegawaiRequest request) {

		Asset asset = new Asset(request.getKendaraan());
		asset = assetPegawaiRepository.save(asset);

		User user = new User(asset, request.getName(), request.getEmail());
		user = dataPegawaiRepository.save(user);
		return "ok";
	}

	@Override
	public Object saveData(SaveRequest request) {
		MasterData masterData = new MasterData(request.getUserId(), request.getTokenDevice(), request.getChannel(),
				request.getSystemOperasi());
		masterData = notifRepository.save(masterData);
		BaseResponse response = new BaseResponse();
		response.setMessage("Data yang masuk adalah: " + request.getUserId() + " , " + request.getTokenDevice() + " , "
				+ request.getChannel() + " , " + request.getSystemOperasi());
		response.setStatus("Berhasil");
		return response;
	}

}
