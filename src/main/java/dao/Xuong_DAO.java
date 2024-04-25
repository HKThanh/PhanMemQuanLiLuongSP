package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entity.Xuong;

public interface Xuong_DAO extends Remote {
	public ArrayList<Xuong> getDSXuong() throws RemoteException;	
	public Xuong getMotXuong(String maXuong) throws RemoteException;
	public ArrayList<Xuong> layTatCaXuongKhacNhau() throws RemoteException;
}
