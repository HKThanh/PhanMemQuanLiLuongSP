package dao;

import java.util.List;

import entity.CongNhan;

public interface CongNhan_DAO {
	public List<CongNhan> getListCN();
	public boolean insertCN(CongNhan cn);
	public boolean deleteCN(String maCN);
	public boolean updateCN(CongNhan cn);	
	public List<CongNhan> getListCNtheoXuong(String maXuong);
	public List<CongNhan> getListNVtheoNamXuong(int nam, String maXuong);
	public List<CongNhan> getDSCongNhan();
	public List<CongNhan> getDSCongNhanTheoXuong(String xuong);
	public CongNhan getCongNhanTheoMaCN(String ma);
	public List<CongNhan> getDSCongNhanTheoXuongVaChuaDuocPhanCong(String xuong);
	public List<CongNhan> getListCntheoXuongCa(int ca, String maXuong);
	public List<CongNhan> layDanhSachCNTheoDK(String maXuong);
	public List<CongNhan> getListCNtheoNamVaoLam(int nam);
}
