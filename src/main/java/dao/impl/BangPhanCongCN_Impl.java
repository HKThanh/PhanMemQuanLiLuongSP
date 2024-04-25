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
	public List<BangPhanCongCN> getDSPhanCongCongDoanTheoMaCD(String ma) {
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
	public boolean insertPhanCongCongNhan(BangPhanCongCN bpccn) {
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
	public List<BangPhanCongCN> getDSCongNhanTheoXuongVaDuocPhanCong(String ma) {
//		ArrayList<BangPhanCongCN> listCNDuocPhanCong = new ArrayList<BangPhanCongCN>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "select bpccn.* from CongNhan cn join Xuong x "
//				+ "on cn.maXuong = x.maXuong left join BangPhanCongCN bpccn "
//				+ "on cn.maCN = bpccn.maCN "
//				+ "where bpccn.maPCCN is not null and maCD = ?";
//		PreparedStatement stmt = null;
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, ma);
//			
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String maPCCN = rs.getString(1);
//				boolean trangThai = rs.getBoolean(2);
//				LocalDate ngayPhanCong = rs.getDate(3).toLocalDate();
//				int soLuongSP = rs.getInt(4);
//				CongNhan cn = new CongNhan(rs.getString(5));
//				CongDoan cd = new CongDoan(rs.getString(6));
//				
//				BangPhanCongCN bpccn = new BangPhanCongCN(maPCCN, trangThai, ngayPhanCong, soLuongSP, cn, cd);
//				listCNDuocPhanCong.add(bpccn);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//			}
//		}
//		return listCNDuocPhanCong;

		String jpql = "select bpccn from BangPhanCongCN bpccn "
				+ "where bpccn.congDoan.maCongDoan = :ma and bpccn.maPhanCong is not null";

		return em.createQuery(jpql).setParameter("ma", ma).getResultList();
	}

	/**
	 * Phương thức lấy danh sách công nhân được phân công
	 * 
	 * @return ArrayList
	 */
	public List<BangPhanCongCN> getDSCongNhanDuocPhanCong() {

		String jpql = "select bpccn from BangPhanCongCN bpccn where bpccn.maPhanCong is not null";

		return em.createQuery(jpql).getResultList();
	}

	/**
	 * Phương thức xoá toàn bộ phân công của công đoạn theo mã công đoạn
	 * 
	 * @param ma
	 * @return true nếu xoá thành công, false nếu thất bại
	 */
	public boolean deleteALLPCCuaCongDoan(String ma) {
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
	
	public int getDSPCTheoMaCD(String maCD) {
		String jpql = "select distinct bpccn.soLuongSanPham from BangPhanCongCN bpccn where bpccn.congDoan.maCongDoan = :maCD";
		
		return em.createQuery(jpql, Integer.class).setParameter("maCD", maCD).getSingleResult();
	}
}
