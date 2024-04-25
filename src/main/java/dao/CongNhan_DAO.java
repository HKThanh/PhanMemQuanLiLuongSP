package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CongNhan;

public interface CongNhan_DAO extends Remote {
	public List<CongNhan> getListCN() throws RemoteException;
	public boolean insertCN(CongNhan cn) throws RemoteException;
	public boolean deleteCN(String maCN) throws RemoteException;
	public boolean updateCN(CongNhan cn) throws RemoteException;	
	public List<CongNhan> getListCNtheoXuong(String maXuong) throws RemoteException;
	public List<CongNhan> getListNVtheoNamXuong(int nam, String maXuong) throws RemoteException;
	public List<CongNhan> getDSCongNhan() throws RemoteException;
	public List<CongNhan> getDSCongNhanTheoXuong(String xuong) throws RemoteException;
	public CongNhan getCongNhanTheoMaCN(String ma) throws RemoteException;
	public List<CongNhan> getDSCongNhanTheoXuongVaChuaDuocPhanCong(String xuong) throws RemoteException;
	public List<CongNhan> getListCntheoXuongCa(int ca, String maXuong) throws RemoteException;
	public List<CongNhan> layDanhSachCNTheoDK(String maXuong) throws RemoteException;
	public List<CongNhan> getListCNtheoNamVaoLam(int nam) throws RemoteException;
}
