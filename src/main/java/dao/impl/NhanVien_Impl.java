package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.NhanVien_DAO;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class NhanVien_Impl extends UnicastRemoteObject implements NhanVien_DAO {
	private EntityManager em;

	public NhanVien_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public ArrayList<NhanVien> getListNV() {
		String jpql = "select nv from NhanVien nv";

		return (ArrayList<NhanVien>) em.createQuery(jpql).getResultList();
	}

	public boolean insertNV(NhanVien nv) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(nv);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<NhanVien> getListNVtheoBP(String maBP) {
		String jpql = "select nv from NhanVien nv where nv.boPhan.maBoPhan = :maBP";

		return (ArrayList<NhanVien>) em.createQuery(jpql).setParameter("maBP", maBP).getResultList();
	}

	public ArrayList<NhanVien> getListNVtheoNamVaoLam(int nam) {
		String jpql = "select nv from NhanVien nv where year(nv.ngayBatDauLamViec) = :nam";

		return (ArrayList<NhanVien>) em.createQuery(jpql).setParameter("nam", nam).getResultList();
	}

	public ArrayList<NhanVien> getListNVtheoNamBP(int nam, String maBP) {
		String jpql = "select nv from NhanVien nv where year(nv.ngayBatDauLamViec) = :nam and nv.boPhan.maBoPhan = :maBP";

		return (ArrayList<NhanVien>) em.createQuery(jpql).setParameter("nam", nam).setParameter("maBP", maBP)
				.getResultList();
	}

	public boolean deleteNV(String maNV) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			NhanVien nv = em.find(NhanVien.class, maNV);
			em.remove(nv);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateNhanVien(NhanVien nv) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(nv);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public NhanVien getMotNVTuMaNV(String maNVien) {
		String jpql = "select nv from NhanVien nv where nv.maNV = :maNV";

		return (NhanVien) em.createQuery(jpql).setParameter("maNV", maNVien).getSingleResult();
	}

	public ArrayList<NhanVien> getListNVtheoBPCa(int ca, String maBP) {
		String jpql = "select nv from NhanVien nv where nv.caLamViec = :ca and nv.boPhan.maBoPhan = :maBP";

		return (ArrayList<NhanVien>) em.createQuery(jpql).setParameter("ca", ca).setParameter("maBP", maBP)
				.getResultList();
	}

}
