package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.BangChamCongCN;
import entity.CongDoan;

public interface CongDoan_DAO extends Remote {
	public List<CongDoan> getDSCongDoan() throws RemoteException;
	public List<CongDoan> getDSCongDoanTheoMaSP(String maSP) throws RemoteException;
	public boolean insertCongDoan(CongDoan cd) throws RemoteException;
	public boolean deleteCongDoan(String maCD) throws RemoteException;
	public CongDoan getMotCongDoanTheoMaCD(String ma) throws RemoteException;
	public List<CongDoan> getDSCongDoanTheoTrangThai(boolean tinhTrang) throws RemoteException;
	public boolean updateCongDoan(CongDoan cd) throws RemoteException;
	public String getMaCDtheomaCC(BangChamCongCN bcc) throws RemoteException;
}
