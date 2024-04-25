package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import entity.BangChamCongNV;

public interface BangChamCongNV_DAO extends Remote {
	public List<BangChamCongNV> getBangCC() throws RemoteException;
	public List<LocalDate> layTatCaThangvaNamkhacNhau() throws RemoteException;
	public List<BangChamCongNV> dsBangChamCongNhanVienTheoTungThang(int thang, int nam) throws RemoteException;
	public List<BangChamCongNV> dsBangLuongtheothangnambophan( int thang, int nam, String bophan) throws RemoteException;
	public List<String> listTatCaBoPhan(List<BangChamCongNV> list) throws RemoteException;
	public int getSoNgayDiLamCua1NV(String maNV, int thang, int nam) throws RemoteException;
	public double getTongSoGioTangCaCua1NV(String maNV, int thang, int nam) throws RemoteException;
	public double getSoBangChamCongCua1NV(String maNV, int thang, int nam) throws RemoteException;
	public List<BangChamCongNV> dsBangCCtheomaNVthangnam(String maNV,int thang, int nam) throws RemoteException;
	public List<BangChamCongNV> getBangCCTheoNgay(LocalDate ngayChamCong) throws RemoteException;	
	public boolean insertBangChamCongNV(BangChamCongNV bangChamCongNV) throws RemoteException;
	public boolean updateBangChamCongNV(BangChamCongNV bangCC) throws RemoteException;
	public List<BangChamCongNV> getBangCCTheoNgayBPCa(LocalDate ngayChamCong,String maBP, int ca) throws RemoteException;	
	public boolean updateGhiChiBangChamCongNV(BangChamCongNV bangCC) throws RemoteException;
	public BangChamCongNV layBangCCCuoiCungThangCua1NV(String maNV, int thang, int nam) throws RemoteException;
	public List<Integer> layDSNamKhacnhauCCNV () throws RemoteException;
}
