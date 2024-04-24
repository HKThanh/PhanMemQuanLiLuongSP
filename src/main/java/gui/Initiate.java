package gui;

import java.awt.EventQueue;

import dao.BangChamCongCN_DAO;
import dao.BangChamCongNV_DAO;
import dao.BangLuongCN_DAO;
import dao.BangLuongNV_DAO;
import dao.BangPhanCongCN_DAO;
import dao.BoPhan_DAO;
import dao.CongDoan_DAO;
import dao.CongNhan_DAO;
import dao.HopDong_DAO;
import dao.NhanVien_DAO;
import dao.SanPham_DAO;
import dao.TaiKhoan_DAO;
import dao.Xuong_DAO;
import dao.impl.BangChamCongCN_Impl;
import dao.impl.BangChamCongNV_Impl;
import dao.impl.BangLuongCN_Impl;
import dao.impl.BangLuongNV_Impl;
import dao.impl.BangPhanCongCN_Impl;
import dao.impl.BoPhan_Impl;
import dao.impl.CongDoan_Impl;
import dao.impl.CongNhan_Impl;
import dao.impl.HopDong_Impl;
import dao.impl.NhanVien_Impl;
import dao.impl.SanPham_Impl;
import dao.impl.TaiKhoan_Impl;
import dao.impl.Xuong_Impl;

public class Initiate {
	static TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_Impl();
	static NhanVien_DAO nhanVien_DAO = new NhanVien_Impl();
	static BangChamCongNV_DAO bangChamCongNV_DAO = new BangChamCongNV_Impl();
	static BangLuongNV_DAO bangLuongNV_DAO = new BangLuongNV_Impl();
	static BoPhan_DAO boPhan_DAO = new BoPhan_Impl();
	static HopDong_DAO hopDong_DAO = new HopDong_Impl();
	static SanPham_DAO sanPham_DAO = new SanPham_Impl();
	static CongDoan_DAO congDoan_DAO = new CongDoan_Impl();
	static Xuong_DAO xuong_DAO = new Xuong_Impl();
	static CongNhan_DAO congNhan_DAO = new CongNhan_Impl();
	static BangChamCongCN_DAO bangChamCongCN_DAO = new BangChamCongCN_Impl();
	static BangLuongCN_DAO bangLuongCN_DAO = new BangLuongCN_Impl();
	static BangPhanCongCN_DAO bangPhanCongCN_DAO = new BangPhanCongCN_Impl();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap_GUI dangNhap = new DangNhap_GUI();
					dangNhap.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
