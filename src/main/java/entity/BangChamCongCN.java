package entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BangChamCongCN")
public class BangChamCongCN {
	@Id
	private String maChamCongCN;
	
	@ManyToOne
	@JoinColumn(name = "maCN")
	
	private CongNhan cn;
	private LocalDate ngayCham;
	private int soGioTangCa;
	private int caLam;
	private int sanLuong;
	private boolean vangMat;
	private boolean coPhep;
	private String ghiChu;

	public BangChamCongCN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BangChamCongCN(String maChamCongCN, CongNhan cn, LocalDate ngayCham, int soGioTangCa, int caLam,
			int sanLuong, boolean vangMat, boolean coPhep, String ghiChu) {
		super();
		this.maChamCongCN = maChamCongCN;
		this.cn = cn;
		this.ngayCham = ngayCham;
		this.soGioTangCa = soGioTangCa;
		this.caLam = caLam;
		this.sanLuong = sanLuong;
		this.vangMat = vangMat;
		this.coPhep = coPhep;
		this.ghiChu = ghiChu;
	}

	public BangChamCongCN(String maChamCongCN) {
		super();
		this.maChamCongCN = maChamCongCN;
	}

	public String getMaChamCongCN() {
		return maChamCongCN;
	}

	public CongNhan getCN() {
		return cn;
	}

	public void setCN(CongNhan cn) {
		this.cn = cn;
	}

	public LocalDate getNgayCham() {
		return ngayCham;
	}

	public void setNgayCham(LocalDate ngayCham) {
		this.ngayCham = ngayCham;
	}

	public int getSoGioTangCa() {
		return soGioTangCa;
	}

	public void setSoGioTangCa(int soGioTangCa) {
		this.soGioTangCa = soGioTangCa;
	}

	public int getCaLam() {
		return caLam;
	}

	public void setCaLam(int caLam) {
		this.caLam = caLam;
	}

	public int getSanLuong() {
		return sanLuong;
	}

	public void setSanLuong(int sanLuong) {
		this.sanLuong = sanLuong;
	}

	public boolean isVangMat() {
		return vangMat;
	}

	public void setVangMat(boolean vangMat) {
		this.vangMat = vangMat;
	}

	public boolean isCoPhep() {
		return coPhep;
	}

	public void setCoPhep(boolean coPhep) {
		this.coPhep = coPhep;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {

		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "BangLuongCongNhan [maLuongCN=" + maChamCongCN + ", cn=" + cn + ", ngayCham=" + ngayCham
				+ ", soGioTangCa=" + soGioTangCa + ", caLam=" + caLam + ", sanLuong=" + sanLuong + ", vangMat="
				+ vangMat + ", coPhep=" + coPhep + ", ghiChu=" + ghiChu + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maChamCongCN == null) ? 0 : maChamCongCN.hashCode());
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
		BangChamCongCN other = (BangChamCongCN) obj;
		if (maChamCongCN == null) {
			if (other.maChamCongCN != null)
				return false;
		} else if (!maChamCongCN.equals(other.maChamCongCN))
			return false;
		return true;
	}
}
