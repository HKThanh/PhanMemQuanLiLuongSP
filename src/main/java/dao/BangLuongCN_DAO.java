package dao;

import entity.BangLuongCN;

public interface BangLuongCN_DAO {
	public int getSize();
	public BangLuongCN getMotBangLuongCNTheoThangNam(String maCN, int thang, int nam);
	public boolean insertBangLuongCN(BangLuongCN bangLuongCN);
	public boolean updateBangLuongCN(BangLuongCN bangLuongCN);
}
