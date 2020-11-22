package entities;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String sdt;
	private String diaChi;
	
	public KhachHang() {
		super();
	}
	public KhachHang(String tenKH, String sdt, String diaChi) {
		super();
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	public KhachHang(String maKH, String tenKH, String sdt, String diaChi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return maKH + "  -  " + tenKH;
	}
	
}
