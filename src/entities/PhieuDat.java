package entities;

import java.sql.Date;
import java.sql.Time;

public class PhieuDat {
	private String maDH;
	private KhachHang khachHang;
	private TieuDe tieuDe;
	private String ngayDat;
	private String gioDat;
	private TaiKhoan taiKhoan;
	private int tinhTrang;
	public PhieuDat(String maDH) {
		super();
		this.maDH = maDH;
	}
	public PhieuDat(String maDH, KhachHang khachHang, TieuDe td, String ngayDat, String gioDat, TaiKhoan taiKhoan,int tinhTrang) {
		super();
		this.maDH = maDH;
		this.khachHang = khachHang;
		this.tieuDe = td;
		this.ngayDat = ngayDat;
		this.gioDat = gioDat;
		this.taiKhoan = taiKhoan;
		this.tinhTrang = tinhTrang;
	}
	public PhieuDat(KhachHang khachHang, TieuDe td, String ngayDat, String gioDat, TaiKhoan taiKhoan,int tinhTrang) {
		super();
		this.khachHang = khachHang;
		this.tieuDe = td;
		this.ngayDat = ngayDat;
		this.gioDat = gioDat;
		this.taiKhoan = taiKhoan;
		this.tinhTrang = tinhTrang;
	}
	public String getMaDH() {
		return maDH;
	}
	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public TieuDe getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(TieuDe td) {
		this.tieuDe = td;
	}
	public String getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}
	public String getGioDat() {
		return gioDat;
	}
	public void setGioDat(String gioDat) {
		this.gioDat = gioDat;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	
}
