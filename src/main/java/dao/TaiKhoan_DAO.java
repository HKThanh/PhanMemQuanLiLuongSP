package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import entity.TaiKhoan;

public interface TaiKhoan_DAO extends Remote {
	public List<TaiKhoan> getListTK() throws RemoteException;
	public int getSize() throws RemoteException;
	public boolean insert(TaiKhoan tk) throws RemoteException;
	public TaiKhoan soSanhPWD(String tk, String mk) throws RemoteException;
	public String getBoPhanCuaNV(TaiKhoan tk) throws RemoteException;
	public void updateNgayDNCuoi(LocalDate date, TaiKhoan tk) throws RemoteException;
}