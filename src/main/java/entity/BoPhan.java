package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BoPhan")
public class BoPhan implements Serializable {
	@Id
	private String maBoPhan;

	@Column(name = "tenBoPhan", columnDefinition = "NVARCHAR(255)")
	private String tenBoPhan;
	private String sDTBoPhan;

	@OneToMany(mappedBy = "boPhan")
	private Set<NhanVien> nhanViens;

	public BoPhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoPhan(String maBoPhan, String tenBoPhan, String sDTBoPhan) {
		super();
		this.maBoPhan = maBoPhan;
		setTenBoPhan(tenBoPhan);
		setsDTBoPhan(sDTBoPhan);
	}

	public BoPhan(String maBoPhan, String tenBoPhan, String sDTBoPhan, Set<NhanVien> nhanViens) {
		super();
		this.maBoPhan = maBoPhan;
		this.tenBoPhan = tenBoPhan;
		this.sDTBoPhan = sDTBoPhan;
		this.nhanViens = nhanViens;
	}

	public BoPhan(String maBoPhan) {
		super();
		this.maBoPhan = maBoPhan;
	}

	public String getTenBoPhan() {
		return tenBoPhan;
	}

	public void setTenBoPhan(String tenBoPhan) {
		this.tenBoPhan = tenBoPhan.trim().length() > 0 ? tenBoPhan : "";
	}

	public String getsDTBoPhan() {
		return sDTBoPhan;
	}

	public void setsDTBoPhan(String sDTBoPhan) {
		this.sDTBoPhan = sDTBoPhan.trim().length() > 0 ? sDTBoPhan : "";
	}

	public String getMaBoPhan() {
		return maBoPhan;
	}

	@Override
	public String toString() {
		return "BoPhan [maBoPhan=" + maBoPhan + ", tenBoPhan=" + tenBoPhan + ", sDTBoPhan=" + sDTBoPhan + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maBoPhan == null) ? 0 : maBoPhan.hashCode());
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
		BoPhan other = (BoPhan) obj;
		if (maBoPhan == null) {
			if (other.maBoPhan != null)
				return false;
		} else if (!maBoPhan.equals(other.maBoPhan))
			return false;
		return true;
	}
}
