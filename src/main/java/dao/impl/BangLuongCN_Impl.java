package dao.impl;

import dao.BangLuongCN_DAO;
import entity.BangLuongCN;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class BangLuongCN_Impl implements BangLuongCN_DAO {
	private EntityManager em;

	public BangLuongCN_Impl() {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public int getSize() {
		return em.createQuery("select bl from BangLuongCN bl", BangLuongCN.class).getResultList().size();
	}

	public BangLuongCN getMotBangLuongCNTheoThangNam(String maCN, int thang, int nam) {
//		BangLuongCN bangLuongCN = null;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT * FROM dbo.BangLuongCongNhan WHERE MaCN = ? AND Thang = ? AND Nam = ?";
//
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maCN);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String maLuongCN = rs.getString(1);
//				int thang1 = rs.getInt(3);
//				int nam1 = rs.getInt(4);
//				int tongSanLuong = rs.getInt(5);
//				int soNgayNghiKhongPhep = rs.getInt(6);
//				double tienPhat = rs.getDouble(7);
//				double bhxh = rs.getDouble(8);
//				double luongTong = rs.getDouble(9);
//				CongNhan congNhan = new CongNhan_DAO().getCongNhanTheoMaCN(rs.getString(2));
//				bangLuongCN = new BangLuongCN(maLuongCN, congNhan, thang1, nam1, tongSanLuong, soNgayNghiKhongPhep,
//						tienPhat, bhxh, luongTong);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//		}
//		return bangLuongCN;
		
//		String jpql = "select bl from BangLuongCN bl "
//				+ "where bl.cn.maCN like :maCN "
//				+ "and bl.thang = :thang "
//				+ "and bl.nam = :nam";
//		
//		return em.createQuery(jpql, BangLuongCN.class)
//				.setParameter("maCN", maCN)
//				.setParameter("thang", thang)
//				.setParameter("nam", nam)
//				.getSingleResult();
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

	public boolean insertBangLuongCN(BangLuongCN bangLuongCN) {
//		int n = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		String sql = "INSERT INTO dbo.BangLuongCongNhan VALUES(?,?,?,?,?,?,?,?,?)";
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, bangLuongCN.getMaLuongCN());
//			stmt.setString(2, bangLuongCN.getCn().getMaCN());
//			stmt.setInt(3, bangLuongCN.getThang());
//			stmt.setInt(4, bangLuongCN.getNam());
//			stmt.setInt(5, bangLuongCN.getTongSanLuong());
//			stmt.setInt(6, bangLuongCN.getSoNgayNghiKhongPhep());
//			stmt.setDouble(7, bangLuongCN.getTienPhat());
//			stmt.setDouble(8, bangLuongCN.getBhxh());
//			stmt.setDouble(9, bangLuongCN.getLuongTong());
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;
		
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

	public boolean updateBangLuongCN(BangLuongCN bangLuongCN) {
//		int n = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		String sql = "UPDATE dbo.BangLuongCongNhan SET sanLuongTong = ?, SoNgayNghiKhongPhep = ?, TienPhat = ?, BHXH = ?, LuongTong = ? WHERE MaLuongCN = ?";
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, bangLuongCN.getTongSanLuong());
//			stmt.setInt(2, bangLuongCN.getSoNgayNghiKhongPhep());
//			stmt.setDouble(3, bangLuongCN.getTienPhat());
//			stmt.setDouble(4, bangLuongCN.getBhxh());
//			stmt.setDouble(5, bangLuongCN.getLuongTong());
//			stmt.setString(6, bangLuongCN.getMaLuongCN());
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;
		
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
