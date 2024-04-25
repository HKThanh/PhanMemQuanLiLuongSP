package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entity.SanPham;

public interface SanPham_DAO extends Remote {
	public int getSize() throws RemoteException;
	public ArrayList<SanPham> getDSSanPham() throws RemoteException;
	public SanPham getMotSanPham(String maSP) throws RemoteException;
	public boolean insertSanPham(SanPham sp) throws RemoteException;
	public boolean updateSanPham(SanPham sp) throws RemoteException;
	public boolean deleteSanPham(String maSP) throws RemoteException;
	public ArrayList<SanPham> getDSSanPhamTheoHopDong(String maHD) throws RemoteException;
	public int getSizeCuaDSTheoHopDong(String maHD) throws RemoteException;
	public ArrayList<SanPham> getDSSanPhamTheoTrangThai(boolean tinhTrang) throws RemoteException;
	public ArrayList<SanPham> getDSSanPhamTheoHDvaTT(String maHD, boolean tinhTrang) throws RemoteException;
}
