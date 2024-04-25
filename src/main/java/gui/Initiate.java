package gui;

import java.awt.EventQueue;
import java.rmi.RemoteException;

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
	static TaiKhoan_DAO taiKhoan_DAO;
	static NhanVien_DAO nhanVien_DAO;
	static BangChamCongNV_DAO bangChamCongNV_DAO;
	static BangLuongNV_DAO bangLuongNV_DAO;
	static BoPhan_DAO boPhan_DAO;
	static HopDong_DAO hopDong_DAO;
	static SanPham_DAO sanPham_DAO;
	static CongDoan_DAO congDoan_DAO;
	static Xuong_DAO xuong_DAO;
	static CongNhan_DAO congNhan_DAO;
	static BangChamCongCN_DAO bangChamCongCN_DAO;
	static BangLuongCN_DAO bangLuongCN_DAO;
	static BangPhanCongCN_DAO bangPhanCongCN_DAO;
	
	public static void main(String[] args) throws RemoteException {
		taiKhoan_DAO = new TaiKhoan_Impl();
		nhanVien_DAO = new NhanVien_Impl();
		bangChamCongNV_DAO = new BangChamCongNV_Impl();
		bangLuongNV_DAO = new BangLuongNV_Impl();
		boPhan_DAO = new BoPhan_Impl();
		hopDong_DAO = new HopDong_Impl();
		sanPham_DAO = new SanPham_Impl();
		congDoan_DAO = new CongDoan_Impl();
		congNhan_DAO = new CongNhan_Impl();
		bangChamCongCN_DAO = new BangChamCongCN_Impl();
		bangLuongCN_DAO = new BangLuongCN_Impl();
		bangPhanCongCN_DAO = new BangPhanCongCN_Impl();
		xuong_DAO = new Xuong_Impl();
		
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
