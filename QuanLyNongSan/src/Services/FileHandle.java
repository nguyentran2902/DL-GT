package Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import Modals.DLList;





public class FileHandle<T> {
	
	
	
	//Ghi file 
	 public  void write(List<T> list, String fileName) {
		 FileOutputStream fos = null;
         ObjectOutputStream oos = null;
         
         try {
             fos = new FileOutputStream(new File(fileName));
             oos = new ObjectOutputStream(fos);
             oos.writeObject(list);
             oos.close();
             fos.close();
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
	 
	//Ghi file 
		 public void writeDDL(DLList list, String fileName) {
			 FileOutputStream fos = null;
	         ObjectOutputStream oos = null;
	         
	         try {
	             fos = new FileOutputStream(new File(fileName));
	             oos = new ObjectOutputStream(fos);
	             oos.writeObject(list);
	             oos.close();
	             fos.close();
	         } catch (FileNotFoundException e) {
	             e.printStackTrace();
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	     }
	 
	 
	 //Đọc file 
	 public  List<T> read(String fileName) {
		 List<T> list = new LinkedList<T>();
	        
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;
	        
	        try {
	            fis = new FileInputStream(new File(fileName));
	            ois = new ObjectInputStream(fis);
	            list = (List<T>) ois.readObject();
	             
	            ois.close();
	            fis.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } 
	        
	        return list;
	    }
	 
	 //Đọc file DDl
	 public DLList readDDL(String fileName) {
	        DLList list = new DLList();
	        
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;
	        
	        try {
	            fis = new FileInputStream(new File(fileName));
	            ois = new ObjectInputStream(fis);
	            list =  (DLList) ois.readObject();
	             
	            ois.close();
	            fis.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } 
	        
	        return list;
	    }

	
	 
}
