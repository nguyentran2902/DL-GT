package Modals;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

//doubleLinkList
public class DLList extends LinkedList implements Serializable {

	private int size;
	private Node head;
	private Node tail;

	public DLList() {

		this.size = 0;
		this.head = this.tail = null;
	}

	// Add node
	public void Add(Node node) {

		if (this.head == null) {
			node.prev = null;
			this.head = this.tail = node;
			node.next = null;
			size++;
			return;

		} else {

			this.tail.next = node;
			node.prev = tail;
			this.tail = node;
			node.next = null;
			size++;
		}
	}

	// chèn đầu
	public void AddFirst(Node node) {

		node.prev = null;

		if (this.head != null) {
			this.head.prev = node;
			node.next = head;
		}

		head = node;
		size++;
	}

	// chèn cuối
	public void AddLast(Node node) {

		this.tail.next = node;
		node.prev = tail;
		this.tail = node;
		node.next = null;
		size++;
	}

	// _______________________Nông sản______________________________________

	// Chèn nông sản sau Id
	public DLList insertNsApterId(Node node1, int id) {
		
		Node nodeB = searchNsById(id);

		if (nodeB.next != null) {

			node1.next = nodeB.next;
			nodeB.next.prev = node1;

			node1.prev = nodeB;
			nodeB.next = node1;
		}

		else {
			node1.next = null;

			node1.prev = nodeB;
			nodeB.next = node1;
		}
		return this;
	}

	// Trả về node theo Id
	public Node searchNsById(int id) {

		Node now = this.head;
		while (now != null) {
			if (now.searchNsById(id)) {
				return now;
			}
			now = now.next;
		}
		;
		return null;
	}

	// Trả về list sau khi xóa
	public void deleteNsbyId(int id) {
		// Xóa đầu
		if (this.head.searchNsById(id)) {

			this.head.next.prev = null;
			this.head = this.head.next;

			// Xóa cuối
		} else if (this.tail.searchNsById(id)) {

			this.tail.prev.next = null;
			this.tail = this.tail.prev;
		}
		// Xóa giữa
		else {
			Node now = this.head.next;
			while (now != null) {
				if (now.searchNsById(id)) {
					now.prev.next = now.next;
					now.next.prev = now.prev;
				}
				now = now.next;
			}
			;
		}

	}

	// in nông sản
	public void printNS(String mess) {

		if (head == null) {
			System.out.println(mess);
			return;
		}
		System.out.println("|----------------------------- Thông tin sản phẩm ------------------------------|");
		System.out.print("|                                                                               |");
		System.out.print("\n|_______________________________________________________________________________|");
		System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên sản phẩm", "Số lượng", "Đơn vị tính", "Giá(vnđ)");
		Node now = head;
		while (now != null) {
			now.PrintNS();
			now = now.next;
		}
		System.out.println();

	}

	// Sửa tên NS
	public DLList editNameNS(Node node, String nameNS) {
		node.editNameNS(nameNS);
		return this;
	}

	// Sửa số lượng NS

	public DLList editQuantityNS(Node node, int quantity) {
		node.editQuantityNS(quantity);
		return this;
	}
	// Sửa giá NS

	public DLList editPriceNS(Node node, float price) {
		node.editPriceNS(price);
		return this;
	}

	// Sửa đơn vị tính NS
	public DLList editDvtNS(Node node, String dvt) {
		node.editDvtNS(dvt);
		return this;
	}

	// sắp xếp theo tên
	public void sortByName() {

		for (Node temp = this.head; temp != null; temp = temp.next) {
			for (Node tempAp = temp.next; tempAp != null; tempAp = tempAp.next) {
				if (temp.sortByNameNS(tempAp)) {
					temp.convert(tempAp);
				}
			}
		}
	}
	
	// sắp xếp theo số lượng
		public void SelectionSort () {

			for (Node temp = this.head; temp != null; temp = temp.next) {
				
				Node min = temp;
				for (Node tempAp = temp.next; tempAp != null; tempAp = tempAp.next) {
					if (temp.sortByQuantity(tempAp)) {
						min = tempAp;
						temp.convert(tempAp);
					}
				}
			}
		}

	// sắp xếp theo số lượng
	public void sortByQuantity() {

		for (Node temp = this.head; temp != null; temp = temp.next) {
			for (Node tempAp = temp.next; tempAp != null; tempAp = tempAp.next) {
				if (temp.sortByQuantity(tempAp)) {
					temp.convert(tempAp);
				}
			}
		}
	}

	// Hiển thị sản phẩm sắp hết

	public List<NongSan> nsSoulOut() {

		List<NongSan> newList = new LinkedList();
		Node newNode = new Node();
		Node now = this.head;

		while (now != null) {
			// Hàm check số lượng
			if (now.nsSoulOut()) {

				newList.add(now.getNongSan());
			}
			now = now.next;
		}
		return newList;
	}

	// update số lượng NS
	public void updateQuaNs(Node nodeNs, int quantity) {
		nodeNs.updateQuaNs(quantity);

	}

//_______________________end Nông Sản_______________________________________	
	
	

	// in khách hàng
	public void printKH(String mess) {

		if (head == null) {
			System.out.println(mess);
			return;
		}
		System.out.println("|---------------------------- Thông tin khách hàng -----------------------------|");
		System.out.print("|                                                                               |");
		System.out.print("\n|_______________________________________________________________________________|");
		System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Email");
		System.out.print("\n|                                                                               |");
		Node now = head;
		while (now != null) {
			now.PrintKH();
			now = now.next;
		}
		System.out.println();

	}

	// Trả về node theo Id
	public Node searchKhById(int id) {

		Node now = this.head;
		while (now != null) {
			if (now.searchKhById(id)) {
				return now;
			}
			now = now.next;
		}
		;
		return null;
	}
	


	// Trả về list sau khi xóa
	public void deleteKHbyId(int id) {
		// Xóa đầu
		if (this.head.searchKhById(id)) {

			this.head.next.prev = null;
			this.head = this.head.next;

			// Xóa cuối
		} else if (this.tail.searchKhById(id)) {

			this.tail.prev.next = null;
			this.tail = this.tail.prev;
		}
		// Xóa giữa
		else {
			Node now = this.head.next;
			while (now != null) {
				if (now.searchKhById(id)) {
					now.prev.next = now.next;
					now.next.prev = now.prev;
				}
				now = now.next;
			}
			;
		}
	}

	// sắp xếp theo tên
	public void sortByNameKH() {

		for (Node temp = this.head; temp != null; temp = temp.next) {
			for (Node tempAp = temp.next; tempAp != null; tempAp = tempAp.next) {
				if (temp.sortByNameKH(tempAp)) {
					temp.convertKH(tempAp);
				}
			}
		}
	}

	// Chèn KH sau Id
	public DLList insertKhApterId(Node node1, int id) {
		Node nodeB = searchKhById(id);

		if (nodeB.next != null) {

			node1.next = nodeB.next;
			nodeB.next.prev = node1;

			node1.prev = nodeB;
			nodeB.next = node1;
		}

		else {
			node1.next = null;

			node1.prev = nodeB;
			nodeB.next = node1;
		}
		return this;
	}

	// Sửa tên KH
	public DLList editNameKH(Node node, String nameKH) {
		node.editNameKH(nameKH);
		return this;
	}

	// Sửa số lượng KH

	public DLList editAddKH(Node node, String add) {
		node.editAddKH(add);
		return this;
	}
	// Sửa sdt KH

	public DLList editSdtKH(Node node, String sdt) {
		node.editSdtKH(sdt);
		return this;
	}

	// Sửa email KH
	public DLList editEmailKH(Node node, String email) {
		node.editEmailKH(email);
		return this;
	}

	// Danh sách KH theo địa chỉ
	public List<KhachHang> KhByAdd(String add) {
		List<KhachHang> newList = new LinkedList<>();
		Node now = this.head;
		while (now != null) {
			if (now.KhByAdd(add)) {

				newList.add(now.addKhachHang());
			}
			now = now.next;
		}

		return newList;
	}

	
}
