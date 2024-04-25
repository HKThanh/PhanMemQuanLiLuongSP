package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.SanPham_DAO;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SanPham_Impl extends UnicastRemoteObject implements SanPham_DAO {
	private EntityManager em;

	public SanPham_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public synchronized int getSize() {
		String jpql = "SELECT sp FROM SanPham sp";

		return em.createQuery(jpql).getResultList().size();
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức trả về danh sách tất cả sản phẩm
	 * 
	 * @return ArrayList
	 */
	public synchronized ArrayList<SanPham> getDSSanPham() {
		String jpql = "SELECT sp FROM SanPham sp";

		return (ArrayList<SanPham>) em.createQuery(jpql).getResultList();
	}

	/**
	 * Lấy một sản phẩm dựa trên mã sản phẩm
	 * 
	 * @param maSP
	 * @return SanPham
	 */
	public synchronized SanPham getMotSanPham(String maSP) {
		SanPham sp = null;

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			sp = em.find(SanPham.class, maSP);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return sp;
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức dùng để thêm 1 sản phẩm được chọn
	 * 
	 * @param sp
	 * @return true nếu thêm thành công
	 */
	public synchronized boolean insertSanPham(SanPham sp) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(sp);
			tx.commit();

			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức dùng để cập nhật 1 sản phẩm được chọn
	 * 
	 * @param sp
	 * @return true nếu cập nhật thành công
	 */
	public synchronized boolean updateSanPham(SanPham sp) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(sp);
			tx.commit();

			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức xoá 1 sản phẩm trong database
	 * 
	 * @param maHD
	 * @return true nếu xoá thành công
	 */
	public synchronized boolean deleteSanPham(String maSP) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			SanPham sp = em.find(SanPham.class, maSP);
			em.remove(sp);
			tx.commit();

			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức trả về danh sách tất cả sản phẩm theo mã hợp
	 * đồng
	 * 
	 * @param maHD
	 * @return ArrayList
	 */
	public synchronized ArrayList<SanPham> getDSSanPhamTheoHopDong(String maHD) {
		String jpql = "SELECT sp FROM SanPham sp WHERE sp.hopDong.maHopDong = :maHD";

		return (ArrayList<SanPham>) em.createQuery(jpql).setParameter("maHD", maHD).getResultList();
	}

	/**
	 * Lấy ra số lượng sản phẩm theo mã hợp đồng
	 * 
	 * @param maHD
	 * @return int
	 */
	public synchronized int getSizeCuaDSTheoHopDong(String maHD) {
		return this.getDSSanPhamTheoHopDong(maHD).size();
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức trả về danh sách tất cả sản phẩm theo trạng
	 * thái sản phẩm (Đã hoàn thành / Chưa hoàn thành)
	 * 
	 * @param tinhTrang
	 * @return ArrayList
	 */
	public synchronized ArrayList<SanPham> getDSSanPhamTheoTrangThai(boolean tinhTrang) {
		String jpql = "SELECT sp FROM SanPham sp WHERE sp.trangThai = :tinhTrang";

		return (ArrayList<SanPham>) em.createQuery(jpql).setParameter("tinhTrang", tinhTrang).getResultList();
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức trả về danh sách tất cả sản phẩm theo cả 2
	 * điều kiện mã hợp đồng và trạng thái sản phẩm
	 * 
	 * @param maHD
	 * @return ArrayList
	 */
	public synchronized ArrayList<SanPham> getDSSanPhamTheoHDvaTT(String maHD, boolean tinhTrang) {
		String jpql = "SELECT sp FROM SanPham sp WHERE sp.hopDong.maHopDong = :maHD AND sp.trangThai = :tinhTrang";

		return (ArrayList<SanPham>) em.createQuery(jpql).setParameter("maHD", maHD).setParameter("tinhTrang", tinhTrang)
				.getResultList();
	}
}
