package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.CongDoan_DAO;
import entity.BangChamCongCN;
import entity.CongDoan;
import entity.CongNhan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CongDoan_Impl extends UnicastRemoteObject implements CongDoan_DAO {
	private EntityManager em;

	public CongDoan_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	/**
	 * Phương thức lấy danh sách công đoạn từ database
	 * 
	 * @return ArrayList<CongDoan> listCD
	 */
	public synchronized List<CongDoan> getDSCongDoan() {
		String jpql = "select cd from CongDoan cd order by cd.ngayBatDau";

		return em.createQuery(jpql, CongDoan.class).getResultList();
	}

	/**
	 * Phương thức lấy danh sách công đoạn theo mã sản phẩm từ database
	 * 
	 * @param maSP
	 * @return ArrayList<CongDoan> listCDTheoMaSP
	 */
	public synchronized List<CongDoan> getDSCongDoanTheoMaSP(String maSP) {
		String jpql = "select cd from CongDoan cd where cd.sanPham.maSP = :maSP order by cd.ngayBatDau";

		return em.createQuery(jpql, CongDoan.class).setParameter("maSP", maSP).getResultList();
	}

	/**
	 * Phương thức thêm một công đoạn vào database
	 * 
	 * @param cd
	 * @return true nếu thêm công đoạn thành công, false nếu thất bại
	 */
	public synchronized boolean insertCongDoan(CongDoan cd) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(cd);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Phương thức xoá một công đoạn trong database
	 * 
	 * @param cd
	 * @return true nếu xoá công đoạn thành công, false nếu thất bại
	 */
	public synchronized boolean deleteCongDoan(String maCD) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			CongDoan cd = em.find(CongDoan.class, maCD);
			em.remove(cd);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Phương lấy một công đoạn từ mã công đoạn trong database
	 * 
	 * @param ma
	 * @return CongDoan cd
	 */
	public synchronized CongDoan getMotCongDoanTheoMaCD(String ma) {
		return em.find(CongDoan.class, ma);
	}

	public synchronized List<CongDoan> getDSCongDoanTheoTrangThai(boolean tinhTrang) {
		String jpql = "select cd from CongDoan cd where cd.trangThai = :tinhTrang order by cd.ngayBatDau";

		return em.createQuery(jpql, CongDoan.class).setParameter("tinhTrang", tinhTrang).getResultList();
	}

	public synchronized boolean updateCongDoan(CongDoan cd) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(cd);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Minh Thật
	public synchronized String getMaCDtheomaCC(BangChamCongCN bcc) {
		String jpql = "select cd.maCongDoan from CongDoan cd " + "join cd.bangPhanCongCNs bpc "
				+ "join bpc.congNhan cn " + "join cn.bangChamCongCNs bcc " + "where bcc.maChamCongCN = :maCC";
		return em.createQuery(jpql, String.class).setParameter("maCC", bcc.getMaChamCongCN()).getSingleResult();
	}
	
	public synchronized List<CongDoan> getCDTheoDSPhanCong() {
		String jpql = "select distinct cd from CongDoan cd join cd.bangPhanCongCNs bpc order by cd.ngayBatDau";
        return em.createQuery(jpql, CongDoan.class).getResultList();
	}
	
	public synchronized List<CongNhan> getDSCBTheoCDVaCa(String maCD, int ca) {
		String jpql = "select cn from CongNhan cn join cn.bangPhanCongCNs bpc join bpc.congDoan cd where cd.maCongDoan = :maCD and cn.caLamViec = :ca";
        return em.createQuery(jpql, CongNhan.class).setParameter("maCD", maCD).setParameter("ca", ca).getResultList();
    }
}
