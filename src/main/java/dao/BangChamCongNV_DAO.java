package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.BangChamCongNV;

public interface BangChamCongNV_DAO {
	public List<BangChamCongNV> getBangCC();
	public List<LocalDate> layTatCaThangvaNamkhacNhau();
	public List<BangChamCongNV> dsBangChamCongNhanVienTheoTungThang(int thang, int nam);
	public List<BangChamCongNV> dsBangLuongtheothangnambophan( int thang, int nam, String bophan);
	public List<String> listTatCaBoPhan(List<BangChamCongNV> list);
	public int getSoNgayDiLamCua1NV(String maNV, int thang, int nam);
	public double getTongSoGioTangCaCua1NV(String maNV, int thang, int nam);
	public double getSoBangChamCongCua1NV(String maNV, int thang, int nam);
	public List<BangChamCongNV> dsBangCCtheomaNVthangnam(String maNV,int thang, int nam);
	public List<BangChamCongNV> getBangCCTheoNgay(LocalDate ngayChamCong);	
	public boolean insertBangChamCongNV(BangChamCongNV bangChamCongNV);
	public boolean updateBangChamCongNV(BangChamCongNV bangCC);
	public List<BangChamCongNV> getBangCCTheoNgayBPCa(LocalDate ngayChamCong,String maBP, int ca);	
	public boolean updateGhiChiBangChamCongNV(BangChamCongNV bangCC);
	public BangChamCongNV layBangCCCuoiCungThangCua1NV(String maNV, int thang, int nam);
	public List<Integer> layDSNamKhacnhauCCNV ();
}
