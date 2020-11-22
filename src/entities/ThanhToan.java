package entities;

public class ThanhToan {
	private String maTT;
	private KhachHang khachHang;
	private int tongTien;
	private String ngayThanhToan;
	private TaiKhoan taiKhoan;
	
	public ThanhToan(String maTT) {
		super();
		this.maTT = maTT;
	}

	public ThanhToan(KhachHang khachHang, int tongTien, String ngayThanhToan, TaiKhoan taiKhoan) {
		super();
		this.khachHang = khachHang;
		this.tongTien = tongTien;
		this.ngayThanhToan = ngayThanhToan;
		this.taiKhoan = taiKhoan;
	}

	public ThanhToan(String maTT, KhachHang khachHang, int tongTien, String ngayThanhToan, TaiKhoan taiKhoan) {
		super();
		this.maTT = maTT;
		this.khachHang = khachHang;
		this.tongTien = tongTien;
		this.ngayThanhToan = ngayThanhToan;
		this.taiKhoan = taiKhoan;
	}

	public String getMaTT() {
		return maTT;
	}
	public void setMaTT(String maTT) {
		this.maTT = maTT;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public String getNgayThanhToan() {
		return ngayThanhToan;
	}
	public void setNgayThanhToan(String ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
}
