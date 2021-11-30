package Services;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Modals.DLList;
import Modals.Node;
import Modals.NongSan;

public class NongSanService {

	static Scanner input = new Scanner(System.in);
	static String nameNS;
	static int quantity;
	static float price;
	static int id;
	static int count;

	// Menu dịch vụ Nông sản
	public static void MenuNS() {

		do {
			System.out.println();
			System.out.println("\n|----------------------------- Quản lý nông sản --------------------------------|");
			System.out.println("|                                                                               |");
			System.out.println("|1. Hiển thị thông tin các mặt hàng trong kho                                   |");
			System.out.println("|2. Tìm kiếm sản phẩm theo id                                                   |");
			System.out.println("|3. Thêm sản phẩm vào hệ thống                                                  |");
			System.out.println("|4. Sửa thông tin sản phẩm                                                      |");
			System.out.println("|5. Xóa sản phẩm khỏi hệ thống theo id                                          |");
			System.out.println("|6. Chèn thêm sản phẩm sau sản phẩm khác (Id)                                   |");
			System.out.println("|7. Sắp xếp sản phẩm theo số lượng                                              |");
			System.out.println("|8. Sắp xếp sản phẩm theo tên                                                   |");
			System.out.println("|9. Hiện thông tin các mặt hàng gần hết(Số lượng < 10).                         |");
			System.out.println("|0. Quay lại.                                                                   |");
			System.out.println("|_______________________________________________________________________________|");

			while (!checkNumber(input.nextLine(), "Không hợp lệ, xin mời nhập lại"))
				;
			switch (id) {
			case 1:
				renderNS();
				break;
			case 2:
				searchNsById();
				break;
			case 3:
				addNS();
				break;
			case 4:
				editNS();
				break;
			case 5:
				deleteNsbyId();
				break;
			case 6:
				insertNS();
				break;
			case 7:
				sortByQuantity();
				break;
			case 8:
				sortByName();
				break;
			case 9:
				nsSoulOut();
				break;
			case 0:
				break;
			default:
				System.err.println("Không hợp lệ. Bạn hãy nhập lại!!!");
			}
		} while (id != 0);

	}

	// khởi tạo danh sách nông sản
	public static void allNS() {

		DLList listNS = new DLList();
		FileHandle file = new FileHandle();

		Node node1 = new Node(new NongSan("Cà rốt", 8, 50000, "kg"));
		Node node2 = new Node(new NongSan("Khoai tây", 30, 33000, "kg"));
		Node node3 = new Node(new NongSan("Dưa leo", 40, 13000, "kg"));
		Node node4 = new Node(new NongSan("Cà chua", 24, 25000, "kg"));
		Node node5 = new Node(new NongSan("Nho", 13, 150000, "kg"));
		Node node6 = new Node(new NongSan("Cam", 16, 60000, "kg"));
		Node node7 = new Node(new NongSan("Bưởi", 5, 45000, "kg"));
		Node node8 = new Node(new NongSan("Rau xà lách", 26, 18000, "kg"));
		Node node9 = new Node(new NongSan("Rau muống", 18, 10000, "kg"));
		Node node10 = new Node(new NongSan("Trà hoa cúc", 13, 60000, "hộp"));

		listNS.Add(node1);
		listNS.Add(node2);
		listNS.Add(node3);
		listNS.Add(node4);
		listNS.Add(node5);
		listNS.Add(node6);
		listNS.Add(node7);
		listNS.Add(node8);
		listNS.Add(node9);
		listNS.Add(node10);

		file.writeDDL(listNS, "dsNongSan.txt");

	}

	// render sản phẩm
	public static void renderNS() {
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		listNS.printNS("Danh sách nông sản trống");

	}

	// tìm sản phẩm theo id
	private static void searchNsById() {
		DLList listNS = new DLList();
		DLList listNSnew = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		Node node = new Node();

		System.out.println("Nhập số id Nông Sản cần tìm:");
		while (!checkNumber(input.nextLine(), "Vui lòng nhập đúng số liệu"))
			;
		node = listNS.searchNsById(id);
		if (node != null) {
			listNSnew.Add(node);
			listNSnew.printNS("Danh sách nông sản trống");
		} else {
			System.err.println("Không tìm thấy nông sản có Id = " + id + " trong hệ thống");
		}
	}

	// Thêm Nông sản
	private static void addNS() {
		System.out.println("Bạn muốn thêm bao nhiêu sản phẩm");
		while (!checkCount(input.nextLine()))
			;
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");

		for (int i = 0; i < count; i++) {
			System.out.printf("Mời bạn nhập sản phẩm thứ %d", i + 1);
			System.out.println("\nNhập tên sản phẩm: ");
			while (!checkName(input.nextLine()))
				;
			System.out.println("Nhập số lượng: ");
			while (!checkQua(input.nextLine()))
				;
			System.out.println("Nhập giá bán: ");
			while (!checkPrice(input.nextLine()))
				;
			System.out.println("\nNhập đơn vị tính: ");
			String dvt = input.nextLine();

			Node node1 = new Node(new NongSan(nameNS, quantity, price, dvt));
			listNS.Add(node1);
			file.writeDDL(listNS, "dsNongSan.txt");
		}
		System.out.println("\nSản phẩm đã được thêm vào hệ thống");

	}

	// Xóa NS theo Id
	private static void deleteNsbyId() {
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		Node node = new Node();

		System.out.println("Nhập số id Nông Sản cần xóa:");
		while (!checkNumber(input.nextLine(), "Vui lòng nhập đúng số liệu"))
			;
		node = listNS.searchNsById(id);
		int idNS = id;

		if (node != null) {

			System.out.println("|----------------------------- Thông tin sản phẩm ------------------------------|");
			System.out.print("\n|_______________________________________________________________________________|");
			System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên sản phẩm", "Số lượng", "Đơn vị tính",
					"Giá(vnđ)");
			node.PrintNS();
			System.out.print("\n|_______________________________________________________________________________|");
			System.out.println("");

			System.out.println("\n                      |------- Bạn muốn xóa sản phẩm này -----|");
			System.out.println("                      |                                       |");
			System.out.println("                      |1. Xóa                                 |");
			System.out.println("                      |2. Hủy                                 |");
			System.out.println("                      |_______________________________________|");

			while (!checkDelete(input.nextLine()))
				;
			switch (id) {
			case 1:
				listNS.deleteNsbyId(idNS);
				file.writeDDL(listNS, "dsNongSan.txt");
				System.out.println("Đã xóa nông sản có Id = " + idNS + " trong hệ thống");
				break;
			case 2:
				System.out.println("Đã hủy thao tác xóa");
				break;
			default:
				System.err.println("Không hợp lệ. Xin mời bạn nhập lại!!");
			}

		} else {
			System.err.println("Không tìm thấy nông sản có Id = " + idNS + " trong hệ thống");
		}
	}

	// Sửa thông tin sản phẩm
	private static void editNS() {
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		Node node1 = new Node();

		
			System.out.println("Nhập iD Nông sản bạn muốn sửa:");
			while (!checkNumber(input.nextLine(), "Vui lòng nhập đúng số liệu"))
				;
			node1 = listNS.searchNsById(id);

			if (node1 != null) {

				System.out.print("\n|_______________________________________________________________________________|");
				System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên sản phẩm", "Số lượng", "Đơn vị tính",
						"Giá");
				node1.PrintNS();
				System.out.println("\n");

				System.out.println("                      |------- Bạn muốn sửa thông tin gì -----|");
				System.out.println("                      |                                       |");
				System.out.println("                      |1. Tên nông sản                        |");
				System.out.println("                      |2. Số lượng nông sản                   |");
				System.out.println("                      |3. Giá nông sản                        |");
				System.out.println("                      |4. Đơn vị tính                         |");
				System.out.println("                      |0. Hủy          .                      |");
				System.out.println("                      |_______________________________________|");

				while (!checkUpdate(input.nextLine()))
					;

				switch (id) {
				case 1:
					System.out.println("\nNhập lại tên Nông sản bạn muốn sửa: ");
					while (!checkName(input.nextLine()))
						;
					listNS.editNameNS(node1, nameNS);
					file.writeDDL(listNS, "dsNongSan.txt");
					System.out.println("\nĐã sửa tên Nông sản thành công!!! ");
					break;
				case 2:
					System.out.println("Nhập lại số lượng Nông sản bạn muốn sửa: ");
					while (!checkQua(input.nextLine()))
						;
					listNS.editQuantityNS(node1, quantity);
					file.writeDDL(listNS, "dsNongSan.txt");
					System.out.println("\nĐã sửa số lượng Nông sản thành công!!! ");
					break;
				case 3:
					System.out.println("Nhập lại giá bán muốn sửa của Nông sản: ");
					while (!checkPrice(input.nextLine()))
						;
					listNS.editPriceNS(node1, price);
					file.writeDDL(listNS, "dsNongSan.txt");
					System.out.println("\nĐã sửa giá Nông sản thành công!!! ");
					break;
				case 4:
					System.out.println("\nNhập lại đơn vị tính bạn muốn sửa: ");
					String dvt = input.nextLine();
					listNS.editDvtNS(node1, dvt);
					file.writeDDL(listNS, "dsNongSan.txt");
					System.out.println("\nĐã sửa đơn vị tính Nông sản thành công!!! ");
					break;
				case 0:
					System.out.println("Đã hủy thao tác");
					break;
				default:
					System.err.println("Không hợp lệ. Xin mời bạn nhập lại!!");
				}

			} else {

				System.err.println("Không có sản phẩm có Id =" + id + " trong hệ thống");
				System.out.println();
			}
		

	}

	// Sắp xếp theo tên
	private static void sortByName() {
		DLList listNS = new DLList();
		DLList listNSNew = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");

		listNS.sortByName();
		System.out.println("Danh sách sản phẩm được sắp xếp theo tên");
		System.out.println();
		listNS.printNS("Danh sách nông sản trống");
	}

	// Sắp xếp theo số lượng
	private static void sortByQuantity() {
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");

//		listNS.sortByQuantity();
		listNS.SelectionSort();
		System.out.println("Danh sách sản phẩm được sắp xếp theo số lượng");
		System.out.println();
		listNS.printNS("Danh sách nông sản trống");

	}

	// Chèn sản phẩm sau sản phẩm khác
	private static void insertNS() {
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");

		while (true) {
			System.out.println("Nhập số id vị trí Nông sản bạn muốn chèn:");
			while (!checkNumber(input.nextLine(), "Vui lòng nhập đúng số liệu"))
				;
			if (listNS.searchNsById(id) != null) {
				break;
			}
			;
			System.err.println("Không có sản phẩm có Id =" + id + " trong hệ thống");
			System.out.println();
		}

		System.out.println("\nNhập tên sản phẩm cần chèn: ");
		while (!checkName(input.nextLine()))
			;
		System.out.println("Nhập số lượng sản phẩm cần chèn: ");
		while (!checkQua(input.nextLine()))
			;
		System.out.println("Nhập giá bán sản phẩm cần chèn: ");
		while (!checkPrice(input.nextLine()))
			;
		System.out.println("\nNhập đơn vị tính sản phẩm cần chèn: ");
		String dvt = input.nextLine();

		Node node1 = new Node(new NongSan(nameNS, quantity, price, dvt));
		listNS.insertNsApterId(node1, id);
		file.writeDDL(listNS, "dsNongSan.txt");
		System.out.println("\nSản phẩm đã được chèn vào hệ thống");
	}

	// Hiển thị danh sách các sản phẩm gần hết (số lượng < 10)
	private static void nsSoulOut() {
		FileHandle file = new FileHandle();
		DLList listNS = file.readDDL("dsNongSan.txt");
		List<NongSan> newList = new LinkedList();

		newList = listNS.nsSoulOut();

		// Sắp xếp theo số lượng
		for (int a = 0; a < newList.size(); a++) {
			for (int b = a + 1; b < newList.size(); b++) {

				if (newList.get(a).getSoLuong() > newList.get(b).getSoLuong()) {
					int id = newList.get(a).getIdNs();
					String name = newList.get(a).getTenNs();
					int quan = newList.get(a).getSoLuong();
					float price = newList.get(a).getGia();
					String dvt = newList.get(a).getDonViTinh();

					newList.get(a).setIdNs(newList.get(b).getIdNs());
					newList.get(a).setTenNs(newList.get(b).getTenNs());
					newList.get(a).setSoLuong(newList.get(b).getSoLuong());
					newList.get(a).setGia(newList.get(b).getGia());
					newList.get(a).setDonViTinh(newList.get(b).getDonViTinh());

					newList.get(b).setIdNs(id);
					newList.get(b).setTenNs(name);
					newList.get(b).setSoLuong(quan);
					newList.get(b).setGia(price);
					newList.get(b).setDonViTinh(dvt);

				}

			}
		}

		System.out.println("Danh sách sản phẩm sắp hết hàng");
		System.out.println();

		System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên sản phẩm", "Số lượng", "Đơn vị tính", "Giá(vnđ)");
		System.out.print("\n|_______________________________________________________________________________|");
		for (NongSan ns : newList) {

			ns.printNS();
		}

	}

	// Các hàm check input
	private static boolean checkNumber(String idInput, String mess) {

		if (idInput != null && isNumeric(idInput)) {
			id = Integer.parseInt(idInput);
			return true;
		} else {
			System.err.println(mess);
			return false;
		}
	}

	// check name
	private static boolean checkName(String name) {
		if (name != null && !name.isEmpty()) {
			nameNS = name;
			return true;
		} else {
			System.err.println("Vui lòng nhập lại tên sản phẩm");
			return false;
		}
	};

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

	private static boolean checkCount(String cou) {
		if (cou != null && isNumeric(cou) && Integer.parseInt(cou) > 0) {
			count = Integer.parseInt(cou);
			return true;
		} else {
			System.err.println("Vui lòng nhập đúng số sản phẩm");
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
