package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.Xuong_DAO;
import entity.Xuong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Xuong_Impl extends UnicastRemoteObject implements Xuong_DAO {
	private EntityManager em;

	public Xuong_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public synchronized ArrayList<Xuong> getDSXuong() {
		String jpql = "SELECT x FROM Xuong x";

		return (ArrayList<Xuong>) em.createQuery(jpql).getResultList();
	}

	public synchronized Xuong getMotXuong(String maXuong) {
		return em.find(Xuong.class, maXuong);
	}

	// Minh Thật
	public synchronized ArrayList<Xuong> layTatCaXuongKhacNhau() {
//		String jpql = "SELECT DISTINCT x FROM Xuong x";
//
//		return (ArrayList<Xuong>) em.createQuery(jpql).getResultList();
		 String jpql = "SELECT DISTINCT x FROM Xuong x";

		    TypedQuery<Xuong> query = em.createQuery(jpql, Xuong.class);

		    List<Xuong> listXuong = query.getResultList();
		    return (ArrayList<Xuong>) listXuong;
	}
}
