package Modals;

import java.io.Serializable;

public class KhachHang implements Serializable {
	private int idKh;
	private String tenKh;
	private String diaChi;
	private String sdtKh;
	private String email;
	private static int IdNs_A = 100;

	public KhachHang() {
		this.idKh = IdNs_A++;
	}

	public KhachHang(String tenKh, String diaChi, String sdtKh, String email) {
		super();
		this.idKh = IdNs_A++;
		this.tenKh = tenKh;
		this.diaChi = diaChi;
		this.sdtKh = sdtKh;
		this.email = email;
	}
	public KhachHang(int idKH,String tenKh, String diaChi, String sdtKh, String email) {
		super();
		this.idKh = idKH;
		this.tenKh = tenKh;
		this.diaChi = diaChi;
		this.sdtKh = sdtKh;
		this.email = email;
	}

	public void printKH() {
		System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", this.getIdKh(), this.getTenKh(),
				this.getDiaChi(), this.getSdtKh(), this.getEmail());
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

}
