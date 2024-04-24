package dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.BangChamCongNV_DAO;
import entity.BangChamCongNV;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class BangChamCongNV_Impl implements BangChamCongNV_DAO {
	private EntityManager em;
	
	public BangChamCongNV_Impl() {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}
	
	public List<BangChamCongNV> getBangCC(){
		String jpql = "select cc from BangChamCongNV cc";
		
		return em.createQuery(jpql).getResultList();
		
	}
	//MinhThat
	public List<LocalDate> layTatCaThangvaNamkhacNhau(){
//		ArrayList<LocalDate> listThangvaNam = new ArrayList<LocalDate>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT DISTINCT MONTH(ngayCham), YEAR(ngayCham) FROM dbo.BangChamCongNhanVien";
//		PreparedStatement stmt = null;
//		int n =0;
//		try {
//			stmt= con.prepareStatement(sql);
//			ResultSet rs  = stmt.executeQuery();
//			
//			while(rs.next()) {
//				LocalDate thangvaNam = LocalDate.of(rs.getInt(2), rs.getInt(1), 1);
//				listThangvaNam.add(thangvaNam);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listThangvaNam;
		
//		String jpql = "select distinct cc.ngayCham from BangChamCongNV cc";
//
//		return em.createQuery(jpql).getResultList();
		List<LocalDate> listThangvaNam = new ArrayList<>();

	    String jpql = "SELECT DISTINCT FUNCTION('MONTH', b.ngayCham), FUNCTION('YEAR', b.ngayCham) FROM BangChamCongNV b";
	    Query query = em.createQuery(jpql);

	    List<Object[]> results = query.getResultList();

	    for (Object[] result : results) {
	        Integer month = (Integer) result[0];
	        Integer year = (Integer) result[1];

	        LocalDate thangvaNam = LocalDate.of(year, month, 1);
	        listThangvaNam.add(thangvaNam);
	    }

	    return listThangvaNam;
		
	}
	public List<BangChamCongNV> dsBangChamCongNhanVienTheoTungThang(int thang, int nam){
		String jpql = "select cc from BangChamCongNV cc where MONTH(cc.ngayCham) = :thang and YEAR(cc.ngayCham) = :nam";
		
		return em.createQuery(jpql)
				.setParameter("thang", thang)
				.setParameter("nam", nam)
				.getResultList();
		
	}
	public List<BangChamCongNV> dsBangLuongtheothangnambophan( int thang, int nam, String bophan){
		String jpql = "select cc from BangChamCongNV cc "
				+ "join NhanVien nv on cc.nv.maNV = nv.maNV "
				+ "where MONTH(cc.ngayCham) = :thang and YEAR(cc.ngayCham) = :nam and nv.maBP = :bophan";
		
		return em.createQuery(jpql)
				.setParameter("thang", thang)
				.setParameter("nam", nam)
				.setParameter("bophan", bophan)
				.getResultList();
		
	}
	public List<String> listTatCaBoPhan(List<BangChamCongNV> listBangChamCongNhanVien){
//		ArrayList<String> listBoPhan = new ArrayList<String>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT DISTINCT bp.maBoPhan from BoPhan bp join NhanVien nv on bp.maBoPhan=nv.maBP join BangChamCongNhanVien ccnv on nv.maNV=ccnv.maNV";
//		PreparedStatement stmt = null;
//		int n =0;
//		try {
//			stmt= con.prepareStatement(sql);
//			ResultSet rs  = stmt.executeQuery();
//			
//			while(rs.next()) {
//				String maBoPhan = rs.getString(1);
//				listBoPhan.add(maBoPhan);
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listBoPhan;
		
		String jpql = "select distinct bp.maBoPhan from BoPhan bp " + "join bp.nhanViens nv "
				+ "join nv.bangChamCongNVs ccnv";

		return em.createQuery(jpql).getResultList();
		
	}
	public int getSoNgayDiLamCua1NV(String maNV, int thang, int nam) {
//		int soNgayDiLam = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT COUNT(*) FROM dbo.BangChamCongNhanVien where maNV = ? and MONTH(ngayCham) = ? and YEAR(ngayCham) = ? and coMat = 1";
//		PreparedStatement stmt = null;
//		int n =0;
//		try {
//			stmt= con.prepareStatement(sql);
//			stmt.setString(1, maNV);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs  = stmt.executeQuery();
//			
//			while(rs.next()) {
//				soNgayDiLam = rs.getInt(1);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return soNgayDiLam;
		
		String jpql = "select count(cc) from BangChamCongNV cc "
				+ "where cc.nv.maNV = :maNV "
				+ "and MONTH(cc.ngayCham) = :thang "
				+ "and YEAR(cc.ngayCham) = :nam "
				+ "and cc.coMat = true";
		
		   return ((Long) em.createQuery(jpql)
		            .setParameter("maNV", maNV)
		            .setParameter("thang", thang)
		            .setParameter("nam", nam)
		            .getSingleResult()).intValue();
	}
	public double getTongSoGioTangCaCua1NV(String maNV, int thang, int nam) {
//		double tongSoGioTangCa = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT SUM(soGioTangCa) FROM dbo.BangChamCongNhanVien where maNV = ? and MONTH(ngayCham) = ? and YEAR(ngayCham) = ?";
//		PreparedStatement stmt = null;
//		int n =0;
//		try {
//			stmt= con.prepareStatement(sql);
//			stmt.setString(1, maNV);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs  = stmt.executeQuery();
//			
//			while(rs.next()) {
//				tongSoGioTangCa = rs.getInt(1);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return tongSoGioTangCa;
		
		String jpql = "select sum(cc.soGioTangCa) from BangChamCongNV cc " 
				+ "where cc.nv.maNV = :maNV "
				+ "and MONTH(cc.ngayCham) = :thang " 
				+ "and YEAR(cc.ngayCham) = :nam";

		Long result = (Long) em.createQuery(jpql)
				.setParameter("maNV", maNV)
				.setParameter("thang", thang)	
				.setParameter("nam", nam)
				.getSingleResult();
		return result == null ? 0 : result.doubleValue();
	}
	public double getSoBangChamCongCua1NV(String maNV, int thang, int nam) {
//		int soBangChamCong = 0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT COUNT(*) FROM dbo.BangChamCongNhanVien where maNV = ? and MONTH(ngayCham) = ? and YEAR(ngayCham) = ?";
//		PreparedStatement stmt = null;
//		int n =0;
//		try {
//			stmt= con.prepareStatement(sql);
//			stmt.setString(1, maNV);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs  = stmt.executeQuery();
//			
//			while(rs.next()) {
//				soBangChamCong = rs.getInt(1);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return soBangChamCong;
		
		String jpql = "select count(cc) from BangChamCongNV cc " 
				+ "where cc.nv.maNV = :maNV "
				+ "and MONTH(cc.ngayCham) = :thang " 
				+ "and YEAR(cc.ngayCham) = :nam";

		 Long result = (Long) em.createQuery(jpql)
				.setParameter("maNV", maNV)
				.setParameter("thang", thang)
				.setParameter("nam", nam)
				.getSingleResult();
		 return result != null ? result.intValue() : 0;
		
	}
	public List<BangChamCongNV> dsBangCCtheomaNVthangnam(String maNV,int thang, int nam){
//		ArrayList<BangChamCongNV> listBangChamCongNhanVien = new ArrayList<BangChamCongNV>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT * FROM dbo.BangChamCongNhanVien where MONTH(ngayCham) = ? and YEAR(ngayCham) = ? and maNV = ?";
//		PreparedStatement stmt = null;
//		int n =0;
//		try {
//			stmt= con.prepareStatement(sql);
//			stmt.setInt(1, thang);
//			stmt.setInt(2, nam);
//			stmt.setString(3, maNV);
//			ResultSet rs  = stmt.executeQuery();
//			
//			while(rs.next()) {
//				BangChamCongNV ccNV = new BangChamCongNV(rs.getString("maChamCong"));
//				ccNV.setNgayCham(rs.getDate("ngayCham").toLocalDate());
//				ccNV.setSoGioTangCa(rs.getInt("soGioTangCa"));
//				ccNV.setCaLam(rs.getInt("caLam"));
//				ccNV.setGhiChu(rs.getString("ghiChu"));
//				ccNV.setCoPhep(rs.getBoolean("coPhep"));
//				ccNV.setCoMat(rs.getBoolean("coMat"));
//				ccNV.setVangMat(rs.getBoolean("vangMat"));
//				NhanVien nv = new NhanVien(rs.getString("maNV"));
//				ccNV.setNv(nv);
//				
//				listBangChamCongNhanVien.add(ccNV);
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listBangChamCongNhanVien;
		
		String jpql = "select cc from BangChamCongNV cc " 
					+ "where cc.nv.maNV = :maNV "
					+ "and MONTH(cc.ngayCham) = :thang " 
					+ "and YEAR(cc.ngayCham) = :nam";
		
		return em.createQuery(jpql)
				.setParameter("maNV", maNV)
				.setParameter("thang", thang)
				.setParameter("nam", nam)
				.getResultList();
		
	}
	
	public List<BangChamCongNV> getBangCCTheoNgay(LocalDate ngayChamCong){
//		ArrayList<BangChamCongNV> bangCC = new ArrayList<BangChamCongNV>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT * FROM dbo.BangChamCongNhanVien where ngayCham = ?";
//		PreparedStatement stmt = null;
//		int n =0;
//		try {
//			stmt= con.prepareStatement(sql);
//			stmt.setString(1, String.valueOf(ngayChamCong));
//			ResultSet rs  = stmt.executeQuery();
//			
//			while(rs.next()) {
//				BangChamCongNV ccNV = new BangChamCongNV(rs.getString("maChamCong"));
//				ccNV.setNgayCham(rs.getDate("ngayCham").toLocalDate());
//				ccNV.setSoGioTangCa(rs.getInt("soGioTangCa"));
//				ccNV.setCaLam(rs.getInt("caLam"));
//				ccNV.setGhiChu(rs.getString("ghiChu"));
//				ccNV.setCoPhep(rs.getBoolean("coPhep"));
//				ccNV.setCoMat(rs.getBoolean("coMat"));
//				ccNV.setVangMat(rs.getBoolean("vangMat"));
//				NhanVien nv = new NhanVien(rs.getString("maNV"));
//				ccNV.setNv(nv);
//				
//				bangCC.add(ccNV);
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bangCC;
		
		String jpql = "select cc from BangChamCongNV cc " + "where cc.ngayCham = :ngayCham";

		return em.createQuery(jpql)
				.setParameter("ngayCham", ngayChamCong).getResultList();
	}
		
	
	public boolean insertBangChamCongNV(BangChamCongNV bangChamCongNV) {
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(bangChamCongNV);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updateBangChamCongNV(BangChamCongNV bangCC) {
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
	
	public List<BangChamCongNV> getBangCCTheoNgayBPCa(LocalDate ngayChamCong,String maBP, int ca){
//		ArrayList<BangChamCongNV> bangCC = new ArrayList<BangChamCongNV>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT * FROM dbo.BangChamCongNhanVien JOIN NhanVien ON BangChamCongNhanVien.maNV = NhanVien.maNV\r\n"
//				+ "WHERE BangChamCongNhanVien.ngayCham = ?"
//				+ "      AND NhanVien.maBP = ?"
//				+ "      AND NhanVien.caLamViec = ?";
//
//		PreparedStatement stmt = null;
//		int n =0;
//		try {
//			stmt= con.prepareStatement(sql);
//			stmt.setString(1, String.valueOf(ngayChamCong));
//			stmt.setString(2, maBP);
//			stmt.setInt(3, ca);
//			ResultSet rs  = stmt.executeQuery();
//			
//			while(rs.next()) {
//				BangChamCongNV ccNV = new BangChamCongNV(rs.getString("maChamCong"));
//				ccNV.setNgayCham(rs.getDate("ngayCham").toLocalDate());
//				ccNV.setSoGioTangCa(rs.getInt("soGioTangCa"));
//				ccNV.setCaLam(rs.getInt("caLam"));
//				ccNV.setGhiChu(rs.getString("ghiChu"));
//				ccNV.setCoPhep(rs.getBoolean("coPhep"));
//				ccNV.setCoMat(rs.getBoolean("coMat"));
//				ccNV.setVangMat(rs.getBoolean("vangMat"));
//				NhanVien nv = new NhanVien(rs.getString("maNV"));
//				ccNV.setNv(nv);
//				
//				bangCC.add(ccNV);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bangCC;
		
		String jpql = "select cc from BangChamCongNV cc " + "join cc.nv nv " + "where cc.ngayCham = :ngayCham "
				+ "and nv.boPhan.maBoPhan = :maBP " + "and nv.caLamViec = :ca";

		return em.createQuery(jpql).setParameter("ngayCham", ngayChamCong)
				.setParameter("maBP", maBP).setParameter("ca", ca).getResultList();
	}
	
	public boolean updateGhiChiBangChamCongNV(BangChamCongNV bangCC) {
//		int n=0;
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		
//		String sql = "update BangChamCongNhanVien set ghiChu=?  where maChamCong= ?";
//		PreparedStatement stmt = null;
//		try {
//			stmt= con.prepareStatement(sql);
//			stmt.setString(1, bangCC.getGhiChu());
//			stmt.setString(2, bangCC.getMaCCNV());
//			n= stmt.executeUpdate();
//			
//		} catch (SQLException e) {	
//			e.printStackTrace();
//		}finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//		}
//		return n>0;
		
		String jpql = "update BangChamCongNV cc set cc.ghiChu = :ghiChu where cc.maChamCongNV = :maChamCong";
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.createQuery(jpql).setParameter("ghiChu", bangCC.getGhiChu())
					.setParameter("maChamCong", bangCC.getMaChamCongNV()).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	
	public BangChamCongNV layBangCCCuoiCungThangCua1NV(String maNV, int thang, int nam) {
//		BangChamCongNV bangCC = new BangChamCongNV();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT TOP 1 * FROM dbo.BangChamCongNhanVien where maNV = ? and MONTH(ngayCham) = ? and YEAR(ngayCham) = ? order by ngayCham desc";
//		PreparedStatement stmt = null;
//		int n =0;		
//		try {
//			stmt= con.prepareStatement(sql);
//			stmt.setString(1, maNV);
//			stmt.setInt(2, thang);
//			stmt.setInt(3, nam);
//			ResultSet rs  = stmt.executeQuery();
//			
//			while(rs.next()) {
//				 bangCC = new BangChamCongNV(rs.getString("maChamCong"));
//				bangCC.setNgayCham(rs.getDate("ngayCham").toLocalDate());
//				bangCC.setSoGioTangCa(rs.getInt("soGioTangCa"));
//				bangCC.setCaLam(rs.getInt("caLam"));
//				bangCC.setGhiChu(rs.getString("ghiChu"));
//				bangCC.setCoPhep(rs.getBoolean("coPhep"));
//				bangCC.setCoMat(rs.getBoolean("coMat"));
//				bangCC.setVangMat(rs.getBoolean("vangMat"));
//				NhanVien nv = new NhanVien(rs.getString("maNV"));
//				bangCC.setNv(nv);
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bangCC;
		
		String jpql = "select cc from BangChamCongNV cc " + "where cc.nv.maNV = :maNV "
				+ "and MONTH(cc.ngayCham) = :thang " + "and YEAR(cc.ngayCham) = :nam " + "order by cc.ngayCham desc";

		return (BangChamCongNV) em.createQuery(jpql).setParameter("maNV", maNV).setParameter("thang", thang)
				.setParameter("nam", nam).setMaxResults(1).getSingleResult();
	}
	public List<Integer> layDSNamKhacnhauCCNV (){
//		ArrayList<Integer> listNam = new ArrayList<Integer>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT DISTINCT YEAR(ngayCham) FROM dbo.BangChamCongNhanVien";
//		PreparedStatement stmt = null;
//		int n =0;
//		try {
//			stmt= con.prepareStatement(sql);
//			ResultSet rs  = stmt.executeQuery();
//			
//			while(rs.next()) {
//				int nam = rs.getInt(1);
//				listNam.add(nam);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listNam;
		
		String jpql = "select distinct year(cc.ngayCham) from BangChamCongNV cc";

		return em.createQuery(jpql).getResultList();
	}
}
