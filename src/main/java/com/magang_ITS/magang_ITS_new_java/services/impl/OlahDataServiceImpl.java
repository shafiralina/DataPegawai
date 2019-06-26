package com.magang_ITS.magang_ITS_new_java.services.impl;

import java.io.IOException;
import java.net.SocketTimeoutException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magang_ITS.magang_ITS_new_java.message.DataPegawaiRequest;
import com.magang_ITS.magang_ITS_new_java.message.DataPegawaiResponse;
import com.magang_ITS.magang_ITS_new_java.model.Asset;
import com.magang_ITS.magang_ITS_new_java.model.User;
import com.magang_ITS.magang_ITS_new_java.repository.AssetPegawaiRepository;
import com.magang_ITS.magang_ITS_new_java.repository.DataPegawaiRepository;
import com.magang_ITS.magang_ITS_new_java.services.OlahDataServices;

@Service("OlahDataService")
public class OlahDataServiceImpl implements OlahDataServices {

//	@Value("#{restprop['notif.url']}")
//	private String url;
//
//	@Value("#{restprop['notif.uri']}")
//	private String uri;

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
	public Object data(DataPegawaiRequest dataPegawaiRequest) throws IOException {
		// TODO Auto-generated method stub
		dataPegawaiRequest.setKendaraan("INOVA");
		dataPegawaiRequest.setName("SHAFIRA");
		dataPegawaiRequest.setEmail("Shafira@gmail.com");

		// TODO: kirim hasil datapegawai ke notif dengan panggil url dan uri nya.
		String url = "http://localhost:8001";
		String uri = "/response/magang/";
		PostMethod post = new PostMethod(url + uri);
		// panggil object
		HttpClient client = new HttpClient();
		Object messageSend = executeCallSilotFeedback(client, post, dataPegawaiRequest);
		return messageSend;
	}

	// objectnya

	private Object executeCallSilotFeedback(HttpClient client, PostMethod post, DataPegawaiRequest dataPegawaiRequest)
			throws IOException {
		String response = null;
		ObjectMapper mapper = new ObjectMapper();

		// TODO: Make String Json to pretty
		String jsonRequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataPegawaiRequest);

		System.out.println("==================== REQUEST FEEDBACK ====================");
		System.out.println(jsonRequest);
		System.out.println("==========================================================");

		StringRequestEntity entity = new StringRequestEntity(jsonRequest, "application/json", null);
		post.setRequestEntity(entity);
		DataPegawaiResponse modelResponse = new DataPegawaiResponse();

		try {
			client.executeMethod(post);
			int statusCodeResponse = post.getStatusCode();
			// JIKA HTTP 200
			if (statusCodeResponse == HttpStatus.OK.value()) {
				DataPegawaiResponse modelResponseSuccess = new DataPegawaiResponse();

				response = post.getResponseBodyAsString();
				modelResponseSuccess = mapper.readValue(response, DataPegawaiResponse.class);

				return modelResponseSuccess;

			} else {
				// TODO SET ERROR HTTP
				return null;
			}

		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return modelResponse;

	}

}
