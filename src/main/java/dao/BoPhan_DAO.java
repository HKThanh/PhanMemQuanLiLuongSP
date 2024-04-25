package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.BoPhan;

public interface BoPhan_DAO extends Remote {
	public List<BoPhan> getdsBoPhan() throws RemoteException;
	public List<BoPhan> layTatCaBoPhanKhacNhau() throws RemoteException;
}
