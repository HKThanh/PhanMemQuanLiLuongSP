package demo;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.BangChamCongNV_DAO;
import dao.BangLuongNV_DAO;
import dao.NhanVien_DAO;
import dao.impl.BangChamCongNV_Impl;
import dao.impl.BangLuongNV_Impl;
import dao.impl.NhanVien_Impl;
import entity.BangChamCongNV;
import entity.NhanVien;
import gui.DangNhap_GUI;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
	private static  EntityManager em ;
	public static EntityManager getEm() {
		return em;
	}
	public static void main(String[] args) {
         em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
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
//        //List nhân viên theo bộ phận
//                NhanVien_DAO nvDAO = new NhanVien_Impl();
//                ArrayList<NhanVien> listNV = nvDAO.getListNVtheoBP("BPNS");
//				listNV.forEach(nv -> {
//					System.out.println(nv.getMaNV() + " - " + nv.getBoPhan().getTenBoPhan());
//				});
//		//Lấy 1 BanLuongNV theo mã nhân viên, tháng và năm
//						BangLuongNV_DAO bldao=new BangLuongNV_Impl();
//						System.out.println(bldao.lay1BangLuongTheoMaNVThangNam("NV220003", 4, 2024));
//        BangChamCongNV_DAO bc = new BangChamCongNV_Impl();
//        List<LocalDate> dsNgayCham = bc.layTatCaThangvaNamkhacNhau();
//        System.out.println(dsNgayCham);
        //getTongSoGioTangCaCua1NV
//             BangChamCongNV_DAO bc = new BangChamCongNV_Impl();
//             System.out.println(bc.getTongSoGioTangCaCua1NV("NV230004", 4, 2024));
}}
