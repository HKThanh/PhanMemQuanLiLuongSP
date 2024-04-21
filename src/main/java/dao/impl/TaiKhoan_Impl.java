package dao.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.TaiKhoan_DAO;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TaiKhoan_Impl implements TaiKhoan_DAO {
	private EntityManager em;

	public TaiKhoan_Impl() {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public List<TaiKhoan> getListTK() {
		String jpql = "SELECT tk FROM TaiKhoan tk";

		return em.createQuery(jpql).getResultList();
	}

	public int getSize() {
		String jpql = "SELECT tk FROM TaiKhoan tk";

		return em.createQuery(jpql).getResultList().size();
	}

	public boolean insert(TaiKhoan tk) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(tk);
			tx.commit();

			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return false;
	}

	public TaiKhoan soSanhPWD(String tk, String mk) {
		TaiKhoan temp = null;
		String pwdHash = "";

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(mk.getBytes());
			byte[] digest = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : digest) {
				sb.append(String.format("%02x", b));
			}

			pwdHash = sb.toString().toUpperCase().substring(0, 16);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(pwdHash);

		String jpql = "SELECT tk FROM TaiKhoan tk WHERE tk.taiKhoan = :tk AND tk.matKhau = :pwd";
		temp = (TaiKhoan) em.createQuery(jpql)
							.setParameter("tk", tk)
							.setParameter("pwd", pwdHash)
							.getResultList()
							.stream()
							.findFirst()
							.orElse(null);

		return temp;
	}

	public String getBoPhanCuaNV(TaiKhoan tk) {
		String maBP = null;

		String jpql = "SELECT nv.boPhan.maBoPhan FROM NhanVien nv WHERE nv.maNV = :maNV";

		maBP = (String) em.createQuery(jpql).setParameter("maNV", tk.getNv().getMaNV()).getSingleResult();

		return maBP;
	}

	public void updateNgayDNCuoi(LocalDate date, TaiKhoan tk) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			tk.setNgayDNCuoi(date);
			em.merge(tk);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
