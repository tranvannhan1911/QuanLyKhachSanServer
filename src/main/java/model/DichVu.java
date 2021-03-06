package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DichVu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maDV;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String tenDV;
	private double donGia;
	
	@OneToMany(mappedBy = "dichVu")
	private List<ChiTietDV> dsChiTietDV;

	public DichVu() {
	
	}
	
	public DichVu(int maDV) {
		this(maDV, "Chưa cập nhật", 0.0);
	}

	public DichVu(int maDV, String tenDV, double donGia) {
		setMaDV(maDV);
		setTenDV(tenDV);
		setDonGia(donGia);
	}

	public DichVu(String tenDV, double donGia) {
		setDonGia(donGia);
		setTenDV(tenDV);
	}

	
	public int getMaDV() {
		return maDV;
	}

	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		if (tenDV.equals(""))
			tenDV = "Chưa cập nhật";
		this.tenDV = tenDV;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia < 0)
			donGia = 0.0;
		this.donGia = donGia;
	}
	
	public int getID() {
		return this.maDV;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maDV;
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
		DichVu other = (DichVu) obj;
		if (maDV != other.maDV)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDV=" + tenDV + ", donGia=" + donGia + ", dsChiTietDV=" + dsChiTietDV
				+ "]";
	}

}
