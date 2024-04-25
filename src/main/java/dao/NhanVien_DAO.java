package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entity.NhanVien;

public interface NhanVien_DAO extends Remote {
	public ArrayList<NhanVien> getListNV() throws RemoteException;
	public boolean insertNV(NhanVien nv) throws RemoteException;
	public ArrayList<NhanVien> getListNVtheoBP(String maBP) throws RemoteException;
	public ArrayList<NhanVien> getListNVtheoNamVaoLam(int nam) throws RemoteException;
	public ArrayList<NhanVien> getListNVtheoNamBP(int nam, String maBP) throws RemoteException;
	public boolean deleteNV(String maNV) throws RemoteException;
	public boolean updateNhanVien(NhanVien nv) throws RemoteException;
	public NhanVien getMotNVTuMaNV(String maNVien) throws RemoteException;	
	public ArrayList<NhanVien> getListNVtheoBPCa(int ca, String maBP) throws RemoteException;
}
