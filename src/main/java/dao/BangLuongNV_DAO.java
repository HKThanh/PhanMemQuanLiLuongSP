package dao;

import java.util.List;

import entity.BangLuongNV;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public interface BangLuongNV_DAO {
	public int getSize() ;
	public List<BangLuongNV> getDSBangLuongNV();
	public List<BangLuongNV> getDSBangLuongNVTheoMaNV(String maNV);
	public List<BangLuongNV> getDSBangLuongNVTheoThangNam(int thang, int nam);
	public List<BangLuongNV> getDSBangLuongNVTheoMaNVThangNam(String maNV, int thang, int nam);
	public boolean insertBangLuongNV(BangLuongNV blnv);
	public boolean updateBangLuongNV(BangLuongNV blnv);
	public BangLuongNV lay1BangLuongTheoMaNVThangNam(String maNV, int thang, int nam);
}