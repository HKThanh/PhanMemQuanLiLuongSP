package dao;

import java.util.List;

import entity.BangChamCongCN;
import entity.CongDoan;

public interface CongDoan_DAO {
	public List<CongDoan> getDSCongDoan();
	public List<CongDoan> getDSCongDoanTheoMaSP(String maSP);
	public boolean insertCongDoan(CongDoan cd);
	public boolean deleteCongDoan(String maCD);
	public CongDoan getMotCongDoanTheoMaCD(String ma);
	public List<CongDoan> getDSCongDoanTheoTrangThai(boolean tinhTrang);
	public boolean updateCongDoan(CongDoan cd);
	public String getMaCDtheomaCC(BangChamCongCN bcc);
}
