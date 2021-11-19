package Modals;

import java.io.Serializable;

//doubleLinkList
public class DLList implements Serializable{
	
	private int size;
	private Node head;
	private Node tail;
	
    
	
	public DLList() {
		this.size = 0;
		this.head = this.tail = null;
	}
  
	
	//Chèn cuối
	public void Add(Node node) {
		
		
		
        if (this.head == null) {
        	node.prev = null;
           this.head = this.tail = node; 
           head.next = null;
           return;
        } else 
        {
        	
          this.tail.next = node;
          node.prev = tail;
          this.tail = node;
          tail.next =null;
       } 
    }
	
	//chèn đầu
    public void AddFirst(Node node) {
        
        node.prev = null;
        
        if (this.head != null) {
        	this.head.prev = node;
        	node.next = head;
        }
        head = node;
    }
    
    //Trả về node theo Id
	  public Node searchNsById(int id) {
		   
	        Node now = this.head;
	         while (now != null) {
	             if (now.searchNsById(id)) {
	            return now;}
	             now = now.next;
	         };
	         return null;
	    }

	  //Trả về list sau khi xóa
	  public DLList deleteNsbyId(int id) {
		  //Xóa đầu
		  if (this.head.searchNsById(id)) {
			
			 this.head.next.prev = null;
			 this.head = this.head.next;
			 return this;
			 
			 //Xóa cuối
		  } else if (this.tail.searchNsById(id)) {
				
				 this.tail.prev.next = null;
				 this.tail = this.tail.prev;
				 return this;
		 } 
		  //Xóa giữa
		  else {
			  Node now = this.head.next;
			  while (now != null) {
		             if (now.searchNsById(id)) {
		            	 	now.prev.next = now.next;
		            	 	now.next.prev = now.prev;
		            	 return this;
		             }
		             now = now.next;
			  	} ;
			  		return this;
			  }
			 
		}

	  //in nông sản
	public void printNS(String mess) {
		 
       if (head == null) { 
        System.out.println(mess);
         return;
        }
        System.out.println("|----------------------------- Thông tin sản phẩm ------------------------------|");
		System.out.print("|                                                                               |");
		System.out.print("\n|_______________________________________________________________________________|");
		System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", "id", "Tên sản phẩm", 
				"Số lượng","Đơn vị tính" , "Giá");
       Node now = head;
       while (now != null) {
         now.PrintNS();
         now = now.next;
        }
		System.out.println();  
		
	}

	// sắp xếp theo tên
	public DLList sortByName() {
		
		for( Node temp = this.head; temp != null; temp = temp.next) {
			for(Node tempAp = temp.next; tempAp != null; tempAp = tempAp.next) {
				if(temp.sortByNameNS(tempAp)) {
					temp.convert(tempAp);
				}
			}
		}
		return this;
	}

	// sắp xếp theo số lượng
	public DLList sortByQuantity() {
		
		for( Node temp = this.head; temp != null; temp = temp.next) {
			for(Node tempAp = temp.next; tempAp != null; tempAp = tempAp.next) {
				if(temp.sortByQuantity(tempAp)) {
					temp.convert(tempAp);
				}
			}
		}
		return this;
	}

	// Chèn nông sản sau Id
	public DLList insertNsApterId(Node node1, int id) {
		Node nodeB = searchNsById(id);
		
		if(nodeB.next != null) {
		
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

	
	
	//Hiển thị sản phẩm sắp hết
	public DLList  nsSoulOut() {
		DLList newList = new DLList();
		Node now = this.head;
		while(now != null) {
			//Hàm check số lượng
			 if (now.nsSoulOut()) {
				 newList.Add(now);
			 }
			 now = now.next;
		 } 
		return newList;
	}


	

	
	
	}

