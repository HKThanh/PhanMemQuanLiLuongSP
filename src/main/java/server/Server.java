package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import dao.BangChamCongCN_DAO;
import dao.BangChamCongNV_DAO;
import dao.BangLuongCN_DAO;
import dao.BangLuongNV_DAO;
import dao.BangPhanCongCN_DAO;
import dao.BangPhanCongXuong_DAO;
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
import dao.impl.BangPhanCongXuong_Impl;
import dao.impl.BoPhan_Impl;
import dao.impl.CongDoan_Impl;
import dao.impl.CongNhan_Impl;
import dao.impl.HopDong_Impl;
import dao.impl.NhanVien_Impl;
import dao.impl.SanPham_Impl;
import dao.impl.TaiKhoan_Impl;
import dao.impl.Xuong_Impl;

public class Server {
	private static final String URL = "rmi://localhost:6351/";
	
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			
			Xuong_DAO xuongDAO = new Xuong_Impl();
			TaiKhoan_DAO taiKhoanDAO = new TaiKhoan_Impl();
			SanPham_DAO sanPhamDAO = new SanPham_Impl();
			NhanVien_DAO nhanVienDAO = new NhanVien_Impl();
			HopDong_DAO hopDongDAO = new HopDong_Impl();
			CongNhan_DAO congNhanDAO = new CongNhan_Impl();
			CongDoan_DAO congDoanDAO = new CongDoan_Impl();
			BoPhan_DAO boPhanDAO = new BoPhan_Impl();
			BangPhanCongXuong_DAO bangPhanCongXuongDAO = new BangPhanCongXuong_Impl();
			BangPhanCongCN_DAO bangPhanCongCNDAO = new BangPhanCongCN_Impl();
			BangLuongNV_DAO bangLuongNVDAO = new BangLuongNV_Impl();
			BangLuongCN_DAO bangLuongCNDAO = new BangLuongCN_Impl();
			BangChamCongCN_DAO bangChamCongCNDAO = new BangChamCongCN_Impl();
			BangChamCongNV_DAO bangChamCongNVDAO = new BangChamCongNV_Impl();
			
			LocateRegistry.createRegistry(6351);
			
			context.bind(URL + "xuongDAO", xuongDAO);
			context.bind(URL + "taiKhoanDAO", taiKhoanDAO);
			context.bind(URL + "sanPhamDAO", sanPhamDAO);
			context.bind(URL + "nhanVienDAO", nhanVienDAO);
			context.bind(URL + "hopDongDAO", hopDongDAO);
			context.bind(URL + "congNhanDAO", congNhanDAO);
			context.bind(URL + "congDoanDAO", congDoanDAO);
			context.bind(URL + "boPhanDAO", boPhanDAO);
			context.bind(URL + "bangPhanCongXuongDAO", bangPhanCongXuongDAO);
			context.bind(URL + "bangPhanCongCNDAO", bangPhanCongCNDAO);
			context.bind(URL + "bangLuongNVDAO", bangLuongNVDAO);
			context.bind(URL + "bangLuongCNDAO", bangLuongCNDAO);
			context.bind(URL + "bangChamCongCNDAO", bangChamCongCNDAO);
			context.bind(URL + "bangChamCongNVDAO", bangChamCongNVDAO);
			
			System.out.println("Server is running...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
