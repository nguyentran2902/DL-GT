package Modals;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Services.FileHandle;

public class HoaDon implements Serializable{
	private int idHd;
	private int idKh;
	private List<Pair> list = new LinkedList();
	private Date date;
	private float thanhTien;
	private static int idHdA = 1000;
	
	
	public HoaDon() {
		this.idHd = idHdA++;
	}

	public HoaDon( int idKh, List list,Date date, float thanhTien) {
		super();
		this.idHd = idHdA++;
		this.idKh = idKh;
		this.list = list;
		this.date = date;
		this.thanhTien = thanhTien;
	}
	
	//In Header
	public void printHeader() {
		System.out.printf("\n|%10s|%36s|%31s|", "Id Hóa đơn", "Ngày tạo", 
				"Tổng tiền(vnđ)");
		System.out.printf("\n|%10s|%36s|%31s|","HĐ" + this.getIdHd(), this.getDate(), 
				this.getThanhTien());
		System.out.print("\n|                                                                               |");
		System.out.print("\n|_______________________________________________________________________________|");
		
	}
	
	//in khach hang
	public void printKH() {
		
		FileHandle file = new FileHandle();
		DLList listKH = file.readDDL("dsKhachHang.txt");
		Node node = listKH.searchKhById(this.getIdKh());
		if(node!=null) {
			
		System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "idKH", "Tên khách hàng", 
				"Địa chỉ","Số điện thoại" , "Email");
		node.PrintKH();
		System.out.print("\n|                          _____________________________________________________|");
		} else {
			System.err.println("\nKhách hàng này không tồn tại trong hệ thống");
		}
	}
	
	//In list Ns
	public void printListNs() {
		List<Pair> ListNs = this.getList();
			System.out.printf("\n|%25s|%5s|%15s|%15s|%15s|","", "Stt", "Tên sản phẩm", 
					"Số lượng", "Giá(vnđ)");
			for(int i = 0; i < ListNs.size(); i++ ) {
			System.out.printf("\n|%25s|%5s|%15s|%15s|%15s|","", i+1, ListNs.get(i).getTenNs(),
					ListNs.get(i).getSoLuong(), ListNs.get(i).getGia());
		}
		
		
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

	public List<Pair> getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	


}