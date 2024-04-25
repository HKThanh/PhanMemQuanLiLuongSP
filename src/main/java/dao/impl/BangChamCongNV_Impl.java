package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.BangChamCongNV_DAO;
import entity.BangChamCongNV;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class BangChamCongNV_Impl extends UnicastRemoteObject implements BangChamCongNV_DAO {
	private EntityManager em;
	
	public BangChamCongNV_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}
	
	public synchronized List<BangChamCongNV> getBangCC(){
		String jpql = "select cc from BangChamCongNV cc";
		
		return em.createQuery(jpql).getResultList();
		
	}
	//MinhThat
	public synchronized List<LocalDate> layTatCaThangvaNamkhacNhau(){
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
	public synchronized List<BangChamCongNV> dsBangChamCongNhanVienTheoTungThang(int thang, int nam){
		String jpql = "select cc from BangChamCongNV cc where MONTH(cc.ngayCham) = :thang and YEAR(cc.ngayCham) = :nam";
		
		return em.createQuery(jpql)
				.setParameter("thang", thang)
				.setParameter("nam", nam)
				.getResultList();
		
	}
	public synchronized List<BangChamCongNV> dsBangLuongtheothangnambophan( int thang, int nam, String bophan){
		String jpql = "select cc from BangChamCongNV cc "
				+ "join NhanVien nv on cc.nv.maNV = nv.maNV "
				+ "where MONTH(cc.ngayCham) = :thang and YEAR(cc.ngayCham) = :nam and nv.maBP = :bophan";
		
		return em.createQuery(jpql)
				.setParameter("thang", thang)
				.setParameter("nam", nam)
				.setParameter("bophan", bophan)
				.getResultList();
		
	}
	public synchronized List<String> listTatCaBoPhan(List<BangChamCongNV> listBangChamCongNhanVien){
		String jpql = "select distinct bp.maBoPhan from BoPhan bp " + "join bp.nhanViens nv "
				+ "join nv.bangChamCongNVs ccnv";

		return em.createQuery(jpql).getResultList();
		
	}
	public synchronized int getSoNgayDiLamCua1NV(String maNV, int thang, int nam) {
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
	public synchronized double getTongSoGioTangCaCua1NV(String maNV, int thang, int nam) {
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
	public synchronized double getSoBangChamCongCua1NV(String maNV, int thang, int nam) {
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
	public synchronized List<BangChamCongNV> dsBangCCtheomaNVthangnam(String maNV,int thang, int nam){
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
	
	public synchronized List<BangChamCongNV> getBangCCTheoNgay(LocalDate ngayChamCong){
		String jpql = "select cc from BangChamCongNV cc " + "where cc.ngayCham = :ngayCham";

		return em.createQuery(jpql)
				.setParameter("ngayCham", ngayChamCong).getResultList();
	}
		
	
	public synchronized boolean insertBangChamCongNV(BangChamCongNV bangChamCongNV) {
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
	
	public synchronized boolean updateBangChamCongNV(BangChamCongNV bangCC) {
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
	
	public synchronized List<BangChamCongNV> getBangCCTheoNgayBPCa(LocalDate ngayChamCong,String maBP, int ca){
		String jpql = "select cc from BangChamCongNV cc " + "join cc.nv nv " + "where cc.ngayCham = :ngayCham "
				+ "and nv.boPhan.maBoPhan = :maBoPhan " + "and nv.caLamViec = :ca";

		return em.createQuery(jpql)
				.setParameter("ngayCham", ngayChamCong)
				.setParameter("maBoPhan", maBP)
				.setParameter("ca", ca).getResultList();
	}
	
	public synchronized boolean updateGhiChiBangChamCongNV(BangChamCongNV bangCC) {
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
	
	public synchronized BangChamCongNV layBangCCCuoiCungThangCua1NV(String maNV, int thang, int nam) {
		BangChamCongNV bangCC = new BangChamCongNV();
		
		String jpql = "select cc from BangChamCongNV cc " + "where cc.nv.maNV = :maNV "
				+ "and MONTH(cc.ngayCham) = :thang " + "and YEAR(cc.ngayCham) = :nam " + "order by cc.ngayCham desc";

		try {
			bangCC = (BangChamCongNV) em.createQuery(jpql).setParameter("maNV", maNV).setParameter("thang", thang)
					.setParameter("nam", nam).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
		return bangCC;
	}
	public synchronized List<Integer> layDSNamKhacnhauCCNV (){
		String jpql = "select distinct year(cc.ngayCham) from BangChamCongNV cc";

		return em.createQuery(jpql).getResultList();
	}
}
