package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.CongDoan_DAO;
import entity.BangChamCongCN;
import entity.CongDoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CongDoan_Impl implements CongDoan_DAO {
	private EntityManager em;

	public CongDoan_Impl() {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	/**
	 * Phương thức lấy danh sách công đoạn từ database
	 * 
	 * @return ArrayList<CongDoan> listCD
	 */
	public List<CongDoan> getDSCongDoan() {
		String jpql = "select cd from CongDoan cd order by cd.ngayBatDau";

		return em.createQuery(jpql, CongDoan.class).getResultList();
	}

	/**
	 * Phương thức lấy danh sách công đoạn theo mã sản phẩm từ database
	 * 
	 * @param maSP
	 * @return ArrayList<CongDoan> listCDTheoMaSP
	 */
	public List<CongDoan> getDSCongDoanTheoMaSP(String maSP) {
		String jpql = "select cd from CongDoan cd where cd.sanPham.maSP = :maSP order by cd.ngayBatDau";

		return em.createQuery(jpql, CongDoan.class).setParameter("maSP", maSP).getResultList();
	}

	/**
	 * Phương thức thêm một công đoạn vào database
	 * 
	 * @param cd
	 * @return true nếu thêm công đoạn thành công, false nếu thất bại
	 */
	public boolean insertCongDoan(CongDoan cd) {
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
	public boolean deleteCongDoan(String maCD) {
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
	public CongDoan getMotCongDoanTheoMaCD(String ma) {
		return em.find(CongDoan.class, ma);
	}

	public List<CongDoan> getDSCongDoanTheoTrangThai(boolean tinhTrang) {
		String jpql = "select cd from CongDoan cd where cd.trangThai = :tinhTrang order by cd.ngayBatDau";

		return em.createQuery(jpql, CongDoan.class).setParameter("tinhTrang", tinhTrang).getResultList();
	}

	public boolean updateCongDoan(CongDoan cd) {
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
	public String getMaCDtheomaCC(BangChamCongCN bcc) {
//		String maCD = null;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "select cd.maCongDoan from CongNhan cn join BangPhanCongCN bpc on cn.maCN=bpc.maCN join CongDoan cd on bpc.maCD=cd.maCongDoan join SanPham sp on cd.maSP=sp.maSP join BangChamCongCongNhan bcc on bcc.maCN=cn.maCN where bcc.maCC =?";
//		
//		PreparedStatement stmt = null;
//		
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, bcc.getMaCCCN());
//			
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				maCD = rs.getString(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return maCD;

		String jpql = "select cd.maCongDoan from CongDoan cd " + "join cd.bangPhanCongCNs bpc "
				+ "join bpc.congNhan cn " + "join cn.bangChamCongCNs bcc " + "where bcc.maCC = :maCC";
		return em.createQuery(jpql, String.class).setParameter("maCC", bcc.getMaChamCongCN()).getSingleResult();
	}
}
