package entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BangLuongNV")
public class BangLuongNV implements Serializable {
	@Id
	private String maLuongNV;
	
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nv;
	
	private int thang;
	private int nam;
	private int soNgayDiLam;
	private int soNgayNghiKhongPhep;
	private double tienPhat;
	private double bhxh;
	private double luongTong;

	public BangLuongNV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BangLuongNV(String maLuongNV) {
		super();
		this.maLuongNV = maLuongNV;
	}
	public BangLuongNV(String maLuongNV, NhanVien nv, int thang, int nam, int soNgayDiLam, int soNgayNghiKhongPhep,
			double tienPhat, double bhxh, double luongTong) {
		super();
		this.maLuongNV = maLuongNV;
		this.nv = nv;
		this.thang = thang;
		this.nam = nam;
		this.soNgayDiLam = soNgayDiLam;
		this.soNgayNghiKhongPhep = soNgayNghiKhongPhep;
		this.tienPhat = tienPhat;
		this.bhxh = bhxh;
		this.luongTong = luongTong;
	}

	public String getMaLuongNV() {
		return maLuongNV;
	}

	public void setMaLuongNV(String maLuongNV) {
		this.maLuongNV = maLuongNV;
	}

	public NhanVien getNv() {
		return nv;
	}

	public void setNv(NhanVien nv) {
		this.nv = nv;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public int getSoNgayDiLam() {
		return soNgayDiLam;
	}

	public void setSoNgayDiLam(int soNgayDiLam) {
		this.soNgayDiLam = soNgayDiLam;
	}

	public int getSoNgayNghiKhongPhep() {
		return soNgayNghiKhongPhep;
	}

	public void setSoNgayNghiKhongPhep(int soNgayNghiKhongPhep) {
		this.soNgayNghiKhongPhep = soNgayNghiKhongPhep;
	}

	public double getTienPhat() {
		return tienPhat;
	}

	public void setTienPhat(double tienPhat) {
		this.tienPhat = tienPhat;
	}

	public double getBhxh() {
		return bhxh;
	}

	public void setBhxh(double bhxh) {
		this.bhxh = bhxh;
	}

	public double getLuongTong() {
		return luongTong;
	}

	public void setLuongTong(double luongTong) {
		this.luongTong = luongTong;
	}

	

	@Override
	public String toString() {
		return "BangLuongNV [maLuongNV=" + maLuongNV + ", nv=" + nv + ", thang=" + thang + ", nam=" + nam
				+ ", soNgayDiLam=" + soNgayDiLam + ", soNgayNghiKhongPhep=" + soNgayNghiKhongPhep + ", tienPhat="
				+ tienPhat + ", bhxh=" + bhxh + ", luongTong=" + luongTong + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLuongNV == null) ? 0 : maLuongNV.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangLuongNV other = (BangLuongNV) obj;
		if (maLuongNV == null) {
			if (other.maLuongNV != null)
				return false;
		} else if (!maLuongNV.equals(other.maLuongNV))
			return false;
		return true;
	}
}
