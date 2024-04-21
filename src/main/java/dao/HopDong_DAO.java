package dao;

import java.util.List;

import entity.HopDong;

public interface HopDong_DAO {
	public int getSize();
	public List<HopDong> getDSHopDong();
	public boolean insertHopDong(HopDong hd);
	public HopDong getMotHopDong(String ma);
	public boolean updateHopDong(HopDong hd);
	public boolean deleteHopDong(String maHD);
	public List<HopDong> getListHDTheoTrangThai(boolean tinhTrang);
	public List<HopDong> getDSHopDongTheoNam(int year);
	public List<Integer> getDSNamKiHopDong();
	public List<HopDong> getDSHopDongTheoNamvaTT(int year, boolean tinhTrang);
}
