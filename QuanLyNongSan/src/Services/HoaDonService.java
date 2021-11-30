package Services;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Modals.DLList;
import Modals.HoaDon;
import Modals.NongSan;
import Modals.KhachHang;
import Modals.Node;
import Modals.Pair;

public class HoaDonService {

	static Scanner input = new Scanner(System.in);
	static int idNS;
	static int quantity;
	static float price;
	static int id;

	//
	public static void MenuHD() {
		do {
			System.out.println();
			System.out.println("\n|------------------------------- Quản lý hóa đơn -------------------------------|");
			System.out.println("|                                                                               |");
			System.out.println("|1. Tạo hóa đơn                                                                 |");
			System.out.println("|2. Xuất tất cả hóa đơn                                                         |");
			System.out.println("|3. In hóa đơn theo Id khách hàng                                               |");
			System.out.println("|4. Thống kê doanh thu theo tháng                                               |");
			System.out.println("|5. Thống kê sản lượng nông sản tiêu thụ trong tháng                            |");
			System.out.println("|0. Quay lại.                                                                   |");
			System.out.println("|_______________________________________________________________________________|");
			while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
				;
			switch (id) {
			case 1:
				addHD();
				break;
			case 2:
				printHD();
				break;
			case 3:
				printHDByIdKH();
				break;
			case 4:
				Doanhthu();
				break;
			case 5:
				nongSanTieuThu();
				break;

			case 0:
				break;
			default:
				System.err.println("Bạn hãy nhập lại");
			}
		} while (id != 0);

	}

	// khởi tạo danh sách hóa đơn
	@SuppressWarnings("deprecation")
	public static void allHD() {
		Date date1 = new Date();
		Date date2 = new Date();
		Date date3 = new Date();
		List<HoaDon> listHD = new LinkedList<>();
		FileHandle file = new FileHandle();

		Pair p1 = new Pair("Cà rốt", 2, 50000);
		Pair p2 = new Pair("Cà chua", 1, 25000);
		Pair p3 = new Pair("Dưa leo", 4, 13000);
		Pair p4 = new Pair("Rau muống", 3, 10000);
		Pair p5 = new Pair("Khoai tây", 1, 33000);
		Pair p6 = new Pair("Cam", 2, 60000);

		List<Pair> listNs1 = new LinkedList<>();
		listNs1.add(p1);
		listNs1.add(p2);
		listNs1.add(p3);

		List<Pair> listNs2 = new LinkedList<>();
		listNs2.add(p4);
		listNs2.add(p5);

		List<Pair> listNs3 = new LinkedList<>();
		listNs3.add(p4);
		listNs3.add(p5);
		listNs3.add(p6);

		date1.setDate(23);
		date1.setMonth(9);
		date2.setDate(23);
		date3.setDate(24);
		HoaDon hd1 = new HoaDon(102, listNs1, date1, 177000);
		HoaDon hd2 = new HoaDon(104, listNs2, date2, 66000);
		HoaDon hd3 = new HoaDon(106, listNs3, date3, 186000);

		listHD.add(hd1);
		listHD.add(hd2);
		listHD.add(hd3);

		file.write(listHD, "dsHoaDon.txt");

	}

	// Tạo hóa đơn
	private static void addHD() {
		Date date = new Date();
		FileHandle file = new FileHandle();
		DLList listKH = file.readDDL("dsKhachHang.txt");

		int idKh;
		String nameNS;
		float price;
		int slKho;
		System.out.println("Bạn đang tạo hóa đơn");

		// Nhập và check id khách hàng
		while (true) {

			System.out.println("Nhập id khách hàng mua hàng");
			while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
				;

			Node nodeKh = listKH.searchKhById(id);

			if (nodeKh != null) {
				idKh = id;
				System.out.println("|---------------------------- Thông tin khách hàng -----------------------------|");
				System.out.print("|                                                                               |");
				System.out.print("\n|_______________________________________________________________________________|");
				System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Email");
				nodeKh.PrintKH();
				System.out.println("");
				
				break;
			} else {
				System.err.println("Không tìm thấy Khách hàng có Id = " + id + " trong hệ thống");
			}
			;
		}

		// Nhập và check sản phẩm đã mua
		System.out.println("\nNhập số hàng hóa khách hàng đã mua");
		while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
			;
		float totalPrice = 0;
		List<Pair> dsMua = new LinkedList<>();

		for (int i = 0; i < id; i++) {
			DLList listNS = file.readDDL("dsNongSan.txt");
			Node nodeNs = new Node();
			System.out.printf("Mời bạn nhập sản phẩm thứ %d", i + 1);

			// check iD nông sản
			while (true) {
				System.out.println("\nNhập id sản phẩm: ");
				while (!checkIdNs(input.nextLine()))
					;

				nodeNs = listNS.searchNsById(idNS);
				if (nodeNs != null) {

					nameNS = nodeNs.getNameNs();
					price = nodeNs.getPriceNs();
					slKho = nodeNs.getQuaNs();
					System.out.print(
							"\n|-------------------------------------------------------------------------------|");
					System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên sản phẩm", "Số lượng", "Đơn vị tính",
							"Giá");
					nodeNs.PrintNS();
					break;
				} else {
					System.err.println("Không tìm thấy Nông sản có Id = " + id + " trong hệ thống");
				}
			}

			// Check số lượng Ns
			while (true) {
				System.out.println("\nNhập số lượng mua: ");
				while (!checkQua(input.nextLine()))
					;

				if (quantity > slKho) {
					System.err.println("Số lượng mua đã vượt quá số lượng trong kho");
					System.err.println("Vui lòng nhập lại số lượng");
				} else {
					listNS.updateQuaNs(nodeNs, quantity);
					file.writeDDL(listNS, "dsNongSan.txt");
					break;
				}
			}

			totalPrice = totalPrice + price * quantity;
			dsMua.add(new Pair(nameNS, quantity, price));

		}
		;

		// Gộp các sản phẩm trùng nhau
		for (int a = 0; a < dsMua.size(); a++) {
			for (int b = a + 1; b < dsMua.size(); b++) {

				if (dsMua.get(a).getTenNs().equals(dsMua.get(b).getTenNs())) {
					dsMua.get(a).setSoLuong(dsMua.get(a).getSoLuong() + dsMua.get(b).getSoLuong());
					dsMua.remove(b);
				}

			}
		}

		//
		List<HoaDon> ListHD = file.read("dsHoaDon.txt");

		HoaDon hd1 = new HoaDon(idKh, dsMua, date, totalPrice);
		ListHD.add(hd1);
		file.write(ListHD, "dsHoaDon.txt");
		
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------Thông tin hóa đơn--------------------------------");
		System.err.println("\n|_______________________________________________________________________________|");
		hd1.printHeader();
		hd1.printKH();
		hd1.printListNs();
		System.out.println("\n|_______________________________________________________________________________|");
		System.out.println("");
		System.out.println("");
		System.out.println("Đã đã tạo hóa đơn thành công!!!");
	}
	
	
	

	// _________________________________printHD___________________________________________________
	
	private static void printHD() {
		System.out.println("--------------------------------Danh sách hóa đơn--------------------------------");
		
		FileHandle file = new FileHandle();
		List<HoaDon> listHd = file.read("dsHoaDon.txt");

		for (int i = 0; i < listHd.size(); i++) {

			listHd.get(i).printHeader();
			listHd.get(i).printKH();
			listHd.get(i).printListNs();
			System.out.print("\n|                                                                               |");
			System.err.print("\n|_______________________________________________________________________________|");
			System.out.print("\n");
			System.out.print("\n");
		}
	}

	// In hóa đơn theo Id khách hàng
	private static void printHDByIdKH() {
		FileHandle file = new FileHandle();
		List<HoaDon> listHd = file.read("dsHoaDon.txt");

		// Nhập và check id khách hàng
		System.out.println("Nhập id khách hàng mua hàng");
		while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
			;

		List<HoaDon> newList = new LinkedList<>();

		for (int i = 0; i < listHd.size(); i++)

			if (listHd.get(i).getIdKh() == id) {

				newList.add(listHd.get(i));
			}

		// In

		if (newList.size() == 0) {
			System.err.println("Không tìm thấy hóa đơn của Khách hàng có Id = " + id + " trong hệ thống");
		} else {
			for (int i = 0; i < newList.size(); i++) {
				System.out.println("-------------------- Danh sách hóa đơn Khách hàng có Id = "
						+ newList.get(i).getIdKh() + " -------------------");
				newList.get(i).printHeader();
				newList.get(i).printKH();
				newList.get(i).printListNs();
				System.out.print("\n|                                                                               |");
				System.err.print("\n|_______________________________________________________________________________|");
				System.out.print("\n");
				System.out.print("\n");
			}
		}
		;

	}

	// Doanh thu
	private static void Doanhthu() {
		System.out.println("Bạn muốn thống kê doanh thu tháng mấy?");
		while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
			;

		FileHandle file = new FileHandle();
		List<HoaDon> listHd = file.read("dsHoaDon.txt");
		List<HoaDon> newList = new LinkedList<>();
		double doanhThu = 0;

		for (HoaDon hd : listHd) {
			if (hd.getDate().getMonth() == id - 1) {
				newList.add(hd);
				doanhThu = doanhThu + hd.getThanhTien();
			}
		}
		System.out.println("------------------------------- Doanh thu tháng " + id + " ------------------------------");
		System.out.printf("\n|%10s|%36s|%31s|", "DT tháng", "Tổng số đơn", "Doanh thu(vnđ)");
		System.out.printf("\n|%10s|%36s|%31s|", id, newList.size(), doanhThu);
		System.err.println("\n|_______________________________________________________________________________|");
		System.err.println("|_______________________________________________________________________________|");
		for (HoaDon hd : newList) {
			hd.printHeader();
		}

	}

	// Top nông sản tiêu thụ trong tháng
	private static void nongSanTieuThu() {

		System.out.println("Bạn muốn thống kê top nông sản tiêu thụ tháng mấy?");
		while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
			;

		FileHandle file = new FileHandle();
		List<HoaDon> listHd = file.read("dsHoaDon.txt");
		List<Pair> newList = new LinkedList<>();

		// Lọc hóa đơn lấy danh sách nông sản
		for (HoaDon hd : listHd) {
			if (hd.getDate().getMonth() == id - 1) {
				for (int i = 0; i < hd.getList().size(); i++) {
					String name = hd.getList().get(i).getTenNs();
					int quan = hd.getList().get(i).getSoLuong();
					float price = hd.getList().get(i).getGia();
					Pair p = new Pair(name, quan, price);
					newList.add(p);
				}
			}
		}
		// Gộp các sản phẩm trùng nhau
		for (int a = 0; a < newList.size(); a++) {
			for (int b = a + 1; b < newList.size(); b++) {

				if (newList.get(a).getTenNs().equals(newList.get(b).getTenNs())
						&& newList.get(a).getGia() == newList.get(b).getGia()) {
					newList.get(a).setSoLuong(newList.get(a).getSoLuong() + newList.get(b).getSoLuong());
					newList.remove(b);
				}

			}
		}
		
		//Sắp xếp theo số lượng
		for (int a = 0; a < newList.size(); a++) {
			for (int b = a + 1; b < newList.size(); b++) {

				if ( newList.get(a).getSoLuong() < newList.get(b).getSoLuong()) {
					String name = newList.get(a).getTenNs();
					int quan = newList.get(a).getSoLuong();
					float price = newList.get(a).getGia();
					
					newList.get(a).setTenNs(newList.get(b).getTenNs());
					newList.get(a).setSoLuong(newList.get(b).getSoLuong());
					newList.get(a).setGia(newList.get(b).getGia());
					
					newList.get(b).setTenNs(name);
					newList.get(b).setSoLuong(quan);
					newList.get(b).setGia(price);
					
					
				}

			}
		}
		

		System.out.println(
				"-----------------Danh sách nông sản tiêu thụ trong tháng " + id + "" + " ---------------------");
		System.out.printf("\n|%15s|%20s|%20s|%21s|", "Stt", "Tên sản phẩm", "Số lượng bán được", "Giá(vnđ)");
		System.err.print("\n|_______________________________________________________________________________|");
		for (int i = 0; i < newList.size(); i++ ) {
			System.out.printf("\n|%15s|%20s|%20s|%21s|", i+1, newList.get(i).getTenNs(),
					newList.get(i).getSoLuong(), newList.get(i).getGia());

		}
	}

	// Các hàm check input
	private static boolean checkId(String idDe, String mess) {

		if (idDe != null && isNumeric(idDe)) {
			id = Integer.parseInt(idDe);
			return true;
		} else {
			System.err.println(mess);
			return false;
		}
	}

	// check name
	private static boolean checkIdNs(String input) {
		if (input != null && isNumeric(input)) {
			idNS = Integer.parseInt(input);
			return true;
		} else {
			System.err.println("Vui lòng nhập đúng số liệu");
			return false;
		}
	}

	private static boolean checkQua(String qua) {
		if (qua != null && isNumeric(qua) && Integer.parseInt(qua) > 0) {
			quantity = Integer.parseInt(qua);
			return true;
		} else {
			System.err.println("Vui lòng nhập đúng số lượng");
			return false;
		}
	}

	private static boolean checkPrice(String qua) {
		if (qua != null && isNumeric(qua) && Integer.parseInt(qua) > 0) {
			price = Float.parseFloat(qua);
			return true;
		} else {
			System.err.println("Vui lòng nhập đúng giá");
			return false;
		}
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

}
