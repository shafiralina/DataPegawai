package com.magang_ITS.magang_ITS_new_java.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magang_ITS.magang_ITS_new_java.message.BaseResponse;
import com.magang_ITS.magang_ITS_new_java.message.Pegawai;
import com.magang_ITS.magang_ITS_new_java.message.SendAllRequest;
import com.magang_ITS.magang_ITS_new_java.model.User;
import com.magang_ITS.magang_ITS_new_java.repository.DataPegawaiRepository;
import com.magang_ITS.magang_ITS_new_java.services.OlahDataServices;

@RestController
public class MagangController {

	@Autowired
	private DataPegawaiRepository pegawaiRepository;

	@Autowired
	OlahDataServices serviceData;

	@GetMapping("/pegawai/{nama}")
	public Pegawai sapaanPagi(@PathVariable String nama) {

		Pegawai data = new Pegawai(nama, "12", "Laki laki");

		return data;

	}

	@GetMapping("/get/all/data")
	public List<User> getAll() {
		List<User> data = (List<User>) pegawaiRepository.findAll();
		return data;
	}

	@RequestMapping(value = { "/response/send/all" }, method = RequestMethod.POST, consumes = {
			MediaType.ALL_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse saveData(HttpServletRequest request, @RequestBody @Valid SendAllRequest objectRequest)
			throws IllegalAccessException, InvocationTargetException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValueAsString(objectRequest);

		Object responses = serviceData.sendAll(objectRequest);
		BaseResponse response = new BaseResponse();
		BeanUtils.copyProperties(responses, response);

		return response;
	}

	@RequestMapping(value = { "/response/send/one" }, method = RequestMethod.GET, consumes = { MediaType.ALL_VALUE })
	@ResponseBody
	public BaseResponse getData(HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		Object responses = serviceData.sendOne("data");
		BaseResponse response = new BaseResponse();
		BeanUtils.copyProperties(responses, response);
		response.setMessage("Berhasil");
		response.setStatus("Alhamdulillah");
		return response;
	}

//	throws IllegalAccessException, InvocationTargetException, IOException

}
