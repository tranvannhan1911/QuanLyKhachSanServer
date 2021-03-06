package app;

import java.awt.Dimension;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import dao.ChiTietDVDao;
import dao.ChiTietHoaDonPhongDao;
import dao.DichVuDao;
import dao.HoaDonDVDao;
import dao.HoaDonPhongDao;
import dao.KhachHangDao;
import dao.LoaiPhongDao;
import dao.PhongDao;

import dao.impl.ChiTietDVImpl;
import dao.impl.ChiTietHoaDonPhongImpl;
import dao.impl.DichVuImpl;
import dao.impl.HoaDonDVImpl;
import dao.impl.HoaDonPhongImpl;
import dao.impl.KhachHangImpl;
import dao.impl.LoaiPhongImpl;
import dao.impl.PhongImpl;


public class Server extends JFrame{
	private JTextArea taConsole;
	private String ip = "localhost";
	private int port = 9991;
	
	public Server() throws NamingException, RemoteException {
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Server quản lý khách sạn");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("QuanLyKhachSan_Server");
		
		this.getContentPane().add(new JScrollPane(taConsole = new JTextArea()));
		
//		RMI
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			securityManager = new SecurityManager();
			System.setSecurityManager(securityManager);
		}
		
		LocateRegistry.createRegistry(port);
		Context context = new InitialContext();
		
		ChiTietDVDao chiTietDVDao = new ChiTietDVImpl(factory);
		context.bind("rmi://"+ ip +":"+ port +"/ChiTietDV", chiTietDVDao);
		
		ChiTietHoaDonPhongDao chiTietHDPDao = new ChiTietHoaDonPhongImpl(factory);
		context.bind("rmi://"+ ip +":"+ port +"/ChiTietHoaDonPhong", chiTietHDPDao);
		
		DichVuDao dichVuDao = new DichVuImpl(factory);
		context.bind("rmi://"+ ip +":"+ port +"/DichVu", dichVuDao);
		
		HoaDonDVDao hoaDonDVDao = new HoaDonDVImpl(factory);
		context.bind("rmi://"+ ip +":"+ port +"/HoaDonDV", hoaDonDVDao);
		
		HoaDonPhongDao hoaDonPhongDao = new HoaDonPhongImpl(factory);
		context.bind("rmi://"+ ip +":"+ port +"/HoaDonPhong", hoaDonPhongDao);
		
		KhachHangDao khachHangDao = new KhachHangImpl(factory);
		context.bind("rmi://"+ ip +":"+ port +"/KhachHang", khachHangDao);
		
		LoaiPhongDao loaiPhongDao= new LoaiPhongImpl(factory);
		context.bind("rmi://"+ ip +":"+ port +"/LoaiPhong", loaiPhongDao);
		
		PhongDao phongDao= new PhongImpl(factory);
		context.bind("rmi://"+ ip +":"+ port +"/Phong", phongDao);
		
		System.out.println("Server bound to the RMIRegistry");
	}
	
	public static void main(String[] args) throws RemoteException, NamingException {
		Server server = new Server();
	}
	
}
