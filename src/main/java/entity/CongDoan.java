package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CongDoan")
public class CongDoan implements Serializable {
	@Id
	private String maCongDoan;
	@Column(name = "tenCongDoan", columnDefinition = "NVARCHAR(255)")
	private String tenCongDoan;
	private int soLuongSanPham;
	private int soLuongCongNhanDuKien;
	private double giaTien;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThucDuKien;
	private boolean trangThai;
	private String congDoanTienQuyet;
	
	@ManyToOne
	@JoinColumn(name = "maSP")
	private SanPham sanPham;
	
	@OneToMany(mappedBy = "congDoan")
	private Set<BangPhanCongCN> bangPhanCongCNs;

	public CongDoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public CongDoan(String maCongDoan, String tenCongDoan, int soLuongSanPham, int soLuongCongNhanDuKien,
			double giaTien, LocalDate ngayBatDau, LocalDate ngayKetThucDuKien, boolean trangThai,
			String congDoanTienQuyet, SanPham sanPham, Set<BangPhanCongCN> bangPhanCongCNs) {
		super();
		this.maCongDoan = maCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.soLuongSanPham = soLuongSanPham;
		this.soLuongCongNhanDuKien = soLuongCongNhanDuKien;
		this.giaTien = giaTien;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThucDuKien = ngayKetThucDuKien;
		this.trangThai = trangThai;
		this.congDoanTienQuyet = congDoanTienQuyet;
		this.sanPham = sanPham;
		this.bangPhanCongCNs = bangPhanCongCNs;
	}


	public Set<BangPhanCongCN> getBangPhanCongCNs() {
		return bangPhanCongCNs;
	}


	public void setBangPhanCongCNs(Set<BangPhanCongCN> bangPhanCongCNs) {
		this.bangPhanCongCNs = bangPhanCongCNs;
	}


	public CongDoan(String maCongDoan, String tenCongDoan, int soLuongSanPham, int soLuongCongNhanDuKien,
			double giaTien, LocalDate ngayBatDau, LocalDate ngayKetThucDuKien, boolean trangThai,
			String congDoanTienQuyet, SanPham sanPham) {
		super();
		this.maCongDoan = maCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.soLuongSanPham = soLuongSanPham;
		this.soLuongCongNhanDuKien = soLuongCongNhanDuKien;
		this.giaTien = giaTien;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThucDuKien = ngayKetThucDuKien;
		this.trangThai = trangThai;
		this.congDoanTienQuyet = congDoanTienQuyet;
		this.sanPham = sanPham;
	}


	public CongDoan(String maCongDoan) {
		super();
		this.maCongDoan = maCongDoan;
	}

	public String getTenCongDoan() {
		return tenCongDoan;
	}

	public void setTenCongDoan(String tenCongDoan) {
		this.tenCongDoan = tenCongDoan;
	}

	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}

	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}

	public int getSoLuongCongNhanDuKien() {
		return soLuongCongNhanDuKien;
	}

	public void setSoLuongCongNhanDuKien(int soLuongCongNhanDuKien) {
		this.soLuongCongNhanDuKien = soLuongCongNhanDuKien;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	
	public LocalDate getNgayKetThucDuKien() {
		return ngayKetThucDuKien;
	}

	public void setNgayKetThucDuKien(LocalDate ngayKetThucDuKien) {
		this.ngayKetThucDuKien = ngayKetThucDuKien;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getCongDoanTienQuyet() {
		return congDoanTienQuyet;
	}

	public void setCongDoanTienQuyet(String congDoanTienQuyet) {
		this.congDoanTienQuyet = congDoanTienQuyet;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public String getMaCongDoan() {
		return maCongDoan;
	}

	@Override
	public String toString() {
		return "CongDoan [maCongDoan=" + maCongDoan + ", tenCongDoan=" + tenCongDoan + ", soLuongSanPham="
				+ soLuongSanPham + ", giaTien=" + giaTien + ", ngayBatDau=" + ngayBatDau + ", trangThai=" + trangThai
				+ ", congDoanTienQuyet=" + congDoanTienQuyet + ", sanPham=" + sanPham + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCongDoan == null) ? 0 : maCongDoan.hashCode());
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
		CongDoan other = (CongDoan) obj;
		if (maCongDoan == null) {
			if (other.maCongDoan != null)
				return false;
		} else if (!maCongDoan.equals(other.maCongDoan))
			return false;
		return true;
	}
}
