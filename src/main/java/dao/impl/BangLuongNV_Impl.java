package dao.impl;

import java.util.List;

import dao.BangLuongNV_DAO;
import entity.BangLuongNV;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BangLuongNV_Impl implements BangLuongNV_DAO {
	private EntityManager em;

	public BangLuongNV_Impl() {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public int getSize() {
		return em.createQuery("select bl from BangLuongNV bl", BangLuongNV.class).getResultList().size();
	}

	public List<BangLuongNV> getDSBangLuongNV() {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "Select * from BangLuongNhanVien";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String maLuongNV = rs.getString(1);
//				NhanVien nv = new NhanVien(rs.getString(2));
//				int thang = rs.getInt(3);
//				int nam = rs.getInt(4);
//				int soNgayDiLam = rs.getInt(5);
//				int soNgayNghiKhongPhep = rs.getInt(6);
//				double tienPhat = rs.getDouble(7);
//				double bhxh = rs.getDouble(8);
//				double luongTong = rs.getDouble(9);
//				BangLuongNV blnv = new BangLuongNV(maLuongNV, nv, thang, nam, soNgayDiLam, soNgayNghiKhongPhep,
//						tienPhat, bhxh, luongTong);
//				listBangLuongNV.add(blnv);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listBangLuongNV;

		String jpql = "select bl from BangLuongNV bl";

		return em.createQuery(jpql, BangLuongNV.class).getResultList();
	}

	public List<BangLuongNV> getDSBangLuongNVTheoMaNV(String maNV) {
//		ArrayList<BangLuongNV> listBangLuongNVTheoMaNV = new ArrayList<BangLuongNV>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "Select * from BangLuongNhanVien where maNV = ?";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maNV);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String maLuongNV = rs.getString(1);
//				NhanVien nv = new NhanVien(rs.getString(2));
//				int thang = rs.getInt(3);
//				int nam = rs.getInt(4);
//				int soNgayDiLam = rs.getInt(5);
//				int soNgayNghiKhongPhep = rs.getInt(6);
//				double tienPhat = rs.getDouble(7);
//				double bhxh = rs.getDouble(8);
//				double luongTong = rs.getDouble(9);
//				BangLuongNV blnv = new BangLuongNV(maLuongNV, nv, thang, nam, soNgayDiLam, soNgayNghiKhongPhep,
//						tienPhat, bhxh, luongTong);
//				listBangLuongNVTheoMaNV.add(blnv);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listBangLuongNVTheoMaNV;

		String jpql = "select bl from BangLuongNV bl where bl.nv.maNV like :maNV";

		return em.createQuery(jpql, BangLuongNV.class).setParameter("maNV", maNV).getResultList();
	}

	public List<BangLuongNV> getDSBangLuongNVTheoThangNam(int thang, int nam) {
//		ArrayList<BangLuongNV> listBangLuongNVTheoThangNam = new ArrayList<BangLuongNV>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "Select * from BangLuongNhanVien where thang = ? and nam = ?";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, thang);
//			stmt.setInt(2, nam);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String maLuongNV = rs.getString(1);
//				NhanVien nv = new NhanVien(rs.getString(2));
//				int thang1 = rs.getInt(3);
//				int nam1 = rs.getInt(4);
//				int soNgayDiLam = rs.getInt(5);
//				int soNgayNghiKhongPhep = rs.getInt(6);
//				double tienPhat = rs.getDouble(7);
//				double bhxh = rs.getDouble(8);
//				double luongTong = rs.getDouble(9);
//				BangLuongNV blnv = new BangLuongNV(maLuongNV, nv, thang1, nam1, soNgayDiLam, soNgayNghiKhongPhep,
//						tienPhat, bhxh, luongTong);
//				listBangLuongNVTheoThangNam.add(blnv);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listBangLuongNVTheoThangNam;

		String jpql = "select bl from BangLuongNV bl where bl.thang = :thang and bl.nam = :nam";

		return em.createQuery(jpql, BangLuongNV.class).setParameter("thang", thang).setParameter("nam", nam)
				.getResultList();
	}

	public List<BangLuongNV> getDSBangLuongNVTheoMaNVThangNam(String maNV, int thang, int nam) {
//		ArrayList<BangLuongNV> listBangLuongNVTheoMaNVThangNam = new ArrayList<BangLuongNV>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "Select * from BangLuongNhanVien where maNV = ? and thang = ? and nam = ?";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maNV);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String maLuongNV = rs.getString(1);
//				NhanVien nv = new NhanVien(rs.getString(2));
//				int thang1 = rs.getInt(3);
//				int nam1 = rs.getInt(4);
//				int soNgayDiLam = rs.getInt(5);
//				int soNgayNghiKhongPhep = rs.getInt(6);
//				double tienPhat = rs.getDouble(7);
//				double bhxh = rs.getDouble(8);
//				double luongTong = rs.getDouble(9);
//				BangLuongNV blnv = new BangLuongNV(maLuongNV, nv, thang1, nam1, soNgayDiLam, soNgayNghiKhongPhep,
//						tienPhat, bhxh, luongTong);
//				listBangLuongNVTheoMaNVThangNam.add(blnv);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listBangLuongNVTheoMaNVThangNam;

		String jpql = "select bl from BangLuongNV bl "
				+ "where bl.nv.maNV like :maNV and bl.thang = :thang and bl.nam = :nam";

		return em.createQuery(jpql, BangLuongNV.class).setParameter("maNV", maNV).setParameter("thang", thang)
				.setParameter("nam", nam).getResultList();
	}

	public boolean insertBangLuongNV(BangLuongNV blnv) {
//		int n = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "insert into BangLuongNhanVien values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, blnv.getMaLuongNV());
//			stmt.setString(2, blnv.getNv().getMaNV());
//			stmt.setInt(3, blnv.getThang());
//			stmt.setInt(4, blnv.getNam());
//			stmt.setInt(5, blnv.getSoNgayDiLam());
//			stmt.setInt(6, blnv.getSoNgayNghiKhongPhep());
//			stmt.setDouble(7, blnv.getTienPhat());
//			stmt.setDouble(8, blnv.getBhxh());
//			stmt.setDouble(9, blnv.getLuongTong());
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;

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

	public boolean updateBangLuongNV(BangLuongNV blnv) {
//		int n = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "update BangLuongNhanVien set soNgayDiLam = ?, soNgayNghiKhongPhep = ?, tienPhat = ?, bhxh = ?, luongTong = ? where maLuongNV = ?";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, blnv.getSoNgayDiLam());
//			stmt.setInt(2, blnv.getSoNgayNghiKhongPhep());
//			stmt.setDouble(3, blnv.getTienPhat());
//			stmt.setDouble(4, blnv.getBhxh());
//			stmt.setDouble(5, blnv.getLuongTong());
//			stmt.setString(6, blnv.getMaLuongNV());
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;

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

	public BangLuongNV lay1BangLuongTheoMaNVThangNam(String maNV, int thang, int nam) {
//		BangLuongNV blnv = null;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "Select * from BangLuongNhanVien where maNV = ? and thang = ? and nam = ?";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maNV);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String maLuongNV = rs.getString(1);
//				NhanVien nv = new NhanVien(rs.getString(2));
//				int thang1 = rs.getInt(3);
//				int nam1 = rs.getInt(4);
//				int soNgayDiLam = rs.getInt(5);
//				int soNgayNghiKhongPhep = rs.getInt(6);
//				double tienPhat = rs.getDouble(7);
//				double bhxh = rs.getDouble(8);
//				double luongTong = rs.getDouble(9);
//				blnv = new BangLuongNV(maLuongNV, nv, thang1, nam1, soNgayDiLam, soNgayNghiKhongPhep, tienPhat, bhxh,
//						luongTong);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return blnv;

		String jpql = "select bl from BangLuongNV bl " + "where bl.nv.maNV like :maNV " + "and bl.thang = :thang "
				+ "and bl.nam = :nam";

		return em.createQuery(jpql, BangLuongNV.class).setParameter("maNV", maNV).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();
	}
}