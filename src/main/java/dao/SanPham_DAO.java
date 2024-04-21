package dao;

import java.util.ArrayList;

import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public interface SanPham_DAO {
	public int getSize();
	public ArrayList<SanPham> getDSSanPham();
	public SanPham getMotSanPham(String maSP);
	public boolean insertSanPham(SanPham sp);
	public boolean updateSanPham(SanPham sp);
	public boolean deleteSanPham(String maSP);
	public ArrayList<SanPham> getDSSanPhamTheoHopDong(String maHD);
	public int getSizeCuaDSTheoHopDong(String maHD);
	public ArrayList<SanPham> getDSSanPhamTheoTrangThai(boolean tinhTrang);
	public ArrayList<SanPham> getDSSanPhamTheoHDvaTT(String maHD, boolean tinhTrang);
}
