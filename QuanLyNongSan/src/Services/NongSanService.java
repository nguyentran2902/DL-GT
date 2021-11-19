package Services;

import java.util.Scanner;

import Modals.DLList;
import Modals.Node;
import Modals.NongSan;

public class NongSanService {
	
	static Scanner input = new Scanner(System.in);
	static String nameNS;
	static int  quantity;
	static float  price;
	static int id;
	static int count;
	//
	public static void MenuNS() {
		int chose;
		do {
			System.out.println();
			System.out.println("|----------------------------- Quản lý nông sản --------------------------------|");
			System.out.println("|                                                                               |");
			System.out.println("|1. Hiển thị thông tin các mặt hàng trong kho                                   |");
			System.out.println("|2. Tìm kiếm sản phẩm theo id                                                   |");
			System.out.println("|3. Thêm sản phẩm vào hệ thống                                                  |");
			System.out.println("|4. Xóa sản phẩm khỏi hệ thống theo id                                          |");
			System.out.println("|5. Sắp xếp sản phẩm theo tên                                                   |");
			System.out.println("|6. Sắp xếp sản phẩm theo số lượng                                              |");
			System.out.println("|7. Chèn thêm sản phẩm sau sản phẩm khác (Id)                                   |");
			System.out.println("|8. Hiện thông tin các mặt hàng gần hết(Số lượng < 10).                         |");
			System.out.println("|0. Quay lại.                                                                   |");
			System.out.println("|_______________________________________________________________________________|");
			chose =Integer.parseInt(input.nextLine());
			switch(chose) {
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
				deleteNsbyId();
				break;
			case 5:
				sortByName();
				break;
			case 6:
				sortByQuantity();
				break;
			case 7:
				insertNS();
				break;
			case 8:
				nsSoulOut();
				break;
			case 0:
				break;
			default:
				System.out.println("Bạn hãy nhập lại");
			}
		} while(chose !=0);
	
	} 
	
	





	//khởi tạo danh sách nông sản
	public static void allNS() {
		
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();

	     
		  Node node1 = new Node(new NongSan("Cà rốt", 20, 50000, "kg"));
		  Node node2 = new Node(new NongSan("Khoai tây", 30, 33000, "kg"));
		  Node node3 = new Node(new NongSan("Dưa leo", 40, 13000, "kg"));
		  Node node4 = new Node(new NongSan("Cà chua", 24, 25000, "kg"));
		  Node node5 = new Node(new NongSan("Nho", 3, 150000, "kg"));
		  Node node6 = new Node(new NongSan("Cam", 6, 60000, "kg"));
		  Node node7 = new Node(new NongSan("Bưởi", 15, 45000, "kg"));
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
	     
	     file.writeDDL(listNS,"dsNongSan.txt");
	     
	}
	
	
	//render sản phẩm
	public static void renderNS() {
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		listNS.printNS("Danh sách nông sản trống");
	   
	}
	
	
	//tìm sản phẩm theo id
	private static void searchNsById() {
		DLList listNS = new DLList();
		DLList listNSnew = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		Node node = new Node();
		
		
		System.out.println("Nhập số id Nông Sản cần tìm:");
		int idSearch = Integer.parseInt(input.nextLine());
		
		node = listNS.searchNsById(idSearch);
		if(node != null) {
			listNSnew.Add(node);
			listNSnew.printNS("Danh sách nông sản trống");
		} else {
			System.out.println("Không tìm thấy nông sản có Id = " + idSearch + " trong hệ thống");
		}
	}
	
	
	
	//Thêm Nông sản
	private static void addNS() {
		System.out.println("Bạn muốn thêm bao nhiêu sản phẩm");
		while(!checkCount(input.nextLine()));
//		int k = Integer.parseInt(input.nextLine());
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
				
		for(int i = 0; i < count; i++) {
			System.out.printf("Mời bạn nhập sản phẩm thứ %d",  i+1 );
			System.out.println("\nNhập tên sản phẩm: ");
			while( !checkName(input.nextLine()) );
			System.out.println("Nhập số lượng: ");
			while(!checkQua(input.nextLine()) );
			System.out.println("Nhập giá bán: ");
			while(!checkPrice(input.nextLine()) );
			System.out.println("\nNhập đơn vị tính: ");
			String dvt = input.nextLine();
			
			Node node1 = new Node(new NongSan(nameNS, quantity, price, dvt));
			listNS.Add(node1);
			file.writeDDL(listNS,"dsNongSan.txt");
			}
		System.out.println("\nSản phẩm đã được thêm vào hệ thống");
		
		}
	
	
	



	//Xóa NS theo Id
	private static void deleteNsbyId() {
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		Node node = new Node();
		
		System.out.println("Nhập số id Nông Sản cần xóa:");
		 while( !checkIddelete(input.nextLine()) );
		node = listNS.searchNsById(id);
		
		if(node != null) {
			listNS = listNS.deleteNsbyId(id);
			file.writeDDL(listNS,"dsNongSan.txt");
			System.out.println("Đã xóa nông sản có Id = " + id + " trong hệ thống");
		} else {
			System.out.println("Không tìm thấy nông sản có Id = " + id + " trong hệ thống");
		}
	}	



	// Sắp xếp theo tên
	private static void sortByName() {
		DLList listNS = new DLList();
		DLList listNSNew = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		
		listNSNew = listNS.sortByName();
		System.out.println("Danh sách sản phẩm được sắp xếp theo tên");
		System.out.println();
		listNSNew.printNS("Danh sách nông sản trống");
	}

	// Sắp xếp theo số lượng
	private static void sortByQuantity() {
		DLList listNS = new DLList();
		DLList listNSNew = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		
		listNSNew = listNS.sortByQuantity();
		System.out.println("Danh sách sản phẩm được sắp xếp theo số lượng");
		System.out.println();
		listNSNew.printNS("Danh sách nông sản trống");
		

		
	}

	//Chèn sản phẩm sau sản phẩm khác
	private static void insertNS() {
		DLList listNS = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		
		while(true) {
			System.out.println("Nhập số id vị trí Nông sản bạn muốn chèn:");
			 while( !checkIddelete(input.nextLine()) );
			 if(listNS.searchNsById(id) !=null ) {
				break; 
			 };
			 System.out.println("Không có sản phẩm có Id =" + id + " trong hệ thống");
			 System.out.println();
		}
		
		System.out.println("\nNhập tên sản phẩm cần chèn: ");
		while( !checkName(input.nextLine()) );
		System.out.println("Nhập số lượng sản phẩm cần chèn: ");
		while(!checkQua(input.nextLine()) );
		System.out.println("Nhập giá bán sản phẩm cần chèn: ");
		while(!checkPrice(input.nextLine()) );
		System.out.println("\nNhập đơn vị tính sản phẩm cần chèn: ");
		String dvt = input.nextLine();
		
		Node node1 = new Node(new NongSan(nameNS, quantity, price, dvt));
		listNS.insertNsApterId(node1, id);
		file.writeDDL(listNS,"dsNongSan.txt");
		System.out.println("\nSản phẩm đã được chèn vào hệ thống");
	}

	


	//Hiển thị danh sách các sản phẩm gần hết (số lượng < 10)
	private static void nsSoulOut() {
		DLList listNS = new DLList();
		DLList listNSNew = new DLList();
		FileHandle file = new FileHandle();
		listNS = file.readDDL("dsNongSan.txt");
		
		listNSNew = listNS.nsSoulOut();
		System.out.println("Danh sách sản phẩm sắp hết hàng");
		System.out.println();
		listNSNew.printNS("Không có sản phẩm nào sắp hết hàng");  
		
	}

	
	
	//Các hàm check input
	private static boolean checkIddelete(String idDelete) {
		
		if(idDelete != null && isNumeric(idDelete) ) {
			id = Integer.parseInt(idDelete);
			return true;
		} else {
			System.out.println("Vui lòng nhập đúng Id");
			return false;
	}
	}


	//check name
	private static boolean checkName(String name) {
		if(name != null && !name.isEmpty()) {
			nameNS = name;
			return true;
		} else {
			System.out.println("Vui lòng nhập lại tên sản phẩm");
			return false;
	}
		};
		
	private static boolean checkQua(String qua) {
			if(qua != null && isNumeric(qua) && Integer.parseInt(qua) > 0) {
				quantity = Integer.parseInt(qua);
				return true;
			} else {
				System.out.println("Vui lòng nhập đúng số lượng");
				return false;
		}
			}
	private static boolean checkPrice(String qua) {
		if(qua != null && isNumeric(qua) && Integer.parseInt(qua) > 0) {
			price = Integer.parseInt(qua);
			return true;
		} else {
			System.out.println("Vui lòng nhập đúng giá");
			return false;
	}
		}

	private static boolean checkCount(String cou) {
		if(cou != null && isNumeric(cou) && Integer.parseInt(cou) > 0) {
			count = Integer.parseInt(cou);
			return true;
		} else {
			System.out.println("Vui lòng nhập đúng số sản phẩm");
			return false;
	}
	}


	

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
	
}
