package dao;

import java.time.LocalDate;
import java.util.List;

import entity.TaiKhoan;

public interface TaiKhoan_DAO {
	public List<TaiKhoan> getListTK();
	public int getSize();
	public boolean insert(TaiKhoan tk);
	public TaiKhoan soSanhPWD(String tk, String mk);
	public String getBoPhanCuaNV(TaiKhoan tk);
	public void updateNgayDNCuoi(LocalDate date, TaiKhoan tk);
}