package Services;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Modals.DLList;
import Modals.Node;
import Modals.NongSan;
import Modals.KhachHang;

public class KhachHangService {

	static Scanner input = new Scanner(System.in);
	static String nameKH;
	static String diachi;
	static String sdt;
	static String email;
	static int id;

	//
	public static void MenuKH() {
		do {
			System.out.println();
			System.out.println("\n|------------------------------ Quản lý khách hàng -----------------------------|");
			System.out.println("|                                                                               |");
			System.out.println("|1. Hiển thị thông tin tất cả khách hàng                                        |");
			System.out.println("|2. Tìm kiếm khách hàng theo id                                                 |");
			System.out.println("|3. Thêm khách hàng vào hệ thống                                                |");
			System.out.println("|4. Sửa thông tin khách hàng trên hệ thống                                      |");
			System.out.println("|5. Xóa khách hàng khỏi hệ thống theo id                                        |");
			System.out.println("|6. Sắp xếp khách hàng theo tên                                                 |");
			System.out.println("|7. Chèn thêm khách hàng sau khách hàng khác (Id)                               |");
			System.out.println("|8. Hiện thông tin các khách hàng theo địa chỉ cụ thể                           |");
			System.out.println("|0. Quay lại.                                                                   |");
			System.out.println("|_______________________________________________________________________________|");
			while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
				;
			switch (id) {
			case 1:
				renderKH();
				break;
			case 2:
				searchKhById();
				break;
			case 3:
				addKH();
				break;
			case 4:
				editKH();
				break;
			case 5:
				deleteKHbyId();
				break;
			case 6:
				sortByNameKH();
				break;
			case 7:
				insertKH();
				break;
			case 8:
				KhByAdd();
				break;
			case 0:
				break;
			default:
				System.out.println("Bạn hãy nhập lại");
			}
		} while (id != 0);

	}


	// khởi tạo danh sách khách hàng
	public static void allKH() {

		DLList listKH = new DLList();
		FileHandle file = new FileHandle();

		Node node1 = new Node(new KhachHang("Trần Thu Q", "An Cựu, Huế", "123123123", "QQ@gmail.com"));
		Node node2 = new Node(new KhachHang("Đỗ Thị H", "Phước Vĩnh, Huế", "234252342", "Dhh@gmail.com"));
		Node node3 = new Node(new KhachHang("Cao Văn T", "Đà Nẵng", "567567566", "Tcc@gmail.com"));
		Node node4 = new Node(new KhachHang("Nguyễn A", "Quảng Trị", "575673342", "Naa@gmail.com"));
		Node node5 = new Node(new KhachHang("Phạm K", "Phú Hội, Huế", "98978978978", "KP@gmail.com"));
		Node node6 = new Node(new KhachHang("Lương Mạnh H", "An Cựu, Huế", "181919198", "Lmh@gmail.com"));
		Node node7 = new Node(new KhachHang("Nguyễn Kỳ D", "Quảng Điền, Huế", "858382902", "KD@gmail.com"));
		Node node8 = new Node(new KhachHang("Trương Hoàng K", "Vỹ Dạ, Huế", "381084011", "THK@gmail.com"));
		Node node9 = new Node(new KhachHang("Lê Thị M", "Đà Nẵng", "24325611312", "LLL@gmail.com"));
		Node node10 = new Node(new KhachHang("Nguyễn Xuân H", "Trường An, Huế", "905585857", "NXH@gmail.com"));

		listKH.Add(node1);
		listKH.Add(node2);
		listKH.Add(node3);
		listKH.Add(node4);
		listKH.Add(node5);
		listKH.Add(node6);
		listKH.Add(node7);
		listKH.Add(node8);
		listKH.Add(node9);
		listKH.Add(node10);

		file.writeDDL(listKH, "dsKhachHang.txt");

	}

	// render khách hàng
	public static void renderKH() {
		DLList listKH = new DLList();
		FileHandle file = new FileHandle();
		listKH = file.readDDL("dsKhachHang.txt");
		listKH.printKH("Danh sách khách hàng trống");

	}
	
	


	// tìm khách hàng theo id
	private static void searchKhById() {
		FileHandle file = new FileHandle();
		DLList listKH = file.readDDL("dsKhachHang.txt");
		DLList listNSnew = new DLList();
		Node node = new Node();

		System.out.println("Nhập số id Khách hàng cần tìm:");
		while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
			;

		node = listKH.searchKhById(id);
		if (node != null) {
			listNSnew.Add(node);
			listNSnew.printKH("Danh sách khách hàng trống");
		} else {
			System.out.println("Không tìm thấy Khách hàng có Id = " + id + " trong hệ thống");
		}
	}

	// Thêm Nông sản
	private static void addKH() {
		System.out.println("Bạn muốn thêm bao nhiêu khách hàng");
		while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
			;

		FileHandle file = new FileHandle();
		DLList listKH = file.readDDL("dsKhachHang.txt");

		for (int i = 0; i < id; i++) {
			System.out.printf("Mời bạn nhập sản phẩm thứ %d", i + 1);
			System.out.println("\nNhập tên khách hàng: ");
			while (!checkName(input.nextLine()))
				;
			System.out.println("Nhập địa chỉ khách hàng: ");
			while (!checkAdd(input.nextLine()))
				;
			System.out.println("Nhập số điện thoại của khách hàng: ");
			while (!checkSdt(input.nextLine()))
				;
			System.out.println("\nNhập email của khách hàng: ");
			while (!checkEmail(input.nextLine()))
				;

			Node node1 = new Node(new KhachHang(nameKH, diachi, sdt, email));
			listKH.Add(node1);
			file.writeDDL(listKH, "dsKhachHang.txt");
		}
		System.out.println("\nKhách hàng đã được thêm vào hệ thống");

	}

	// Xóa KH theo Id
	private static void deleteKHbyId() {
		FileHandle file = new FileHandle();
		DLList listKH = file.readDDL("dsKhachHang.txt");
		Node node = new Node();

		System.out.println("Nhập số id Khách hàng cần xóa:");
		while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
			;
		node = listKH.searchKhById(id);
		int idKh = id;
		if (node != null) {

			System.out.println("|---------------------------- Thông tin khách hàng -----------------------------|");
			System.out.print("|                                                                               |");
			System.out.print("\n|_______________________________________________________________________________|");
			System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên khách hàng", "Địa chỉ", "Số điện thoại",
					"Email");

			node.PrintKH();
			System.out.print("\n|_______________________________________________________________________________|");
			System.out.println("");

			System.out.println("\n                      |------- Bạn muốn xóa khách hàng này -----|");
			System.out.println("                      |                                       |");
			System.out.println("                      |1. Xóa                                 |");
			System.out.println("                      |2. Hủy                                 |");
			System.out.println("                      |_______________________________________|");

			while (!checkDelete(input.nextLine()))
				;
			switch (id) {
			case 1:
				listKH.deleteKHbyId(idKh);
				file.writeDDL(listKH, "dsKhachHang.txt");
				System.out.println("Đã xóa Khách hàng có Id = " + idKh + " trong hệ thống");
				break;
			case 2:
				System.out.println("Đã hủy thao tác xóa");
				break;
			default:
				System.err.println("Không hợp lệ. Xin mời bạn nhập lại!!");
			}

		} else {
			System.out.println("Không tìm thấy Khách hàng có Id = " + idKh + " trong hệ thống");
		}
	}

	// Sắp xếp theo tên
	private static void sortByNameKH() {
		FileHandle file = new FileHandle();
		DLList listKH = file.readDDL("dsKhachHang.txt");
		;

		listKH.sortByNameKH();
		System.out.println("Danh sách Khách hàng được sắp xếp theo tên");
		System.out.println();
		listKH.printKH("Danh sách khách hàng trống");
	}

	// Chèn sản phẩm sau sản phẩm khác
	private static void insertKH() {
		FileHandle file = new FileHandle();
		DLList listKH = file.readDDL("dsKhachHang.txt");

		while (true) {
			System.out.println("Nhập số id vị trí Khách hàng bạn muốn chèn:");
			while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
				;

			if (listKH.searchKhById(id) != null) {
				break;
			}
			;
			System.out.println("Không có khách hàng có Id =" + id + " trong hệ thống");
			System.out.println();
		}

		System.out.println("\nNhập tên của Khách hàng cần chèn: ");
		while (!checkName(input.nextLine()))
			;
		System.out.println("Nhập địa chỉ của khách hàng cần chèn: ");
		while (!checkAdd(input.nextLine()))
			;
		System.out.println("Nhập giá số điện thoại của khách hàng cần chèn: ");
		while (!checkSdt(input.nextLine()))
			;
		System.out.println("\nNhập email của Khách hàng cần chèn: ");
		while (!checkEmail(input.nextLine()))
			;

		Node node1 = new Node(new KhachHang(nameKH, diachi, sdt, email));
		listKH.insertKhApterId(node1, id);
		file.writeDDL(listKH, "dsKhachHang.txt");
		System.out.println("\nKhách hàng đã được chèn vào hệ thống");
	}

	// Sửa thông tin sản phẩm
	private static void editKH() {
		FileHandle file = new FileHandle();
		DLList listKH = file.readDDL("dsKhachHang.txt");
		Node node1 = new Node();

		System.out.println("Nhập iD Khách hàng bạn muốn sửa:");
		while (!checkId(input.nextLine(), "Vui lòng nhập đúng số liệu"))
			;
		node1 = listKH.searchKhById(id);

		if (node1 != null) {
			System.out.print("\n|_______________________________________________________________________________|");
			System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên khách hàng", "Địa chỉ", "Số điện thoại",
					"Email");
			node1.PrintKH();
			System.out.println("\n");

			System.out.println("                      |--------- Bạn muốn sửa thông tin gì -------|");
			System.out.println("                      |                                           |");
			System.out.println("                      |1. Tên Khách hàng                          |");
			System.out.println("                      |2. Địa chỉ của Khách hàng                  |");
			System.out.println("                      |3. Số điện thoại của Khách hàng            |");
			System.out.println("                      |4. Email của Khách hàng                    |");
			System.out.println("                      |0. Hủy          .                          |");
			System.out.println("                      |_________________________________    ______|");

			while (!checkUpdate(input.nextLine()))
				;

			switch (id) {
			case 1:
				System.out.println("\nNhập lại tên Khách hàng bạn muốn sửa: ");
				while (!checkName(input.nextLine()))
					;
				listKH.editNameKH(node1, nameKH);
				file.writeDDL(listKH, "dsKhachHang.txt");
				System.out.println("\nĐã sửa tên Khách hàng thành công!!! ");
				break;
			case 2:
				System.out.println("Nhập lại địa chỉ khách hàng bạn muốn sửa: ");
				while (!checkAdd(input.nextLine()))
					;
				listKH.editAddKH(node1, diachi);
				file.writeDDL(listKH, "dsKhachHang.txt");
				System.out.println("\nĐã sửa địa chỉ khách hàng thành công!!! ");
				break;
			case 3:
				System.out.println("Nhập lại số điện thoại muốn sửa của khách hàng: ");
				while (!checkSdt(input.nextLine()))
					;
				listKH.editSdtKH(node1, sdt);
				file.writeDDL(listKH, "dsKhachHang.txt");
				System.out.println("\nĐã sửa số điện thoại khách hàng thành công!!! ");
				break;
			case 4:
				System.out.println("\nNhập lại email bạn muốn sửa: ");
				while (!checkEmail(input.nextLine()))
					;
				listKH.editEmailKH(node1, email);
				file.writeDDL(listKH, "dsKhachHang.txt");
				System.out.println("\nĐã sửa email Khách hàng thành công!!! ");
				break;
			case 0:
				System.out.println("Đã hủy thao tác");
				break;
			default:
				System.err.println("Không hợp lệ. Xin mời bạn nhập lại!!");
			}

		} else {

			System.err.println("Không có Khách hàng có Id =" + id + " trong hệ thống");
			System.out.println();
		}

	}

	// Hiển thị danh sách khách hàng theo địa chỉ
	private static void KhByAdd() {

		FileHandle file = new FileHandle();
		DLList listKH = file.readDDL("dsKhachHang.txt");
		List<KhachHang> newList = new LinkedList<>();
		System.out.println("Nhập địa chỉ bạn muốn tìm: ");
		while (!checkAdd(input.nextLine()))
			;

		newList = listKH.KhByAdd(diachi);

		if (newList.size() == 0) {
			System.err.println("Khôn tìm thấy khách hàng có địa chỉ tại " + diachi);
		} else {
			System.out.println("Danh sách khách hàng có địa chỉ tại " + diachi);
			System.out.println();
			System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên khách hàng", "Địa chỉ", "Số điện thoại",
					"Email");
			System.out.print("\n|_______________________________________________________________________________|");
			for (KhachHang kh : newList) {
				
				kh.printKH();
			}
			
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
	private static boolean checkName(String name) {
		if (name != null && !name.isEmpty()) {
			nameKH = name;
			return true;
		} else {
			System.err.println("Vui lòng nhập lại tên khách hàng");
			return false;
		}
	};

	private static boolean checkAdd(String add) {
		if (add != null && !add.isEmpty()) {
			diachi = add;
			return true;
		} else {
			System.err.println("Vui lòng nhập đúng địa chỉ");
			return false;
		}
	}

	private static boolean checkSdt(String input) {
		if (input != null && isNumeric(input)) {
			sdt = input;
			return true;
		} else {
			System.err.println("Vui lòng nhập đúng sđt");
			return false;
		}
	}

	private static boolean checkEmail(String input) {
		if (input != null && input.contains("@") && !input.contains(" ")) {
			email = input;
			return true;
		} else {
			System.err.println("Vui lòng nhập đúng email");
			return false;
		}
	}

	private static boolean checkDelete(String idInput) {

		if ((isNumeric(idInput)) && (Integer.parseInt(idInput) == 1 || Integer.parseInt(idInput) == 2)) {
			id = Integer.parseInt(idInput);
			return true;
		} else {
			System.err.println("Vui lòng nhập đúng thao tác");
			return false;
		}
	}

	private static boolean checkUpdate(String idInput) {

		if ((isNumeric(idInput))
				&& (Integer.parseInt(idInput) == 1 || Integer.parseInt(idInput) == 2 || Integer.parseInt(idInput) == 3
						|| Integer.parseInt(idInput) == 4 || Integer.parseInt(idInput) == 0)) {
			id = Integer.parseInt(idInput);
			return true;
		} else {
			System.err.println("Vui lòng nhập đúng thao tác");
			return false;
		}
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

}
