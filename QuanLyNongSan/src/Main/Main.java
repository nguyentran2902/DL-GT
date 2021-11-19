package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Modals.TaiKhoan;
import Services.FileHandle;
import Services.NongSanService;

public class Main {

	
	static Scanner input = new Scanner(System.in);

	
//____________________main_____________________
	
		public static void main(String[] args) {
			menuDangNhap();
			menuMain();
			
				
			
		}

//___________________menu Đăng nhập________________
		
	public static void menuDangNhap() {
		
		TaiKhoan taikhoan = new TaiKhoan();
		taikhoan.allTaiKhoan();
		FileHandle file = new FileHandle();
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		list = file.read("dstaikhoan.txt");
		
		System.out.println("Đăng nhập vào hệ thống");
		
		while(true) {
			//
			System.out.print("Tài khoản:");
			String name =input.nextLine();
			System.out.print("Mật khẩu:");
			String pass =input.nextLine();
			
			boolean isUser = false;
			//check tài khoản
			for(TaiKhoan tk: list) {
				if ((name.equals(tk.getTaiKhoan()))&&(pass.equals(tk.getMatKhau()))) {
					isUser = true;
					break;
				} 
			};
			
			if(isUser) {
				break;
			} else {
				System.out.println("Tài khoản đăng nhập không đúng, vui lòng đăng nhập lại");
			}
		}
		
	}
	
	
//___________________menuMain_______________________
	
	public static void menuMain() {
		
		NongSanService.allNS();
		int chose;
		do {
			System.out.println("                      |--------- Mời bạn chọn dịch vụ --------|");
			System.out.println("                      |                                       |");
			System.out.println("                      |1. Quản lý nông sản                    |");
			System.out.println("                      |2. Quản lý khách hàng                  |");
			System.out.println("                      |3. Quản lý hóa đơn                     |");
			System.out.println("                      |0. Đóng hệ thống.                      |");
			System.out.println("                      |_______________________________________|");
			
			 chose = input.nextInt();
			switch(chose) {
			case 1:
				NongSanService.MenuNS();
				
				break;
//			case 2:
//				nh.MenuNS();
//				break;
			case 0:
				System.out.println("Đã thoát khỏi hệ thống");
				break;
			default:
				System.err.println("Không hợp lệ. Xin mời bạn nhập lại!!");
			}
		}while(chose !=0);
		System.out.println("Xin cảm ơn !!");
	}
	
	

}
