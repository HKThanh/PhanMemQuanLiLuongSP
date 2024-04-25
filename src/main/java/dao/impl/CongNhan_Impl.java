package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.CongNhan_DAO;
import entity.CongNhan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CongNhan_Impl extends UnicastRemoteObject implements CongNhan_DAO {
	private EntityManager em;

	public CongNhan_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public synchronized List<CongNhan> getListCN() {
		String jpql = "select cn from CongNhan cn";

		return em.createQuery(jpql).getResultList();
	}

	public synchronized boolean insertCN(CongNhan cn) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(cn);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public synchronized boolean deleteCN(String maCN) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			CongNhan cn = em.find(CongNhan.class, maCN);
			em.remove(cn);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public synchronized boolean updateCN(CongNhan cn) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(cn);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public synchronized List<CongNhan> getListCNtheoXuong(String maXuong) {
		String jpql = "select cn from CongNhan cn where cn.xuong.maXuong = :maXuong";

		return em.createQuery(jpql).setParameter("maXuong", maXuong).getResultList();
	}

	public synchronized List<CongNhan> getListCNtheoNamVaoLam(int nam) {
		String jpql = "select cn from CongNhan cn where year(cn.ngayBatDauLamViec) = :nam";

		return em.createQuery(jpql).setParameter("nam", nam).getResultList();
	}

	public synchronized List<CongNhan> getListNVtheoNamXuong(int nam, String maXuong) {
		String jpql = "select cn from CongNhan cn where year(cn.ngayBatDauLamViec) = :nam and cn.xuong.maXuong = :maXuong";

		return em.createQuery(jpql).setParameter("nam", nam).setParameter("maXuong", maXuong)
				.getResultList();
	}

	public synchronized List<CongNhan> getDSCongNhan() {
		String jpql = "select cn from CongNhan cn";

		return em.createQuery(jpql).getResultList();
	}

	public synchronized List<CongNhan> getDSCongNhanTheoXuong(String xuong) {
		String jpql = "select cn from CongNhan cn where cn.xuong.tenXuong like :xuong";

		return em.createQuery(jpql).setParameter("xuong", xuong).getResultList();
	}

	public synchronized CongNhan getCongNhanTheoMaCN(String ma) {
		return em.find(CongNhan.class, ma);
	}

	public synchronized List<CongNhan> getDSCongNhanTheoXuongVaChuaDuocPhanCong(String xuong) {
		String jpql = "select cn from CongNhan cn where cn.xuong.tenXuong like :xuong";

		return em.createQuery(jpql).setParameter("xuong", xuong).getResultList();
	}

	public synchronized List<CongNhan> getListCntheoXuongCa(int ca, String maXuong) {
		String jpql = "select cn from CongNhan cn where cn.caLamViec = :ca and cn.xuong.maXuong = :maXuong";

		return em.createQuery(jpql).setParameter("ca", ca).setParameter("maXuong", maXuong)
				.getResultList();
	}

	// Minh Thật
	public synchronized List<CongNhan> layDanhSachCNTheoDK(String maXuong) {
		String jpql = "select cn from CongNhan cn where cn.xuong.tenXuong like :maXuong";

		return em.createQuery(jpql).setParameter("maXuong", maXuong).getResultList();
	}
}
