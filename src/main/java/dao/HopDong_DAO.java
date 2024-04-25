package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HopDong;

public interface HopDong_DAO extends Remote {
	public int getSize() throws RemoteException;
	public List<HopDong> getDSHopDong()throws RemoteException;
	public boolean insertHopDong(HopDong hd) throws RemoteException;
	public HopDong getMotHopDong(String ma) throws RemoteException;
	public boolean updateHopDong(HopDong hd) throws RemoteException;
	public boolean deleteHopDong(String maHD) throws RemoteException;
	public List<HopDong> getListHDTheoTrangThai(boolean tinhTrang) throws RemoteException;
	public List<HopDong> getDSHopDongTheoNam(int year) throws RemoteException;
	public List<Integer> getDSNamKiHopDong() throws RemoteException;
	public List<HopDong> getDSHopDongTheoNamvaTT(int year, boolean tinhTrang) throws RemoteException;
}
