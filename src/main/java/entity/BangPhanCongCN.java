package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BangPhanCongCN")
public class BangPhanCongCN implements Serializable {
	@Id
	private String maPhanCong;
	private boolean trangThai;
	private LocalDate ngayPhanCong;
	private int soLuongSanPham;
	
	@ManyToOne
	@JoinColumn(name = "maCN")
	private CongNhan congNhan;
	
	@ManyToOne
	@JoinColumn(name = "maCongDoan")
	private CongDoan congDoan;

	public BangPhanCongCN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BangPhanCongCN(String maPhanCong, boolean trangThai, LocalDate ngayPhanCong, int soLuongSanPham,
			CongNhan congNhan, CongDoan congDoan) {
		super();
		this.maPhanCong = maPhanCong;
		this.trangThai = trangThai;
		this.ngayPhanCong = ngayPhanCong;
		this.soLuongSanPham = soLuongSanPham;
		this.congNhan = congNhan;
		this.congDoan = congDoan;
	}

	public BangPhanCongCN(String maPhanCong) {
		super();
		this.maPhanCong = maPhanCong;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public LocalDate getNgayPhanCong() {
		return ngayPhanCong;
	}

	public void setNgayPhanCong(LocalDate ngayPhanCong) {
		this.ngayPhanCong = ngayPhanCong;
	}

	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}

	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}

	public CongNhan getCongNhan() {
		return congNhan;
	}

	public void setCongNhan(CongNhan congNhan) {
		this.congNhan = congNhan;
	}

	public CongDoan getCongDoan() {
		return congDoan;
	}

	public void setCongDoan(CongDoan congDoan) {
		this.congDoan = congDoan;
	}

	public String getMaPhanCong() {
		return maPhanCong;
	}

	@Override
	public String toString() {
		return "BangPhanCongCongDoan [maPC=" + maPhanCong + ", trangThai=" + trangThai + ", ngayPhanCong=" + ngayPhanCong
				+ ", soLuongSanPham=" + soLuongSanPham + ", congNhan=" + congNhan + ", congDoan=" + congDoan + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhanCong == null) ? 0 : maPhanCong.hashCode());
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
		BangPhanCongCN other = (BangPhanCongCN) obj;
		if (maPhanCong == null) {
			if (other.maPhanCong != null)
				return false;
		} else if (!maPhanCong.equals(other.maPhanCong))
			return false;
		return true;
	}
}
