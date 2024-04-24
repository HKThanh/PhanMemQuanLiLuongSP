package gui;

import java.awt.EventQueue;

import dao.HopDong_DAO;
import dao.NhanVien_DAO;
import dao.SanPham_DAO;
import dao.TaiKhoan_DAO;
import dao.impl.HopDong_Impl;
import dao.impl.NhanVien_Impl;
import dao.impl.SanPham_Impl;
import dao.impl.TaiKhoan_Impl;

public class Initiate {
	static TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_Impl();
	static NhanVien_DAO nhanVien_DAO = new NhanVien_Impl();
	static HopDong_DAO hopDong_DAO = new HopDong_Impl();
	static SanPham_DAO sanPham_DAO = new SanPham_Impl();
	
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
