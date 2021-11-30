package Modals;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import Services.FileHandle;

public class TaiKhoan implements Serializable{
	private String taiKhoan;
	private String matKhau;
	
	public TaiKhoan() {
	}

	public TaiKhoan(String taiKhoan, String matKhau) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public void allTaiKhoan() {
		FileHandle file = new FileHandle();
		TaiKhoan t1 = new TaiKhoan("nguyentran","111111");
		TaiKhoan t2 = new TaiKhoan("nguyentran2","222222");
		TaiKhoan t3 = new TaiKhoan("nguyentran3","333333");
		
		List<TaiKhoan> list = new LinkedList<>();
		list.add(t1);
		list.add(t2);
		list.add(t3);
		file.write(list,"dstaikhoan.txt");
	}
	
}
