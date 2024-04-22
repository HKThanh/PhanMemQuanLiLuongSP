package dao.impl;

import java.util.List;

import dao.CongNhan_DAO;
import entity.CongNhan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CongNhan_Impl implements CongNhan_DAO {
	private EntityManager em;

	public CongNhan_Impl() {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public List<CongNhan> getListCN() {
		String jpql = "select cn from CongNhan cn";

		return em.createQuery(jpql).getResultList();
	}

	public boolean insertCN(CongNhan cn) {
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

	public boolean deleteCN(String maCN) {
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

	public boolean updateCN(CongNhan cn) {
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

	public List<CongNhan> getListCNtheoXuong(String maXuong) {
		String jpql = "select cn from CongNhan cn where cn.xuong.maXuong = :maXuong";

		return em.createQuery(jpql).setParameter("maXuong", maXuong).getResultList();
	}

	public List<CongNhan> getListCNtheoNamVaoLam(int nam) {
		String jpql = "select cn from CongNhan cn where year(cn.ngayBatDauLamViec) = :nam";

		return em.createQuery(jpql).setParameter("nam", nam).getResultList();
	}

	public List<CongNhan> getListNVtheoNamXuong(int nam, String maXuong) {
		String jpql = "select cn from CongNhan cn where year(cn.ngayBatDauLamViec) = :nam and cn.xuong.maXuong = :maXuong";

		return em.createQuery(jpql).setParameter("nam", nam).setParameter("maXuong", maXuong)
				.getResultList();
	}

	public List<CongNhan> getDSCongNhan() {
		String jpql = "select cn from CongNhan cn";

		return em.createQuery(jpql).getResultList();
	}

	public List<CongNhan> getDSCongNhanTheoXuong(String xuong) {
		String jpql = "select cn from CongNhan cn where cn.xuong.tenXuong like :xuong";

		return em.createQuery(jpql).setParameter("xuong", xuong).getResultList();
	}

	public CongNhan getCongNhanTheoMaCN(String ma) {
		return em.find(CongNhan.class, ma);
	}

	public List<CongNhan> getDSCongNhanTheoXuongVaChuaDuocPhanCong(String xuong) {
		String jpql = "select cn from CongNhan cn where cn.xuong.tenXuong like :xuong";

		return em.createQuery(jpql).setParameter("xuong", xuong).getResultList();
	}

	public List<CongNhan> getListCntheoXuongCa(int ca, String maXuong) {
		String jpql = "select cn from CongNhan cn where cn.caLamViec = :ca and cn.xuong.maXuong = :maXuong";

		return em.createQuery(jpql).setParameter("ca", ca).setParameter("maXuong", maXuong)
				.getResultList();
	}

	// Minh Thật
	public List<CongNhan> layDanhSachCNTheoDK(String maXuong) {
//		ArrayList<CongNhan> list = new ArrayList<CongNhan>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "select cn.* from CongNhan cn join Xuong x on cn.maXuong=x.maXuong where x.tenXuong like ?";
//		try {
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setString(1, maXuong);
//			ResultSet rs = stmt.executeQuery();
//			while(rs.next()) {
//				CongNhan cn = new CongNhan();
//				cn.setMaCN(rs.getString(1));
//				cn.setAnhDaiDien(rs.getBytes(2));
//				cn.setHo(rs.getString(3));
//				cn.setTen(rs.getString(4));
//				cn.setGioiTinh(rs.getBoolean(5));
//				java.sql.Date ngaySinh = rs.getDate(6);
//				LocalDate NgaySinh = ngaySinh.toLocalDate();
//				cn.setcCCD(rs.getString(7));
//				cn.setDiaChi(rs.getString(8));
//				cn.setSoDienThoai(rs.getString(9));
//				cn.setChuyenMon(rs.getNString(10));
//				cn.setCaLamViec(rs.getInt(11));
//				cn.setPhuCap(rs.getDouble(12));
//				cn.setLuongCoBan(rs.getDouble(13));
//				java.sql.Date ngayBatDauLamViec = rs.getDate(14);
//				LocalDate NgayBatDauLamViec = ngayBatDauLamViec.toLocalDate();	
//				Xuong x = new Xuong(rs.getString(15));
//				cn.setXuong(x);
//				list.add(cn);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;

		String jpql = "select cn from CongNhan cn where cn.xuong.tenXuong like :maXuong";

		return em.createQuery(jpql).setParameter("maXuong", maXuong).getResultList();
	}
}
