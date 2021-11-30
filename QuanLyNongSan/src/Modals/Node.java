package Modals;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Node implements Serializable {

	private NongSan nongSan;
	private KhachHang khachHang;
	private HoaDon hoaDon;
	Node prev;
	Node next;

	public Node() {

	}

	public Node(NongSan nongSan) {
		this.nongSan = nongSan;
		prev = next = null;

	}

	public Node(KhachHang khachHang) {
		this.khachHang = khachHang;
		prev = next = null;
	}

	public Node(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
		prev = next = null;
	}

	// ____________________________________________________________________________________________________
	// In nông sản
	public void PrintNS() {
		System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", this.nongSan.getIdNs(),
				this.nongSan.getTenNs(),this.nongSan.getSoLuong(),
				this.nongSan.getDonViTinh(), this.nongSan.getGia());
	}

	// check Id nông sản
	public boolean searchNsById(int Id) {
		if (this.nongSan.getIdNs() == Id) {
			return true;
		} else
			return false;

	}

	// Sửa tên nông sản
	public void editNameNS(String nameNS) {
		this.nongSan.setTenNs(nameNS);
	}

	// Sửa số lượng NS
	public void editQuantityNS(int quan) {
		this.nongSan.setSoLuong(quan);
	}

	// Sửa giá NS
	public void editPriceNS(float price) {
		this.nongSan.setGia(price);
	}

	// Sửa đơn vị tính NS
	public void editDvtNS(String dvt) {
		this.nongSan.setDonViTinh(dvt);
	}

	// So sánh tên
	public boolean sortByNameNS(Node tempAp) {

		if (this.nongSan.getTenNs().compareToIgnoreCase(tempAp.nongSan.getTenNs()) > 0) {
			return true;
		}
		return false;
	}

	// so sánh số lượng
	public boolean sortByQuantity(Node tempAp) {

		if (this.nongSan.getSoLuong() > tempAp.nongSan.getSoLuong()) {
			return true;
		}
		return false;
	}

	// Đổi vị trí
	public void convert(Node tempAp) {
		int id = this.nongSan.getIdNs();
		String name = this.nongSan.getTenNs();
		int quantity = this.nongSan.getSoLuong();
		float price = this.nongSan.getGia();
		String dvt = this.nongSan.getDonViTinh();

		this.nongSan.setIdNs(tempAp.nongSan.getIdNs());
		this.nongSan.setTenNs(tempAp.nongSan.getTenNs());
		this.nongSan.setSoLuong(tempAp.nongSan.getSoLuong());
		this.nongSan.setGia(tempAp.nongSan.getGia());
		this.nongSan.setDonViTinh(tempAp.nongSan.getDonViTinh());

		tempAp.nongSan.setIdNs(id);
		tempAp.nongSan.setTenNs(name);
		tempAp.nongSan.setSoLuong(quantity);
		tempAp.nongSan.setGia(price);
		tempAp.nongSan.setDonViTinh(dvt);

	}

	// so sánh số lượng < 10
	public boolean nsSoulOut() {
		if (this.nongSan.getSoLuong() < 10) {
			return true;
		} else
			return false;

	}

	// getNameNs
	public String getNameNs() {

		return this.nongSan.getTenNs();
	}

	// getPriceNs
	public float getPriceNs() {

		return this.nongSan.getGia();
	}

	// getQuaNs
	public int getQuaNs() {
		return this.nongSan.getSoLuong();
	}

	// updateQuaNs
	public void updateQuaNs(int quantity) {
		this.nongSan.setSoLuong(this.nongSan.getSoLuong() - quantity);
	}

	public NongSan getNongSan() {
		NongSan ns = new NongSan(this.nongSan.getIdNs(), this.nongSan.getTenNs(), this.nongSan.getSoLuong(),
				this.nongSan.getGia(), this.nongSan.getDonViTinh());
		return ns;
	}

//____________________________________________________________________________________________________-

	// In Khách hàng
	public void PrintKH() {
		System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", this.khachHang.getIdKh(), this.khachHang.getTenKh(),
				this.khachHang.getDiaChi(), this.khachHang.getSdtKh(), this.khachHang.getEmail());
	}

	// check Id khách hàng
	public boolean searchKhById(int Id) {
		if (this.khachHang.getIdKh() == Id) {
			return true;
		} else
			return false;

	}

	// So sánh tên
	public boolean sortByNameKH(Node tempAp) {
		String Bname = new StringBuffer(this.khachHang.getTenKh()).
			      reverse().toString();
		String Aname =  new StringBuffer(tempAp.khachHang.getTenKh()).
			      reverse().toString();

		if (Bname.compareToIgnoreCase(Aname) > 0) {
			return true;
		}
		return false;
	}

	// Đổi vị trí
	public void convertKH(Node tempAp) {
		int id = this.khachHang.getIdKh();
		String name = this.khachHang.getTenKh();
		String diachi = this.khachHang.getDiaChi();
		String sdt = this.khachHang.getSdtKh();
		String email = this.khachHang.getEmail();

		this.khachHang.setIdKh(tempAp.khachHang.getIdKh());
		this.khachHang.setTenKh(tempAp.khachHang.getTenKh());
		this.khachHang.setDiaChi(tempAp.khachHang.getDiaChi());
		this.khachHang.setSdtKh(tempAp.khachHang.getSdtKh());
		this.khachHang.setEmail(tempAp.khachHang.getEmail());

		tempAp.khachHang.setIdKh(id);
		tempAp.khachHang.setTenKh(name);
		tempAp.khachHang.setDiaChi(diachi);
		tempAp.khachHang.setSdtKh(sdt);
		tempAp.khachHang.setEmail(email);

	}

	// Sửa tên KH
	public void editNameKH(String nameKH) {
		this.khachHang.setTenKh(nameKH);
	}

	// Sửa địa chỉ KH
	public void editAddKH(String add) {
		this.khachHang.setDiaChi(add);
	}

	// Sửa sđt KH
	public void editSdtKH(String sdt) {
		this.khachHang.setSdtKh(sdt);
	}

	// Sửa email
	public void editEmailKH(String email) {
		this.khachHang.setEmail(email);
	}

	// Tìm theo địa chỉ
	public boolean KhByAdd(String add) {
		if (this.khachHang.getDiaChi().contains(add.trim()) || this.khachHang.getDiaChi().equalsIgnoreCase("/*"+add +"*/")) {
			return true;
		}
		return false;
	}

	public KhachHang addKhachHang() {
		KhachHang kh = new KhachHang(this.khachHang.getIdKh(),this.khachHang.getTenKh(), this.khachHang.getDiaChi(),
				this.khachHang.getSdtKh(), this.khachHang.getEmail());
		return kh;
	}

}
