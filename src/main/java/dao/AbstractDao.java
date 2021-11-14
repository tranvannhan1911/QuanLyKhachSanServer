package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDao extends UnicastRemoteObject{
	

	private EntityManagerFactory factory;
	public String ChiTietDV = "ChiTietDV";
	public String DichVu = "DichVu";
	public String HoaDonDV= "HoaDonDV";
	public String HoaDonPhong = "HoaDonPhong";
	public String KhachHang = "KhachHang";
	public String LoaiPhong = "LoaiPhong";
	public String Phong = "Phong";

	protected AbstractDao() throws RemoteException {
		super();
		
		factory = Persistence.createEntityManagerFactory("QuanLyKhachSan_Server");
	}
	
	public boolean them(Object obj, Class<?> classname) {
		
		return true;
	}
	
	public boolean capNhat(Object obj, Class<?> classname) {
		
		return true;
	}
	
	public boolean xoa(int id, Class<?> classname) {
		
		return true;
	}
	
	public boolean xoa(String id, Class<?> classname) {
		
		return true;
	}
	
	public List<Class<?>> getList(String sql, Class<?> classname){
		return null;
	}
	
	public Class<?> getSingle(String sql, Class<?> classname){
		return null;
	}
	
	public int getLastestId(String tableName) {
//		
		return 0;
	}
	
}