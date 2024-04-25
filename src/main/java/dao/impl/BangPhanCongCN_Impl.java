package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.BangPhanCongCN_DAO;
import entity.BangPhanCongCN;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BangPhanCongCN_Impl extends UnicastRemoteObject implements BangPhanCongCN_DAO {
	private EntityManager em;

	public BangPhanCongCN_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	/**
	 * Phương thức lấy danh sách phân công công nhân theo mã công đoạn
	 * 
	 * @param ma
	 * @return ArrayList
	 */
	public synchronized List<BangPhanCongCN> getDSPhanCongCongDoanTheoMaCD(String ma) {
//		String jpql = "select bpccn from BangPhanCongCN bpccn where bpccn.congDoan.maCongDoan = :ma";
		
		String jpql = "select bpccn from BangPhanCongCN bpccn where bpccn.congDoan.maCongDoan = :ma and bpccn.maPhanCong is not null";

		return em.createQuery(jpql).setParameter("ma", ma).getResultList();
	}

	/**
	 * Phương thức thêm một phân công công nhân vào database
	 * 
	 * @param bpccn
	 * @return true nếu thêm thành công, false nếu thất bại
	 */
	public synchronized boolean insertPhanCongCongNhan(BangPhanCongCN bpccn) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(bpccn);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Lấy danh sách công nhân được phân công ở xưởng từ database
	 * 
	 * @param ma
	 * @return ArrayList
	 */
	public synchronized List<BangPhanCongCN> getDSCongNhanTheoXuongVaDuocPhanCong(String ma) {
		String jpql = "select bpccn from BangPhanCongCN bpccn "
				+ "where bpccn.congDoan.maCongDoan = :ma and bpccn.maPhanCong is not null";

		return em.createQuery(jpql).setParameter("ma", ma).getResultList();
	}

	/**
	 * Phương thức lấy danh sách công nhân được phân công
	 * 
	 * @return ArrayList
	 */
	public synchronized List<BangPhanCongCN> getDSCongNhanDuocPhanCong() {

		String jpql = "select bpccn from BangPhanCongCN bpccn where bpccn.maPhanCong is not null";

		return em.createQuery(jpql).getResultList();
	}

	/**
	 * Phương thức xoá toàn bộ phân công của công đoạn theo mã công đoạn
	 * 
	 * @param ma
	 * @return true nếu xoá thành công, false nếu thất bại
	 */
	public synchronized boolean deleteALLPCCuaCongDoan(String ma) {
		String jpql = "delete from BangPhanCongCN bpccn where bpccn.congDoan.maCongDoan = :ma";

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.createQuery(jpql).setParameter("ma", ma).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}
	
	public synchronized int getDSPCTheoMaCD(String maCD) {
		String jpql = "select distinct bpccn.soLuongSanPham from BangPhanCongCN bpccn where bpccn.congDoan.maCongDoan = :maCD";
		
		return em.createQuery(jpql, Integer.class).setParameter("maCD", maCD).getSingleResult();
	}
}
