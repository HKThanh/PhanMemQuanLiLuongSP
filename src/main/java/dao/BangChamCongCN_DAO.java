package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import entity.BangChamCongCN;

public interface BangChamCongCN_DAO extends Remote {
	public List<BangChamCongCN> getBangCC() throws RemoteException;
	public List<String> listTatCaXuong(List<BangChamCongCN> listBangChamCongCongNhan) throws RemoteException;
	public int getSoNgayDiLamCua1CN(String maCN, int thang, int nam) throws RemoteException;
	public double getTongSoGioTangCaCua1CN(String maCN, int thang, int nam) throws RemoteException;	
	public double getSoBangChamCongCua1CN(String maCN, int thang, int nam) throws RemoteException;
	public List<BangChamCongCN> dsBangCCtheomaCNthangnam(String maNV, int thang, int nam) throws RemoteException;
	public List<BangChamCongCN> getBangCCTheoNgay(LocalDate ngayChamCong) throws RemoteException;
	public boolean insertBangChamCongCN(BangChamCongCN bangChamCongCN) throws RemoteException;
	public boolean updateBangChamCongCN(BangChamCongCN bangCC) throws RemoteException;
	public List<BangChamCongCN> getBangCCCNTheoThangvaNam(int thang, int nam) throws RemoteException;	
	public List<LocalDate> layTatCaThangvaNamkhacNhauCN() throws RemoteException;
	public List<String> layTatCaCongDoanTheoThang(int thang, int nam) throws RemoteException;
	public List<String> laySanPhamTheoCongDoan(String maCD) throws RemoteException;	
	public List<BangChamCongCN> getBangCCCNTheomaCNThangNam(String maCN, int thang, int nam) throws RemoteException;
	public int laySoSanLuongCuaCNTheoThangNam(String maCN, int thang, int nam) throws RemoteException;
	public int laySoNgayDiLamCuaCNTheoThangNam(String maCN, int thang, int nam) throws RemoteException;
	public int layTongSoGioTangCaCuaCNTheoThangNam(String maCN, int thang, int nam) throws RemoteException;
	public double layGiaTienSanPhamTheoBCC(BangChamCongCN bcc) throws RemoteException;
	public int laySoNgayNghiKhongPhepCua1CNTheoThangNam(String maCN, int thang, int nam) throws RemoteException;
	public boolean updateGhiChuBCCCN(BangChamCongCN bcccn) throws RemoteException;
	public BangChamCongCN layBangChamCongCuoiCungCuaThang(String maCN, int thang, int nam) throws RemoteException;
	public List<Integer> layDSNamKhacnhauCCCN() throws RemoteException;
	public String layMaSPtheoMaCC(BangChamCongCN bc) throws RemoteException;
}
