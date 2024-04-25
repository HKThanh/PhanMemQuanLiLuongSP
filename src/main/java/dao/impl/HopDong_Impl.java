package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.HopDong_DAO;
import entity.HopDong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HopDong_Impl extends UnicastRemoteObject implements HopDong_DAO {
	private EntityManager em;

	public HopDong_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	/**
	 * cre: Huỳnh Kim Thành Hàm lấy số lượng phân tử trong mảng
	 * 
	 * @return int
	 */
	public int getSize() {
		return em.createQuery("select hd from HopDong hd", HopDong.class).getResultList().size();
	}

	/**
	 * cre: Huỳnh Kim Thành hàm lấy danh sách hợp đồng
	 * 
	 * @return ArrayList<HopDong>
	 */
	public List<HopDong> getDSHopDong() {
		return em.createQuery("select hd from HopDong hd", HopDong.class).getResultList();
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức thêm một hợp đồng vào database
	 * 
	 * @param hd
	 * @return true nếu thêm vào thành công
	 */
	public boolean insertHopDong(HopDong hd) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(hd);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức lấy một hợp đồng từ mã hợp đồng
	 * 
	 * @param ma
	 * @return HopDong
	 */
	public HopDong getMotHopDong(String ma) {
		return em.find(HopDong.class, ma);
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức cập nhật 1 hợp đồng trong database
	 * 
	 * @param hd
	 * @return true nếu cập nhật thành công
	 */
	public boolean updateHopDong(HopDong hd) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(hd);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức xoá 1 hợp đồng trong database
	 * 
	 * @param maHD
	 * @return true nếu xoá thành công
	 */
	public boolean deleteHopDong(String maHD) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			HopDong hd = em.find(HopDong.class, maHD);
			em.remove(hd);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức trả về danh sách hợp đồng theo trạng thái
	 * được nhập.
	 * 
	 * @param tinhTrang
	 * @return ArrayList<HopDong>
	 */
	public List<HopDong> getListHDTheoTrangThai(boolean tinhTrang) {
		String jpql = "select hd from HopDong hd where hd.trangThai = :tinhTrang";

		return em.createQuery(jpql, HopDong.class).setParameter("tinhTrang", tinhTrang)
				.getResultList();
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức trả về danh sách hợp đồng theo năm được
	 * nhập.
	 * 
	 * @param year
	 * @return ArrayList<HopDong>
	 */
	public List<HopDong> getDSHopDongTheoNam(int year) {
		String jpql = "select hd from HopDong hd where year(hd.ngayKy) = :year";

		return em.createQuery(jpql, HopDong.class).setParameter("year", year).getResultList();
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức trả về danh sách các năm kí hợp đồng
	 * 
	 * @param tinhTrang
	 * @return ArrayList<Integer>
	 */
	public List<Integer> getDSNamKiHopDong() {
		Set<Integer> setNam = new HashSet<Integer>();

		List<HopDong> listHopDong = (ArrayList<HopDong>) em.createQuery("select hd from HopDong hd", HopDong.class)
				.getResultList();

		for (HopDong hd : listHopDong) {
			setNam.add(hd.getNgayKy().getYear());
		}

		return new ArrayList<Integer>(setNam);
	}

	/**
	 * cre: Huỳnh Kim Thành Phương thức trả về danh sách hợp đồng theo trạng thái và
	 * năm được nhập.
	 * 
	 * @param year, tinhTrang
	 * @return ArrayList<HopDong>
	 */
	public List<HopDong> getDSHopDongTheoNamvaTT(int year, boolean tinhTrang) {
		String jpql = "select hd from HopDong hd where year(hd.ngayKy) = :year and hd.trangThai = :tinhTrang";

		return em.createQuery(jpql, HopDong.class).setParameter("year", year)
				.setParameter("tinhTrang", tinhTrang).getResultList();
	}
}
