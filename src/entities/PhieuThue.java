package entities;

import java.sql.Date;

public class PhieuThue {
	private String maPT;
	private KhachHang khachHang;
	private String ngayThue;
	private TaiKhoan nhanVien;
	private int tongTien;
	public PhieuThue(String maPT, KhachHang khachHang, String ngayThue, TaiKhoan nhanVien, int tongTien) {
		super();
		this.maPT = maPT;
		this.khachHang = khachHang;
		this.ngayThue = ngayThue;
		this.nhanVien = nhanVien;
		this.tongTien = tongTien;
	}
	public PhieuThue(String maPT) {
		super();
		this.maPT = maPT;
	}
	
	public PhieuThue(KhachHang khachHang, String ngayThue, TaiKhoan nhanVien, int tongTien) {
		super();
		this.khachHang = khachHang;
		this.ngayThue = ngayThue;
		this.nhanVien = nhanVien;
		this.tongTien = tongTien;
	}
	public String getMaPT() {
		return maPT;
	}
	public void setMaPT(String maPT) {
		this.maPT = maPT;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
	public String getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(String ngayThue) {
		this.ngayThue = ngayThue;
	}
	public TaiKhoan getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(TaiKhoan nhanVien) {
		this.nhanVien = nhanVien;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public String toString() {
		return "PhieuThue [maPT=" + maPT + ", khachHang=" + khachHang + ", ngayThue=" + ngayThue + ", nhanVien="
				+ nhanVien + ", tongTien=" + tongTien + "]";
	}
	
	
}
