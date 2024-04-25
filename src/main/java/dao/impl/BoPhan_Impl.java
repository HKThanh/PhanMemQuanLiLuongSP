package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.BoPhan_DAO;
import entity.BoPhan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class BoPhan_Impl extends UnicastRemoteObject implements BoPhan_DAO {
	private EntityManager em;

	public BoPhan_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public ArrayList<BoPhan> getdsBoPhan() {
		String jpql = "select bp from BoPhan bp";

		return (ArrayList<BoPhan>) em.createQuery(jpql).getResultList();
	}

	public ArrayList<BoPhan> layTatCaBoPhanKhacNhau() {
		String jpql = "select distinct bp from BoPhan bp";

		return (ArrayList<BoPhan>) em.createQuery(jpql).getResultList();
	}
}
