package Modals;

import java.io.Serializable;

public class NongSan implements Serializable{
	private int idNs;
	private String tenNs;
	private int soLuong;
	private float gia;
	private String donViTinh;
	private static int IdNs_A = 100;
	
	
	public NongSan() {
		this.idNs = IdNs_A++;
	}


	public NongSan( String tenNs, int soLuong, float gia, String donViTinh) {
		super();
		this.idNs = IdNs_A++;
		this.tenNs = tenNs;
		this.soLuong = soLuong;
		this.gia = gia;
		this.donViTinh = donViTinh;
	}
	public NongSan(int idNs, String tenNs, int soLuong, float gia, String donViTinh) {
		super();
		this.idNs = idNs;
		this.tenNs = tenNs;
		this.soLuong = soLuong;
		this.gia = gia;
		this.donViTinh = donViTinh;
	}

	public int getIdNs() {
		return idNs;
	}


	public void setIdNs(int idNs) {
		this.idNs = idNs;
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


	public String getDonViTinh() {
		return donViTinh;
	}


	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}


	public void printNS() {
		System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", this.getIdNs(), this.getTenNs(),
				this.getSoLuong(), this.getDonViTinh(), this.getGia());
	}
	
	
}

