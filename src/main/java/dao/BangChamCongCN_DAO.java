package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.BangChamCongCN;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public interface BangChamCongCN_DAO {
	public List<BangChamCongCN> getBangCC();
	public List<String> listTatCaXuong(List<BangChamCongCN> listBangChamCongCongNhan);
	public int getSoNgayDiLamCua1CN(String maCN, int thang, int nam);
	public double getTongSoGioTangCaCua1CN(String maCN, int thang, int nam);	
	public double getSoBangChamCongCua1CN(String maCN, int thang, int nam);
	public List<BangChamCongCN> dsBangCCtheomaCNthangnam(String maNV, int thang, int nam);
	public List<BangChamCongCN> getBangCCTheoNgay(LocalDate ngayChamCong);
	public boolean insertBangChamCongCN(BangChamCongCN bangChamCongCN);
	public boolean updateBangChamCongCN(BangChamCongCN bangCC);
	public List<BangChamCongCN> getBangCCCNTheoThangvaNam(int thang, int nam);	
	public List<LocalDate> layTatCaThangvaNamkhacNhauCN();
	public List<String> layTatCaCongDoanTheoThang(int thang, int nam);
	public List<String> laySanPhamTheoCongDoan(String maCD);	
	public List<BangChamCongCN> getBangCCCNTheomaCNThangNam(String maCN, int thang, int nam);
	public int laySoSanLuongCuaCNTheoThangNam(String maCN, int thang, int nam);
	public int laySoNgayDiLamCuaCNTheoThangNam(String maCN, int thang, int nam);
	public int layTongSoGioTangCaCuaCNTheoThangNam(String maCN, int thang, int nam);
	public double layGiaTienSanPhamTheoBCC(BangChamCongCN bcc);
	public int laySoNgayNghiKhongPhepCua1CNTheoThangNam(String maCN, int thang, int nam);
	public boolean updateGhiChuBCCCN(BangChamCongCN bcccn);
	public BangChamCongCN layBangChamCongCuoiCungCuaThang(String maCN, int thang, int nam);
	public List<Integer> layDSNamKhacnhauCCCN();
	public String layMaSPtheoMaCC(BangChamCongCN bc);
}
