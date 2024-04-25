package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.BangLuongCN_DAO;
import entity.BangLuongCN;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class BangLuongCN_Impl extends UnicastRemoteObject implements BangLuongCN_DAO {
	private EntityManager em;

	public BangLuongCN_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public synchronized int getSize() {
		return em.createQuery("select bl from BangLuongCN bl", BangLuongCN.class).getResultList().size();
	}

	public synchronized BangLuongCN getMotBangLuongCNTheoThangNam(String maCN, int thang, int nam) {
		String jpql = "SELECT b FROM BangLuongCN b WHERE b.cn.maCN = :maCN AND b.thang = :thang AND b.nam = :nam";

	    TypedQuery<BangLuongCN> query = em.createQuery(jpql, BangLuongCN.class);
	    query.setParameter("maCN", maCN);
	    query.setParameter("thang", thang);
	    query.setParameter("nam", nam);

	    BangLuongCN bangLuongCN = null;
	    try {
	        bangLuongCN = query.getSingleResult();
	    } catch (NoResultException e) {
	        // Handle case where no result is found
	    }

	    return bangLuongCN;
	}

	public synchronized boolean insertBangLuongCN(BangLuongCN bangLuongCN) {
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(bangLuongCN);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return false;
	}

	public synchronized boolean updateBangLuongCN(BangLuongCN bangLuongCN) {
		EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            em.merge(bangLuongCN);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }

        return false;
	}
}
