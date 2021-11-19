package Modals;

import java.io.Serializable;

public class KhachHang implements Serializable{
	private int idKh;
	private String tenKh;
	private String diaChi;
	private String sdtKh;
	private String email;
	
	public KhachHang() {
	}

	public KhachHang(int idKh, String tenKh, String diaChi, String sdtKh, String email) {
		super();
		this.idKh = idKh;
		this.tenKh = tenKh;
		this.diaChi = diaChi;
		this.sdtKh = sdtKh;
		this.email = email;
	}

	public int getIdKh() {
		return idKh;
	}

	public void setIdKh(int idKh) {
		this.idKh = idKh;
	}

	public String getTenKh() {
		return tenKh;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdtKh() {
		return sdtKh;
	}

	public void setSdtKh(String sdtKh) {
		this.sdtKh = sdtKh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void printDataKH() {
		System.out.println("tenKh");
	}
}
