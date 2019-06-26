package com.magang_ITS.magang_ITS_new_java.message;

public class Pegawai {
	
	private String nama;
	private String umur;
	private String kelamin;
	
	public Pegawai(String nama, String umur, String kelamin){
		this.nama=nama;
		this.umur=umur;
		this.kelamin=kelamin;
	}
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getUmur() {
		return umur;
	}
	public void setUmur(String umur) {
		this.umur = umur;
	}
	public String getKelamin() {
		return kelamin;
	}
	public void setKelamin(String kelamin) {
		this.kelamin = kelamin;
	}
	
	

}
