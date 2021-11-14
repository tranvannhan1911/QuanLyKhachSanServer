package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import model.HoaDonPhong;

public interface HoaDonPhongDao extends Remote {
	public List<HoaDonPhong> getListHoaDonPhong() throws RemoteException;
	public List<HoaDonPhong> getListHoaDonPhongByDate(Date tuNgay, Date denNgay) throws RemoteException;
	public List<HoaDonPhong> getListHoaDonPhongByMaKH(int maKH) throws RemoteException;
	public List<HoaDonPhong> getListHoaDonPhongByMaKH(int maKH, Date tuNgay, Date denNgay) throws RemoteException;
	public boolean themHoaDonPhong(HoaDonPhong hdp) throws RemoteException;
	public boolean xoaHoaDonPhong(int maHD) throws RemoteException;
	public boolean capNhatTinhTrang(int maHD, int tinhTrang) throws RemoteException;
	public HoaDonPhong getHDPbyMaPhong(String maPhong) throws RemoteException; // lấy hóa đơn của phòng trong thời điểm hiện tại
	public List<HoaDonPhong> getListHDPByTinhTrang() throws RemoteException;
}
