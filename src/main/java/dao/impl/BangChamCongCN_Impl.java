package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.BangChamCongCN_DAO;
import entity.BangChamCongCN;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class BangChamCongCN_Impl extends UnicastRemoteObject implements BangChamCongCN_DAO {
	private EntityManager em;

	public BangChamCongCN_Impl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public synchronized List<BangChamCongCN> getBangCC() {
		String jpql = "select bcc from BangChamCongCN bcc";

		return em.createQuery(jpql).getResultList();
	}

	public synchronized List<String> listTatCaXuong(List<BangChamCongCN> listBangChamCongCongNhan) {
		String jpql = "select distinct x.maXuong from Xuong x";

		return em.createQuery(jpql).getResultList();
	}

	public synchronized int getSoNgayDiLamCua1CN(String maCN, int thang, int nam) {

		String jpql = "select count(bcc) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam " + "and bcc.coPhep = 1";

		return (int) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();
	}

	public synchronized double getTongSoGioTangCaCua1CN(String maCN, int thang, int nam) {
		double tongSoGioTangCa = 0;

		String jpql = "select sum(bcc.soGioTangCa) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam";

		tongSoGioTangCa = (double) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();

		return tongSoGioTangCa;
	}

	public synchronized double getSoBangChamCongCua1CN(String maCN, int thang, int nam) {
		int soBangChamCong = 0;

		String jpql = "select count(bcc) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam";

		soBangChamCong = (int) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();

		return soBangChamCong;
	}

	public synchronized List<BangChamCongCN> dsBangCCtheomaCNthangnam(String maNV, int thang, int nam) {

		String jpql = "select bcc from BangChamCongCN bcc " + "where month(bcc.ngayCham) = :thang "
				+ "and year(bcc.ngayCham) = :nam " + "and bcc.cn.maCN = :maNV";

		return em.createQuery(jpql).setParameter("thang", thang).setParameter("nam", nam).setParameter("maNV", maNV)
				.getResultList();
	}

	public synchronized ArrayList<BangChamCongCN> getBangCCTheoNgay(LocalDate ngayChamCong) {

		String jpql = "select bcc from BangChamCongCN bcc " + "where bcc.ngayCham = :ngayCham";

		return (ArrayList<BangChamCongCN>) em.createQuery(jpql).setParameter("ngayCham", ngayChamCong).getResultList();

	}

	public synchronized boolean insertBangChamCongCN(BangChamCongCN bangChamCongCN) {
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

	public synchronized boolean updateBangChamCongCN(BangChamCongCN bangCC) {
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
	public synchronized List<BangChamCongCN> getBangCCCNTheoThangvaNam(int thang, int nam) {
		ArrayList<BangChamCongCN> bangCC = new ArrayList<BangChamCongCN>();

		String jpql = "select bcc from BangChamCongCN bcc " + "where month(bcc.ngayCham) = :thang "
				+ "and year(bcc.ngayCham) = :nam";

		return em.createQuery(jpql).setParameter("thang", thang).setParameter("nam", nam).getResultList();
	}

	public synchronized List<LocalDate> layTatCaThangvaNamkhacNhauCN() {
		String jpql = "SELECT bcc FROM BangChamCongCN bcc";

		TypedQuery<BangChamCongCN> query = em.createQuery(jpql, BangChamCongCN.class);

		List<BangChamCongCN> bangCC = query.getResultList();

		List<LocalDate> list = bangCC.stream()
				.map(bcc -> LocalDate.of(bcc.getNgayCham().getYear(), bcc.getNgayCham().getMonth(), 1)).distinct()
				.collect(Collectors.toList());

		return list;
	}

	public synchronized List<String> layTatCaCongDoanTheoThang(int thang, int nam) {
		String jpql = "select distinct cd.maCongDoan from CongDoan cd join BangPhanCongCN bpc on cd.maCongDoan=bpc.maCD "
				+ "join CongNhan cn on cn.maCN=bpc.maCN join BangChamCongCN bcc on cn.maCN= bcc.cn.maCN "
				+ "where month(bcc.ngayCham) = :thang and year(bcc.ngayCham) = :nam";

		return em.createQuery(jpql).setParameter("thang", thang).setParameter("nam", nam).getResultList();
	}

	public synchronized List<String> laySanPhamTheoCongDoan(String maCD) {
		String jpql = "select distinct sp.maSP from SanPham sp join CongDoan cd on sp.maSP=cd.maSP where cd.maCongDoan=:maCD";

		return em.createQuery(jpql).setParameter("maCD", maCD).getResultList();
	}

	public synchronized List<BangChamCongCN> getBangCCCNTheomaCNThangNam(String maCN, int thang, int nam) {
		String jpql = "SELECT bcc FROM BangChamCongCN bcc WHERE bcc.cn.maCN = :maCN AND FUNCTION('MONTH', bcc.ngayCham) = :thang AND FUNCTION('YEAR', bcc.ngayCham) = :nam";

		TypedQuery<BangChamCongCN> query = em.createQuery(jpql, BangChamCongCN.class);
		query.setParameter("maCN", maCN);
		query.setParameter("thang", thang);
		query.setParameter("nam", nam);

		List<BangChamCongCN> bangCC = query.getResultList();
		return bangCC;

	}

	public synchronized int laySoSanLuongCuaCNTheoThangNam(String maCN, int thang, int nam) {
		int soSanLuong = 0;
		String jpql = "select sum(bcc.sanLuong) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam";

		Long soSanLuongLong = (Long) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();

		soSanLuong = soSanLuongLong != null ? soSanLuongLong.intValue() : 0;
		return soSanLuong;
	}

	public synchronized int laySoNgayDiLamCuaCNTheoThangNam(String maCN, int thang, int nam) {
		int soNgayDiLam = 0;
		String jpql = "select count(bcc) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam " + "and bcc.vangMat = false";

		soNgayDiLam = ((Long) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult()).intValue();
		return soNgayDiLam;
	}

	public synchronized int layTongSoGioTangCaCuaCNTheoThangNam(String maCN, int thang, int nam) {
		int soGioTangCa = 0;

		String jpql = "select sum(bcc.soGioTangCa) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam";

		Long soGioTangCaLong = (Long) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();

		soGioTangCa = soGioTangCaLong != null ? soGioTangCaLong.intValue() : 0;
		return soGioTangCa;

	}

	public synchronized double layGiaTienSanPhamTheoBCC(BangChamCongCN bcc) {
		double giaTien = 0;

		String jpql = "select distinct cd.giaTien from CongDoan cd join BangPhanCongCN bpc on cd.maCongDoan=bpc.congDoan.maCongDoan "
				+ "join CongNhan cn on cn.maCN=bpc.congNhan.maCN join BangChamCongCN bcc on cn.maCN= bcc.cn.maCN "
				+ "where bcc.cn.maCN = :maCN";

		giaTien = (double) em.createQuery(jpql).setParameter("maCN", bcc.getCN().getMaCN()).getSingleResult();

		return giaTien;
	}

	public synchronized int laySoNgayNghiKhongPhepCua1CNTheoThangNam(String maCN, int thang, int nam) {
		int soNgayDiLam = 0;
		String jpql = "select count(bcc) from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam "
				+ "and bcc.vangMat = true and bcc.coPhep = false";

		Long soNgayDiLamLong = (Long) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
				.setParameter("nam", nam).getSingleResult();

		soNgayDiLam = soNgayDiLamLong != null ? soNgayDiLamLong.intValue() : 0;
		return soNgayDiLam;
	}

	public synchronized boolean updateGhiChuBCCCN(BangChamCongCN bcccn) {
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

	public synchronized BangChamCongCN layBangChamCongCuoiCungCuaThang(String maCN, int thang, int nam) {
		String jpql = "select bcc from BangChamCongCN bcc " + "where bcc.cn.maCN = :maCN "
				+ "and month(bcc.ngayCham) = :thang " + "and year(bcc.ngayCham) = :nam " + "order by bcc.ngayCham desc";

		BangChamCongCN result = null;
		try {
			result = (BangChamCongCN) em.createQuery(jpql).setParameter("maCN", maCN).setParameter("thang", thang)
					.setParameter("nam", nam).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			// Handle or log the exception as needed
		}

		return result;
    }
	public synchronized List<Integer> layDSNamKhacnhauCCCN() {
		String jpql = "select distinct year(bcc.ngayCham) from BangChamCongCN bcc";
		List<Integer> list = em.createQuery(jpql).getResultList();
		return list;
	}

	public synchronized String layMaSPtheoMaCC(BangChamCongCN bc) {
		String jpql = "select cd.sanPham.maSP from CongDoan cd join BangPhanCongCN bpc on cd.maCongDoan=bpc.congDoan.maCongDoan "
				+ "join CongNhan cn on cn.maCN=bpc.congNhan.maCN join BangChamCongCN bcc on cn.maCN= bcc.cn.maCN "
				+ "where bcc.maChamCongCN = :maCC";

		return (String) em.createQuery(jpql).setParameter("maCC", bc.getMaChamCongCN()).getSingleResult();
	}
}
