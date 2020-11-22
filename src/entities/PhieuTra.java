package entities;

import java.sql.Date;

public class PhieuTra {
	private String maPTr;
	private PhieuThue pt;
	private Dia dia;
	private String ngayTra;
	private TaiKhoan nhanVien;
	private int quaHan;
	private int huHong;
	
	public PhieuTra(String maPTr) {
		super();
		this.maPTr = maPTr;
	}
	
	public PhieuTra(PhieuThue pt, Dia dia, String ngayTra, TaiKhoan nhanVien, int quaHan, int huHong) {
		super();
		this.pt = pt;
		this.dia = dia;
		this.ngayTra = ngayTra;
		this.nhanVien = nhanVien;
		this.quaHan = quaHan;
		this.huHong = huHong;
	}

	public PhieuTra(String maPTr, PhieuThue pt, Dia dia, String ngayTra, TaiKhoan nhanVien, int quaHan, int huHong) {
		super();
		this.maPTr = maPTr;
		this.pt = pt;
		this.dia = dia;
		this.ngayTra = ngayTra;
		this.nhanVien = nhanVien;
		this.quaHan = quaHan;
		this.huHong = huHong;
	}

	public String getMaPTr() {
		return maPTr;
	}

	public void setMaPTr(String maPTr) {
		this.maPTr = maPTr;
	}

	public PhieuThue getPt() {
		return pt;
	}

	public void setPt(PhieuThue pt) {
		this.pt = pt;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public String getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}

	public TaiKhoan getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(TaiKhoan nhanVien) {
		this.nhanVien = nhanVien;
	}

	public int getQuaHan() {
		return quaHan;
	}

	public void setQuaHan(int quaHan) {
		this.quaHan = quaHan;
	}

	public int getHuHong() {
		return huHong;
	}

	public void setHuHong(int huHong) {
		this.huHong = huHong;
	}
		
}
