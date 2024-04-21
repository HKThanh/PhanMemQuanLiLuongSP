package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import entity.HopDong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public interface HopDong_DAO {
	public int getSize();
	public ArrayList<HopDong> getDSHopDong();
	public boolean insertHopDong(HopDong hd);
	public HopDong getMotHopDong(String ma);
	public boolean updateHopDong(HopDong hd);
	public boolean deleteHopDong(String maHD);
	public ArrayList<HopDong> getListHDTheoTrangThai(boolean tinhTrang);
	public ArrayList<HopDong> getDSHopDongTheoNam(int year);
	public ArrayList<Integer> getDSNamKiHopDong();
	public ArrayList<HopDong> getDSHopDongTheoNamvaTT(int year, boolean tinhTrang);
}
