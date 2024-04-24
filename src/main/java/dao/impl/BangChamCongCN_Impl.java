package dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.BangChamCongCN_DAO;
import entity.BangChamCongCN;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BangChamCongCN_Impl implements BangChamCongCN_DAO {
	private EntityManager em;

	public BangChamCongCN_Impl() {
		em = demo.Main.getEm();
	}

	public List<BangChamCongCN> getBangCC() {
		String jpql = "select bcc from BangChamCongCN bcc";

		return em.createQuery(jpql).getResultList();
	}

	public List<String> listTatCaXuong(List<BangChamCongCN> listBangChamCongCongNhan) {
		String jpql = "select distinct x.maXuong from Xuong x";

		return em.createQuery(jpql).getResultList();
	}

	public int getSoNgayDiLamCua1CN(String maCN, int thang, int nam) {
//		int soNgayDiLam = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT COUNT(*) FROM dbo.BangChamCongCongNhan where maCN = ? and MONTH(ngayCham) = ? and YEAR(ngayCham) = ? and coPhep = 1";
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maCN);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				soNgayDiLam = rs.getInt(1);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return soNgayDiLam;

		String jpql = "select count(bcc) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam " + "and bcc.coPhep = 1";

		return (int) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();
	}

	public double getTongSoGioTangCaCua1CN(String maCN, int thang, int nam) {
		double tongSoGioTangCa = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT SUM(soGioTangCa) FROM dbo.BangChamCongNhanVien where maCN = ? and MONTH(ngayCham) = ? and YEAR(ngayCham) = ?";
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maCN);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				tongSoGioTangCa = rs.getInt(1);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		String jpql = "select sum(bcc.soGioTangCa) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam";

		tongSoGioTangCa = (double) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();

		return tongSoGioTangCa;
	}

	public double getSoBangChamCongCua1CN(String maCN, int thang, int nam) {
		int soBangChamCong = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT COUNT(*) FROM dbo.BangChamCongNhanVien where maCN = ? and MONTH(ngayCham) = ? and YEAR(ngayCham) = ?";
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maCN);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				soBangChamCong = rs.getInt(1);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		String jpql = "select count(bcc) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam";

		soBangChamCong = (int) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();

		return soBangChamCong;
	}

	public List<BangChamCongCN> dsBangCCtheomaCNthangnam(String maNV, int thang, int nam) {
//		ArrayList<BangChamCongCN> listBangChamCongCongNhan = new ArrayList<BangChamCongCN>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT * FROM dbo.BangChamCongNhanVien where MONTH(ngayCham) = ? and YEAR(ngayCham) = ? and maNV = ?";
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, thang);
//			stmt.setInt(2, nam);
//			stmt.setString(3, maNV);
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				BangChamCongCN ccCN = new BangChamCongCN(rs.getString("maChamCong"));
//				ccCN.setNgayCham(rs.getDate("ngayCham").toLocalDate());
//				ccCN.setSoGioTangCa(rs.getInt("soGioTangCa"));
//				ccCN.setCaLam(rs.getInt("caLam"));
//				ccCN.setGhiChu(rs.getString("ghiChu"));
//				ccCN.setCoPhep(rs.getBoolean("coPhep"));
//				ccCN.setVangMat(rs.getBoolean("vangMat"));
//				CongNhan cn = new CongNhan(rs.getString("maCN"));
//				ccCN.setCn(cn);
//
//				listBangChamCongCongNhan.add(ccCN);
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listBangChamCongCongNhan;

		String jpql = "select bcc from BangChamCongCN bcc " + "where month(bcc.ngayCham) = :thang "
				+ "and year(bcc.ngayCham) = :nam " + "and bcc.cn.maCN = :maNV";

		return em.createQuery(jpql).setParameter("thang", thang).setParameter("nam", nam).setParameter("maNV", maNV)
				.getResultList();
	}

	public ArrayList<BangChamCongCN> getBangCCTheoNgay(LocalDate ngayChamCong) {
//		ArrayList<BangChamCongCN> bangCC = new ArrayList<BangChamCongCN>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT * FROM dbo.BangChamCongNhanVien where ngayCham = ?";
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, String.valueOf(ngayChamCong));
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				BangChamCongCN ccNV = new BangChamCongCN(rs.getString("maChamCong"));
//				ccNV.setNgayCham(rs.getDate("ngayCham").toLocalDate());
//				ccNV.setSoGioTangCa(rs.getInt("soGioTangCa"));
//				ccNV.setCaLam(rs.getInt("caLam"));
//				ccNV.setGhiChu(rs.getString("ghiChu"));
//				ccNV.setCoPhep(rs.getBoolean("coPhep"));
//				ccNV.setVangMat(rs.getBoolean("vangMat"));
//				CongNhan cn = new CongNhan(rs.getString("maNV"));
//				ccNV.setCn(cn);
//
//				bangCC.add(ccNV);
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bangCC;

		String jpql = "select bcc from BangChamCongCN bcc " + "where bcc.ngayCham = :ngayCham";

		return (ArrayList<BangChamCongCN>) em.createQuery(jpql).setParameter("ngayCham", ngayChamCong).getResultList();

	}

	public boolean insertBangChamCongCN(BangChamCongCN bangChamCongCN) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(bangChamCongCN);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateBangChamCongCN(BangChamCongCN bangCC) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(bangCC);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return false;
	}

	// Minh Thật
	public List<BangChamCongCN> getBangCCCNTheoThangvaNam(int thang, int nam) {
		ArrayList<BangChamCongCN> bangCC = new ArrayList<BangChamCongCN>();
//		ConnectDB.getInstance();
//		Statement state = null;
//		try {
//			Connection con = ConnectDB.getConnection();
//			String Sql = "SELECT * FROM dbo.BangChamCongCongNhan where MONTH(NgayCham)=" + thang
//					+ " and YEAR(NgayCham)=" + nam;
//			state = con.createStatement();
//			ResultSet rs = state.executeQuery(Sql);
//			while (rs.next()) {
//				BangChamCongCN ccCN = new BangChamCongCN();
//				ccCN.setMaCCCN(rs.getString(1));
//				java.sql.Date ngayCham = rs.getDate(2);
//				LocalDate NgayCham = ngayCham.toLocalDate();
//				ccCN.setVangMat(rs.getBoolean(4));
//				ccCN.setCoPhep(rs.getBoolean(5));
//				ccCN.setSoGioTangCa(rs.getInt(6));
//				ccCN.setSanLuong(rs.getInt(7));
//				ccCN.setGhiChu(rs.getString(8));
//				cn_DAO = new CongNhan_DAO();
//				CongNhan cn = cn_DAO.getCongNhanTheoMaCN(rs.getString(3));
//				ccCN.setCn(cn);
//				ccCN.setCaLam(cn.getCaLamViec());
//				bangCC.add(ccCN);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bangCC

		String jpql = "select bcc from BangChamCongCN bcc " + "where month(bcc.ngayCham) = :thang "
				+ "and year(bcc.ngayCham) = :nam";

		return em.createQuery(jpql).setParameter("thang", thang).setParameter("nam", nam).getResultList();
	}

	public List<LocalDate> layTatCaThangvaNamkhacNhauCN() {
//		ArrayList<LocalDate> list = new ArrayList<LocalDate>();
//		ConnectDB.getInstance();
//		Statement state = null;
//		try {
//			Connection con = ConnectDB.getConnection();
//			String Sql = "SELECT DISTINCT MONTH(NgayCham), YEAR(NgayCham) FROM dbo.BangChamCongCongNhan";
//			state = con.createStatement();
//			ResultSet rs = state.executeQuery(Sql);
//			while (rs.next()) {
//				LocalDate date = LocalDate.of(rs.getInt(2), rs.getInt(1), 1);
//				list.add(date);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;

		String jpql = "select distinct month(bcc.ngayCham), year(bcc.ngayCham) from BangChamCongCN bcc";
		List<Object[]> list = em.createQuery(jpql).getResultList();
		List<LocalDate> listDate = new ArrayList<LocalDate>();
		for (Object[] objects : list) {
			LocalDate date = LocalDate.of((int) objects[1], (int) objects[0], 1);
			listDate.add(date);
		}
		return listDate;
	}

	public List<String> layTatCaCongDoanTheoThang(int thang, int nam) {
//		ArrayList<String> list = new ArrayList<String>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT DISTINCT cd.maCongDoan from CongDoan cd join BangPhanCongCN bpc on cd.maCongDoan=bpc.maCD join CongNhan cn on cn.maCN=bpc.maCN join BangChamCongCongNhan bcc on cn.maCN= bcc.maCN where MONTH(NgayCham)="
//				+ thang + " and YEAR(NgayCham)=" + nam;
//		try {
//			Statement state = con.createStatement();
//			ResultSet rs = state.executeQuery(sql);
//			while (rs.next()) {
//				list.add(rs.getString(1));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;

		String jpql = "select distinct cd.maCongDoan from CongDoan cd join BangPhanCongCN bpc on cd.maCongDoan=bpc.maCD "
				+ "join CongNhan cn on cn.maCN=bpc.maCN join BangChamCongCN bcc on cn.maCN= bcc.cn.maCN "
				+ "where month(bcc.ngayCham) = :thang and year(bcc.ngayCham) = :nam";

		return em.createQuery(jpql).setParameter("thang", thang).setParameter("nam", nam).getResultList();
	}

	public List<String> laySanPhamTheoCongDoan(String maCD) {
//		ArrayList<String> list = new ArrayList<String>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT DISTINCT sp.maSP from SanPham sp join CongDoan cd on sp.maSP=cd.maSP where cd.maCongDoan='"
//				+ maCD + "'";
//		try {
//			Statement state = con.createStatement();
//			ResultSet rs = state.executeQuery(sql);
//			while (rs.next()) {
//				list.add(rs.getString(1));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;

		String jpql = "select distinct sp.maSP from SanPham sp join CongDoan cd on sp.maSP=cd.maSP where cd.maCongDoan=:maCD";

		return em.createQuery(jpql).setParameter("maCD", maCD).getResultList();
	}

	public List<BangChamCongCN> getBangCCCNTheomaCNThangNam(String maCN, int thang, int nam) {
//		ArrayList<BangChamCongCN> bangCC = new ArrayList<BangChamCongCN>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String Sql = "SELECT * FROM dbo.BangChamCongCongNhan where maCN= ? and MONTH(NgayCham)=? and YEAR(NgayCham)=?";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(Sql);
//			stmt.setString(1, maCN);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				BangChamCongCN ccCN = new BangChamCongCN();
//				ccCN.setMaCCCN(rs.getString(1));
//				ccCN.setNgayCham(rs.getDate(2).toLocalDate());
//				ccCN.setVangMat(rs.getBoolean(4));
//				ccCN.setCoPhep(rs.getBoolean(5));
//				ccCN.setSoGioTangCa(rs.getInt(6));
//				ccCN.setSanLuong(rs.getInt(7));
//				ccCN.setGhiChu(rs.getString(8));
//				cn_DAO = new CongNhan_DAO();
//				CongNhan cn = cn_DAO.getCongNhanTheoMaCN(rs.getString(3));
//				ccCN.setCn(cn);
//				ccCN.setCaLam(cn.getCaLamViec());
//				bangCC.add(ccCN);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bangCC;

		String jpql = "select bcc from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam";

		return em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang).setParameter("nam", nam)
				.getResultList();
	}

	public int laySoSanLuongCuaCNTheoThangNam(String maCN, int thang, int nam) {
		int soSanLuong = 0;
//		ConnectDB.getInstance();
//		Statement state = null;
//		try {
//			Connection con = ConnectDB.getConnection();
//			String Sql = "SELECT SUM(SanLuong) FROM dbo.BangChamCongCongNhan where maCN='" + maCN
//					+ "' and MONTH(NgayCham)=" + thang + " and YEAR(NgayCham)=" + nam;
//			state = con.createStatement();
//			ResultSet rs = state.executeQuery(Sql);
//			while (rs.next()) {
//				soSanLuong = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		String jpql = "select sum(bcc.sanLuong) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam";

		soSanLuong = (int) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();
		return soSanLuong;
	}

	public int laySoNgayDiLamCuaCNTheoThangNam(String maCN, int thang, int nam) {
		int soNgayDiLam = 0;
//		ConnectDB.getInstance();
//		Statement state = null;
//		try {
//			Connection con = ConnectDB.getConnection();
//			String Sql = "SELECT COUNT(NgayCham) FROM dbo.BangChamCongCongNhan where maCN='" + maCN
//					+ "' and MONTH(NgayCham)=" + thang + " and YEAR(NgayCham)=" + nam + " and VangMat=0";
//			state = con.createStatement();
//			ResultSet rs = state.executeQuery(Sql);
//			while (rs.next()) {
//				soNgayDiLam = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		String jpql = "select count(bcc) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam " + "and bcc.vangMat = 0";

		soNgayDiLam = (int) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();
		return soNgayDiLam;
	}

	public int layTongSoGioTangCaCuaCNTheoThangNam(String maCN, int thang, int nam) {
		int soGioTangCa = 0;
//		ConnectDB.getInstance();
//		Statement state = null;
//		try {
//			Connection con = ConnectDB.getConnection();
//			String Sql = "SELECT SUM(SoGioTangCa) FROM dbo.BangChamCongCongNhan where maCN='" + maCN
//					+ "' and MONTH(NgayCham)=" + thang + " and YEAR(NgayCham)=" + nam;
//			state = con.createStatement();
//			ResultSet rs = state.executeQuery(Sql);
//			while (rs.next()) {
//				soGioTangCa = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		String jpql = "select sum(bcc.soGioTangCa) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam";

		soGioTangCa = (int) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();

		return soGioTangCa;
	}

	public double layGiaTienSanPhamTheoBCC(BangChamCongCN bcc) {
		double giaTien = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String Sql = "select cd.giaTien from CongNhan cn join BangPhanCongCN bpc on cn.maCN=bpc.maCN join CongDoan cd on bpc.maCD=cd.maCongDoan join SanPham sp on cd.maSP=sp.maSP join BangChamCongCongNhan bcc on bcc.maCN=cn.maCN where bcc.maCN=?";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(Sql);
//			stmt.setString(1, bcc.getCn().getMaCN());
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				giaTien = rs.getDouble(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		String jpql = "select cd.giaTien from CongDoan cd join BangPhanCongCN bpc on cd.maCongDoan=bpc.maCD "
				+ "join CongNhan cn on cn.maCN=bpc.maCN join BangChamCongCN bcc on cn.maCN= bcc.cn.maCN "
				+ "where bcc.cn.maCN = :maCN";

		giaTien = (double) em.createQuery(jpql).setParameter("maCN", bcc.getCN().getMaCN()).getSingleResult();

		return giaTien;
	}

	public int laySoNgayNghiKhongPhepCua1CNTheoThangNam(String maCN, int thang, int nam) {
		int soNgayDiLam = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String Sql = "SELECT COUNT(NgayCham) FROM dbo.BangChamCongCongNhan where maCN= ? and MONTH(NgayCham)=? and YEAR(NgayCham)=? and VangMat=1 and CoPhep=0";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(Sql);
//			stmt.setString(1, maCN);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				soNgayDiLam = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		String jpql = "select count(bcc) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam "
				+ "and bcc.vangMat = 1 and bcc.coPhep = 0";

		soNgayDiLam = (int) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();

		return soNgayDiLam;
	}

	public boolean updateGhiChuBCCCN(BangChamCongCN bcccn) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.merge(bcccn);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return false;
	}

	public BangChamCongCN layBangChamCongCuoiCungCuaThang(String maCN, int thang, int nam) {
//		BangChamCongCN bcccn = null;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT TOP 1 * FROM dbo.BangChamCongCongNhan WHERE maCN = ? AND MONTH(NgayCham) = ? AND YEAR(NgayCham) = ? ORDER BY NgayCham DESC";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maCN);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				bcccn = new BangChamCongCN();
//				bcccn.setMaCCCN(rs.getString(1));
//				java.sql.Date ngayCham = rs.getDate(2);
//				LocalDate NgayCham = ngayCham.toLocalDate();
//				bcccn.setVangMat(rs.getBoolean(4));
//				bcccn.setCoPhep(rs.getBoolean(5));
//				bcccn.setSoGioTangCa(rs.getInt(6));
//				bcccn.setSanLuong(rs.getInt(7));
//				bcccn.setGhiChu(rs.getString(8));
//				cn_DAO = new CongNhan_DAO();
//				CongNhan cn = cn_DAO.getCongNhanTheoMaCN(rs.getString(3));
//				bcccn.setCn(cn);
//				bcccn.setCaLam(cn.getCaLamViec());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bcccn;

		String jpql = "select bcc from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam " + "order by bcc.ngayCham desc";

		return (BangChamCongCN) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).setMaxResults(1).getSingleResult();
	}

	public List<Integer> layDSNamKhacnhauCCCN() {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		ConnectDB.getInstance();
//		Statement state = null;
//		try {
//			Connection con = ConnectDB.getConnection();
//			String Sql = "SELECT DISTINCT YEAR(NgayCham) FROM dbo.BangChamCongCongNhan";
//			state = con.createStatement();
//			ResultSet rs = state.executeQuery(Sql);
//			while (rs.next()) {
//				list.add(rs.getInt(1));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;

		String jpql = "select distinct year(bcc.ngayCham) from BangChamCongCN bcc";
		List<Integer> list = em.createQuery(jpql).getResultList();
		return list;
	}

	public String layMaSPtheoMaCC(BangChamCongCN bc) {
//		String maSP = null;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//
//		String sql = "select sp.maSP from CongNhan cn join BangPhanCongCN bpc on cn.maCN=bpc.maCN join CongDoan cd on bpc.maCD=cd.maCongDoan join SanPham sp on cd.maSP=sp.maSP join BangChamCongCongNhan bcc on bcc.maCN=cn.maCN where bcc.maCC =?";
//		PreparedStatement stmt = null;
//
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, bc.getMaCCCN());
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				maSP = rs.getString(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return maSP;

		String jpql = "select sp.maSP from CongDoan cd join BangPhanCongCN bpc on cd.maCongDoan=bpc.maCD "
				+ "join CongNhan cn on cn.maCN=bpc.maCN join BangChamCongCN bcc on cn.maCN= bcc.cn.maCN "
				+ "where bcc.maChamCongCN = :maCC";

		return (String) em.createQuery(jpql).setParameter("maCC", bc.getMaChamCongCN()).getSingleResult();
	}
}
