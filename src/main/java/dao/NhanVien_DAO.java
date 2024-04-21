package dao;

import java.util.ArrayList;

import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public interface NhanVien_DAO {
	public ArrayList<NhanVien> getListNV();
	public boolean insertNV(NhanVien nv);
	public ArrayList<NhanVien> getListNVtheoBP(String maBP);
	public ArrayList<NhanVien> getListNVtheoNamVaoLam(int nam);
	public ArrayList<NhanVien> getListNVtheoNamBP(int nam, String maBP);
	public boolean deleteNV(String maNV);
	public boolean updateNhanVien(NhanVien nv);
	public NhanVien getMotNVTuMaNV(String maNVien);	
	public ArrayList<NhanVien> getListNVtheoBPCa(int ca, String maBP);
}
