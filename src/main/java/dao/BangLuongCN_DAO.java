package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.BangLuongCN;

public interface BangLuongCN_DAO extends Remote {
	public int getSize() throws RemoteException;
	public BangLuongCN getMotBangLuongCNTheoThangNam(String maCN, int thang, int nam) throws RemoteException;
	public boolean insertBangLuongCN(BangLuongCN bangLuongCN) throws RemoteException;
	public boolean updateBangLuongCN(BangLuongCN bangLuongCN) throws RemoteException;
}
