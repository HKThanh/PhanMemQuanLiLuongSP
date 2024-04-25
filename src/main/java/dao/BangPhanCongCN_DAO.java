package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.BangPhanCongCN;

public interface BangPhanCongCN_DAO extends Remote {
	public List<BangPhanCongCN> getDSPhanCongCongDoanTheoMaCD(String ma) throws RemoteException;
	public boolean insertPhanCongCongNhan(BangPhanCongCN bpccn) throws RemoteException;
	public List<BangPhanCongCN> getDSCongNhanTheoXuongVaDuocPhanCong(String ma) throws RemoteException;
	public List<BangPhanCongCN> getDSCongNhanDuocPhanCong() throws RemoteException;
	public boolean deleteALLPCCuaCongDoan(String ma) throws RemoteException;
}
