package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {
	@Id
	private String maNV;
	
	private byte[] anhDaiDien;
	@Column(name = "ho", columnDefinition = "NVARCHAR(255)")
	private String ho;
	@Column(name = "ten", columnDefinition = "NVARCHAR(255)")
	private String ten;
	private boolean gioiTinh;
	private String soDienThoai;
	@Column(name = "diaChi", columnDefinition = "NVARCHAR(255)")
	private String diaChi;
	private String cCCD;
	private LocalDate ngaySinh;
	private LocalDate ngayBatDauLamViec;
	private int caLamViec;
	private double luongCoBan;
	private int thangBacLuong;
	private double heSoLuong;
	private double phuCap;
	
	@ManyToOne
	@JoinColumn(name = "maBoPhan")
	private BoPhan boPhan;
	
    @OneToMany(mappedBy = "nv")
    private Set<BangChamCongNV> bangChamCongNVs;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNV, byte[] anhDaiDien, String ho, String ten, boolean gioiTinh, String soDienThoai,
			String diaChi, String cCCD, LocalDate ngaySinh, LocalDate ngayBatDauLamViec, int caLamViec,
			double luongCoBan, int thangBacLuong, double heSoLuong, double phuCap, BoPhan boPhan) {
		super();
		this.maNV = maNV;
		this.anhDaiDien = anhDaiDien;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.cCCD = cCCD;
		this.ngaySinh = ngaySinh;
		this.ngayBatDauLamViec = ngayBatDauLamViec;
		this.caLamViec = caLamViec;
		this.luongCoBan = luongCoBan;
		this.thangBacLuong = thangBacLuong;
		this.heSoLuong = heSoLuong;
		this.phuCap = phuCap;
		this.boPhan = boPhan;
	}

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}

	public byte[] getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(byte[] anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getcCCD() {
		return cCCD;
	}

	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public LocalDate getNgayBatDauLamViec() {
		return ngayBatDauLamViec;
	}

	public void setNgayBatDauLamViec(LocalDate ngayBatDauLamViec) {
		this.ngayBatDauLamViec = ngayBatDauLamViec;
	}

	public int getCaLamViec() {
		return caLamViec;
	}

	public void setCaLamViec(int caLamViec) {
		this.caLamViec = caLamViec;
	}

	public double getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	public int getThangBacLuong() {
		return thangBacLuong;
	}

	public void setThangBacLuong(int thangBacLuong) {
		this.thangBacLuong = thangBacLuong;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public BoPhan getBoPhan() {
		return boPhan;
	}

	public void setBoPhan(BoPhan boPhan) {
		this.boPhan = boPhan;
	}

	public String getMaNV() {
		return maNV;
	}
	
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", anhDaiDien=" + Arrays.toString(anhDaiDien) + ", ho=" + ho + ", ten=" + ten
				+ ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", cCCD=" + cCCD
				+ ", ngaySinh=" + ngaySinh + ", ngayBatDauLamViec=" + ngayBatDauLamViec + ", caLamViec=" + caLamViec
				+ ", luongCoBan=" + luongCoBan + ", thangBacLuong=" + thangBacLuong + ", heSoLuong=" + heSoLuong
				+ ", phuCap=" + phuCap + ", boPhan=" + boPhan + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}
}
