package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.BangLuongNV_DAO;
import entity.BangLuongNV;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BangLuongNV_Impl extends UnicastRemoteObject implements BangLuongNV_DAO {
	private EntityManager em;

	public BangLuongNV_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public synchronized int getSize() {
		return em.createQuery("select bl from BangLuongNV bl", BangLuongNV.class).getResultList().size();
	}

	public synchronized List<BangLuongNV> getDSBangLuongNV() {
		String jpql = "select bl from BangLuongNV bl";

		return em.createQuery(jpql, BangLuongNV.class).getResultList();
	}

	public synchronized List<BangLuongNV> getDSBangLuongNVTheoMaNV(String maNV) {
		String jpql = "select bl from BangLuongNV bl where bl.nv.maNV like :maNV";

		return em.createQuery(jpql, BangLuongNV.class).setParameter("maNV", maNV).getResultList();
	}

	public synchronized List<BangLuongNV> getDSBangLuongNVTheoThangNam(int thang, int nam) {
		String jpql = "select bl from BangLuongNV bl where bl.thang = :thang and bl.nam = :nam";

		return em.createQuery(jpql, BangLuongNV.class).setParameter("thang", thang).setParameter("nam", nam)
				.getResultList();
	}

	public synchronized List<BangLuongNV> getDSBangLuongNVTheoMaNVThangNam(String maNV, int thang, int nam) {
		String jpql = "select bl from BangLuongNV bl "
				+ "where bl.nv.maNV like :maNV and bl.thang = :thang and bl.nam = :nam";

		return em.createQuery(jpql, BangLuongNV.class).setParameter("maNV", maNV).setParameter("thang", thang)
				.setParameter("nam", nam).getResultList();
	}

	public synchronized boolean insertBangLuongNV(BangLuongNV blnv) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(blnv);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return false;
	}

	public synchronized boolean updateBangLuongNV(BangLuongNV blnv) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(blnv);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return false;
	}

//	public int getSizeBL(ArrayList<BangLuongNV> listBangLuongNV) {
//		return listBangLuongNV.size();
//	}

	public synchronized BangLuongNV lay1BangLuongTheoMaNVThangNam(String maNV, int thang, int nam) {
		String jpql = "select bl from BangLuongNV bl " + "where bl.nv.maNV like :maNV " + "and bl.thang = :thang "
				+ "and bl.nam = :nam";

		 List<BangLuongNV> results = em.createQuery(jpql, BangLuongNV.class)
		            .setParameter("maNV", maNV)
		            .setParameter("thang", thang)
		            .setParameter("nam", nam)
		            .getResultList();

		    if (!results.isEmpty()) {
		        return results.get(0);
		    } else {
		        return null;
		    }
	}
}