package Modals;

import java.io.Serializable;

public class Pair implements Serializable{
	private String tenNs;
	private int soLuong;
	private float gia; 
	
	public Pair() {
	}

	public Pair( String tenNs, int soLuong, float gia) {
		super();
		this.tenNs = tenNs;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	
	

	public String getTenNs() {
		return tenNs;
	}

	public void setTenNs(String tenNs) {
		this.tenNs = tenNs;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}



}
