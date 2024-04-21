package dao;

import java.util.List;

import entity.BangPhanCongCN;

public interface BangPhanCongCN_DAO {
	public List<BangPhanCongCN> getDSPhanCongCongDoanTheoMaCD(String ma);
	public boolean insertPhanCongCongNhan(BangPhanCongCN bpccn);
	public List<BangPhanCongCN> getDSCongNhanTheoXuongVaDuocPhanCong(String ma);
	public List<BangPhanCongCN> getDSCongNhanDuocPhanCong();
	public boolean deleteALLPCCuaCongDoan(String ma);
}
