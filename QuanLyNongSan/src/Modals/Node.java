package Modals;

import java.io.Serializable;

public class Node implements Serializable{
	private NongSan    nongSan;
	private KhachHang  khachHang;
	private HoaDon     hoaDon;
	        Node       prev = null; 
            Node       next = null; 
    
    public Node() {
    	
    }
    
    public Node(NongSan nongSan) {
    	this.nongSan = nongSan;
    	
    }
    
    public Node(KhachHang khachHang) {
    	this.khachHang = khachHang;
    	
    }
    
    public Node(HoaDon hoaDon) {
    	this.hoaDon = hoaDon;
    	
    }
    
    public void PrintNS() {
    	System.out.printf("\n|%10s|%20s|%15s|%15s|%15s|", this.nongSan.getIdNs(), this.nongSan.getTenNs(), 
    			this.nongSan.getSoLuong(), this.nongSan.getDonViTinh(), this.nongSan.getGia());
    }
    
    public boolean searchNsById(int Id) {
		if (this.nongSan.getIdNs() == Id) {
			return true;
			}
		else return false;
    	
    }
    
    public boolean sortByNameNS( Node tempAp) {
		
    	if(this.nongSan.getTenNs().compareTo(tempAp.nongSan.getTenNs()) > 0) {
    		return true;
    	}
			return false;
	}
    
    public boolean sortByQuantity( Node tempAp) {
		
    	if(this.nongSan.getSoLuong() > tempAp.nongSan.getSoLuong() ) {
    		return true;
    	}
			return false;
	}

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

	public boolean nsSoulOut() {
		if (this.nongSan.getSoLuong() < 10) {
			return true;
		}else return false;
				
	}

}
