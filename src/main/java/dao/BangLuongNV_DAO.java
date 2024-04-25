package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.BangLuongNV;

public interface BangLuongNV_DAO extends Remote {
	public int getSize() throws RemoteException;
	public List<BangLuongNV> getDSBangLuongNV() throws RemoteException;
	public List<BangLuongNV> getDSBangLuongNVTheoMaNV(String maNV) throws RemoteException;
	public List<BangLuongNV> getDSBangLuongNVTheoThangNam(int thang, int nam) throws RemoteException;
	public List<BangLuongNV> getDSBangLuongNVTheoMaNVThangNam(String maNV, int thang, int nam) throws RemoteException;
	public boolean insertBangLuongNV(BangLuongNV blnv) throws RemoteException;
	public boolean updateBangLuongNV(BangLuongNV blnv) throws RemoteException;
	public BangLuongNV lay1BangLuongTheoMaNVThangNam(String maNV, int thang, int nam) throws RemoteException;
}