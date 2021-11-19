package Modals;

import java.io.Serializable;

public class HoaDon implements Serializable{
	private int idHd;
	private int idKh;
	private int idNs;
	private int soLuong;
	private float thanhTien;
	
	
	public HoaDon() {
	}

	public HoaDon(int idHd, int idKh, int idNs, int soLuong, float thanhTien) {
		super();
		this.idHd = idHd;
		this.idKh = idKh;
		this.idNs = idNs;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public int getIdHd() {
		return idHd;
	}

	public void setIdHd(int idHd) {
		this.idHd = idHd;
	}

	public int getIdKh() {
		return idKh;
	}

	public void setIdKh(int idKh) {
		this.idKh = idKh;
	}

	public int getIdNs() {
		return idNs;
	}

	public void setIdNs(int idNs) {
		this.idNs = idNs;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	public void printDataHD() {
		System.out.println("idHd");
	}
}
