package dao.impl;

import java.rmi.RemoteException;
import java.util.List;

import dao.AbstractDao;
import dao.DichVuDao;

public class DichVuImpl extends AbstractDao implements DichVuDao{

	public DichVuImpl() throws RemoteException {
		super();
	}

	@Override
	public List<model.DichVu> getListDichVu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<model.DichVu> timKiemByName(String tenDV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean themDichVu(model.DichVu dv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean capNhatDichVu(model.DichVu dv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoaDichVu(int maDV) {
		// TODO Auto-generated method stub
		return false;
	}

}