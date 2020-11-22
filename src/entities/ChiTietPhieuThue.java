package entities;

import java.sql.Date;

public class ChiTietPhieuThue {
	private PhieuThue phieuThue;
	private Dia dia;
	private String hanTra;
	private int thanhTien;
	
	public ChiTietPhieuThue(PhieuThue phieuThue, Dia dia, String hanTra, int thanhTien) {
		super();
		this.phieuThue = phieuThue;
		this.dia = dia;
		this.hanTra = hanTra;
		this.thanhTien = thanhTien;
	}

	public ChiTietPhieuThue() {
		super();
	}

	public PhieuThue getPhieuThue() {
		return phieuThue;
	}

	public void setPhieuThue(PhieuThue phieuThue) {
		this.phieuThue = phieuThue;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public String getHanTra() {
		return hanTra;
	}

	public void setHanTra(String hanTra) {
		this.hanTra = hanTra;
	}

	public int getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

}
